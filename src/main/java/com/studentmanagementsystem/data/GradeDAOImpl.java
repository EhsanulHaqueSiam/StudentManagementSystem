package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Grade;
import main.java.com.studentmanagementsystem.util.DatabaseManager;
import main.java.com.studentmanagementsystem.data.query.GradeQueryConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDAOImpl implements GradeDAO {

  private DatabaseManager databaseManager;

  public GradeDAOImpl() {
    databaseManager = DatabaseManager.getInstance();
  }

  @Override
  public void addGrade(Grade grade) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GradeQueryConstants.INSERT_GRADE)) {

      preparedStatement.setInt(1, grade.getGradeId());
      preparedStatement.setDouble(2, grade.getCGPA());
      preparedStatement.setString(3, grade.getSemester());
      preparedStatement.setString(4, grade.getSemesterYear());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void updateGrade(Grade grade) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GradeQueryConstants.UPDATE_GRADE)) {

      preparedStatement.setDouble(1, grade.getCGPA());
      preparedStatement.setString(2, grade.getSemester());
      preparedStatement.setString(3, grade.getSemesterYear());
      preparedStatement.setInt(4, grade.getGradeId());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteGrade(String gradeId) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GradeQueryConstants.DELETE_GRADE)) {

      preparedStatement.setString(1, gradeId);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Grade getGradeById(String gradeId) {
    Grade grade = null;

    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GradeQueryConstants.GET_GRADE_BY_ID)) {

      preparedStatement.setString(1, gradeId);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          grade = extractGradeFromResultSet(resultSet);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return grade;
  }

  @Override
  public List<Grade> getAllGrades() {
    List<Grade> grades = new ArrayList<>();

    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GradeQueryConstants.GET_ALL_GRADES);
        ResultSet resultSet = preparedStatement.executeQuery()) {

      while (resultSet.next()) {
        Grade grade = extractGradeFromResultSet(resultSet);
        grades.add(grade);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return grades;
  }

  private Grade extractGradeFromResultSet(ResultSet resultSet) throws SQLException {
    int gradeId = resultSet.getInt("G_ID");
    double cgpa = resultSet.getDouble("cgpa");
    String semester = resultSet.getString("Semester");
    String semesterYear = resultSet.getString("Sem_year");

    return new Grade(gradeId, semesterYear, semester, cgpa);
  }
}
