/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.lomake;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter
 */
public class LomakeControllerTest {
    
    public LomakeControllerTest() {
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

    /**
     * Test of newArticle method, of class LomakeController.
     */
//    @Test
//    public void testNewArticle() {
//        System.out.println("newArticle");
//        LomakeController.newArticle();
//    }

    /**
     * Test of saveArticle method, of class LomakeController.
     */
    @Test
    public void testSaveArticle() {
        System.out.println("saveArticle");
        String author = "asd";
        String title = "asd";
        String journal = "asd";
        String year = "1";
        String volume = "0";
        String number = "0";
        String pages = "0";
        String month = "0";
        String note = "0";
        String key = "0";
        LomakeController.saveArticle(author, title, journal, year, volume, number, pages, month, note, key);
    }

    /**
     * Test of newBook method, of class LomakeController.
     */
//    public void testNewBook() {
//        System.out.println("newBook");
//        LomakeController.newBook();
//    }

    /**
     * Test of saveBook method, of class LomakeController.
     */
    @Test
    public void testSaveBook() {
        System.out.println("saveBook");
        String author = "asd";
        String title = "asd";
        String publisher = "asd";
        String year = "1";
        String volume = "0";
        String series = "0";
        String address = "0";
        String month = "0";
        String note = "0";
        String key = "0";
        LomakeController.saveBook(author, title, publisher, year, volume, series, address, month, note, key);
    }

    /**
     * Test of newProceeding method, of class LomakeController.
     */
//    @Test
//    public void testNewProceeding() {
//        System.out.println("newProceeding");
//        LomakeController.newProceeding();
//    }

    /**
     * Test of saveProceeding method, of class LomakeController.
     */
    @Test
    public void testSaveProceeding() {
        System.out.println("saveProceeding");
        String title = "asdasd";
        String year = "0";
        String editor = "asdad";
        String volume = "0";
        String series = "0";
        String address = "0";
        String month = "0";
        String publisher = "0";
        String organization = "0";
        String note = "0";
        String key = "0";
        LomakeController.saveProceeding(title, year, editor, volume, series, address, month, publisher, organization, note, key);
    }
    
}
