package main.java.com.studentmanagementsystem.data.query;

public class GradeQueryConstants {
  public static final String INSERT_GRADE = "INSERT INTO grade (G_ID , cgpa , Semester , Sem_year  ) VALUES (?, ?, ?, ?)";
  public static final String UPDATE_GRADE = "UPDATE grade SET cgpa  = ?, Semester  = ?, Sem_year   = ? WHERE G_ID  = ?";
  public static final String DELETE_GRADE = "DELETE FROM grade WHERE G_ID  = ?";
  public static final String GET_GRADE_BY_ID = "SELECT * FROM grade WHERE G_ID  = ?";
  public static final String GET_ALL_GRADES = "SELECT * FROM grade";
}
