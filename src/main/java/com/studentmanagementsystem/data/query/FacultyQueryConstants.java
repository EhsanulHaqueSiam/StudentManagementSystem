package main.java.com.studentmanagementsystem.data.query;

/**
 * The `FacultyQueryConstants` class provides SQL query constants for faculty-related operations.
 * These constants represent SQL statements for inserting, updating, deleting, and retrieving faculty records.
 */
public class FacultyQueryConstants {

  /**
   * SQL query to insert a new faculty record into the 'faculty' table.
   * Parameters: F_ID, F_name, F_contact, F_mail
   */
  public static final String INSERT_FACULTY = "INSERT INTO faculty (F_ID, F_name, F_contact, F_mail) VALUES (?, ?, ?, ?)";

  /**
   * SQL query to update an existing faculty record in the 'faculty' table.
   * Parameters: F_name, F_contact, F_mail, F_ID
   */
  public static final String UPDATE_FACULTY = "UPDATE faculty SET F_name = ?, F_contact = ?, F_mail = ? WHERE F_ID = ?";

  /**
   * SQL query to delete a faculty record from the 'faculty' table by faculty ID.
   * Parameters: F_ID
   */
  public static final String DELETE_FACULTY = "DELETE FROM faculty WHERE F_ID = ?";

  /**
   * SQL query to retrieve specific faculty information from the 'faculty' table by faculty ID.
   * Parameters: F_ID
   */
  public static final String GET_FACULTY_BY_ID = "SELECT * FROM faculty WHERE F_ID = ?";

  /**
   * SQL query to retrieve all faculty records from the 'faculty' table.
   */
  public static final String GET_ALL_FACULTIES = "SELECT * FROM faculty";
}
