/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.lomake;

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

    public static void main(String[] args) { //stub testaamiselle
        ArticleForm af = new ArticleForm();
        af.showForm();
    }

    public static void newArticle() {
        ArticleForm af = new ArticleForm();
        af.showForm();
    }
    public static void saveArticle(String author, String title, String journal, String year, String volume, String number, String pages, String month, String note, String key) {
        //ArticleDao ad = new ArticleDao();
        Author auth = new Author(author);
        Title tit = new Title(title);
        Journal jour = new Journal(journal);
        Year yr = new Year(Integer.getInteger(year));
        Volume vol = new Volume(volume);
        Number num = new Number(Integer.getInteger(number));
        Pages pgs = new Pages(Integer.getInteger(pages));
        Month mth = new Month(Integer.getInteger(month));
        Note nte = new Note(note);
        Key k = new Key(Integer.getInteger(key));
        
        Article article = new Article(auth,tit,jour,yr,vol);
        article.addNumber(num);
        article.addPages(pgs);
        article.addMonth(mth);
        article.addNote(nte);
        article.addKey(k);
        //tee jotain artikkelille
        
//        try {
//            ad.addArticle(author, title, journal, year, volume, number, pages, month, note, key);
//        } catch (SQLException ex) {
//            Logger.getLogger(LomakeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public static void newBook() {
        BookForm bf = new BookForm();
        bf.showForm();
    }
    public static void saveBook(String author, String title, String publisher, String year, String volume, String series, String address, String month, String note, String key) {
        Author auth = new Author(author);
        Title tit = new Title(title);
        Publisher pub = new Publisher(publisher);
        Year yr = new Year(Integer.getInteger(year));
        Volume vol = new Volume(volume);
        Series ser = new Series(series);
        Address add = new Address(address);
        Month mth = new Month(Integer.getInteger(month));
        Note nte = new Note(note);
        Key k = new Key(Integer.getInteger(key));
        
        Book book = new Book(auth, tit, pub, yr);
        book.addSeries(ser);
        book.addAddress(add);
        book.addMonth(mth);
        book.addNote(nte);
        book.addKey(k);
        //tee jotain kirjalle
    }

    public static void newProceeding() {
        ProceedingsForm pf = new ProceedingsForm();
        pf.showForm();
    }
    public static void saveProceeding(String title, String year, String editor, String volume, String series, String address, String month, String publisher, String organization, String note, String key) {
        Title tit = new Title(title);
        Year yr = new Year(Integer.getInteger(year));
        Editor ed = new Editor(editor);
        Volume vol = new Volume(volume);
        Series ser = new Series(series);
        Address add = new Address(address);
        Month mth = new Month(Integer.getInteger(month));     
        Publisher pub = new Publisher(publisher);
        Organization org = new Organization(organization);
        Note nte = new Note(note);
        Key k = new Key(Integer.getInteger(key));
        
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
    }
}
