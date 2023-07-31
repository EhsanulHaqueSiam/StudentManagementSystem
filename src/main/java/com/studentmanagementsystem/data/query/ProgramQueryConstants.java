package main.java.com.studentmanagementsystem.data.query;

public class ProgramQueryConstants {
  public static final String INSERT_PROGRAM = "INSERT INTO program (P_ID , P_name , P_duration , P_type ) VALUES (?, ?, ?, ?)";
  public static final String UPDATE_PROGRAM = "UPDATE program SET P_name  = ?, P_duration  = ?, P_type  = ? WHERE P_ID = ?";
  public static final String DELETE_PROGRAM = "DELETE FROM program WHERE P_ID  = ?";
  public static final String GET_PROGRAM_BY_ID = "SELECT * FROM program WHERE P_ID  = ?";
  public static final String GET_ALL_PROGRAMS = "SELECT * FROM program";
}