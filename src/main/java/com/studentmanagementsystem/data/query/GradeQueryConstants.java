package main.java.com.studentmanagementsystem.data.query;

/**
 * The `GradeQueryConstants` class provides SQL query constants for grade-related operations.
 * These constants represent SQL statements for inserting, updating, deleting, and retrieving grade records.
 */
public class GradeQueryConstants {

  /**
   * SQL query to insert a new grade record into the 'grade' table.
   * Parameters: G_ID, cgpa, Semester, Sem_year
   */
  public static final String INSERT_GRADE = "INSERT INTO grade (G_ID, cgpa, Semester, Sem_year) VALUES (?, ?, ?, ?)";

  /**
   * SQL query to update an existing grade record in the 'grade' table.
   * Parameters: cgpa, Semester, Sem_year, G_ID
   */
  public static final String UPDATE_GRADE = "UPDATE grade SET cgpa = ?, Semester = ?, Sem_year = ? WHERE G_ID = ?";

  /**
   * SQL query to delete a grade record from the 'grade' table by grade ID.
   * Parameters: G_ID
   */
  public static final String DELETE_GRADE = "DELETE FROM grade WHERE G_ID = ?";

  /**
   * SQL query to retrieve specific grade information from the 'grade' table by grade ID.
   * Parameters: G_ID
   */
  public static final String GET_GRADE_BY_ID = "SELECT * FROM grade WHERE G_ID = ?";

  /**
   * SQL query to retrieve all grade records from the 'grade' table.
   */
  public static final String GET_ALL_GRADES = "SELECT * FROM grade";
}
