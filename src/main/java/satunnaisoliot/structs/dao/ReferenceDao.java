package satunnaisoliot.structs.dao;

import satunnaisoliot.structs.enums.FieldType;
import satunnaisoliot.structs.interfaces.Reference;
import satunnaisoliot.structs.references.Article;
import satunnaisoliot.structs.references.Book;
import satunnaisoliot.structs.references.Proceedings;
import satunnaisoliot.util.DataManager;
import satunnaisoliot.util.SqlDatastore;

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
    public void deleteReference(Reference ref) {
        String bibtexkey = ref.getBibTexKey();
        String reftype = ref.getType().toString().toLowerCase();

        try {
            PreparedStatement stmt = datastore.getNewPreparedStatement("DELETE FROM Reference WHERE reference_type = ? AND bibtex_key = ?");
            stmt.setString(1, reftype);
            stmt.setString(2, bibtexkey);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public List<Reference> findAll() {
        try {
            ResultSet rs = this.datastore.query("SELECT * FROM Reference");
            List<Reference> references = convertResultSetToReferenceList(rs);
            rs.close();

            return references;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    private Reference createReference(String referenceType) {
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
        return ref;
    }

    private Reference setFields(Reference ref, ResultSet rs) {
        try {
            for (FieldType field : FieldType.values()) {
                String column = field.toString().toLowerCase();
                if (column.equals("key")) {
                    column = "bibkey";
                }
                String content = rs.getString(column);
                ref.setField(field, content);
            }
            ref.setBibTexKey(rs.getString("bibtex_key"));
            return ref;
        }  catch (SQLException ex) {
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

    @Override
    public int countReferenceswithSameBibTexKey(String bibTexKey) {
        try {
            ResultSet rs = DataManager.getSqlDatastore().query("SELECT bibtex_key FROM Reference");
            int count = 0;

            while(rs.next()) {
                String key = rs.getString("bibtex_key");
                if(key.matches("^" + bibTexKey + "[a-z]?")) {
                    count++;
                }
            }

            rs.close();
            return count;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Reference> findAllContainingString(String keyword) {
        try {
            PreparedStatement stmt = datastore.getNewPreparedStatement(formSearchQuery());
            for(int i = 1; i < FieldType.values().length; i++) {
                stmt.setString(i, "%" + keyword + "%");
            }
            ResultSet rs = stmt.executeQuery();
            List<Reference> references = convertResultSetToReferenceList(rs);
            rs.close();
            return references;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    private String formSearchQuery() {
        String query = "SELECT * FROM Reference WHERE ";
        String condition = " LIKE ?";
        int i = 0;

        for (FieldType field : FieldType.values()) {
            String column = field.toString().toLowerCase();
            if(!column.matches("key")) {
                query += column + condition;
                if(i < FieldType.values().length - 1) {
                    query += " OR ";
                }
            }
            i++;
        }
        System.out.println(query);
        return query;
    }

    private List<Reference> convertResultSetToReferenceList(ResultSet rs) {
        List<Reference> references = new ArrayList<>();
        try {
            while (rs.next()) {
                String referenceType = rs.getString("reference_type");
                Reference ref = createReference(referenceType);
                setFields(ref, rs);
                references.add(ref);
            }
            rs.close();

            return references;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
