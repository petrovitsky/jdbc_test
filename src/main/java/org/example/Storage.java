package org.example;

import java.sql.*;

public class Storage {
    private static final Storage INSTANCE = new Storage();
    private Connection connection;

    private Storage() {
        try {
            String connectionUrl = "jdbc:h2:./test";
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Storage getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public int executeUpdate(String sql) {
        try (Statement statement = connection.createStatement();) {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
