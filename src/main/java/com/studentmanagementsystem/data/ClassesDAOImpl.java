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

public class ClassesDAOImpl implements ClassesDAO {

  private DatabaseManager databaseManager;

  public ClassesDAOImpl() {
    databaseManager = DatabaseManager.getInstance();
  }

  @Override
  public void addClass(Classes classes) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ClassesQueryConstants.INSERT_CLASS)) {

      preparedStatement.setString(1, classes.getClassRoomno());
      preparedStatement.setString(2, classes.getClassName());
      preparedStatement.setString(3, classes.getClassTime());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void updateClass(Classes classes) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ClassesQueryConstants.UPDATE_CLASS)) {

      preparedStatement.setString(1, classes.getClassName());
      preparedStatement.setString(2, classes.getClassTime());
      preparedStatement.setString(3, classes.getClassRoomno());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteClass(String className) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ClassesQueryConstants.DELETE_CLASS)) {

      preparedStatement.setString(1, className);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Classes getClassByName(String className) {
    Classes classes = null;

    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ClassesQueryConstants.GET_CLASS_BY_ROOM_NO)) {

      preparedStatement.setString(1, className);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          classes = extractClassesFromResultSet(resultSet);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return classes;
  }

  @Override
  public List<Classes> getAllClasses() {
    List<Classes> classesList = new ArrayList<>();

    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ClassesQueryConstants.GET_ALL_CLASSES);
        ResultSet resultSet = preparedStatement.executeQuery()) {

      while (resultSet.next()) {
        Classes classes = extractClassesFromResultSet(resultSet);
        classesList.add(classes);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return classesList;
  }

  private Classes extractClassesFromResultSet(ResultSet resultSet) throws SQLException {
    String className = resultSet.getString("Cl_name");
    String classRoomno = resultSet.getString("Cl_roomno");
    String classTime = resultSet.getString("Cl_time");

    return new Classes(className, classRoomno, classTime);
  }
}
