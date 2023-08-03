package main.java.com.studentmanagementsystem.data.query;

/**
 * The `ClassesQueryConstants` class provides SQL query constants for classroom-related operations.
 * These constants represent SQL statements for inserting, updating, deleting, and retrieving classroom records.
 */
public class ClassesQueryConstants {

  /**
   * SQL query to insert a new classroom record into the 'classroom' table.
   * Parameters: Cl_roomno, Cl_name, Cl_time
   */
  public static final String INSERT_CLASS = "INSERT INTO classroom (Cl_roomno, Cl_name, Cl_time) VALUES (?, ?, ?)";

  /**
   * SQL query to update an existing classroom record in the 'classroom' table.
   * Parameters: Cl_name, Cl_time, Cl_roomno
   */
  public static final String UPDATE_CLASS = "UPDATE classroom SET Cl_name = ?, Cl_time = ? WHERE Cl_roomno = ?";

  /**
   * SQL query to delete a classroom record from the 'classroom' table by room number.
   * Parameters: Cl_roomno
   */
  public static final String DELETE_CLASS = "DELETE FROM classroom WHERE Cl_roomno = ?";

  /**
   * SQL query to retrieve a classroom record from the 'classroom' table by room number.
   * Parameters: Cl_roomno
   */
  public static final String GET_CLASS_BY_ROOM_NO = "SELECT * FROM classroom WHERE Cl_roomno = ?";

  /**
   * SQL query to retrieve all classroom records from the 'classroom' table.
   */
  public static final String GET_ALL_CLASSES = "SELECT * FROM classroom";
}
