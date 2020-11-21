/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suite;

import controller.CategoryControllerTest;
import controller.ProductControllerTest;
import importcsv.ImportCSVTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tablemodel.CategoryTableModelTest;
import tablemodel.ProductTableModelTest;

/**
 *
 * @author MAICON
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    CategoryControllerTest.class,
    ProductControllerTest.class,
    ImportCSVTest.class,
    CategoryTableModelTest.class,
    ProductTableModelTest.class

})
public class TechStarProTestSuite {

    public TechStarProTestSuite() {
    }

}
