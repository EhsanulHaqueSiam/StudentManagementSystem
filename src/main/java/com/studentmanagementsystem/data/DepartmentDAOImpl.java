package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Department;
import main.java.com.studentmanagementsystem.util.DatabaseManager;
import main.java.com.studentmanagementsystem.data.query.DepartmentQueryConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the DepartmentDAO interface that performs CRUD operations on department records in the database.
 */
public class DepartmentDAOImpl implements DepartmentDAO {

  private DatabaseManager databaseManager;

  public DepartmentDAOImpl() {
    databaseManager = DatabaseManager.getInstance();
  }

  @Override
  public void addDepartment(Department department) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(DepartmentQueryConstants.INSERT_DEPARTMENT);

      preparedStatement.setInt(1, department.getDeptId());
      preparedStatement.setString(2, department.getDeptName());
      preparedStatement.setString(3, department.getDeptHead());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public void updateDepartment(Department department) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(DepartmentQueryConstants.UPDATE_DEPARTMENT);

      preparedStatement.setString(1, department.getDeptName());
      preparedStatement.setString(2, department.getDeptHead());
      preparedStatement.setInt(3, department.getDeptId());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public void deleteDepartment(String deptId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(DepartmentQueryConstants.DELETE_DEPARTMENT);

      preparedStatement.setString(1, deptId);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(null, preparedStatement);
      databaseManager.releaseConnection(connection);
    }
  }

  @Override
  public Department getDepartmentById(String deptId) {
    Department department = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(DepartmentQueryConstants.GET_DEPARTMENT_BY_ID);

      preparedStatement.setString(1, deptId);

      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        department = extractDepartmentFromResultSet(resultSet);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(resultSet, preparedStatement);
      databaseManager.releaseConnection(connection);
    }

    return department;
  }

  @Override
  public List<Department> getAllDepartments() {
    List<Department> departments = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = databaseManager.getConnection();
      preparedStatement = connection.prepareStatement(DepartmentQueryConstants.GET_ALL_DEPARTMENTS);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Department department = extractDepartmentFromResultSet(resultSet);
        departments.add(department);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DatabaseManager.getInstance().closeResources(resultSet, preparedStatement);
      databaseManager.releaseConnection(connection);
    }

    return departments;
  }

  private Department extractDepartmentFromResultSet(ResultSet resultSet) throws SQLException {
    int deptId = resultSet.getInt("D_ID");
    String deptName = resultSet.getString("D_name");
    String deptHead = resultSet.getString("D_head");

    return new Department(deptId, deptName, deptHead);
  }
}
