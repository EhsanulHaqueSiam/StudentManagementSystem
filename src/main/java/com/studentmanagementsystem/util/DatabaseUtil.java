package main.java.com.studentmanagementsystem.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtil {
  // Method to close a database connection, statement, and result set
  public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
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
