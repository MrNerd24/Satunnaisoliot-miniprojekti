package satunnaisoliot.gui;

import satunnaisoliot.structs.interfaces.Reference;
import satunnaisoliot.util.SqlDatastore;
import satunnaisoliot.structs.references.Article;
import satunnaisoliot.structs.references.Book;
import satunnaisoliot.structs.references.Proceedings;
import satunnaisoliot.util.BibtexKeyManager;
import satunnaisoliot.util.DataManager;
import satunnaisoliot.util.PostOffice;

/**
 * Handles opening and saving new references.
 *
 * @author Peter
 */
public class FormController {

    SqlDatastore db;

    public FormController() {
    }

    /**
     * Create new controller for datastore
     *
     * @param sql datastore to create controller for.
     */
    public FormController(SqlDatastore sql) {
        this.db = sql;
    }

    /**
     * Opens a window for new blank article.
     */
    public void newArticle() {
        ArticleForm af = new ArticleForm(this);
        af.showForm();
    }

    /**
     * Saves an article with given parameters.
     *
     * @param bibkey
     * @param author
     * @param title
     * @param journal
     * @param year
     * @param volume
     * @param number
     * @param pages
     * @param month
     * @param note
     * @param key
     */
    public void saveArticle(String bibkey, String author, String title, String journal, String year, String volume, String number, String pages, String month, String note, String key) {
        Article article = new Article();
        article.setAuthor(author);
        article.setTitle(title);
        article.setJournal(journal);
        article.setYear(year);
        article.setVolume(volume);
        article.setNumber(number);
        article.setPages(pages);
        article.setMonth(month);
        article.setNote(note);
        article.setKey(key);
        article.setBibTexKey(bibkey);

        addReference(article);
    }

    /**
     * Opens a window for a new blank book.
     */
    public void newBook() {
        BookForm bf = new BookForm(this);
        bf.showForm();
    }

    /**
     * Saves a book with given parameters.
     *
     * @param bibkey
     * @param author
     * @param title
     * @param publisher
     * @param year
     * @param volume
     * @param series
     * @param address
     * @param month
     * @param note
     * @param key
     */
    public void saveBook(String bibkey, String author, String title, String publisher, String year, String volume, String series, String address, String month, String note, String key) {

        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setYear(year);
        book.setVolume(volume);
        book.setAddress(address);
        book.setSeries(series);
        book.setMonth(month);
        book.setNote(note);
        book.setKey(key);
        book.setBibTexKey(bibkey);

        addReference(book);
    }

    /**
     * Open a window for new blank proceeding.
     */
    public void newProceeding() {
        ProceedingsForm pf = new ProceedingsForm(this);
        pf.showForm();
    }

    /**
     * Saves a proceeding with given parameters.
     *
     * @param bibkey
     * @param title
     * @param year
     * @param editor
     * @param volume
     * @param series
     * @param address
     * @param month
     * @param publisher
     * @param organization
     * @param note
     * @param key
     */
    public void saveProceeding(String bibkey, String title, String year, String editor, String volume, String series, String address, String month, String publisher, String organization, String note, String key) {

        Proceedings proceedings = new Proceedings();
        proceedings.setTitle(title);
        proceedings.setPublisher(publisher);
        proceedings.setYear(year);
        proceedings.setEditor(editor);
        proceedings.setVolume(volume);
        proceedings.setAddress(address);
        proceedings.setOrganization(organization);
        proceedings.setSeries(series);
        proceedings.setMonth(month);
        proceedings.setNote(note);
        proceedings.setKey(key);
        proceedings.setBibTexKey(bibkey);

        addReference(proceedings);
    }

    /**
     * Add reference to the database.
     *
     * @param ref Reference to add.
     */
    public void addReference(Reference ref) {
        if (BibtexKeyManager.handleBibTexKey(ref)) {
            new ErrorWindow("Reference's bibTexKey has been generated or changed to: " + ref.getBibTexKey()).setVisible(true);
        }

        DataManager.getDao().addReference(ref);
        PostOffice.sendMessage("reference added");
    }

    void pasteBibtex() {
        PasteBibtexWindow pb = new PasteBibtexWindow(this);
        pb.showForm();
    }

}
