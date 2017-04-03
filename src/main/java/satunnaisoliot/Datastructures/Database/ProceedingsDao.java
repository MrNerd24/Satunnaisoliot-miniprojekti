package satunnaisoliot.Datastructures.Database;

import satunnaisoliot.SqlDatastore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by laura
 */
public class ProceedingsDao {

    private SqlDatastore datastore;

    public ProceedingsDao(SqlDatastore datastore) {
        this.datastore = datastore;
    }

    public void addProceedings(String title, String year, String editor, String volume, String series, String address, String month, String publisher, String organization, String note, String key) throws SQLException {
        Connection connection = datastore.getConnection();
        PreparedStatement stmt = connection.prepareStatement("insert into Proceedings Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, title);
        stmt.setString(2, year);
        stmt.setString(3, editor);
        stmt.setString(4, volume);
        stmt.setString(5, series);
        stmt.setString(6, address);
        stmt.setString(7, month);
        stmt.setString(8, publisher);
        stmt.setString(9, organization);
        stmt.setString(10, note);
        stmt.setString(11, key);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }

}
