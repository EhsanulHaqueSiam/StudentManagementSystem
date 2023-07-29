package main.java.com.studentmanagementsystem.data.query;

public class ClassesQueryConstants {
  public static final String INSERT_CLASS = "INSERT INTO classes (className, classLocation, time) VALUES (?, ?, ?)";
  public static final String UPDATE_CLASS = "UPDATE classes SET classLocation = ?, time = ? WHERE className = ?";
  public static final String DELETE_CLASS = "DELETE FROM classes WHERE className = ?";
  public static final String GET_CLASS_BY_NAME = "SELECT * FROM classes WHERE className = ?";
  public static final String GET_ALL_CLASSES = "SELECT * FROM classes";
}
