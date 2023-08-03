package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Department;

import java.util.List;

/**
 * An interface for performing CRUD (Create, Read, Update, Delete) operations on department records in the database.
 */
public interface DepartmentDAO {

  /**
   * Adds a new department record to the database.
   *
   * @param department The Department object to be added.
   */
  void addDepartment(Department department);

  /**
   * Updates an existing department record in the database.
   *
   * @param department The updated Department object.
   */
  void updateDepartment(Department department);

  /**
   * Deletes a department record from the database based on the department ID.
   *
   * @param deptId The unique identifier of the department to be deleted.
   */
  void deleteDepartment(String deptId);

  /**
   * Retrieves a department record from the database based on the department ID.
   *
   * @param deptId The unique identifier of the department.
   * @return The Department object representing the retrieved department record, or null if not found.
   */
  Department getDepartmentById(String deptId);

  /**
   * Retrieves all department records from the database.
   *
   * @return A list of Department objects representing all department records.
   */
  List<Department> getAllDepartments();
}
