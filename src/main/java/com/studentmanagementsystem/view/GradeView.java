package main.java.com.studentmanagementsystem.view;

import java.util.List;
import java.util.Scanner;
import main.java.com.studentmanagementsystem.model.Grade;

public class GradeView {
  private final Scanner scanner;

  public GradeView() {
    scanner = new Scanner(System.in);
  }

  public void showMenu() {
    System.out.println("==== Grade Management System ====");
    System.out.println("1. Add Grade");
    System.out.println("2. Update Grade");
    System.out.println("3. Delete Grade");
    System.out.println("4. Get Grade by ID");
    System.out.println("5. Get All Grades");
    System.out.println("0. Exit");
  }

  public int getInput(String prompt) {
    System.out.print(prompt);
    return scanner.nextInt();
  }

  public Grade getInputGrade() {
    System.out.println("Enter Grade Details:");
    System.out.print("Grade ID: ");
    scanner.nextLine(); // Consume the newline character
    int gradeId = scanner.nextInt();
    scanner.nextLine();
    System.out.print("CGPA: ");
    double cgpa = scanner.nextDouble();
    scanner.nextLine();
    System.out.print("Semester: ");
    String semester = scanner.nextLine();
    System.out.print("Semester Year: ");
    String semesterYear = scanner.nextLine();

    Grade grade = new Grade(gradeId, semesterYear, semester, cgpa);

    return grade;
  }

  public void showMessage(String message) {
    System.out.println(message);
  }

  public void showGradeDetails(Grade grade) {
    System.out.println("Grade Details:");
    System.out.println("ID: " + grade.getGradeId());
    System.out.println("CGPA: " + grade.getCGPA());
    System.out.println("Semester: " + grade.getSemester());
    System.out.println("Semester Year: " + grade.getSemesterYear());
  }

  public void showAllGrades(List<Grade> grades) {
    if (grades.isEmpty()) {
      System.out.println("No grades found.");
    } else {
      System.out.println("All Grades:");
      for (Grade grade : grades) {
        System.out.println("ID: " + grade.getGradeId() + ", CGPA: " + grade.getCGPA());
      }
    }
  }
}
