/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.gui;

import satunnaisoliot.gui.BookForm;
import satunnaisoliot.gui.ArticleForm;
import satunnaisoliot.SqlDatastore;
import satunnaisoliot.datastructures.database.BookDao;
import satunnaisoliot.datastructures.database.ProceedingsDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import satunnaisoliot.datastructures.database.ArticleDao;
import satunnaisoliot.datastructures.references.Article;
import satunnaisoliot.datastructures.references.Book;
import satunnaisoliot.datastructures.references.Proceedings;

/**
 *
 * @author Peter
 */
public class LomakeController {
    SqlDatastore db;
    public LomakeController(){
        
    }
    public LomakeController(SqlDatastore sql){
        this.db = sql;
    }

    public void main(String[] args) { //stub testaamiselle
        ArticleForm af = new ArticleForm();
        af.showForm();
    }

    public void newArticle() {
        ArticleForm af = new ArticleForm();
        af.showForm();
    }
    public void saveArticle(String author, String title, String journal, String year, String volume, String number, String pages, String month, String note, String key) {
        ArticleDao ad = new ArticleDao(new SqlDatastore("referenceDB.db"));

        
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
        
        //tee jotain artikkelille

        try {
            ad.addArticle(author, title, journal, year, volume, number, pages, month, note, key);
        } catch (SQLException ex) {
            Logger.getLogger(LomakeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void newBook() {
        BookForm bf = new BookForm();
        bf.showForm();
    }
    public void saveBook(String author, String title, String publisher, String year, String volume, String series, String address, String month, String note, String key) {
        
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
        
        //tee jotain kirjalle

        BookDao bd = new BookDao(this.db);
        try {
            bd.addBook(author, title, publisher, year, volume, series, address, month, note, key);
        } catch (SQLException ex) {
            Logger.getLogger(LomakeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void newProceeding() {
        ProceedingsForm pf = new ProceedingsForm();
        pf.showForm();
    }
    public void saveProceeding(String title, String year, String editor, String volume, String series, String address, String month, String publisher, String organization, String note, String key) {
        
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
        
        //tee jotain proceedingille

        ProceedingsDao pd = new ProceedingsDao(this.db);
        try {
            pd.addProceedings(title, year, editor, volume, series, address, month, publisher, organization, note, key);
        } catch (SQLException ex) {
            Logger.getLogger(LomakeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
