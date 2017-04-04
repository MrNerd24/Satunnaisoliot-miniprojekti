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
public class ProceedingsFormTest {
    private static BookForm instance = new BookForm();
    
    public ProceedingsFormTest() {
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
            fail("proceedingslomake ei näy");
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
