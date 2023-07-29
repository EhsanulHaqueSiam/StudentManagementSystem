package main.java.com.studentmanagementsystem.data.query;

public class AuthoritiesQueryConstants {
  public static final String INSERT_AUTHORITY = "INSERT INTO authorities (authorityName, authorityRole, authorityMail, authorityContact) VALUES (?, ?, ?, ?)";
  public static final String UPDATE_AUTHORITY = "UPDATE authorities SET authorityRole=?, authorityMail=?, authorityContact=? WHERE authorityName=?";
  public static final String DELETE_AUTHORITY = "DELETE FROM authorities WHERE authorityName=?";
  public static final String GET_AUTHORITY_BY_NAME = "SELECT * FROM authorities WHERE authorityName=?";
}
