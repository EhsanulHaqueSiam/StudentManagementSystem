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

/**
 * The implementation of the CourseDAO interface for performing CRUD operations on course records in the database.
 */
public class CourseDAOImpl implements CourseDAO {

  private DatabaseManager databaseManager;

  /**
   * Constructs a new CourseDAOImpl instance.
   */
  public CourseDAOImpl() {
    databaseManager = DatabaseManager.getInstance();
  }

  @Override
  public void addCourse(Course course) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(CourseQueryConstants.INSERT_COURSE);

      preparedStatement.setInt(1, course.getCourseId());
      preparedStatement.setString(2, course.getCourseName());
      preparedStatement.setString(3, course.getCourseDuration());
      preparedStatement.setInt(4, course.getCourseCredits());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public void updateCourse(Course course) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(CourseQueryConstants.UPDATE_COURSE);

      preparedStatement.setString(1, course.getCourseName());
      preparedStatement.setString(2, course.getCourseDuration());
      preparedStatement.setInt(3, course.getCourseCredits());
      preparedStatement.setInt(4, course.getCourseId());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public void deleteCourse(String courseId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(CourseQueryConstants.DELETE_COURSE);

      preparedStatement.setString(1, courseId);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public Course getCourseById(String courseId) {
    Course course = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(CourseQueryConstants.GET_COURSE_BY_ID);

      preparedStatement.setString(1, courseId);

      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        course = extractCourseFromResultSet(resultSet);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(resultSet, preparedStatement);
      databaseManager.releaseConnection(connection);
    }

    return course;
  }

  @Override
  public List<Course> getAllCourses() {
    List<Course> courses = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(CourseQueryConstants.GET_ALL_COURSES);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Course course = extractCourseFromResultSet(resultSet);
        courses.add(course);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(resultSet, preparedStatement);
      databaseManager.releaseConnection(connection);
    }

    return courses;
  }

  /**
   * Extracts course information from the result set.
   *
   * @param resultSet The result set containing course data.
   * @return The extracted Course object.
   * @throws SQLException If a database access error occurs.
   */
  private Course extractCourseFromResultSet(ResultSet resultSet) throws SQLException {
    int courseId = resultSet.getInt("C_ID");
    String courseName = resultSet.getString("C_name");
    String courseDuration = resultSet.getString("C_duration");
    int courseCredits = resultSet.getInt("C_credit");

    return new Course(courseId, courseName, courseCredits, courseDuration);
  }
}
