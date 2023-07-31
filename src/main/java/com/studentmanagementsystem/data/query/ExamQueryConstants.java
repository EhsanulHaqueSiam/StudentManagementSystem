package main.java.com.studentmanagementsystem.data.query;

public class ExamQueryConstants {
  public static final String INSERT_EXAM = "INSERT INTO exam (E_ID , E_date , E_type , E_location ) VALUES (?, ?, ?, ?)";
  public static final String UPDATE_EXAM = "UPDATE exam SET E_date =?, E_type=?, E_location=? WHERE E_ID=?";
  public static final String DELETE_EXAM = "DELETE FROM exam WHERE E_ID=?";
  public static final String GET_EXAM_BY_DATE_AND_TYPE = "SELECT E_date ,E_type ,E_location FROM exam WHERE E_ID=?";
  public static final String GET_ALL_EXAMS = "SELECT E_ID, E_date , E_type, examLocation FROM exam";
}