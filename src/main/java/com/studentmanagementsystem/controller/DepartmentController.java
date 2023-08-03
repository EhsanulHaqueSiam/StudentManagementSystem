package main.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.data.DepartmentDAO;
import main.java.com.studentmanagementsystem.data.DepartmentDAOImpl;
import main.java.com.studentmanagementsystem.model.Department;
import main.java.com.studentmanagementsystem.view.DepartmentView;

import java.util.List;

/**
 * The DepartmentController class manages user interactions and business logic
 * related
 * to handling departments within the Student Management System.
 */
public class DepartmentController {
  private final DepartmentDAO departmentDAO;
  private final DepartmentView departmentView;

  /**
   * Initializes the DepartmentController with the necessary DAO and View
   * instances.
   */
  public DepartmentController() {
    this.departmentDAO = new DepartmentDAOImpl();
    this.departmentView = new DepartmentView();
  }

  /**
   * Starts the main loop of the department management system, displaying the menu
   * and
   * handling user input.
   */
  public void run() {
    boolean running = true;
    while (running) {
      departmentView.showMenu();
      int choice = departmentView.getInput("Enter your choice: ");

      switch (choice) {
        case 1:
          addDepartment();
          break;
        case 2:
          updateDepartment();
          break;
        case 3:
          deleteDepartment();
          break;
        case 4:
          getDepartmentById();
          break;
        case 5:
          getAllDepartments();
          break;
        case 0:
          running = false;
          break;
        default:
          departmentView.showMessage("Invalid choice. Please try again.");
          break;
      }
    }
  }

  /**
   * Adds a new department to the system based on user input.
   */
  private void addDepartment() {
    Department department = departmentView.getInputDepartment();
    departmentDAO.addDepartment(department);
    departmentView.showMessage("Department added successfully!");
  }

  /**
   * Updates an existing department's information based on user input.
   */
  private void updateDepartment() {
    int deptId = departmentView.getInput("Enter the ID of the department to update: ");
    Department department = departmentDAO.getDepartmentById(String.valueOf(deptId));

    if (department != null) {
      Department updatedDepartment = departmentView.getInputDepartment();
      updatedDepartment.setDeptId(deptId);
      departmentDAO.updateDepartment(updatedDepartment);
      departmentView.showMessage("Department updated successfully!");
    } else {
      departmentView.showMessage("Department with ID " + deptId + " not found.");
    }
  }

  /**
   * Deletes an existing department from the system based on user input.
   */
  private void deleteDepartment() {
    int deptId = departmentView.getInput("Enter the ID of the department to delete: ");
    departmentDAO.deleteDepartment(String.valueOf(deptId));
    departmentView.showMessage("Department deleted successfully!");
  }

  /**
   * Retrieves and displays details of a department based on user input.
   */
  private void getDepartmentById() {
    int deptId = departmentView.getInput("Enter the ID of the department to retrieve: ");
    Department department = departmentDAO.getDepartmentById(String.valueOf(deptId));

    if (department != null) {
      departmentView.showDepartmentDetails(department);
    } else {
      departmentView.showMessage("Department with ID " + deptId + " not found.");
    }
  }

  /**
   * Retrieves and displays details of all departments in the system.
   */
  private void getAllDepartments() {
    List<Department> departments = departmentDAO.getAllDepartments();
    departmentView.showAllDepartments(departments);
  }

}
