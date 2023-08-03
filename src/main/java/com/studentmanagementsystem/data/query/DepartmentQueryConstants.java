package main.java.com.studentmanagementsystem.data.query;

/**
 * The `DepartmentQueryConstants` class provides SQL query constants for department-related operations.
 * These constants represent SQL statements for inserting, updating, deleting, and retrieving department records.
 */
public class DepartmentQueryConstants {

  /**
   * SQL query to insert a new department record into the 'dept' table.
   * Parameters: D_ID, D_name, D_head
   */
  public static final String INSERT_DEPARTMENT = "INSERT INTO dept (D_ID, D_name, D_head) VALUES (?, ?, ?)";

  /**
   * SQL query to update an existing department record in the 'dept' table.
   * Parameters: D_name, D_head, D_ID
   */
  public static final String UPDATE_DEPARTMENT = "UPDATE dept SET D_name = ?, D_head = ? WHERE D_ID = ?";

  /**
   * SQL query to delete a department record from the 'dept' table by department ID.
   * Parameters: D_ID
   */
  public static final String DELETE_DEPARTMENT = "DELETE FROM dept WHERE D_ID = ?";

  /**
   * SQL query to retrieve specific department information from the 'dept' table by department ID.
   * Parameters: D_ID
   */
  public static final String GET_DEPARTMENT_BY_ID = "SELECT * FROM dept WHERE D_ID = ?";

  /**
   * SQL query to retrieve all department records from the 'dept' table.
   */
  public static final String GET_ALL_DEPARTMENTS = "SELECT * FROM dept";
}
