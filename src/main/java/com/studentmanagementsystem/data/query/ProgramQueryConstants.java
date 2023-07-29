package main.java.com.studentmanagementsystem.data.query;

public class ProgramQueryConstants {
  public static final String INSERT_PROGRAM = "INSERT INTO programs (programId, programName, programDuration, programType) VALUES (?, ?, ?, ?)";
  public static final String UPDATE_PROGRAM = "UPDATE programs SET programName = ?, programDuration = ?, programType = ? WHERE programId = ?";
  public static final String DELETE_PROGRAM = "DELETE FROM programs WHERE programId = ?";
  public static final String GET_PROGRAM_BY_ID = "SELECT * FROM programs WHERE programId = ?";
  public static final String GET_ALL_PROGRAMS = "SELECT * FROM programs";
}