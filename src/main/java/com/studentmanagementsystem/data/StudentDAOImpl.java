package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Student;
import main.java.com.studentmanagementsystem.util.DatabaseHelper;
import main.java.com.studentmanagementsystem.util.DatabaseUtil;
import main.java.com.studentmanagementsystem.data.query.StudentQueryConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class StudentDAOImpl implements StudentDAO {

  @Override
  public void addStudent(Student student) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(StudentQueryConstants.INSERT_STUDENT);
      preparedStatement.setString(1, student.getStudentId());
      preparedStatement.setString(2, student.getName());
      preparedStatement.setString(3, student.getContact());
      preparedStatement.setString(4, student.getEmail());
      preparedStatement.setDate(5, new java.sql.Date(student.getEnrollYear().getTime()));
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void updateStudent(Student student) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(StudentQueryConstants.UPDATE_STUDENT);
      preparedStatement.setString(1, student.getName());
      preparedStatement.setString(2, student.getContact());
      preparedStatement.setString(3, student.getEmail());
      preparedStatement.setDate(4, new java.sql.Date(student.getEnrollYear().getTime()));
      preparedStatement.setString(5, student.getStudentId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void deleteStudent(int id) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(StudentQueryConstants.DELETE_STUDENT);
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public Student getStudentById(int id) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    Student student = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(StudentQueryConstants.GET_STUDENT_BY_ID);
      preparedStatement.setInt(1, id);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        String studentId = resultSet.getString("studentId");
        String name = resultSet.getString("name");
        String contact = resultSet.getString("contact");
        String email = resultSet.getString("email");
        Date enrollYear = resultSet.getDate("enrollYear");

        student = new Student(studentId, name, contact, enrollYear, email);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
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
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(StudentQueryConstants.GET_ALL_STUDENTS);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        String studentId = resultSet.getString("studentId");
        String name = resultSet.getString("name");
        String contact = resultSet.getString("contact");
        String email = resultSet.getString("email");
        Date enrollYear = resultSet.getDate("enrollYear");

        students.add(new Student(studentId, name, contact, enrollYear, email));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
    }

    return students;
  }
}
