/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import br.com.maicon.techstartpro.model.Category;
import br.com.maicon.techstartpro.model.Product;
import br.com.maicon.techstartpro.model.ProductTableModel;
import java.math.BigDecimal;
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
public class ProductTableModelTest {
    
    public ProductTableModelTest() {
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
    public void mustReturnFiveInNumberOfColumns(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Brinquedos"));        
        
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Carrinho", "Carrinho", BigDecimal.ONE, categories));
        ProductTableModel productTableModel = new ProductTableModel(products);        
        
        assertEquals(5, productTableModel.getColumnCount());
    } 
    
    @Test
    public void mustReturnOneInNumberOfLines(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Brinquedos"));        
        
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Carrinho", "Carrinho", BigDecimal.ONE, categories));
        ProductTableModel productTableModel = new ProductTableModel(products);     
        
        assertEquals(1, productTableModel.getRowCount());
    }     
    
    @Test
    public void mustReturnTheValuesCorrectlyFromTheColumns(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Móveis")); 
        categories.add(new Category(1L, "Decoração"));   
        
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Mesa", "Mesa de Vidro", BigDecimal.ONE, categories));
        ProductTableModel productTableModel = new ProductTableModel(products);    
        
        assertEquals(1L, productTableModel.getValueAt(0, 0));        
        assertEquals("Mesa", productTableModel.getValueAt(0, 1));        
        assertEquals("Mesa de Vidro", productTableModel.getValueAt(0, 2));        
        assertEquals("R$ 1,00", productTableModel.getValueAt(0, 3));        
        assertEquals("Móveis, Decoração", productTableModel.getValueAt(0, 4));        
    }    
    
    @Test
    public void mustReturnTheNamesCorrectlyFromTheColumns(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Móveis"));  
        
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Mesa", "Mesa de Vidro", BigDecimal.ONE, categories));
        ProductTableModel productTableModel = new ProductTableModel(products);    
        
        assertEquals("ID", productTableModel.getColumnName(0));        
        assertEquals("NAME", productTableModel.getColumnName(1));        
        assertEquals("DESCRIPTION", productTableModel.getColumnName(2));        
        assertEquals("PRICE", productTableModel.getColumnName(3));        
        assertEquals("CATEGORIES", productTableModel.getColumnName(4));        
    }      
}
