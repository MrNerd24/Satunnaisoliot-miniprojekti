package satunnaisoliot.util;

import java.sql.*;

public class SqlDatastore {

    private Connection connection;
    private String filename;

    private final static int QUERY_TIMEOUT = 10;

    public SqlDatastore(String filename) {
        this.filename = filename;
        String connectionUrl = "jdbc:sqlite:" + filename;
        try {
            this.connection = DriverManager.getConnection(connectionUrl);
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
