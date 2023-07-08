package com.sm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    private static Connection connection = null;
    private static DatabaseHelper instance = null;

    private DatabaseHelper() {
        ConfigLoader configLoader = ConfigLoader.getInstance();

        String url = configLoader.getProperty("db.url");
        String user = configLoader.getProperty("db.username");
        String password = configLoader.getProperty("db.password");

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Get a connection to the database
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseHelper getInstance() {
        if (instance == null) {
            instance = new DatabaseHelper();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
