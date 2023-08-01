package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Authorities;
import main.java.com.studentmanagementsystem.util.DatabaseManager;
import main.java.com.studentmanagementsystem.data.query.AuthoritiesQueryConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthoritiesDAOImpl implements AuthoritiesDAO {

  private DatabaseManager databaseManager;

  public AuthoritiesDAOImpl() {
    databaseManager = DatabaseManager.getInstance();
  }

  @Override
  public void addAuthority(Authorities authority) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(AuthoritiesQueryConstants.INSERT_AUTHORITY);

      preparedStatement.setString(1, authority.getAuthorityMail());
      preparedStatement.setString(2, authority.getAuthorityName());
      preparedStatement.setString(3, authority.getAuthorityRole());
      preparedStatement.setString(4, authority.getAuthorityContact());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public void updateAuthority(Authorities authority) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(AuthoritiesQueryConstants.UPDATE_AUTHORITY);

      preparedStatement.setString(1, authority.getAuthorityName());
      preparedStatement.setString(2, authority.getAuthorityRole());
      preparedStatement.setString(3, authority.getAuthorityContact());
      preparedStatement.setString(4, authority.getAuthorityMail());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public void deleteAuthority(String authorityName) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(AuthoritiesQueryConstants.DELETE_AUTHORITY);

      preparedStatement.setString(1, authorityName);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public Authorities getAuthorityByName(String authorityName) {
    Authorities authority = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(AuthoritiesQueryConstants.GET_AUTHORITY_BY_MAIL);

      preparedStatement.setString(1, authorityName);

      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        authority = extractAuthorityFromResultSet(resultSet);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(resultSet, preparedStatement);
      databaseManager.releaseConnection(connection);
    }

    return authority;
  }

  private Authorities extractAuthorityFromResultSet(ResultSet resultSet) throws SQLException {
    String authorityName = resultSet.getString("A_name");
    String authorityRole = resultSet.getString("A_role");
    String authorityMail = resultSet.getString("A_mail");
    String authorityContact = resultSet.getString("A_contact");

    return new Authorities(authorityName, authorityRole, authorityMail, authorityContact);
  }
}
