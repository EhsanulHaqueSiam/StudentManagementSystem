package main.java.com.studentmanagementsystem.data.query;

public class FacultyQueryConstants {
  // SQL queries for Faculty table
  public static final String INSERT_FACULTY = "INSERT INTO faculty (faculty_id, name, contact, email) VALUES (?, ?, ?, ?)";
  public static final String UPDATE_FACULTY = "UPDATE faculty SET name=?, contact=?, email=? WHERE faculty_id=?";
  public static final String DELETE_FACULTY = "DELETE FROM faculty WHERE faculty_id=?";
  public static final String GET_FACULTY_BY_ID = "SELECT * FROM faculty WHERE faculty_id=?";
  public static final String GET_ALL_FACULTIES = "SELECT * FROM faculty";
}
