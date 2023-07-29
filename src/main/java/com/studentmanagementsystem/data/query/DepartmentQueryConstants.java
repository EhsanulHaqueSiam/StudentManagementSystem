package main.java.com.studentmanagementsystem.data.query;

public class DepartmentQueryConstants {
  public static final String INSERT_DEPARTMENT = "INSERT INTO departments (deptId, deptName, deptHead) VALUES (?, ?, ?)";
  public static final String UPDATE_DEPARTMENT = "UPDATE departments SET deptName = ?, deptHead = ? WHERE deptId = ?";
  public static final String DELETE_DEPARTMENT = "DELETE FROM departments WHERE deptId = ?";
  public static final String GET_DEPARTMENT_BY_ID = "SELECT * FROM departments WHERE deptId = ?";
  public static final String GET_ALL_DEPARTMENTS = "SELECT * FROM departments";
}
