/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importcsv;

import br.com.maicon.techstartpro.model.Category;
import br.com.maicon.techstartpro.utils.ReadCSV;
import java.io.File;
import java.io.IOException;
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
public class ImportCSVTest {
    
    public ImportCSVTest() {
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
    public void mustReadCSVWithTwoCategories() throws IOException{   
            File file = new File(getClass().getResource("/files/categories.csv").getPath());
            List<Category> categoriesImported = ReadCSV.readCategoriesCSV(file);
            
            assertEquals(2, categoriesImported.size());
            assertEquals("Móveis", categoriesImported.get(0).getName());
            assertEquals("Informática", categoriesImported.get(1).getName());
    }
    
}
