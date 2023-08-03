package main.java.com.studentmanagementsystem.data.query;

/**
 * The `AuthoritiesQueryConstants` class provides SQL query constants for authority-related operations.
 * These constants represent SQL statements for inserting, updating, deleting, and retrieving authority records.
 */
public class AuthoritiesQueryConstants {

  /**
   * SQL query to insert a new authority record into the 'authority' table.
   * Parameters: A_mail, A_name, A_role, A_contact
   */
  public static final String INSERT_AUTHORITY = "INSERT INTO authority (A_mail, A_name, A_role, A_contact) VALUES (?, ?, ?, ?)";

  /**
   * SQL query to update an existing authority record in the 'authority' table.
   * Parameters: A_name, A_role, A_contact, A_mail
   */
  public static final String UPDATE_AUTHORITY = "UPDATE authority SET A_name=?, A_role=?, A_contact=? WHERE A_mail=?";

  /**
   * SQL query to delete an authority record from the 'authority' table by email.
   * Parameters: A_mail
   */
  public static final String DELETE_AUTHORITY = "DELETE FROM authority WHERE A_mail=?";

  /**
   * SQL query to retrieve an authority record from the 'authority' table by email.
   * Parameters: A_mail
   */
  public static final String GET_AUTHORITY_BY_MAIL = "SELECT * FROM authority WHERE A_mail=?";
}
