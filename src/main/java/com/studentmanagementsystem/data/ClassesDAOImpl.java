package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Classes;
import main.java.com.studentmanagementsystem.util.DatabaseHelper;
import main.java.com.studentmanagementsystem.util.DatabaseUtil;
import main.java.com.studentmanagementsystem.data.query.ClassesQueryConstants;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClassesDAOImpl implements ClassesDAO {

  @Override
  public void addClass(Classes classes) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ClassesQueryConstants.INSERT_CLASS);
      preparedStatement.setString(1, classes.getClassName());
      preparedStatement.setString(2, classes.getClassLocation());
      preparedStatement.setTimestamp(3, Timestamp.valueOf(classes.getTime()));
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void updateClass(Classes classes) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ClassesQueryConstants.UPDATE_CLASS);
      preparedStatement.setString(1, classes.getClassLocation());
      preparedStatement.setTimestamp(2, Timestamp.valueOf(classes.getTime()));
      preparedStatement.setString(3, classes.getClassName());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void deleteClass(String className) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ClassesQueryConstants.DELETE_CLASS);
      preparedStatement.setString(1, className);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public Classes getClassByName(String className) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    Classes classes = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ClassesQueryConstants.GET_CLASS_BY_NAME);
      preparedStatement.setString(1, className);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        String classLocation = resultSet.getString("classLocation");
        LocalDateTime time = resultSet.getTimestamp("time").toLocalDateTime();

        classes = new Classes(className, classLocation, time);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
    }

    return classes;
  }

  @Override
  public List<Classes> getAllClasses() {
    List<Classes> classesList = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ClassesQueryConstants.GET_ALL_CLASSES);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        String className = resultSet.getString("className");
        String classLocation = resultSet.getString("classLocation");
        LocalDateTime time = resultSet.getTimestamp("time").toLocalDateTime();

        Classes classes = new Classes(className, classLocation, time);
        classesList.add(classes);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
    }

    return classesList;
  }
}
