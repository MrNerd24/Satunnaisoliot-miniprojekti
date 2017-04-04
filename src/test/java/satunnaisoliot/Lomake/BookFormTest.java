package satunnaisoliot.Lomake;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import satunnaisoliot.lomake.BookForm;

/**
 *
 * @author Peter
 */
public class BookFormTest {
    private static BookForm instance = new BookForm();
    
    public BookFormTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance.showForm();
        instance.setVisible(true);
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
        instance.setAllFields("asd", "asd", "", "", "", "", "", "", "", "");
        String[] a = instance.getAllFields();
        if(a[0].equals("asd") && a[1].equals("asd") && a[2].equals("")){
        }else fail("setteri ja getteri ei toimi");
    }
    
}
