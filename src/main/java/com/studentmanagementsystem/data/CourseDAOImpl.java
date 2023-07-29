package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Course;
import main.java.com.studentmanagementsystem.util.DatabaseHelper;
import main.java.com.studentmanagementsystem.util.DatabaseUtil;
import main.java.com.studentmanagementsystem.data.query.CourseQueryConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

  @Override
  public void addCourse(Course course) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(CourseQueryConstants.INSERT_COURSE);
      preparedStatement.setString(1, course.getCourseId());
      preparedStatement.setString(2, course.getCourseName());
      preparedStatement.setInt(3, course.getCourseCredits());
      preparedStatement.setInt(4, course.getCourseDuration());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void updateCourse(Course course) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(CourseQueryConstants.UPDATE_COURSE);
      preparedStatement.setString(1, course.getCourseName());
      preparedStatement.setInt(2, course.getCourseCredits());
      preparedStatement.setInt(3, course.getCourseDuration());
      preparedStatement.setString(4, course.getCourseId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void deleteCourse(String courseId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(CourseQueryConstants.DELETE_COURSE);
      preparedStatement.setString(1, courseId);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public Course getCourseById(String courseId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    Course course = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(CourseQueryConstants.GET_COURSE_BY_ID);
      preparedStatement.setString(1, courseId);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        String courseName = resultSet.getString("courseName");
        int courseCredits = resultSet.getInt("courseCredits");
        int courseDuration = resultSet.getInt("courseDuration");

        course = new Course(courseId, courseName, courseCredits, courseDuration);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
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
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(CourseQueryConstants.GET_ALL_COURSES);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        String courseId = resultSet.getString("courseId");
        String courseName = resultSet.getString("courseName");
        int courseCredits = resultSet.getInt("courseCredits");
        int courseDuration = resultSet.getInt("courseDuration");

        courses.add(new Course(courseId, courseName, courseCredits, courseDuration));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
    }

    return courses;
  }
}