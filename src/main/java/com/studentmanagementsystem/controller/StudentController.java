package main.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.data.StudentDAO;
import main.java.com.studentmanagementsystem.data.StudentDAOImpl;
import main.java.com.studentmanagementsystem.model.Student;
import main.java.com.studentmanagementsystem.view.StudentView;

import java.util.List;

public class StudentController {
  private final StudentDAO studentDAO;
  private final StudentView studentView;

  public StudentController() {
    this.studentDAO = new StudentDAOImpl();
    this.studentView = new StudentView();
  }

  public void run() {
    boolean running = true;
    while (running) {
      studentView.showMenu();
      int choice = studentView.getInput("Enter your choice: ");

      switch (choice) {
        case 1:
          addStudent();
          break;
        case 2:
          updateStudent();
          break;
        case 3:
          deleteStudent();
          break;
        case 4:
          getStudentById();
          break;
        case 5:
          getAllStudents();
          break;
        case 0:
          running = false;
          break;
        default:
          studentView.showMessage("Invalid choice. Please try again.");
          break;
      }
    }
  }

  private void addStudent() {
    Student student = studentView.getInputStudent();
    studentDAO.addStudent(student);
    studentView.showMessage("Student added successfully!");
  }

  private void updateStudent() {
    int studentId = studentView.getInput("Enter the ID of the student to update: ");
    Student student = studentDAO.getStudentById(studentId);

    if (student != null) {
      Student updatedStudent = studentView.getInputStudent();
      updatedStudent.setStudentId(studentId);
      studentDAO.updateStudent(updatedStudent);
      studentView.showMessage("Student updated successfully!");
    } else {
      studentView.showMessage("Student with ID " + studentId + " not found.");
    }
  }

  private void deleteStudent() {
    int studentId = studentView.getInput("Enter the ID of the student to delete: ");
    studentDAO.deleteStudent(studentId);
    studentView.showMessage("Student deleted successfully!");
  }

  private void getStudentById() {

    int studentId = studentView.getInput("Enter the ID of the student to retrieve: ");
    Student student = studentDAO.getStudentById(studentId);

    if (student != null) {
      studentView.showStudentDetails(student);
    } else {
      studentView.showMessage("Student with ID " + studentId + " not found.");
    }
  }

  private void getAllStudents() {
    List<Student> students = studentDAO.getAllStudents();
    studentView.showAllStudents(students);
  }

}
