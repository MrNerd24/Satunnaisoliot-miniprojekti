package satunnaisoliot.gui;

import java.awt.Frame;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArticleFormTest {

    private static FormController fc = new FormController();
    private static ArticleForm instance = new ArticleForm(fc);

    public ArticleFormTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        instance.showForm();
        instance.setVisible(true);
    }

    @AfterClass
    public static void tearDownClass() {
        Frame[] a = ArticleForm.getFrames();
        for (Frame i : a) {
            i.dispose();
        }
    }
    /**
     * Test of showForm method, of class ArticleForm.
     */
    @Test
    public void testShowForm() {
        System.out.println("showForm");
        if (!instance.isVisible()) {
            fail("Artikkelilomake ei näy");
        }
    }

    @Test
    public void testSetAndGetAllFields() {
        instance.setAllFields("bib", "asd", "asd", "", "", "", "", "", "", "", "");
        String[] a = instance.getAllFields();
        if (a[0].equals("bib") && a[1].equals("asd") && a[5].equals("")) {
        } else {
            fail("setteri ja getteri ei toimi");
        }
    }

}
