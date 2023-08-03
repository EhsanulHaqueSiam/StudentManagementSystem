package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Classes;
import main.java.com.studentmanagementsystem.util.DatabaseManager;
import main.java.com.studentmanagementsystem.data.query.ClassesQueryConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The `ClassesDAOImpl` class provides implementations for CRUD operations
 * on class records in the database.
 */
public class ClassesDAOImpl implements ClassesDAO {

  private DatabaseManager databaseManager;

  /**
   * Constructs a new `ClassesDAOImpl` instance.
   */
  public ClassesDAOImpl() {
    databaseManager = DatabaseManager.getInstance();
  }

  @Override
  public void addClass(Classes classes) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(ClassesQueryConstants.INSERT_CLASS);

      preparedStatement.setString(1, classes.getClassRoomno());
      preparedStatement.setString(2, classes.getClassName());
      preparedStatement.setString(3, classes.getClassTime());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public void updateClass(Classes classes) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(ClassesQueryConstants.UPDATE_CLASS);

      preparedStatement.setString(1, classes.getClassName());
      preparedStatement.setString(2, classes.getClassTime());
      preparedStatement.setString(3, classes.getClassRoomno());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public void deleteClass(String className) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(ClassesQueryConstants.DELETE_CLASS);

      preparedStatement.setString(1, className);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public Classes getClassByName(String className) {
    Classes classes = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(ClassesQueryConstants.GET_CLASS_BY_ROOM_NO);

      preparedStatement.setString(1, className);

      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        classes = extractClassesFromResultSet(resultSet);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(resultSet, preparedStatement);
      databaseManager.releaseConnection(connection);
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
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(ClassesQueryConstants.GET_ALL_CLASSES);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Classes classes = extractClassesFromResultSet(resultSet);
        classesList.add(classes);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(resultSet, preparedStatement);
      databaseManager.releaseConnection(connection);
    }

    return classesList;
  }

  /**
   * Extracts a `Classes` object from a `ResultSet` row.
   *
   * @param resultSet The `ResultSet` containing class data.
   * @return A `Classes` object representing the class data.
   * @throws SQLException If a database access error occurs.
   */
  private Classes extractClassesFromResultSet(ResultSet resultSet) throws SQLException {
    String className = resultSet.getString("Cl_name");
    String classRoomno = resultSet.getString("Cl_roomno");
    String classTime = resultSet.getString("Cl_time");

    return new Classes(className, classRoomno, classTime);
  }
}
