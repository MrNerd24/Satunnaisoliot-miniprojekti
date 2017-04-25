/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.gui;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter
 */
public class ExportTexWindowTest {
    
    public ExportTexWindowTest() {
    }

    /**
     * Test of main method, of class ExportTexWindow.
     */
    @Test
    public void testMain() throws InterruptedException {
        ExportTexWindow etx = new ExportTexWindow();
        System.out.println("main");
        String[] args = null;
        etx.main(args);
        Thread.sleep(1000);
        assertTrue(etx.isEnabled());
    }
    
}
