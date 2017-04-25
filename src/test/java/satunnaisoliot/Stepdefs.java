package satunnaisoliot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import java.io.File;
import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.Robot;
import org.fest.swing.fixture.FrameFixture;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import satunnaisoliot.gui.ArticleForm;
import satunnaisoliot.gui.BookForm;
import satunnaisoliot.gui.ExportTexWindow;
import satunnaisoliot.gui.MainWindow;
import satunnaisoliot.gui.ProceedingsForm;
import satunnaisoliot.gui.TypeSelectionWindow;

public class Stepdefs {
    //private Frame[] openFrames;
    private FrameFixture mainWindow;
    private FrameFixture typeSelect;
    private FrameFixture newArticle;
    private FrameFixture newBook;
    private FrameFixture newProceeding;
    private FrameFixture exportWindow;
    private Robot robot;
    
    
        @Before
    public void setUp() {
      //openFrames = MainWindow.getFrames();
      robot = BasicRobot.robotWithCurrentAwtHierarchy();
      mainWindow = new FrameFixture(robot, new MainWindow());
      typeSelect = new FrameFixture(robot, new TypeSelectionWindow());
      newArticle = new FrameFixture(robot, new ArticleForm());
      newBook = new FrameFixture(robot, new BookForm());
      newProceeding = new FrameFixture(robot, new ProceedingsForm());
      exportWindow = new FrameFixture(robot, new ExportTexWindow());
      //fmain.show();
    }
    @AfterClass
    public void tearDown() {
      //openFrames = MainWindow.getFrames();
        mainWindow.cleanUp();
        typeSelect.cleanUp();
        newArticle.cleanUp();
        newBook.cleanUp();
        newProceeding.cleanUp();
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
        @When("^User opens export window$")
    public void open_export_window() throws Throwable {
            System.out.println("User opens reference selection window");
            mainWindow.button("ExportButton").click();
           Thread.sleep(1000);
    }
        @When("^User selects new article$")
    public void ref_select_new_article() throws Throwable {
        typeSelect.show();
        Thread.sleep(1000);
        typeSelect.list("referenceTypeList").clickItem("Article reference");
    }
        @When("^User selects new book")
    public void ref_select_new_book() throws Throwable {
        typeSelect.show();
        Thread.sleep(1000);
        typeSelect.list("referenceTypeList").clickItem("Book reference");
    }
        @When("^User selects new proceeding")
    public void ref_select_new_proceeding() throws Throwable {
        typeSelect.show();
        Thread.sleep(1000);
        typeSelect.list("referenceTypeList").clickItem("Proceedings reference");
    }
        @When("^User hits clear button on article form")
    public void ref_clear_article() throws Throwable {
        newArticle.show();
        Thread.sleep(1000);
        newArticle.button("clearButton").click();
        newArticle.textBox("bibtexKeyField").requireText("");
        newArticle.textBox("authorField").requireText("");
        newArticle.textBox("titleField").requireText("");
        newArticle.textBox("journalField").requireText("");
        newArticle.textBox("yearField").requireText("");
        newArticle.textBox("volumeField").requireText("");
    }
        @When("^User hits clear button on book form")
    public void ref_clear_book() throws Throwable {
        newBook.show();
        Thread.sleep(1000);
        newBook.button("clearButton").click();
        newBook.textBox("bibtexKeyField").requireText("");
        newBook.textBox("authorField").requireText("");
        newBook.textBox("titleField").requireText("");
        newBook.textBox("publisherField").requireText("");
        newBook.textBox("yearField").requireText("");
    }
        @When("^User hits clear button on proceedings form")
    public void ref_clear_proceeding() throws Throwable {
        newProceeding.show();
        Thread.sleep(1000);
        newProceeding.button("clearButton").click();
        newProceeding.textBox("bibtexKeyField").requireText("");
        newProceeding.textBox("titleField").requireText("");
        newProceeding.textBox("yearField").requireText("");
    }
        @When("^User inputs values: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" to a new article$")
    public void ref_new_article(String bibkey, String author, String title, String journal, String year, String volume) throws Throwable {
        newArticle.show();
        Thread.sleep(2500);
        newArticle.textBox("bibtexKeyField").enterText(bibkey);
        newArticle.textBox("authorField").enterText(author);
        newArticle.textBox("titleField").enterText(title);
        newArticle.textBox("journalField").enterText(journal);
        newArticle.textBox("yearField").enterText(year);
        newArticle.textBox("volumeField").enterText(volume);
        
        newArticle.textBox("bibtexKeyField").requireText(bibkey);
        newArticle.textBox("authorField").requireText(author);
        newArticle.textBox("titleField").requireText(title);
        newArticle.textBox("journalField").requireText(journal);
        newArticle.textBox("yearField").requireText(year);
        newArticle.textBox("volumeField").requireText(volume);
        //Thread.sleep(1000);
        newArticle.button("saveButton").click();
        newArticle.cleanUp();
            System.out.println("article done");
    }
        @When("^User inputs values: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" to a new book$")
    public void ref_new_book(String bibkey, String author, String title, String publisher, String year, String volume) throws Throwable {
        newBook.show();
        Thread.sleep(2500);
        newBook.textBox("bibtexKeyField").enterText(bibkey);
        newBook.textBox("authorField").enterText(author);
        newBook.textBox("titleField").enterText(title);
        newBook.textBox("publisherField").enterText(publisher);
        newBook.textBox("yearField").enterText(year);
        
        newBook.textBox("bibtexKeyField").requireText(bibkey);
        newBook.textBox("authorField").requireText(author);
        newBook.textBox("titleField").requireText(title);
        newBook.textBox("publisherField").requireText(publisher);
        newBook.textBox("yearField").requireText(year);
        Thread.sleep(500);
        newBook.button("saveButton").click();
        newBook.cleanUp();
    }
        @When("^User inputs values: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" to a new proceeding$")
    public void ref_new_proceeding(String bibkey, String title, String year) throws Throwable {
        newProceeding.show();
        Thread.sleep(2500);
        newProceeding.textBox("bibtexKeyField").enterText(bibkey);
        newProceeding.textBox("titleField").enterText(title);
        newProceeding.textBox("yearField").enterText(year);
        
        newProceeding.textBox("bibtexKeyField").requireText(bibkey);
        newProceeding.textBox("titleField").requireText(title);
        newProceeding.textBox("yearField").requireText(year);
        Thread.sleep(500);
        newProceeding.button("saveButton").click();
        newProceeding.cleanUp();
    }
        @When("^User inputs value: \"([^\"]*)\" to export file path$")
    public void ref_new_proceeding(String export) throws Throwable {
        File file = new File(export);
        file.deleteOnExit();
        if(file.exists()){
            file.delete();
                    }
        exportWindow.show();
        Thread.sleep(2500);
        exportWindow.textBox("filePathField").enterText(export);
        exportWindow.textBox("filePathField").requireText(export);
        Thread.sleep(500);
        exportWindow.button("exportButton").click();
        exportWindow.cleanUp();
        assertTrue(file.exists());
    }
        @Then("^Values are added$")
    public void ref_new_article_added() throws Throwable {
        //check that the value was added somehow
    }
            @Then("^Values are cleared")
    public void ref_values_cleared() throws Throwable {
        //check that the values were cleared somehow
    }
}
