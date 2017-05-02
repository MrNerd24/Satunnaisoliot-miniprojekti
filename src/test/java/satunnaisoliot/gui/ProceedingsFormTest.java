package satunnaisoliot.gui;

import java.awt.Frame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProceedingsFormTest {
    private static FormController fc = new FormController();
    private static ProceedingsForm instance = new ProceedingsForm(fc);
    
    public ProceedingsFormTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance.showForm();
        instance.setVisible(true);
    }
    
    @AfterClass
    public static void tearDownClass() {
        Frame[] a = ProceedingsForm.getFrames();
        for(Frame i : a){
            i.dispose();
        }
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
        instance.setAllFields("bibke","asd", "asd", "", "", "", "", "", "", "", "","");
        String[] a = instance.getAllFields();
        if(a[0].equals("bibke") && a[1].equals("asd") && a[4].equals("")){
        }else fail("setteri ja getteri ei toimi");
    }
    
}
