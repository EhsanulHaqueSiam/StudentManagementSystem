package main.java.com.studentmanagementsystem.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The `DatabaseManager` class provides a centralized and efficient way to
 * manage
 * database connections using a connection pool. It follows the Singleton
 * pattern
 * to ensure a single instance of the connection pool is maintained throughout
 * the application's lifecycle.
 *
 * <p>
 * Database connection pooling is an optimization technique that allows
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
  private final BlockingQueue<Connection> connectionPool = new LinkedBlockingQueue<>();
  private final int maxPoolSize = 10;

  /**
   * Private constructor to prevent direct instantiation.
   * Initializes the connection pool with database connection details.
   * Throws a runtime exception if connection pool initialization fails.
   */
  private DatabaseManager() {
    try {
      // Load database configuration
      ConfigLoader configLoader = ConfigLoader.getInstance("src/main/resources/config.properties");
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
   * Retrieves the singleton instance of `DatabaseManager`.
   *
   * @return The singleton instance of `DatabaseManager`.
   */
  public static DatabaseManager getInstance() {
    return instance;
  }

  /**
   * Resets the singleton instance of the DatabaseManager class.
   * This method is intended for testing purposes to clear the existing
   * singleton instance, allowing a new instance to be created.
   * It uses reflection to set the "instance" field to null.
   *
   * @throws IllegalAccessException if there's an issue accessing the "instance"
   *                                field.
   */
  public static void resetInstance() {
    try {
      Field instance = DatabaseManager.class.getDeclaredField("instance");
      instance.setAccessible(true);
      instance.set(null, null);
    } catch (Exception e) {
      // Handle the exception appropriately
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
   * Retrieves a database connection from the connection pool. If the pool is
   * empty, a new connection is created. Reusing existing connections reduces
   * the overhead of creating and closing connections for every database
   * operation.
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
      return connectionPool.poll();
    }
  }

  /**
   * Releases a database connection back to the connection pool after it has
   * been used. Releasing a connection allows it to be reused for subsequent
   * operations, optimizing resource utilization.
   *
   * @param connection The connection to be released.
   */
  public void releaseConnection(Connection connection) {
    if (connection != null) {
      connectionPool.offer(connection);
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
    close(resultSet);
    close(preparedStatement);
  }

  /**
   * Closes a database connection explicitly when it is no longer needed.
   * Properly closing connections helps release resources and prevent
   * potential memory leaks or connection exhaustion.
   *
   * @param connection The connection to be closed.
   */
  public void closeConnection(Connection connection) {
    close(connection);
  }

  /**
   * Closes all database connections in the connection pool when they are no
   * longer needed. Properly closing the connections ensures graceful
   * termination of the application and releases any associated resources.
   *
   * @implNote This method iterates through the connection pool, releases
   *           connections that are not closed back to the pool, and then clears
   *           the
   *           connection pool. Connections that are already closed are ignored.
   *           Any
   *           exceptions that occur during the closing of connections are caught
   *           and logged.
   *
   * @implNote It's recommended to call this method when the application is
   *           shutting down or when the database connections are no longer
   *           required to
   *           ensure proper resource management and prevent potential resource
   *           leaks.
   */
  public void close() {
    List<Connection> connectionsToRelease = new ArrayList<>(connectionPool);
    for (Connection connection : connectionsToRelease) {
      closeConnection(connection);
    }
    connectionPool.clear();
  }

  // Private helper method to close resources
  /**
   * Closes a resource (connection, statement, or result set) if it is not null.
   * Properly closing resources helps release system resources and prevent
   * potential memory leaks.
   *
   * @param resource The resource to be closed.
   */
  private void close(AutoCloseable resource) {
    try {
      if (resource != null) {
        resource.close();
      }
    } catch (Exception e) {
      // Handle or log the exception appropriately
    }
  }

  /**
   * Checks if a connection has been closed.
   *
   * @param connection The connection to check.
   * @return True if the connection has been closed, false otherwise.
   */
  public boolean isConnectionClosed(Connection connection) {
    return !connectionPool.contains(connection);
  }

  /**
   * Validates a database connection to ensure it's still functional.
   *
   * @param connection The connection to validate.
   * @return True if the connection is valid, false otherwise.
   */
  private boolean validateConnection(Connection connection) {
    try {
      return connection != null && !connection.isClosed();
    } catch (SQLException e) {
      return false;
    }
  }

  /**
   * Dynamically adjusts the pool size based on demand.
   *
   * @throws SQLException if an error occurs while creating a connection.
   */
  private void adjustPoolSize() throws SQLException {
    if (connectionPool.size() < maxPoolSize) {
      int numToAdd = maxPoolSize - connectionPool.size();
      for (int i = 0; i < numToAdd; i++) {
        connectionPool.offer(createNewConnection());
      }
    }
  }

  /**
   * Gracefully shuts down the connection pool.
   */
  public void shutdown() {
    for (Connection connection : connectionPool) {
      closeConnection(connection);
    }
    connectionPool.clear();
  }

  // Other methods and fields related to monitoring, metrics, and security can be
  // added here.
}
