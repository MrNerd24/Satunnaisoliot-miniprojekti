/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.Datastructures.References;

import satunnaisoliot.datastructures.references.Article;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import satunnaisoliot.datastructures.fields.Author;
import satunnaisoliot.datastructures.fields.Journal;
import satunnaisoliot.datastructures.fields.Month;
import satunnaisoliot.datastructures.fields.Note;
import satunnaisoliot.datastructures.fields.Number;
import satunnaisoliot.datastructures.fields.Pages;
import satunnaisoliot.datastructures.fields.Title;
import satunnaisoliot.datastructures.fields.Volume;
import satunnaisoliot.datastructures.fields.Year;
import satunnaisoliot.datastructures.interfaces.Field;

/**
 *
 * @author juuso_j0pbwen
 */
public class ArticleTest {
    
    Article article;
    
    public ArticleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Author author = Author.getAuthorObject("Matti Meikäläinen");
        Title title = Title.getTitleObject("Great Article");
        Journal journal = Journal.getJournalObject("Great Journal");
        Year year = Year.getYearObject(2017);
        Volume volume = Volume.getVolumeObject("1");
        article = new Article(author, title, journal, year, volume);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setAuthor method, of class Article.
     */
    @Test
    public void testSetAuthor() {
        Field originalAuthor = article.getAuthors().get(0);
        assertEquals("Matti Meikäläinen", originalAuthor.toString());
        article.setAuthor(0, Author.getAuthorObject("Maija Meikäläinen"));
        assertEquals("Maija Meikäläinen", article.getAuthors().get(0).toString());
        assertTrue(article.getAuthors().get(0).getReferences().contains(article));
        assertTrue(!originalAuthor.getReferences().contains(article));
    }

    /**
     * Test of addAuthor method, of class Article.
     */
    @Test
    public void testAddAuthor() {
        article.addAuthor(Author.getAuthorObject("Maija Meikäläinen"));
        assertEquals("Matti Meikäläinen", article.getAuthors().get(0).toString());
        assertEquals("Maija Meikäläinen", article.getAuthors().get(1).toString());
        assertTrue(article.getAuthors().get(0).getReferences().contains(article));
        assertTrue(article.getAuthors().get(1).getReferences().contains(article));
    }

    /**
     * Test of getAuthors method, of class Article.
     */
    @Test
    public void testGetAuthors() {
        Author first = (Author) article.getAuthors().get(0);
        Author second = Author.getAuthorObject("Maija Meikäläinen");
        article.addAuthor(second);
        assertEquals(first, article.getAuthors().get(0));
        assertEquals(second, article.getAuthors().get(1));
    }

