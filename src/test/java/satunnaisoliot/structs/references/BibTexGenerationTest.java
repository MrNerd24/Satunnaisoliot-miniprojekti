/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.structs.references;

import satunnaisoliot.structs.references.Book;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author juuso_j0pbwen
 */
public class BibTexGenerationTest {
    
    Book swebok;
    
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
    
    @Test
    public void generateBibTexExamplesTest() {
        swebok = new Book();
        swebok.setBibTexKey("SWEBOK");
        swebok.setPublisher("IEEE Computer Society");
        swebok.setEditor("Abram, Aman;More, James W;Bourgue Pierre;Dupuis Robert");
        swebok.setYear("2004");
        swebok.setTitle("Guide to the Software Engineering Body of Knownledge");
        
        for (String line : swebok.toBibTex()) {
            System.out.println(line);
        }
        
        swebok = new Book();
        swebok.setBibTexKey("test");
        swebok.setPublisher("åbo akademi");
        swebok.setEditor("åke åström");
        swebok.setYear("2004");
        swebok.setTitle("öfäååäåsäöåÖsÄÅÖfdÅjÄÖqÖjtÅÖÄ");
        swebok.setNote("Ääliö älä lyö, ööliä läikkyy");
        
        for (String line : swebok.toBibTex()) {
            System.out.println(line);
        }
    }
}
