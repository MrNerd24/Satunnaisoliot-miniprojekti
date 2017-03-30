import satunnaisoliot.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class StubMain {

    public static void main(String[] args) {
        SqlDatastore datastore = new SqlDatastore("foo.sqlite");
        Statement stmt = datastore.getNewStatement();
        try {
            // semicolons are optional at the end of the sql string
            stmt.executeUpdate("create table if not exists foo (field1 integer, field2 varchar)");
            stmt.executeUpdate("insert into foo values (3, 'three'), (4, 'four'), (5, 'five'), (6, 'six')");

            // closing a statement is technically optional but recommended
            stmt.close();

            // you could also do executeQuery on a Statement received from
            // datastore.getNewStatement, but this method exists as a
            // convenience.
            ResultSet rs = datastore.query("SELECT field1 AS intfield, field2 AS stringfield FROM foo");
            while (rs.next()) {
                // notice how sqlite is flexible: we can retrieve a string
                // from a column defined as integer
                System.out.println(rs.getString("intfield") + "\t" + rs.getString("stringfield"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

}
