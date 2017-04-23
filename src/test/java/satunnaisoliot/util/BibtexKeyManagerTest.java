/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import satunnaisoliot.structs.references.Article;

/**
 *
 * @author juuso_j0pbwen
 */
public class BibtexKeyManagerTest {

    public BibtexKeyManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        DataManager.setDatabaseFileName(":memory:");

        Article article = new Article();
        article.setAuthor("Meikäläinen, Matti");
        article.setYear("2017");
        article.setBibTexKey("Mei17");
        DataManager.getDao().addReference(article);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testHasKey() {
        assertEquals(true, BibtexKeyManager.hasKey("Mei17"));
        assertEquals(false, BibtexKeyManager.hasKey("Mei16"));
    }

    @Test
    public void testHandleBibTexKey1() {
        for (int i = 0; i <= 30; i++) {
            Article article = new Article();
            article.setAuthor("Meikäläinen, Matti");
            article.setYear("2017");
            BibtexKeyManager.handleBibTexKey(article);
            DataManager.getDao().addReference(article);
        }
        assertEquals(true, BibtexKeyManager.hasKey("Mei17"));
        assertEquals(true, BibtexKeyManager.hasKey("Mei17a"));
        assertEquals(true, BibtexKeyManager.hasKey("Mei17h"));
        assertEquals(true, BibtexKeyManager.hasKey("Mei17aa"));
        assertEquals(true, BibtexKeyManager.hasKey("Mei17ac"));
    }
    
    @Test
    public void testHandleBibTexKey2() {
        for (int i = 0; i <= 30; i++) {
            Article article = new Article();
            article.setAuthor("Meikäläinen, Matti; Jokunen, Jaakko");
            article.setYear("2016");
            BibtexKeyManager.handleBibTexKey(article);
            DataManager.getDao().addReference(article);
        }
        assertEquals(true, BibtexKeyManager.hasKey("MJ16"));
        assertEquals(true, BibtexKeyManager.hasKey("MJ16a"));
        assertEquals(true, BibtexKeyManager.hasKey("MJ16h"));
        assertEquals(true, BibtexKeyManager.hasKey("MJ16aa"));
        assertEquals(true, BibtexKeyManager.hasKey("MJ16ac"));
    }
    
    @Test
    public void testHandleBibTexKey3() {
        for (int i = 0; i <= 30; i++) {
            Article article = new Article();
            article.setAuthor("Meikäläinen, Matti; Jokunen, Jaakko");
            BibtexKeyManager.handleBibTexKey(article);
            DataManager.getDao().addReference(article);
        }
        assertEquals(true, BibtexKeyManager.hasKey("MJ"));
        assertEquals(true, BibtexKeyManager.hasKey("MJa"));
        assertEquals(true, BibtexKeyManager.hasKey("MJh"));
        assertEquals(true, BibtexKeyManager.hasKey("MJaa"));
        assertEquals(true, BibtexKeyManager.hasKey("MJac"));
    }
    
    @Test
    public void testHandleBibTexKey4() {
        for (int i = 0; i <= 30; i++) {
            Article article = new Article();
            article.setAuthor("Meikäläinen, Matti; Jokunen, Jaakko");
            article.setBibTexKey("MageJaJake");
            BibtexKeyManager.handleBibTexKey(article);
            DataManager.getDao().addReference(article);
        }
        assertEquals(true, BibtexKeyManager.hasKey("MageJaJake"));
        assertEquals(true, BibtexKeyManager.hasKey("MageJaJakea"));
        assertEquals(true, BibtexKeyManager.hasKey("MageJaJakeh"));
        assertEquals(true, BibtexKeyManager.hasKey("MageJaJakeaa"));
        assertEquals(true, BibtexKeyManager.hasKey("MageJaJakeac"));
    }

}
