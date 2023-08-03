package main.java.com.studentmanagementsystem.data.query;

/**
 * The `ExamQueryConstants` class provides SQL query constants for exam-related operations.
 * These constants represent SQL statements for inserting, updating, deleting, and retrieving exam records.
 */
public class ExamQueryConstants {

  /**
   * SQL query to insert a new exam record into the 'exam' table.
   * Parameters: E_ID, E_date, E_type, E_roomno, Mark
   */
  public static final String INSERT_EXAM = "INSERT INTO exam (E_ID, E_date, E_type, E_roomno, Mark) VALUES (?, ?, ?, ?, ?)";

  /**
   * SQL query to update an existing exam record in the 'exam' table.
   * Parameters: E_date, E_type, E_roomno, Mark, E_ID
   */
  public static final String UPDATE_EXAM = "UPDATE exam SET E_date = ?, E_type = ?, E_roomno = ?, Mark = ? WHERE E_ID = ?";

  /**
   * SQL query to delete an exam record from the 'exam' table by exam ID.
   * Parameters: E_ID
   */
  public static final String DELETE_EXAM = "DELETE FROM exam WHERE E_ID = ?";

  /**
   * SQL query to retrieve specific exam information from the 'exam' table by exam ID.
   * Parameters: E_ID
   */
  public static final String GET_EXAM_BY_DATE_AND_TYPE = "SELECT E_date, E_type, E_roomno, Mark FROM exam WHERE E_ID = ?";

  /**
   * SQL query to retrieve all exam records from the 'exam' table.
   */
  public static final String GET_ALL_EXAMS = "SELECT E_ID, E_date, E_type, E_roomno, Mark FROM exam";
}
