package satunnaisoliot.datastructures.database;

import satunnaisoliot.util.SqlDatastore;
import satunnaisoliot.datastructures.enums.FieldType;
import satunnaisoliot.datastructures.generic.GenericReference;
import satunnaisoliot.datastructures.interfaces.Reference;
import satunnaisoliot.datastructures.references.Article;
import satunnaisoliot.datastructures.references.Book;
import satunnaisoliot.datastructures.references.Proceedings;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReferenceDao implements Dao {

    private SqlDatastore datastore;

    public ReferenceDao(SqlDatastore datastore) {
        this.datastore = datastore;
    }

    @Override
    public void addReference(Reference ref) {
        String type = ref.getType().toString().toLowerCase();

        try {
            PreparedStatement stmt = this.datastore.getNewPreparedStatement("INSERT INTO Reference (reference_type) VALUES (?)");
            stmt.setString(1, type);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);

                for (FieldType field : FieldType.values()) {
                    String content = ref.getField(field);
                    String column = field.toString().toLowerCase();
                    if (content == null) {
                        continue;
                    }
                    if (column == "key") {
                        column = "bibkey";
                    }
                    stmt = this.datastore.getNewPreparedStatement("UPDATE Reference SET " + column + " = ? WHERE id = " + id);
                    stmt.setString(1, content);
                    stmt.executeUpdate();
                }

                stmt = this.datastore.getNewPreparedStatement("UPDATE Reference SET bibtex_key = ? WHERE id = " + id);
                stmt.setString(1, ref.getBibTexKey());
                stmt.executeUpdate();

            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }

    public List<GenericReference> findAll() throws SQLException {
        List<GenericReference> references = new ArrayList<>();
        ResultSet rs = this.datastore.query("SELECT * FROM Reference");

        while (rs.next()) {
            String referenceType = rs.getString("reference_type");
            GenericReference ref;

            switch (referenceType) {
                case "article":
                    ref = new Article();
                    break;
                case "book":
                    ref = new Book();
                    break;
                case "proceedings":
                    ref = new Proceedings();
                    break;
                default:
                    throw new UnsupportedOperationException("Reference type not supported yet.");
            }

            for (FieldType field : FieldType.values()) {
                String column = field.toString().toLowerCase();
                String content = rs.getString(column);
                ref.setField(field, content);
            }
            references.add(ref);
        }
        rs.close();

        return references;
    }

}
