package main.java.com.studentmanagementsystem.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.java.com.studentmanagementsystem.data.query.StudentQueryConstants;
import main.java.com.studentmanagementsystem.model.Student;
import main.java.com.studentmanagementsystem.util.DatabaseManager;

/**
 * The StudentDAOImpl class implements the StudentDAO interface and provides methods
 * for performing CRUD (Create, Read, Update, Delete) operations on Student entities
 * in the database.
 */
public class StudentDAOImpl implements StudentDAO {

  private final DatabaseManager databaseManager;

  public StudentDAOImpl() {
    databaseManager = DatabaseManager.getInstance();
  }

  @Override
  public void addStudent(Student student) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(StudentQueryConstants.INSERT_STUDENT);

      preparedStatement.setInt(1, student.getStudentId());
      preparedStatement.setString(2, student.getName());
      preparedStatement.setString(3, student.getEmail());
      preparedStatement.setString(4, student.getContact());
      preparedStatement.setDate(5, new java.sql.Date(student.getEnrollYear().getTime()));
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public void updateStudent(Student student) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(StudentQueryConstants.UPDATE_STUDENT);

      preparedStatement.setString(1, student.getName());
      preparedStatement.setString(2, student.getEmail());
      preparedStatement.setString(3, student.getContact());
      preparedStatement.setDate(4, new java.sql.Date(student.getEnrollYear().getTime()));
      preparedStatement.setInt(5, student.getStudentId());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public void deleteStudent(int id) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(StudentQueryConstants.DELETE_STUDENT);

      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public Student getStudentById(int id) {
    Student student = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(StudentQueryConstants.GET_STUDENT_BY_ID);

      preparedStatement.setInt(1, id);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        student = extractStudentFromResultSet(resultSet);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(resultSet, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
    return student;
  }

  @Override
  public List<Student> getAllStudents() {
    List<Student> students = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(StudentQueryConstants.GET_ALL_STUDENTS);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Student student = extractStudentFromResultSet(resultSet);
        students.add(student);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(resultSet, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
    return students;
  }

  /**
   * Extracts a Student object from the ResultSet obtained from a database query.
   *
   * @param resultSet The ResultSet containing student data.
   * @return A Student object extracted from the ResultSet.
   * @throws SQLException If a database access error occurs.
   */
  private Student extractStudentFromResultSet(ResultSet resultSet) throws SQLException {
    int studentId = resultSet.getInt("S_ID");
    String name = resultSet.getString("S_name");
    String email = resultSet.getString("S_mail");
    String contact = resultSet.getString("S_contact");
    java.sql.Date enrollDate = resultSet.getDate("EnrollYear");
    Date enrollYear = new Date(enrollDate.getTime());

    return new Student(studentId, name, contact, email, enrollYear);
  }
}
