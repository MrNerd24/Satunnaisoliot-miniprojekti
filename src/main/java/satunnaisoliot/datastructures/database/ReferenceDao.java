package satunnaisoliot.datastructures.database;

import satunnaisoliot.SqlDatastore;
import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.enums.ReferenceType;
import satunnaisoliot.datastructures.interfaces.Reference;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by laura on 6.4.2017.
 */
public class ReferenceDao {
    private SqlDatastore datastore;

    public ReferenceDao(SqlDatastore datastore) {
        this.datastore = datastore;
    }

    public void addReference(Reference ref) {
        String type = ref.getType().toString().toLowerCase();

        try {
            PreparedStatement stmt = this.datastore.getNewPreparedStatement("INSERT INTO Reference (reference_type) VALUES (?)");
            stmt.setString(1, type);
            stmt.executeUpdate();
            ResultSet rs = stmt.getResultSet();
            if(rs.next()) {
                int id = rs.getInt("id");
                for (FieldType field : FieldType.values()) {
                    String content = ref.getField(field);
                    if (content == null) {
                        continue;
                    }

                    stmt = this.datastore.getNewPreparedStatement("INSERT INTO Reference (" + field.toString().toLowerCase() +") VALUES (?) WHERE id = " + id);
                    stmt.setString(1, content);
                    stmt.executeUpdate();
                }
            }
            stmt.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }
}
