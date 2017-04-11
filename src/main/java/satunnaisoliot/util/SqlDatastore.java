package satunnaisoliot.util;

import java.sql.*;

public class SqlDatastore {

    // by reference table names should be lowercase....
    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS Reference (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "reference_type VARCHAR," +
        "bibtex_key VARCHAR," +
        "address VARCHAR," +
        "annote VARCHAR, " +
        "author VARCHAR, " +
        "booktitle VARCHAR, " +
        "chapter VARCHAR, " +
        "crossref VARCHAR, " +
        "edition VARCHAR, " +
        "editor VARCHAR, " +
        "howpublished VARCHAR, " +
        "institution VARCHAR, " +
        "journal VARCHAR, " +
        "bibkey VARCHAR, " +
        "month VARCHAR, " +
        "note VARCHAR, " +
        "number VARCHAR, " +
        "organization VARCHAR, " +
        "pages VARCHAR, " +
        "publisher VARCHAR, " +
        "school VARCHAR, " +
        "series VARCHAR, " +
        "title VARCHAR, " +
        "type VARCHAR, " +
        "volume VARCHAR, " +
        "year VARCHAR " +
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
            stmt.executeUpdate(SQL_CREATE_TABLE);
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
