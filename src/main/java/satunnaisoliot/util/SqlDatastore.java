package satunnaisoliot.util;

import java.sql.*;

public class SqlDatastore {

    private static final String createSql = "CREATE TABLE IF NOT EXISTS Reference (\n" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
        "reference_type varchar,\n" +
        "bibtex_key varchar,\n" +
        "address varchar,\n" +
        "annote varchar,\n" +
        "author varchar,\n" +
        "booktitle varchar,\n" +
        "chapter varchar,\n" +
        "crossref varchar,\n" +
        "edition varchar,\n" +
        "editor varchar,\n" +
        "howpublished varchar,\n" +
        "institution varchar,\n" +
        "journal varchar,\n" +
        "bibkey varchar,\n" +
        "month varchar,\n" +
        "note varchar,\n" +
        "number varchar,\n" +
        "organization varchar,\n" +
        "pages varchar,\n" +
        "publisher varchar,\n" +
        "school varchar,\n" +
        "series varchar,\n" +
        "title varchar,\n" +
        "type varchar,\n" +
        "volume varchar,\n" +
        "year varchar\n" +
        ");";

    private Connection connection;
    private String filename;

    private final static int QUERY_TIMEOUT = 10;

    public SqlDatastore(String filename) {
        this.filename = filename;
        String connectionUrl = "jdbc:sqlite:" + filename;
        try {
            this.connection = DriverManager.getConnection(connectionUrl);
            // Create database tables in the file.
            // Because of our use of the IF NOT EXISTS clause,
            // this overwrites nothing.
            Statement stmt = connection.createStatement();
            stmt.executeQuery(createSql);
        } catch (SQLException ex) {
            // should do something smarter in this case probably
            System.err.println(ex.toString());
        }
    }

    public Statement getNewStatement() {
        Statement stmt = null;
        try {
            stmt = this.connection.createStatement();
            stmt.setQueryTimeout(QUERY_TIMEOUT);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return stmt;
    }

    public PreparedStatement getNewPreparedStatement(String query) {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement(query);
            stmt.setQueryTimeout(QUERY_TIMEOUT);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return stmt;
    }

    public ResultSet query(String sqlSelectQuery) {
        try {
            if (this.connection.isClosed()) {
                return null;
            }
            Statement stmt = this.getNewStatement();
            ResultSet rs = stmt.executeQuery(sqlSelectQuery);
            return rs;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public String getFilename() {
        return this.filename;
    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
}
