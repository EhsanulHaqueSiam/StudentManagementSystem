package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Faculty;
import main.java.com.studentmanagementsystem.util.DatabaseManager;
import main.java.com.studentmanagementsystem.data.query.FacultyQueryConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAOImpl implements FacultyDAO {

  private DatabaseManager databaseManager;

  public FacultyDAOImpl() {
    databaseManager = DatabaseManager.getInstance();
  }

  @Override
  public void addFaculty(Faculty faculty) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FacultyQueryConstants.INSERT_FACULTY)) {

      preparedStatement.setInt(1, faculty.getFacultyId());
      preparedStatement.setString(2, faculty.getName());
      preparedStatement.setString(3, faculty.getContact());
      preparedStatement.setString(4, faculty.getEmail());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void updateFaculty(Faculty faculty) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FacultyQueryConstants.UPDATE_FACULTY)) {

      preparedStatement.setString(1, faculty.getName());
      preparedStatement.setString(2, faculty.getContact());
      preparedStatement.setString(3, faculty.getEmail());
      preparedStatement.setInt(4, faculty.getFacultyId());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteFaculty(String facultyId) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FacultyQueryConstants.DELETE_FACULTY)) {

      preparedStatement.setString(1, facultyId);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Faculty getFacultyById(String facultyId) {
    Faculty faculty = null;

    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FacultyQueryConstants.GET_FACULTY_BY_ID)) {

      preparedStatement.setString(1, facultyId);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          faculty = extractFacultyFromResultSet(resultSet);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return faculty;
  }

  @Override
  public List<Faculty> getAllFaculties() {
    List<Faculty> faculties = new ArrayList<>();

    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FacultyQueryConstants.GET_ALL_FACULTIES);
        ResultSet resultSet = preparedStatement.executeQuery()) {

      while (resultSet.next()) {
        Faculty faculty = extractFacultyFromResultSet(resultSet);
        faculties.add(faculty);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return faculties;
  }

  private Faculty extractFacultyFromResultSet(ResultSet resultSet) throws SQLException {
    int facultyId = resultSet.getInt("F_ID");
    String name = resultSet.getString("F_name");
    String contact = resultSet.getString("F_contact");
    String email = resultSet.getString("F_mail");

    return new Faculty(facultyId, name, contact, email);
  }
}
