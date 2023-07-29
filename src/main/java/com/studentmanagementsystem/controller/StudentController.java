package main.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.data.StudentDAO;
import main.java.com.studentmanagementsystem.data.StudentDAOImpl;
import main.java.com.studentmanagementsystem.model.Student;

import java.util.List;

public class StudentController {

  private final StudentDAO studentDAO;

  public StudentController() {
    this.studentDAO = new StudentDAOImpl(); // Instantiate the StudentDAO implementation
  }

  // Method to add a new student
  public void addStudent(Student student) {
    // Add any validation or business logic here, if needed
    studentDAO.addStudent(student);
  }

  // Method to update an existing student
  public void updateStudent(Student student) {
    // Add any validation or business logic here, if needed
    studentDAO.updateStudent(student);
  }

  // Method to delete a student by their ID
  public void deleteStudent(int studentId) {
    // Add any validation or business logic here, if needed
    studentDAO.deleteStudent(studentId);
  }

  // Method to get a student by their ID
  public Student getStudentById(int studentId) {
    // Add any validation or business logic here, if needed
    return studentDAO.getStudentById(studentId);
  }

  // Method to get all students
  public List<Student> getAllStudents() {
    // Add any validation or business logic here, if needed
    return studentDAO.getAllStudents();
  }

  // Add other methods as needed for specific functionality related to student management
  // For example, methods to handle enrollment, grades, etc.
}
