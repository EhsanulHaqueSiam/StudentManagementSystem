package main.java.com.studentmanagementsystem.data.query;

public class FacultyQueryConstants {
  // SQL queries for Faculty table
  public static final String INSERT_FACULTY = "INSERT INTO faculty (F_ID , F_name , F_contact , F_mail ) VALUES (?, ?, ?, ?)";
  public static final String UPDATE_FACULTY = "UPDATE faculty SET F_name =?, F_contact =?, F_mail =? WHERE F_ID =?";
  public static final String DELETE_FACULTY = "DELETE FROM faculty WHERE F_ID =?";
  public static final String GET_FACULTY_BY_ID = "SELECT * FROM faculty WHERE F_ID =?";
  public static final String GET_ALL_FACULTIES = "SELECT * FROM faculty";
}
