package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Department;

import java.util.List;

public interface DepartmentDAO {
  void addDepartment(Department department);
  void updateDepartment(Department department);
  void deleteDepartment(String deptId);
  Department getDepartmentById(String deptId);
  List<Department> getAllDepartments();
}
