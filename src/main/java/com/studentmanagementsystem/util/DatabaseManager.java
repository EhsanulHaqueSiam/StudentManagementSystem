package main.java.com.studentmanagementsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
  private static final DatabaseManager instance = new DatabaseManager();
  private final String url;
  private final String user;
  private final String password;
  private final List<Connection> connectionPool = new ArrayList<>();
  private final int maxPoolSize = 10;

  private DatabaseManager() {
    try {
      ConfigLoader configLoader = ConfigLoader.getInstance();
      url = configLoader.getProperty("db.url");
      user = configLoader.getProperty("db.username");
      password = configLoader.getProperty("db.password");

      initializeConnectionPool();
    } catch (SQLException e) {
      throw new RuntimeException("Failed to initialize the database connection pool.", e);
    }
  }

  private void initializeConnectionPool() throws SQLException {
    for (int i = 0; i < maxPoolSize; i++) {
      connectionPool.add(createNewConnection());
    }
  }

  private Connection createNewConnection() throws SQLException {
    return DriverManager.getConnection(url, user, password);
  }

  public static DatabaseManager getInstance() {
    return instance;
  }

  public synchronized Connection getConnection() throws SQLException {
    if (connectionPool.isEmpty()) {
      // If the pool is empty, create a new connection and return it
      return createNewConnection();
    } else {
      // Otherwise, retrieve a connection from the pool
      return connectionPool.remove(connectionPool.size() - 1);
    }
  }

  public synchronized void releaseConnection(Connection connection) {
    if (connection != null) {
      // Release the connection by adding it back to the pool
      connectionPool.add(connection);
    }
  }

  public void closeResources(ResultSet resultSet, PreparedStatement preparedStatement) {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
    } catch (SQLException e) {
      // Handle or log the exception, don't just print the stack trace.
      e.printStackTrace();
    }

    try {
      if (preparedStatement != null) {
        preparedStatement.close();
      }
    } catch (SQLException e) {
      // Handle or log the exception, don't just print the stack trace.
      e.printStackTrace();
    }
  }

  public void closeConnection(Connection connection) {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    } catch (SQLException e) {
      // Handle or log the exception, don't just print the stack trace.
      e.printStackTrace();
    }
  }

  public void close() {
    for (Connection connection : connectionPool) {
      try {
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
