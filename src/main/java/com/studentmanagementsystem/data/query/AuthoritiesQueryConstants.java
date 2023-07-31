package main.java.com.studentmanagementsystem.data.query;

public class AuthoritiesQueryConstants {
  public static final String INSERT_AUTHORITY = "INSERT INTO authority (A_mail,A_name, A_role, A_contact) VALUES (?, ?, ?, ?)";
  public static final String UPDATE_AUTHORITY = "UPDATE authority SET A_name=?, A_role=?, A_contact=? WHERE A_mail=?";
  public static final String DELETE_AUTHORITY = "DELETE FROM authority WHERE A_mail=?";
  public static final String GET_AUTHORITY_BY_MAIL = "SELECT * FROM authority WHERE A_mail=?";
}
