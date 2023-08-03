package main.java.com.studentmanagementsystem.data.query;

/**
 * The `ProgramQueryConstants` class provides SQL query constants for program-related operations.
 * These constants represent SQL statements for inserting, updating, deleting, and retrieving program records.
 */
public class ProgramQueryConstants {

  /**
   * SQL query to insert a new program record into the 'program' table.
   * Parameters: P_ID, P_name, P_duration, P_type
   */
  public static final String INSERT_PROGRAM = "INSERT INTO program (P_ID, P_name, P_duration, P_type) VALUES (?, ?, ?, ?)";

  /**
   * SQL query to update an existing program record in the 'program' table.
   * Parameters: P_name, P_duration, P_type, P_ID
   */
  public static final String UPDATE_PROGRAM = "UPDATE program SET P_name = ?, P_duration = ?, P_type = ? WHERE P_ID = ?";

  /**
   * SQL query to delete a program record from the 'program' table by program ID.
   * Parameters: P_ID
   */
  public static final String DELETE_PROGRAM = "DELETE FROM program WHERE P_ID = ?";

  /**
   * SQL query to retrieve specific program information from the 'program' table by program ID.
   * Parameters: P_ID
   */
  public static final String GET_PROGRAM_BY_ID = "SELECT * FROM program WHERE P_ID = ?";

  /**
   * SQL query to retrieve all program records from the 'program' table.
   */
  public static final String GET_ALL_PROGRAMS = "SELECT * FROM program";
}
