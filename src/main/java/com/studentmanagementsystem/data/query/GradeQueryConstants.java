package main.java.com.studentmanagementsystem.data.query;

public class GradeQueryConstants {
  public static final String INSERT_GRADE = "INSERT INTO grades (gradeId, year, semester, grade) VALUES (?, ?, ?, ?)";
  public static final String UPDATE_GRADE = "UPDATE grades SET year = ?, semester = ?, grade = ? WHERE gradeId = ?";
  public static final String DELETE_GRADE = "DELETE FROM grades WHERE gradeId = ?";
  public static final String GET_GRADE_BY_ID = "SELECT * FROM grades WHERE gradeId = ?";
  public static final String GET_ALL_GRADES = "SELECT * FROM grades";
}
