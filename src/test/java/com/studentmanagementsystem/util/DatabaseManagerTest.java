package test.java.com.studentmanagementsystem.util;

import main.java.com.studentmanagementsystem.util.DatabaseManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseManagerTest {

  private DatabaseManager databaseManager;

  @BeforeEach
  public void setUp() {
    databaseManager = DatabaseManager.getInstance();
  }

  @AfterEach
  public void tearDown() {
    DatabaseManager.resetInstance();
  }

  @Test
  public void testSingletonPattern() {
    DatabaseManager instance1 = DatabaseManager.getInstance();
    DatabaseManager instance2 = DatabaseManager.getInstance();
    assertSame(instance1, instance2);
  }

  @Test
  public void testGetConnection() throws SQLException {
    Connection connection = databaseManager.getConnection();
    assertNotNull(connection);
    connection.close();
  }

  @Test
  public void testReleaseConnection() throws SQLException {
    Connection connection = databaseManager.getConnection();
    databaseManager.releaseConnection(connection);

    Connection reusedConnection = databaseManager.getConnection();
    assertEquals(connection, reusedConnection);

    // Close the reused connection
    reusedConnection.close();
  }

  @Test
  public void testCloseConnection() throws SQLException {
    Connection connection = databaseManager.getConnection();

    databaseManager.closeConnection(connection);
    assertTrue(connection.isClosed());
  }

  @Test
  public void testClose() throws SQLException {
    Connection connection1 = databaseManager.getConnection();
    Connection connection2 = databaseManager.getConnection();

    // Release the connections back to the pool
    databaseManager.releaseConnection(connection1);
    databaseManager.releaseConnection(connection2);

    // Close the database manager (including released connections)
    databaseManager.close();

    assertTrue(databaseManager.isConnectionClosed(connection1));
    assertTrue(databaseManager.isConnectionClosed(connection2));
  }

  // Add more test methods as needed for monitoring, metrics, and security-related
  // functionality
}
