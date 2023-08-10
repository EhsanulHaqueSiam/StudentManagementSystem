package main.java.com.studentmanagementsystem;

import java.sql.SQLException;
import java.util.Scanner;
import main.java.com.studentmanagementsystem.controller.*;
import main.java.com.studentmanagementsystem.util.DatabaseManager;

public class Main {

  public static void main(String[] args) throws SQLException {
    Scanner scanner = new Scanner(System.in);

    // Start the database connection initialization in a separate thread
    Thread dbConnectionThread = new Thread(() -> {
      DatabaseManager.getInstance(); // Initialize the database connection
    });
    dbConnectionThread.start(); // Start the thread

    // Register a shutdown hook to ensure proper closing of the database connection
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      DatabaseManager.getInstance().close();
    }));

    System.out.println("Welcome to the Student Management System!");
    System.out.println("Please choose a controller to run:");
    System.out.println("1. Authorities Controller");
    System.out.println("2. Classes Controller");
    System.out.println("3. Course Controller");
    System.out.println("4. Department Controller");
    System.out.println("5. Exam Controller");
    System.out.println("6. Faculty Controller");
    System.out.println("7. Grade Controller");
    System.out.println("8. Program Controller");
    System.out.println("9. Student Controller");
    System.out.print("Enter the number of the controller you want to run: ");

    int choice = scanner.nextInt();

    // Wait for the database connection thread to finish
    try {
      dbConnectionThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    switch (choice) {
      case 1:
        runAuthoritiesController();
        break;
      case 2:
        runClassesController();
        break;
      case 3:
        runCourseController();
        break;
      case 4:
        runDepartmentController();
        break;
      case 5:
        runExamController();
        break;
      case 6:
        runFacultyController();
        break;
      case 7:
        runGradeController();
        break;
      case 8:
        runProgramController();
        break;
      case 9:
        runStudentController();
        break;
      default:
        System.out.println("Invalid choice. Exiting...");
    }

    scanner.close();
  }

  private static void runAuthoritiesController() throws SQLException {
    AuthoritiesController authoritiesController = new AuthoritiesController();
    authoritiesController.run();
  }

  private static void runClassesController() throws SQLException {
    ClassesController classesController = new ClassesController();
    classesController.run();
  }

  private static void runCourseController() throws SQLException {
    CourseController courseController = new CourseController();
    courseController.run();
  }

  private static void runDepartmentController() throws SQLException {
    DepartmentController departmentController = new DepartmentController();
    departmentController.run();
  }

  private static void runExamController() throws SQLException {
    ExamController examController = new ExamController();
    examController.run();
  }

  private static void runFacultyController() throws SQLException {
    FacultyController facultyController = new FacultyController();
    facultyController.run();
  }

  private static void runGradeController() throws SQLException {
    GradeController gradeController = new GradeController();
    gradeController.run();
  }

  private static void runProgramController() throws SQLException {
    ProgramController programController = new ProgramController();
    programController.run();
  }

  private static void runStudentController() throws SQLException {
    StudentController studentController = new StudentController();
    studentController.run();
  }
}
