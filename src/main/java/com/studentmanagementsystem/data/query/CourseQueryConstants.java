package main.java.com.studentmanagementsystem.data.query;

public class CourseQueryConstants {
  public static final String INSERT_COURSE = "INSERT INTO course (C_ID , C_name , C_duration , C_credit ) VALUES (?, ?, ?, ?)";
  public static final String UPDATE_COURSE = "UPDATE course SET C_name = ?, C_duration = ?, C_credit = ? WHERE C_ID = ?";
  public static final String DELETE_COURSE = "DELETE FROM course WHERE C_ID = ?";
  public static final String GET_COURSE_BY_ID = "SELECT C_name, C_duration, C_credit FROM course WHERE C_ID = ?";
  public static final String GET_ALL_COURSES = "SELECT C_name, C_duration, C_credit FROM course";
}