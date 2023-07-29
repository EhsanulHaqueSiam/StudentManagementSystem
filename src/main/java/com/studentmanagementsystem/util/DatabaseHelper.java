package main.java.com.studentmanagementsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DatabaseHelper class is a utility class that provides a connection to the
 * database.
 * It follows the Singleton pattern to ensure only one instance of
 * DatabaseHelper is created.
 */
public class DatabaseHelper {

  // Singleton instance
  private static DatabaseHelper instance;
  // Connection to the database
  private static Connection connection;

  /**
   * Private constructor to prevent direct instantiation.
   * The connection to the database is established during object creation.
   */
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

  /**
   * Gets the singleton instance of DatabaseHelper.
   *
   * @return The singleton instance of DatabaseHelper.
   */
  public static synchronized DatabaseHelper getInstance() {
    if (instance == null) {
      instance = new DatabaseHelper();
    }
    return instance;
  }

  /**
   * Retrieves the connection to the database.
   *
   * @return The connection to the database.
   */
  public Connection getConnection() {
    return connection;
  }
}
