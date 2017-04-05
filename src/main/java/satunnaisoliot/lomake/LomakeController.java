/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.lomake;

import satunnaisoliot.SqlDatastore;
import satunnaisoliot.datastructures.database.BookDao;
import satunnaisoliot.datastructures.database.ProceedingsDao;
import satunnaisoliot.datastructures.fields.Address;
import satunnaisoliot.datastructures.fields.Publisher;
import satunnaisoliot.datastructures.fields.Year;
import satunnaisoliot.datastructures.fields.Organization;
import satunnaisoliot.datastructures.fields.Series;
import satunnaisoliot.datastructures.fields.Editor;
import satunnaisoliot.datastructures.fields.Note;
import satunnaisoliot.datastructures.fields.Volume;
import satunnaisoliot.datastructures.fields.Journal;
import satunnaisoliot.datastructures.fields.Month;
import satunnaisoliot.datastructures.fields.Key;
import satunnaisoliot.datastructures.fields.Pages;
import satunnaisoliot.datastructures.fields.Author;
import satunnaisoliot.datastructures.fields.Title;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import satunnaisoliot.datastructures.database.ArticleDao;
import satunnaisoliot.datastructures.fields.Number;
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
        Author auth = Author.getAuthorObject(author);
        Title tit = Title.getTitleObject(title);
        Journal jour = Journal.getJournalObject(journal);
        Year yr = Year.getYearObject(Integer.parseInt(year));
        Volume vol = Volume.getVolumeObject(volume);
        Number num = Number.getNumberObject(Integer.parseInt(number));
        Pages pgs = Pages.getPagesObject(Integer.parseInt(pages));
        Month mth = Month.getMonthObject(Integer.parseInt(month));
        Note nte = Note.getNoteObject(note);
        Key k = Key.getKeyObject(Integer.parseInt(key));
        
        Article article = new Article(auth,tit,jour,yr,vol);
        article.addNumber(num);
        article.addPages(pgs);
        article.addMonth(mth);
        article.addNote(nte);
        article.addKey(k);
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
        Author auth = Author.getAuthorObject(author);
        Title tit = Title.getTitleObject(title);
        Publisher pub = Publisher.getPublisherObject(publisher);
        Year yr = Year.getYearObject(Integer.parseInt(year));
        Volume vol = Volume.getVolumeObject(volume);
        Series ser = Series.getSeriesObject(series);
        Address add = Address.getAddressObject(address);
        Month mth = Month.getMonthObject(Integer.parseInt(month));
        Note nte = Note.getNoteObject(note);
        Key k = Key.getKeyObject(Integer.parseInt(key));
        
        Book book = new Book(auth, tit, pub, yr);
        book.addSeries(ser);
        book.addAddress(add);
        book.addMonth(mth);
        book.addNote(nte);
        book.addKey(k);
        //tee jotain kirjalle

        BookDao bd = new BookDao(new SqlDatastore("referenceDB.db"));
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
        Title tit = Title.getTitleObject(title);
        Year yr = Year.getYearObject(Integer.parseInt(year));
        Editor ed = Editor.getEditorObject(editor);
        Volume vol = Volume.getVolumeObject(volume);
        Series ser = Series.getSeriesObject(series);
        Address add = Address.getAddressObject(address);
        Month mth = Month.getMonthObject(Integer.parseInt(month));     
        Publisher pub = Publisher.getPublisherObject(publisher);
        Organization org = Organization.getOrganizationObject(organization);
        Note nte = Note.getNoteObject(note);
        Key k = Key.getKeyObject(Integer.parseInt(key));
        
        Proceedings proceeding = new Proceedings(tit, yr);
        proceeding.addEditor(ed);
        proceeding.addVolume(vol);
        proceeding.addSeries(ser);
        proceeding.addAddress(add);
        proceeding.addMonth(mth);
        proceeding.addPublisher(pub);
        proceeding.addOrganization(org);
        proceeding.addNote(nte);
        proceeding.addKey(k);
        //tee jotain proceedingille

        ProceedingsDao pd = new ProceedingsDao(new SqlDatastore("referenceDB.db"));
        try {
            pd.addProceedings(title, year, editor, volume, series, address, month, publisher, organization, note, key);
        } catch (SQLException ex) {
            Logger.getLogger(LomakeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
