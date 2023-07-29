package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Authorities;
import main.java.com.studentmanagementsystem.util.DatabaseHelper;
import main.java.com.studentmanagementsystem.util.DatabaseUtil;
import main.java.com.studentmanagementsystem.data.query.AuthoritiesQueryConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthoritiesDAOImpl implements AuthoritiesDAO {

  @Override
  public void addAuthority(Authorities authority) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(AuthoritiesQueryConstants.INSERT_AUTHORITY);
      preparedStatement.setString(1, authority.getAuthorityName());
      preparedStatement.setString(2, authority.getAuthorityRole());
      preparedStatement.setString(3, authority.getAuthorityMail());
      preparedStatement.setString(4, authority.getAuthorityContact());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void updateAuthority(Authorities authority) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(AuthoritiesQueryConstants.UPDATE_AUTHORITY);
      preparedStatement.setString(1, authority.getAuthorityRole());
      preparedStatement.setString(2, authority.getAuthorityMail());
      preparedStatement.setString(3, authority.getAuthorityContact());
      preparedStatement.setString(4, authority.getAuthorityName());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void deleteAuthority(String authorityName) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(AuthoritiesQueryConstants.DELETE_AUTHORITY);
      preparedStatement.setString(1, authorityName);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public Authorities getAuthorityByName(String authorityName) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    Authorities authority = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(AuthoritiesQueryConstants.GET_AUTHORITY_BY_NAME);
      preparedStatement.setString(1, authorityName);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        String roleName = resultSet.getString("authorityRole");
        String email = resultSet.getString("authorityMail");
        String contact = resultSet.getString("authorityContact");

        authority = new Authorities(authorityName, roleName, email, contact);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
    }

    return authority;
  }
}
