package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Faculty;
import main.java.com.studentmanagementsystem.util.DatabaseHelper;
import main.java.com.studentmanagementsystem.util.DatabaseUtil;
import main.java.com.studentmanagementsystem.data.query.FacultyQueryConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAOImpl implements FacultyDAO {

  @Override
  public void addFaculty(Faculty faculty) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(FacultyQueryConstants.INSERT_FACULTY);
      preparedStatement.setString(1, faculty.getfacultyId());
      preparedStatement.setString(2, faculty.getName());
      preparedStatement.setString(3, faculty.getcontact());
      preparedStatement.setString(4, faculty.getEmail());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void updateFaculty(Faculty faculty) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(FacultyQueryConstants.UPDATE_FACULTY);
      preparedStatement.setString(1, faculty.getName());
      preparedStatement.setString(2, faculty.getcontact());
      preparedStatement.setString(3, faculty.getEmail());
      preparedStatement.setString(4, faculty.getfacultyId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void deleteFaculty(String facultyId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(FacultyQueryConstants.DELETE_FACULTY);
      preparedStatement.setString(1, facultyId);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public Faculty getFacultyById(String facultyId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    Faculty faculty = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(FacultyQueryConstants.GET_FACULTY_BY_ID);
      preparedStatement.setString(1, facultyId);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        String name = resultSet.getString("name");
        String contact = resultSet.getString("contact");
        String email = resultSet.getString("email");

        faculty = new Faculty(facultyId, name, contact, email);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
    }

    return faculty;
  }

  @Override
  public List<Faculty> getAllFaculties() {
    List<Faculty> faculties = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(FacultyQueryConstants.GET_ALL_FACULTIES);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        String facultyId = resultSet.getString("facultyId");
        String name = resultSet.getString("name");
        String contact = resultSet.getString("contact");
        String email = resultSet.getString("email");

        faculties.add(new Faculty(facultyId, name, contact, email));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      //Handle the exception, log it, or rethrow as needed.
      } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
      }

          return faculties;
      }
      }