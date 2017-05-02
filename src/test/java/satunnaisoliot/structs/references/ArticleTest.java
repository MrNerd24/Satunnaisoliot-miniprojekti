package satunnaisoliot.structs.references;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juuso_j0pbwen
 */
public class ArticleTest {

    Article article = new Article();

    public ArticleTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        article.setAuthor("Matti Meikäläinen;åäöÅÄÖ påpäpöpÅpÄpÖp");
        article.setTitle("Great article");
        article.setJournal("Journal of great articles");
        article.setYear("2017");
        article.setVolume("1");
        article.setNumber("1");
        article.setPages("3");
        article.setMonth("5");
        article.setNote("Nice!");
        article.setKey("1");
        article.setBibTexKey("testArticle");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setAuthor method, of class Article.
     */
    @Test
    public void testSetAndGet() {
        
        article.setAuthor("Maija Meikäläinen");
        article.setTitle("Better article");
        article.setJournal("Journal of better articles");
        article.setYear("2010");
        article.setVolume("5");
        article.setNumber("3");
        article.setPages("1");
        article.setMonth("8");
        article.setNote("Very nice!");
        article.setKey("5");
        article.setBibTexKey("testArticle");
        
        assertEquals(article.getAuthor(), "Maija Meikäläinen");
        assertEquals(article.getTitle(), "Better article");
        assertEquals(article.getJournal(), "Journal of better articles");
        assertEquals(article.getYear(), "2010");
        assertEquals(article.getVolume(), "5");
        assertEquals(article.getNumber(), "3");
        assertEquals(article.getPages(), "1");
        assertEquals(article.getMonth(), "8");
        assertEquals(article.getNote(), "Very nice!");
        assertEquals(article.getKey(), "5");
        assertEquals(article.getBibTexKey(), "testArticle");
    }
    @Test
    public void testToBibTex() {
        ArrayList<String> bibTex = (ArrayList) article.toBibTex();
        for (String line : bibTex) {
            System.out.println(line);
        }
        assertEquals("	author = {Matti Meik\\\"{a}l\\\"{a}inen and \\aa\\\"{a}\\\"{o}\\AA\\\"{A}\\\"{O} p\\aap\\\"{a}p\\\"{o}p\\AAp\\\"{A}p\\\"{O}p},", bibTex.get(1));
    }

}
