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

public class DepartmentDAOImpl implements DepartmentDAO {

  private DatabaseManager databaseManager;

  public DepartmentDAOImpl() {
    databaseManager = DatabaseManager.getInstance();
  }

  @Override
  public void addDepartment(Department department) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DepartmentQueryConstants.INSERT_DEPARTMENT)) {

      preparedStatement.setInt(1, department.getDeptId());
      preparedStatement.setString(2, department.getDeptName());
      preparedStatement.setString(3, department.getDeptHead());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void updateDepartment(Department department) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DepartmentQueryConstants.UPDATE_DEPARTMENT)) {

      preparedStatement.setString(1, department.getDeptName());
      preparedStatement.setString(2, department.getDeptHead());
      preparedStatement.setInt(3, department.getDeptId());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteDepartment(String deptId) {
    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DepartmentQueryConstants.DELETE_DEPARTMENT)) {

      preparedStatement.setString(1, deptId);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Department getDepartmentById(String deptId) {
    Department department = null;

    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DepartmentQueryConstants.GET_DEPARTMENT_BY_ID)) {

      preparedStatement.setString(1, deptId);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          department = extractDepartmentFromResultSet(resultSet);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return department;
  }

  @Override
  public List<Department> getAllDepartments() {
    List<Department> departments = new ArrayList<>();

    try (Connection connection = databaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DepartmentQueryConstants.GET_ALL_DEPARTMENTS);
        ResultSet resultSet = preparedStatement.executeQuery()) {

      while (resultSet.next()) {
        Department department = extractDepartmentFromResultSet(resultSet);
        departments.add(department);
      }
    } catch (SQLException e) {
      e.printStackTrace();
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
