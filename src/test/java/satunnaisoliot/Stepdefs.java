package satunnaisoliot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.Robot;
import org.fest.swing.fixture.FrameFixture;
import org.junit.AfterClass;
import satunnaisoliot.gui.ArticleForm;
import satunnaisoliot.gui.MainWindow;
import satunnaisoliot.gui.TypeSelectionWindow;

public class Stepdefs {
    //private Frame[] openFrames;
    private FrameFixture mainWindow;
    private FrameFixture typeSelect;
    private FrameFixture newArticle;
    private Robot robot;
    
    
        @Before
    public void setUp() {
      //openFrames = MainWindow.getFrames();
      robot = BasicRobot.robotWithCurrentAwtHierarchy();
      mainWindow = new FrameFixture(robot, new MainWindow());
      typeSelect = new FrameFixture(robot, new TypeSelectionWindow());
      newArticle = new FrameFixture(robot, new ArticleForm());
      //fmain.show();
    }
    @AfterClass
    public void tearDown() {
      //openFrames = MainWindow.getFrames();
      //fmain.cleanUp();
//      ftypes.cleanUp();
//      fnewarticle.cleanUp();
    }
    @Given("^Program is running$")
    public void program_is_running() throws Throwable {
            mainWindow.show();
            System.out.println("running");
            Thread.sleep(1000);
    }
        @When("^User opens reference selection window$")
    public void ref_select_window_opens() throws Throwable {
            System.out.println("User opens reference selection window");
            mainWindow.button("AddButton").click();
            Thread.sleep(1000);
    }
        @When("^User selects new article$")
    public void ref_select_new_article() throws Throwable {
        typeSelect.show();
        Thread.sleep(1000);
        typeSelect.list("referenceTypeList").clickItem("Article reference");
        Thread.sleep(1000);
    }
        @When("^User inputs test values to new article$")
    public void ref_new_test_article() throws Throwable {
        newArticle.show();
        Thread.sleep(2500);
        newArticle.textBox("bibkeyField").enterText("ErkkiKalle");
        newArticle.textBox("authorField").enterText("Erkki,Kalle");
        newArticle.textBox("titleField").enterText("Erkki");
        newArticle.textBox("journalField").enterText("Erkki");
        newArticle.textBox("yearField").enterText("1000");
        newArticle.textBox("volumeField").enterText("1");
        newArticle.textBox("bibkeyField").requireText("ErkkiKalle");
        newArticle.textBox("authorField").requireText("Erkki,Kalle");
        newArticle.textBox("titleField").requireText("Erkki");
        newArticle.textBox("journalField").requireText("Erkki");
        newArticle.textBox("yearField").requireText("1000");
        newArticle.textBox("volumeField").requireText("1");
        Thread.sleep(2500);
        newArticle.button("saveButton").click();
        Thread.sleep(2500);
    }
        @Then("^Values are added$")
    public void ref_new_article_added() throws Throwable {
    }
}
