package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Course;
import main.java.com.studentmanagementsystem.util.DatabaseManager;
import main.java.com.studentmanagementsystem.data.query.CourseQueryConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

  private DatabaseManager databaseManager;

  public CourseDAOImpl() {
    databaseManager = DatabaseManager.getInstance();
  }

  @Override
  public void addCourse(Course course) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CourseQueryConstants.INSERT_COURSE)) {

      preparedStatement.setInt(1, course.getCourseId());
      preparedStatement.setString(2, course.getCourseName());
      preparedStatement.setString(3, course.getCourseDuration());
      preparedStatement.setInt(4, course.getCourseCredits());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void updateCourse(Course course) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CourseQueryConstants.UPDATE_COURSE)) {

      preparedStatement.setString(1, course.getCourseName());
      preparedStatement.setString(2, course.getCourseDuration());
      preparedStatement.setInt(3, course.getCourseCredits());
      preparedStatement.setInt(4, course.getCourseId());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteCourse(String courseId) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CourseQueryConstants.DELETE_COURSE)) {

      preparedStatement.setString(1, courseId);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Course getCourseById(String courseId) {
    Course course = null;

    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CourseQueryConstants.GET_COURSE_BY_ID)) {

      preparedStatement.setString(1, courseId);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          course = extractCourseFromResultSet(resultSet);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return course;
  }

  @Override
  public List<Course> getAllCourses() {
    List<Course> courses = new ArrayList<>();

    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CourseQueryConstants.GET_ALL_COURSES);
        ResultSet resultSet = preparedStatement.executeQuery()) {

      while (resultSet.next()) {
        Course course = extractCourseFromResultSet(resultSet);
        courses.add(course);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return courses;
  }

  private Course extractCourseFromResultSet(ResultSet resultSet) throws SQLException {
    int courseId = resultSet.getInt("C_ID");
    String courseName = resultSet.getString("C_name");
    String courseDuration = resultSet.getString("C_duration");
    int courseCredits = resultSet.getInt("C_credit");

    return new Course(courseId, courseName, courseCredits, courseDuration);
  }
}
