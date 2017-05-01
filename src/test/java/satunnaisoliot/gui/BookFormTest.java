package satunnaisoliot.gui;

import java.awt.Frame;
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
public class BookFormTest {
    private static FormController fc = new FormController();
    private static BookForm instance = new BookForm(fc);
    
    public BookFormTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance.showForm();
        instance.setVisible(true);
    }
    
    @AfterClass
    public static void tearDownClass() {
        Frame[] b = BookForm.getFrames();
        for(Frame i : b){
            i.dispose();
        }
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of showForm method, of class ArticleForm.
     */
    @Test
    public void testShowForm() {
        System.out.println("showForm");
        if(!instance.isVisible()){
            fail("kirjalomake ei näy");
        }
    }
    @Test
    public void testSetAndGetAllFields() {
        instance.setAllFields("bibk","asd", "asd", "", "", "", "", "", "", "", "");
        String[] a = instance.getAllFields();
        if(a[0].equals("bibk") && a[1].equals("asd") && a[5].equals("")){
        }else fail("setteri ja getteri ei toimi");
    }
    
}
