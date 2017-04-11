/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.datastructures.references;

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
        swebok.setBibTexKey("SWEBOK7");
        swebok.setPublisher("IEEE Couter Society");
        swebok.setEditor("Abram, an;More, James W;Bourgue Pierre;Dupuis Robert");
        swebok.setYear("2004");
        swebok.setTitle("Guide to the Software Engdseering Body of Knownledge");
        
        for (String line : swebok.toBibTex()) {
            System.out.println(line);
        }
    }
}
