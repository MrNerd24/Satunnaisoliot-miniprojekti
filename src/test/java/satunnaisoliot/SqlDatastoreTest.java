
package satunnaisoliot;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDatastoreTest {

    static String validStoreFilename = "SqlDatastoreTest1.sqlite";
    static String invalidStoreFilename = "SqlDatastoreTest2.sqlite";
    static String tempStoreFilename = "SqlDatastoreTest3.sqlite";

    // Our validStore is a SqlDatastore based on a SQLite database file
    // created on the fly and destroyed after testing.
    static SqlDatastore validStore;
    // We'll create an invalid SqlDatastore by letting SQLite create the new
    // database file, and then we'll delete it, leaving the java.sql.Connection
    // object pointing at a file that doesn't exist.
    static SqlDatastore invalidStore;

    @BeforeClass
    public static void createDatastores() throws SQLException {
        validStore = new SqlDatastore(validStoreFilename);
        invalidStore = new SqlDatastore(invalidStoreFilename);

        File validStoreFile = new File(validStoreFilename);
        validStoreFile.deleteOnExit();

        File invalidStoreFile = new File(invalidStoreFilename);
        if (invalidStoreFile.exists()) {
            boolean delete = invalidStoreFile.delete();
            if (!delete) {
                System.err.println("Wasn't able to delete '" + invalidStoreFilename + "' for SqlDatastoreTest:ing purposes");
            }
        }

        Statement stmt = validStore.getNewStatement();
        stmt.executeUpdate("CREATE TABLE javatest (intfield INTEGER, strfield VARCHAR)");
        stmt.executeUpdate("INSERT INTO javatest VALUES (1, '111'), (10, 'asdf'), (100, 'qwerty')");
        stmt.close();
    }

    @AfterClass
    public static void closeDatastores() {
        validStore.close();
        invalidStore.close();
    }

    @Test
    public void testGetFilename() {
        assertEquals(validStoreFilename, validStore.getFilename());
    }

    @Test
    public void testGetStatement() {
        assertNotNull(validStore.getNewStatement());
    }

    @Test
    public void testQuery() throws SQLException {
        ResultSet rs = validStore.query("SELECT * FROM javatest ORDER BY intfield ASC");
        rs.next();
        assertEquals(1, rs.getInt("intfield"));
        assertEquals("111", rs.getString("strfield"));
        rs.close();
    }

}
