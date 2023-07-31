package main.java.com.studentmanagementsystem.data.query;

public class ClassesQueryConstants {
  public static final String INSERT_CLASS = "INSERT INTO classroom (Cl_roomno , Cl_name , Cl_time ) VALUES (?, ?, ?)";
  public static final String UPDATE_CLASS = "UPDATE classroom SET Cl_name = ?, Cl_time = ? WHERE Cl_roomno = ?";
  public static final String DELETE_CLASS = "DELETE FROM classroom WHERE Cl_roomno = ?";
  public static final String GET_CLASS_BY_ROOM_NO = "SELECT * FROM classroom WHERE Cl_roomno = ?";
  public static final String GET_ALL_CLASSES = "SELECT * FROM classroom";
}
