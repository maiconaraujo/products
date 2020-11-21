/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import br.com.maicon.techstartpro.model.Category;
import br.com.maicon.techstartpro.model.CategoryTableModel;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MAICON
 */
public class CategoryTableModelTest {
    
    public CategoryTableModelTest() {
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

    @Test
    public void mustReturnOneInNumberOfColumns(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Brinquedos"));
        CategoryTableModel categoryTableModel = new CategoryTableModel(categories);        
        
        assertEquals(1, categoryTableModel.getColumnCount());
    } 
    
    @Test
    public void mustReturnOneInNumberOfLines(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Brinquedos"));
        CategoryTableModel categoryTableModel = new CategoryTableModel(categories);        
        
        assertEquals(1, categoryTableModel.getRowCount());
    }     
    
    @Test
    public void mustReturnTheCategoryNameInLineZeroColumnZero(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Brinquedos"));
        CategoryTableModel categoryTableModel = new CategoryTableModel(categories);        
        
        assertEquals("Brinquedos", categoryTableModel.getValueAt(0, 0));        
    }
    
    
}
