package main.java.com.studentmanagementsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The `DatabaseManager` class provides a centralized and efficient way to manage
 * database connections using a connection pool. It follows the Singleton pattern
 * to ensure a single instance of the connection pool is maintained throughout
 * the application's lifecycle.
 *
 * <p>Database connection pooling is an optimization technique that allows
 * reusing established database connections instead of creating new ones for
 * each database operation. This helps improve performance and reduce overhead,
 * especially in applications with frequent database interactions.
 */
public class DatabaseManager {

  // Singleton instance
  private static final DatabaseManager instance = new DatabaseManager();

  // Database connection details
  private final String url;
  private final String user;
  private final String password;

  // Connection pool and its maximum size
  private final List<Connection> connectionPool = new ArrayList<>();
  private final int maxPoolSize = 10;

  /**
   * Private constructor to prevent direct instantiation.
   * Initializes the connection pool with database connection details.
   * Throws a runtime exception if connection pool initialization fails.
   */
  private DatabaseManager() {
    try {
      // Load database configuration
      ConfigLoader configLoader = ConfigLoader.getInstance();
      url = configLoader.getProperty("db.url");
      user = configLoader.getProperty("db.username");
      password = configLoader.getProperty("db.password");

      // Initialize the connection pool
      initializeConnectionPool();
    } catch (SQLException e) {
      throw new RuntimeException("Failed to initialize the database connection pool.", e);
    }
  }

  /**
   * Initializes the connection pool by creating a set number of connections.
   *
   * @throws SQLException if an error occurs while creating a connection.
   */
  private void initializeConnectionPool() throws SQLException {
    for (int i = 0; i < maxPoolSize; i++) {
      connectionPool.add(createNewConnection());
    }
  }

  /**
   * Creates a new database connection.
   *
   * @return A new database connection.
   * @throws SQLException if an error occurs while establishing the connection.
   */
  private Connection createNewConnection() throws SQLException {
    return DriverManager.getConnection(url, user, password);
  }

  /**
   * Retrieves the singleton instance of `DatabaseManager`.
   *
   * @return The singleton instance of `DatabaseManager`.
   */
  public static DatabaseManager getInstance() {
    return instance;
  }

  /**
   * Retrieves a database connection from the connection pool. If the pool is
   * empty, a new connection is created. Reusing existing connections reduces
   * the overhead of creating and closing connections for every database operation.
   *
   * @return A database connection.
   * @throws SQLException if an error occurs while obtaining a connection.
   */
  public synchronized Connection getConnection() throws SQLException {
    if (connectionPool.isEmpty()) {
      // If the pool is empty, create a new connection and return it
      return createNewConnection();
    } else {
      // Otherwise, retrieve a connection from the pool
      return connectionPool.remove(connectionPool.size() - 1);
    }
  }

  /**
   * Releases a database connection back to the connection pool after it has
   * been used. Releasing a connection allows it to be reused for subsequent
   * operations, optimizing resource utilization.
   *
   * @param connection The connection to be released.
   */
  public synchronized void releaseConnection(Connection connection) {
    if (connection != null) {
      // Release the connection by adding it back to the pool
      connectionPool.add(connection);
    }
  }

  /**
   * Closes the result set and prepared statement resources after their use
   * to prevent resource leaks. Proper resource management ensures efficient
   * use of system resources and helps avoid potential issues.
   *
   * @param resultSet         The result set to be closed.
   * @param preparedStatement The prepared statement to be closed.
   */
  public void closeResources(ResultSet resultSet, PreparedStatement preparedStatement) {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
    } catch (SQLException e) {
      // Handle or log the exception
      e.printStackTrace();
    }

    try {
      if (preparedStatement != null) {
        preparedStatement.close();
      }
    } catch (SQLException e) {
      // Handle or log the exception
      e.printStackTrace();
    }
  }

  /**
   * Closes a database connection explicitly when it is no longer needed.
   * Properly closing connections helps release resources and prevent
   * potential memory leaks or connection exhaustion.
   *
   * @param connection The connection to be closed.
   */
  public void closeConnection(Connection connection) {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    } catch (SQLException e) {
      // Handle or log the exception
      e.printStackTrace();
    }
  }

  /**
   * Closes all database connections in the connection pool when they are no
   * longer needed. Properly closing the connections ensures graceful
   * termination of the application and releases any associated resources.
   */
  public void close() {
    for (Connection connection : connectionPool) {
      try {
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      } catch (SQLException e) {
        // Handle or log the exception
        e.printStackTrace();
      }
    }
  }
}
