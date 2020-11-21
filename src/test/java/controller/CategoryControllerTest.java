/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.maicon.techstartpro.controller.CategoryController;
import br.com.maicon.techstartpro.dao.HibernateCategoryDAO;
import br.com.maicon.techstartpro.model.Category;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author MAICON
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {
    
    public CategoryControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Mock
    private HibernateCategoryDAO hibernateCategoryDAO;
    
    @InjectMocks
    private CategoryController categoryController;
    
    private final String nameCategoria1 = "Móveis";
    private final String nameCategoria2 = "Informática";
    
    private final File file = new File(getClass().getResource("/files/categories.csv").getPath());

    @Test
    public void deveRetornarAllCategorias() throws Exception{
        List<Category> lista = new ArrayList<>();
        lista.add(new Category(1L, "Móveis"));
        lista.add(new Category(1L, "Informática"));
        when(hibernateCategoryDAO.findAll()).thenReturn(lista);
        
        List<Category> categories =  categoryController.listCategories();
        
        verify(hibernateCategoryDAO, times(1)).findAll();              
        assertEquals(2, categories.size());
    }
    
    @Test
    public void shouldNotImportWhenCategoryAlreadyExists() throws Exception{
        when(hibernateCategoryDAO.findByName(nameCategoria1)).thenReturn(new Category("Móveis"));
        when(hibernateCategoryDAO.findByName(nameCategoria2)).thenReturn(new Category("Informática"));
        
        List<Category> categories =  categoryController.importCategories(file);
                
        assertEquals(0, categories.size());
    }    
    
    @Test
    public void mustImportCategoriesWhenTheyDoNotExistInTheDatabase() throws Exception{
        when(hibernateCategoryDAO.findByName(nameCategoria1)).thenReturn(null);
        when(hibernateCategoryDAO.findByName(nameCategoria2)).thenReturn(null);
        
        List<Category> categories =  categoryController.importCategories(file);
                
        assertEquals(2, categories.size());
    }        
}
