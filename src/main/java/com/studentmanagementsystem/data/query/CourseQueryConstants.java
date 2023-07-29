package main.java.com.studentmanagementsystem.data.query;

public class CourseQueryConstants {
  public static final String INSERT_COURSE = "INSERT INTO courses (courseId, courseName, courseCredits, courseDuration) VALUES (?, ?, ?, ?)";
  public static final String UPDATE_COURSE = "UPDATE courses SET courseName = ?, courseCredits = ?, courseDuration = ? WHERE courseId = ?";
  public static final String DELETE_COURSE = "DELETE FROM courses WHERE courseId = ?";
  public static final String GET_COURSE_BY_ID = "SELECT courseId, courseName, courseCredits, courseDuration FROM courses WHERE courseId = ?";
  public static final String GET_ALL_COURSES = "SELECT courseId, courseName, courseCredits, courseDuration FROM courses";
}