package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Department;
import main.java.com.studentmanagementsystem.util.DatabaseHelper;
import main.java.com.studentmanagementsystem.util.DatabaseUtil;
import main.java.com.studentmanagementsystem.data.query.DepartmentQueryConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

  @Override
  public void addDepartment(Department department) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(DepartmentQueryConstants.INSERT_DEPARTMENT);
      preparedStatement.setString(1, department.getDeptId());
      preparedStatement.setString(2, department.getDeptName());
      preparedStatement.setString(3, department.getDeptHead());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void updateDepartment(Department department) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(DepartmentQueryConstants.UPDATE_DEPARTMENT);
      preparedStatement.setString(1, department.getDeptName());
      preparedStatement.setString(2, department.getDeptHead());
      preparedStatement.setString(3, department.getDeptId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public void deleteDepartment(String deptId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(DepartmentQueryConstants.DELETE_DEPARTMENT);
      preparedStatement.setString(1, deptId);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, null);
    }
  }

  @Override
  public Department getDepartmentById(String deptId) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    Department department = null;

    try {
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(DepartmentQueryConstants.GET_DEPARTMENT_BY_ID);
      preparedStatement.setString(1, deptId);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        String deptName = resultSet.getString("deptName");
        String deptHead = resultSet.getString("deptHead");

        department = new Department(deptId, deptName, deptHead);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
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
      connection = DatabaseHelper.getInstance().getConnection();
      preparedStatement = connection.prepareStatement(DepartmentQueryConstants.GET_ALL_DEPARTMENTS);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        String deptId = resultSet.getString("deptId");
        String deptName = resultSet.getString("deptName");
        String deptHead = resultSet.getString("deptHead");

        departments.add(new Department(deptId, deptName, deptHead));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle the exception, log it, or rethrow as needed.
    } finally {
      DatabaseUtil.closeConnection(connection, preparedStatement, resultSet);
    }

    return departments;
  }
}
