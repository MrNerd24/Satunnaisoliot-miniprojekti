package satunnaisoliot.gui;

import java.awt.Frame;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import satunnaisoliot.util.DataManager;

public class FormControllerTest {

    FormController lc = new FormController();

    public FormControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        DataManager.setDatabaseFileName(":memory:");
    }

    @AfterClass
    public static void tearDownClass() {
        Frame[] a = ArticleForm.getFrames();
        Frame[] b = ProceedingsForm.getFrames();
        Frame[] c = BookForm.getFrames();
        for (Frame i : a) {
            i.dispose();
        }
        for (Frame i : b) {
            i.dispose();
        }
        for (Frame i : c) {
            i.dispose();
        }
    }

    /**
     * Test of newArticle method, of class FormController.
     */
    @Test
    public void testNewArticle() {
        System.out.println("newArticle");
    }

    /**
     * Test of saveArticle method, of class FormController.
     */
    @Test
    public void testSaveArticle() {
        System.out.println("saveArticle");

        String bibkey = "asd";
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
        lc.saveArticle(bibkey, author, title, journal, year, volume, number, pages, month, note, key);
    }

    /**
     * Test of newBook method, of class FormController.
     */
    public void testNewBook() {
        System.out.println("newBook");
        lc.newBook();
    }

    /**
     * Test of saveBook method, of class FormController.
     */
    @Test
    public void testSaveBook() {
        System.out.println("saveBook");
        String bibkey = "asd";
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
        lc.saveBook(bibkey, author, title, publisher, year, volume, series, address, month, note, key);
    }

    /**
     * Test of newProceeding method, of class FormController.
     */
    @Test
    public void testNewProceeding() {
        System.out.println("newProceeding");
        lc.newProceeding();
    }

    /**
     * Test of saveProceeding method, of class FormController.
     */
    @Test
    public void testSaveProceeding() {
        System.out.println("saveProceeding");
        String bibkey = "asdasd";
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
        lc.saveProceeding(bibkey, title, year, editor, volume, series, address, month, publisher, organization, note, key);
    }
}
