package main.java.com.studentmanagementsystem.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The DatabaseUtil class provides utility methods to work with database
 * connections.
 */
public class DatabaseUtil {

  /**
   * Closes a database connection, prepared statement, and result set.
   *
   * @param connection        The database connection to be closed.
   * @param preparedStatement The prepared statement to be closed.
   * @param resultSet         The result set to be closed.
   */
  public static void closeConnection(Connection connection, PreparedStatement preparedStatement,
      ResultSet resultSet) {
    if (resultSet != null) {
      try {
        resultSet.close();
      } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception, log it, or rethrow as needed.
      }
    }

    if (preparedStatement != null) {
      try {
        preparedStatement.close();
      } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception, log it, or rethrow as needed.
      }
    }

    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception, log it, or rethrow as needed.
      }
    }
  }
}
