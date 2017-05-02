package satunnaisoliot.gui;

import org.junit.Test;
import static org.junit.Assert.*;

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
