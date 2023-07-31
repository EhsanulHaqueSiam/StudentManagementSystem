package main.java.com.studentmanagementsystem.data.query;

public class DepartmentQueryConstants {
  public static final String INSERT_DEPARTMENT = "INSERT INTO dept (D_ID , D_name , D_head ) VALUES (?, ?, ?)";
  public static final String UPDATE_DEPARTMENT = "UPDATE dept SET D_name  = ?, D_head  = ? WHERE D_ID = ?";
  public static final String DELETE_DEPARTMENT = "DELETE FROM dept WHERE D_ID = ?";
  public static final String GET_DEPARTMENT_BY_ID = "SELECT * FROM dept WHERE D_ID = ?";
  public static final String GET_ALL_DEPARTMENTS = "SELECT * FROM dept";
}
