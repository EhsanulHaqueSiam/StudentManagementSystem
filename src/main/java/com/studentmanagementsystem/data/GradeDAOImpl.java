package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Grade;
import main.java.com.studentmanagementsystem.util.DatabaseHelper;
import main.java.com.studentmanagementsystem.util.DatabaseUtil;
import main.java.com.studentmanagementsystem.data.query.GradeQueryConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeDAOImpl implements GradeDAO {

  @Override
  public void addGrade(Grade grade) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(GradeQueryConstants.INSERT_GRADE);
      preparedStatement.setString(1, grade.getGradeId());
      preparedStatement.setInt(2, grade.getYear());
      preparedStatement.setString(3, grade.getSemester());
      preparedStatement.setDouble(4, grade.getGrade());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void updateGrade(Grade grade) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(GradeQueryConstants.UPDATE_GRADE);
      preparedStatement.setInt(1, grade.getYear());
      preparedStatement.setString(2, grade.getSemester());
      preparedStatement.setDouble(3, grade.getGrade());
      preparedStatement.setString(4, grade.getGradeId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void deleteGrade(String gradeId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(GradeQueryConstants.DELETE_GRADE);
      preparedStatement.setString(1, gradeId);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public Grade getGradeById(String gradeId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    Grade grade = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(GradeQueryConstants.GET_GRADE_BY_ID);
      preparedStatement.setString(1, gradeId);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        int year = resultSet.getInt("year");
        String semester = resultSet.getString("semester");
        Double gradeValue = resultSet.getDouble("grade");

        grade = new Grade(gradeId, year, semester, gradeValue);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
    }

    return grade;
  }

  @Override
  public List<Grade> getAllGrades() {
    List<Grade> grades = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(GradeQueryConstants.GET_ALL_GRADES);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        String gradeId = resultSet.getString("gradeId");
        int year = resultSet.getInt("year");
        String semester = resultSet.getString("semester");
        Double gradeValue = resultSet.getDouble("grade");

        grades.add(new Grade(gradeId, year, semester, gradeValue));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
    }

    return grades;
  }
}
