package main.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.data.DepartmentDAO;
import main.java.com.studentmanagementsystem.data.DepartmentDAOImpl;
import main.java.com.studentmanagementsystem.model.Department;
import main.java.com.studentmanagementsystem.view.DepartmentView;

import java.util.List;

public class DepartmentController {
  private final DepartmentDAO departmentDAO;
  private final DepartmentView departmentView;

  public DepartmentController() {
    this.departmentDAO = new DepartmentDAOImpl();
    this.departmentView = new DepartmentView();
  }

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

  private void addDepartment() {
    Department department = departmentView.getInputDepartment();
    departmentDAO.addDepartment(department);
    departmentView.showMessage("Department added successfully!");
  }

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

  private void deleteDepartment() {
    int deptId = departmentView.getInput("Enter the ID of the department to delete: ");
    departmentDAO.deleteDepartment(String.valueOf(deptId));
    departmentView.showMessage("Department deleted successfully!");
  }

  private void getDepartmentById() {
    int deptId = departmentView.getInput("Enter the ID of the department to retrieve: ");
    Department department = departmentDAO.getDepartmentById(String.valueOf(deptId));

    if (department != null) {
      departmentView.showDepartmentDetails(department);
    } else {
      departmentView.showMessage("Department with ID " + deptId + " not found.");
    }
  }

  private void getAllDepartments() {
    List<Department> departments = departmentDAO.getAllDepartments();
    departmentView.showAllDepartments(departments);
  }

  public static void main(String[] args) {
    DepartmentController controller = new DepartmentController();
    controller.run();
  }
}
