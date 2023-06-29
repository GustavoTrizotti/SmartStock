package br.ifsp.edu.dsw3.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable {
    private static PreparedStatement stmt = null;
    private static Connection connection = null;

    public static Connection createConnection() {
        try {
            if (connection == null) {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:teste.db");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static String getDatabaseName() throws SQLException {
        return connection.getMetaData().getDatabaseProductName();
    }

    public static PreparedStatement createStatement(String sql) {
        try {
            stmt = createConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    @Override
    public void close() throws Exception {
        if (connection != null)
            connection.close();
        if (stmt != null)
            stmt.close();
    }
}