    /**
     * Test of setTitle method, of class Article.
     */
    @Test
    public void testSetTitle() {
        Title title = Title.getTitleObject("Better title");
        article.setTitle(0, title);
        assertEquals("Better title", article.getTitles().get(0).toString());
    }
    
//    /**
//     * Test of addTitle method, of class Article.
//     */
//    @Test
//    public void testAddTitle() {
//        System.out.println("addTitle");
//        Title value = null;
//        Article instance = null;
//        instance.addTitle(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTitles method, of class Article.
//     */
//    @Test
//    public void testGetTitles() {
//        System.out.println("getTitles");
//        Article instance = null;
//        List<Field> expResult = null;
//        List<Field> result = instance.getTitles();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setJournal method, of class Article.
//     */
//    @Test
//    public void testSetJournal() {
//        System.out.println("setJournal");
//        int index = 0;
//        Journal value = null;
//        Article instance = null;
//        instance.setJournal(index, value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addJournal method, of class Article.
//     */
//    @Test
//    public void testAddJournal() {
//        System.out.println("addJournal");
//        Journal value = null;
//        Article instance = null;
//        instance.addJournal(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getJournals method, of class Article.
//     */
//    @Test
//    public void testGetJournals() {
//        System.out.println("getJournals");
//        Article instance = null;
//        List<Field> expResult = null;
//        List<Field> result = instance.getJournals();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setYear method, of class Article.
//     */
//    @Test
//    public void testSetYear() {
//        System.out.println("setYear");
//        int index = 0;
//        Year value = null;
//        Article instance = null;
//        instance.setYear(index, value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addYear method, of class Article.
//     */
//    @Test
//    public void testAddYear() {
//        System.out.println("addYear");
//        Year value = null;
//        Article instance = null;
//        instance.addYear(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getYears method, of class Article.
//     */
//    @Test
//    public void testGetYears() {
//        System.out.println("getYears");
//        Article instance = null;
//        List<Field> expResult = null;
//        List<Field> result = instance.getYears();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setVolume method, of class Article.
//     */
//    @Test
//    public void testSetVolume() {
//        System.out.println("setVolume");
//        int index = 0;
//        Volume value = null;
//        Article instance = null;
//        instance.setVolume(index, value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addVolume method, of class Article.
//     */
//    @Test
//    public void testAddVolume() {
//        System.out.println("addVolume");
//        Volume value = null;
//        Article instance = null;
//        instance.addVolume(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getVolumes method, of class Article.
//     */
//    @Test
//    public void testGetVolumes() {
//        System.out.println("getVolumes");
//        Article instance = null;
//        List<Field> expResult = null;
//        List<Field> result = instance.getVolumes();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setNumber method, of class Article.
//     */
//    @Test
//    public void testSetNumber() {
//        System.out.println("setNumber");
//        int index = 0;
//        Number value = null;
//        Article instance = null;
//        instance.setNumber(index, value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addNumber method, of class Article.
//     */
//    @Test
//    public void testAddNumber() {
//        System.out.println("addNumber");
//        Number value = null;
//        Article instance = null;
//        instance.addNumber(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getNumbers method, of class Article.
//     */
//    @Test
//    public void testGetNumbers() {
//        System.out.println("getNumbers");
//        Article instance = null;
//        List<Field> expResult = null;
//        List<Field> result = instance.getNumbers();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPages method, of class Article.
//     */
//    @Test
//    public void testSetPages() {
//        System.out.println("setPages");
//        int index = 0;
//        Pages value = null;
//        Article instance = null;
//        instance.setPages(index, value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addPages method, of class Article.
//     */
//    @Test
//    public void testAddPages() {
//        System.out.println("addPages");
//        Pages value = null;
//        Article instance = null;
//        instance.addPages(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPagesList method, of class Article.
//     */
//    @Test
//    public void testGetPagesList() {
//        System.out.println("getPagesList");
//        Article instance = null;
//        List<Field> expResult = null;
//        List<Field> result = instance.getPagesList();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setMonth method, of class Article.
//     */
//    @Test
//    public void testSetMonth() {
//        System.out.println("setMonth");
//        int index = 0;
//        Month value = null;
//        Article instance = null;
//        instance.setMonth(index, value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addMonth method, of class Article.
//     */
//    @Test
//    public void testAddMonth() {
//        System.out.println("addMonth");
//        Month value = null;
//        Article instance = null;
//        instance.addMonth(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMonths method, of class Article.
//     */
//    @Test
//    public void testGetMonths() {
//        System.out.println("getMonths");
//        Article instance = null;
//        List<Field> expResult = null;
//        List<Field> result = instance.getMonths();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setNote method, of class Article.
//     */
//    @Test
//    public void testSetNote() {
//        System.out.println("setNote");
//        int index = 0;
//        Note value = null;
//        Article instance = null;
//        instance.setNote(index, value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addNote method, of class Article.
//     */
//    @Test
//    public void testAddNote() {
//        System.out.println("addNote");
//        Note value = null;
//        Article instance = null;
//        instance.addNote(value);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getNotes method, of class Article.
//     */
//    @Test
//    public void testGetNotes() {
//        System.out.println("getNotes");
//        Article instance = null;
//        List<Field> expResult = null;
//        List<Field> result = instance.getNotes();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toBibTex method, of class Article.
//     */
//    @Test
//    public void testToBibTex() {
//        System.out.println("toBibTex");
//        Article instance = null;
//        List<String> expResult = null;
//        List<String> result = instance.toBibTex();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
