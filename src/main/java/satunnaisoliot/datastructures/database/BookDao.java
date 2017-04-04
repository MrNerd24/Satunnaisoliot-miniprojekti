package satunnaisoliot.datastructures.database;

import satunnaisoliot.SqlDatastore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by laura
 */
public class BookDao {

    private SqlDatastore datastore;

    public BookDao(SqlDatastore datastore) {
        this.datastore = datastore;
    }

    public void addBook(String author, String title, String publisher, String year, String volume, String series, String address, String month, String note, String key) throws SQLException {
        Connection connection = datastore.getConnection();
        PreparedStatement stmt = connection.prepareStatement("insert into Book Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, author);
        stmt.setString(2, title);
        stmt.setString(3, publisher);
        stmt.setString(4, year);
        stmt.setString(5, volume);
        stmt.setString(6, series);
        stmt.setString(7, address);
        stmt.setString(8, month);
        stmt.setString(9, note);
        stmt.setString(10, key);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }

}
