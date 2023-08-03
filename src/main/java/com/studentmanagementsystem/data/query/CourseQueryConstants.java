package main.java.com.studentmanagementsystem.data.query;

/**
 * The `CourseQueryConstants` class provides SQL query constants for course-related operations.
 * These constants represent SQL statements for inserting, updating, deleting, and retrieving course records.
 */
public class CourseQueryConstants {

  /**
   * SQL query to insert a new course record into the 'course' table.
   * Parameters: C_ID, C_name, C_duration, C_credit
   */
  public static final String INSERT_COURSE = "INSERT INTO course (C_ID , C_name , C_duration , C_credit ) VALUES (?, ?, ?, ?)";

  /**
   * SQL query to update an existing course record in the 'course' table.
   * Parameters: C_name, C_duration, C_credit, C_ID
   */
  public static final String UPDATE_COURSE = "UPDATE course SET C_name = ?, C_duration = ?, C_credit = ? WHERE C_ID = ?";

  /**
   * SQL query to delete a course record from the 'course' table by course ID.
   * Parameters: C_ID
   */
  public static final String DELETE_COURSE = "DELETE FROM course WHERE C_ID = ?";

  /**
   * SQL query to retrieve specific course information from the 'course' table by course ID.
   * Parameters: C_ID
   */
  public static final String GET_COURSE_BY_ID = "SELECT C_name, C_duration, C_credit FROM course WHERE C_ID = ?";

  /**
   * SQL query to retrieve all course records from the 'course' table.
   */
  public static final String GET_ALL_COURSES = "SELECT C_name, C_duration, C_credit FROM course";
}
