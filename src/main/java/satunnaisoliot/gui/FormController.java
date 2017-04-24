/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.gui;

import satunnaisoliot.structs.dao.ReferenceDao;
import satunnaisoliot.structs.interfaces.Reference;
import satunnaisoliot.util.SqlDatastore;
import satunnaisoliot.structs.references.Article;
import satunnaisoliot.structs.references.Book;
import satunnaisoliot.structs.references.Proceedings;
import satunnaisoliot.util.BibtexKeyManager;
import satunnaisoliot.util.DataManager;
import satunnaisoliot.util.PostOffice;

/**
 *
 * @author Peter
 */
public class FormController {

    SqlDatastore db;

    public FormController() {
    }

    public FormController(SqlDatastore sql) {
        this.db = sql;
    }

    public void newArticle() {
        ArticleForm af = new ArticleForm(this, "", "", "", "", "", "", "", "", "", "", "");
        af.showForm();
    }

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

        //  tee jotain artikkelille
        addReference(article);
    }

    public void newBook() {
        BookForm bf = new BookForm(this, "", "", "", "", "", "", "", "", "", "", "");
        bf.showForm();
    }

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

        //tee jotain kirjalle
        addReference(book);
    }

    public void newProceeding() {
        ProceedingsForm pf = new ProceedingsForm(this, "", "", "", "", "", "", "", "", "", "", "", "");
        pf.showForm();
    }

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

        //tee jotain proceedingille
        addReference(proceedings);
    }

    public void addReference(Reference ref) {
        if (BibtexKeyManager.handleBibTexKey(ref)) {
            new ErrorWindow("Reference's bibTexKey has been generated or changed to: " + ref.getBibTexKey()).setVisible(true);
        }

        DataManager.getDao().addReference(ref);
        PostOffice.sendMessage("reference added");
    }
}
