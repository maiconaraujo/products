/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.maicon.techstartpro.controller.ProductController;
import br.com.maicon.techstartpro.dao.HibernateProductDAO;
import br.com.maicon.techstartpro.model.Category;
import br.com.maicon.techstartpro.model.Product;
import java.math.BigDecimal;
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
public class ProductControllerTest {
    
    public ProductControllerTest() {
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
    private HibernateProductDAO hibernateProductDAO;
    
    @InjectMocks
    private ProductController productController;    

    @Test
    public void mustReturnAllProducts() throws Exception{
        List<Product> lista = new ArrayList<>();
        lista.add(new Product(1L, "Carrinho", "Carrinho", BigDecimal.ONE, new ArrayList<>()));
        lista.add(new Product(1L, "Mesa", "Mesa", BigDecimal.ONE, new ArrayList<>()));
        when(hibernateProductDAO.findAll()).thenReturn(lista);
        
        List<Product> products =  productController.listProducts();
        
        verify(hibernateProductDAO, times(1)).findAll();              
        assertEquals(2, products.size());
    }
    
    @Test
    public void mustSaveProducts() throws Exception{
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Brinquedos"));        
        Product product = new Product(null, "Carrinho", "Carrinho", BigDecimal.ONE, categories);
        
        productController.saveProduct(product);
        
        verify(hibernateProductDAO, times(1)).save(product);
    }
    
    @Test
    public void mustUpdateProducts() throws Exception{
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Brinquedos"));        
        Product product = new Product(1L, "Carrinho", "Carrinho", BigDecimal.ONE, categories);
        
        productController.saveProduct(product);
        
        verify(hibernateProductDAO, times(1)).update(product);
    }    
    
    @Test
    public void mustRemoveProducts() throws Exception{
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Brinquedos"));        
        Product product = new Product(1L, "Carrinho", "Carrinho", BigDecimal.ONE, categories);
        
        productController.removeProduct(product.getId());
        
        verify(hibernateProductDAO, times(1)).remove(product.getId());
    }    
    
    @Test
    public void mustFilterProducts() throws Exception{     
        Product product = new Product(null, "Carrinho", "Carrinho", BigDecimal.ONE, null);
        
        productController.searchProductByFilter(product);
        
        verify(hibernateProductDAO, times(1)).findByFilter(product);
    }        
    
    
}
