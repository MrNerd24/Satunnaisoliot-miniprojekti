package satunnaisoliot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import cucumber.api.java.Before;
import java.awt.Frame;
import satunnaisoliot.gui.MainWindow;

public class Stepdefs {

    private Frame[] openFrames;
    private MainWindow mw;

    @Before
    public void setUp() {
        openFrames = MainWindow.getFrames();

    }

    @Given("^Program is not running$")
    public void program_is_not_running() throws Throwable {
        openFrames = MainWindow.getFrames();
        System.out.println("open frames (not running): " + openFrames.length);
        assertFalse(openFrames.length > 1);
    }

    @Given("^Program is running$")
    public void program_is_running() throws Throwable {
        String[] arg = {""};
        Main.main(arg);
        Thread.sleep(2500);
        openFrames = MainWindow.getFrames();
        System.out.println("open frames (running): " + openFrames.length);
        assertTrue(openFrames.length >= 1);
    }

    @When("^User launches the program$")
    public void program_launch() throws Throwable {
        openFrames = MainWindow.getFrames();
        System.out.println("open frames (launch): " + openFrames.length);
    }

    @Then("^Main window opens$")
    public void main_window_open() throws Throwable {
        String[] arg = {""};
        Main.main(arg);
        Thread.sleep(2500);
        openFrames = MainWindow.getFrames();
        System.out.println("open frames (launch): " + openFrames.length);
        assertTrue(openFrames.length >= 1);
    }
}
