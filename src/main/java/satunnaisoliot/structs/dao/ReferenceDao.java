package satunnaisoliot.structs.dao;

import satunnaisoliot.util.SqlDatastore;
import satunnaisoliot.structs.enums.FieldType;
import satunnaisoliot.structs.generic.GenericReference;
import satunnaisoliot.structs.interfaces.Reference;
import satunnaisoliot.structs.references.Article;
import satunnaisoliot.structs.references.Book;
import satunnaisoliot.structs.references.Proceedings;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import satunnaisoliot.util.DataManager;

public class ReferenceDao implements Dao {

    private SqlDatastore datastore;

    public ReferenceDao(SqlDatastore datastore) {
        this.datastore = datastore;
    }

    @Override
    public void addReference(Reference ref) {
        String type = ref.getType().toString().toLowerCase();

        try {
            PreparedStatement stmt = DataManager.getSqlDatastore().getNewPreparedStatement("INSERT INTO Reference (reference_type) VALUES (?)");
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
                    if (column.equals("key")) {
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

    @Override
    public List<Reference> findAll() {
        try {
            List<Reference> references = new ArrayList<>();
            ResultSet rs = this.datastore.query("SELECT * FROM Reference");

            while (rs.next()) {
                String referenceType = rs.getString("reference_type");
                Reference ref;

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
                    if (column.equals("key")) {
                        column = "bibkey";
                    }
                    String content = rs.getString(column);
                    ref.setField(field, content);
                }
                ref.setBibTexKey(rs.getString("bibtex_key"));
                references.add(ref);
            }
            rs.close();

            return references;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public int rowcount() {
        try {
            ResultSet rs = this.datastore.query("SELECT COUNT(id) AS count FROM Reference");
            rs.next();
            int rowcount = rs.getInt("count");
            return rowcount;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
