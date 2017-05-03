package satunnaisoliot.structs.dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import satunnaisoliot.structs.references.Article;
import satunnaisoliot.structs.references.Book;
import satunnaisoliot.structs.references.Proceedings;
import satunnaisoliot.util.DataManager;
import satunnaisoliot.util.SqlDatastore;

import java.io.File;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ReferenceDaoTest {
    static Dao dao;
    static SqlDatastore datastore;
    static File storeFile;

    @BeforeClass
    public static void createDatastore() throws SQLException {
        String storeFilename = "test.sqlite";
        datastore = new SqlDatastore(storeFilename);
        DataManager.setDatabaseFileName(storeFilename);

        storeFile = new File(storeFilename);
        dao = DataManager.getDao();

    }

    @AfterClass
    public static void closeDatastore() {
        datastore.close();
        storeFile.delete();
    }

    @Test
    public void addReferenceTest() {
        Article article = new Article();
        article.setAuthor("Maija Meikäläinen");
        article.setBibTexKey("testArticle");
        dao.addReference(article);

        assertEquals(1, dao.rowcount());
        dao.deleteReference(article);
    }

    @Test
    public void deleteReferenceTest() {
        Article article = new Article();
        article.setAuthor("Maija Meikäläinen");
        article.setBibTexKey("testArticle");
        dao.addReference(article);

        assertEquals(1, dao.findAll().size());
        dao.deleteReference(article);
        assertEquals(0, dao.rowcount());
    }

    @Test
    public void findAllTest() {
        Book book = new Book();
        book.setBibTexKey("a");
        Article art = new Article();
        art.setBibTexKey("b");
        Proceedings proc = new Proceedings();
        proc.setBibTexKey("c");

        dao.addReference(book);
        dao.addReference(art);
        dao.addReference(proc);

        assertEquals(3, dao.findAll().size());

        dao.deleteReference(book);
        dao.deleteReference(art);
        dao.deleteReference(proc);
        assertEquals(0, dao.rowcount());
    }

    @Test
    public void searchTest() {
        Book book = new Book();
        book.setAuthor("Meikäläinen, Maija; Husu, Heikki");
        book.setBibTexKey("aa");
        Article art = new Article();
        art.setJournal("Heikin tiede");
        art.setBibTexKey("bb");

        dao.addReference(book);
        dao.addReference(art);

        assertEquals(0, dao.findAllContainingString("kuu").size());
        assertEquals(1, dao.findAllContainingString("Ma").size());
        assertEquals(2, dao.findAllContainingString("Hei").size());

        dao.deleteReference(book);
        dao.deleteReference(art);
    }
}
