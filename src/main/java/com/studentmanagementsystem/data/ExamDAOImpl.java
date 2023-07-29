package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Exam;
import main.java.com.studentmanagementsystem.util.DatabaseHelper;
import main.java.com.studentmanagementsystem.util.DatabaseUtil;
import main.java.com.studentmanagementsystem.data.query.ExamQueryConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamDAOImpl implements ExamDAO {

  @Override
  public void addExam(Exam exam) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ExamQueryConstants.INSERT_EXAM);
      preparedStatement.setDate(1, new java.sql.Date(exam.getExamDate().getTime()));
      preparedStatement.setInt(2, exam.getTotalMark());
      preparedStatement.setString(3, exam.getExamType());
      preparedStatement.setString(4, exam.getExamLocation());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void updateExam(Exam exam) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ExamQueryConstants.UPDATE_EXAM);
      preparedStatement.setInt(1, exam.getTotalMark());
      preparedStatement.setString(2, exam.getExamLocation());
      preparedStatement.setDate(3, new java.sql.Date(exam.getExamDate().getTime()));
      preparedStatement.setString(4, exam.getExamType());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void deleteExam(Date examDate, String examType) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ExamQueryConstants.DELETE_EXAM);
      preparedStatement.setDate(1, new java.sql.Date(examDate.getTime()));
      preparedStatement.setString(2, examType);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public Exam getExamByDateAndType(Date examDate, String examType) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    Exam exam = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ExamQueryConstants.GET_EXAM_BY_DATE_AND_TYPE);
      preparedStatement.setDate(1, new java.sql.Date(examDate.getTime()));
      preparedStatement.setString(2, examType);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        int totalMark = resultSet.getInt("totalMark");
        String examLocation = resultSet.getString("examLocation");

        exam = new Exam(examDate, totalMark, examType, examLocation);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
    }

    return exam;
  }

  @Override
  public List<Exam> getAllExams() {
    List<Exam> exams = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(ExamQueryConstants.GET_ALL_EXAMS);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Date examDate = resultSet.getDate("examDate");
        int totalMark = resultSet.getInt("totalMark");
        String examType = resultSet.getString("examType");
        String examLocation = resultSet.getString("examLocation");

        exams.add(new Exam(examDate, totalMark, examType, examLocation));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
    }

    return exams;
  }
}