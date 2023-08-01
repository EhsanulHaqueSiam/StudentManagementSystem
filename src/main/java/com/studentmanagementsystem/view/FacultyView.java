package main.java.com.studentmanagementsystem.view;

import java.util.List;
import java.util.Scanner;
import main.java.com.studentmanagementsystem.model.Faculty;

public class FacultyView {
  private final Scanner scanner;

  public FacultyView() {
    scanner = new Scanner(System.in);
  }

  public void showMenu() {
    System.out.println("==== Faculty Management System ====");
    System.out.println("1. Add Faculty");
    System.out.println("2. Update Faculty");
    System.out.println("3. Delete Faculty");
    System.out.println("4. Get Faculty by ID");
    System.out.println("5. Get All Faculties");
    System.out.println("0. Exit");
  }

  public int getInput(String prompt) {
    System.out.print(prompt);
    return scanner.nextInt();
  }

  public Faculty getInputFaculty() {
    System.out.println("Enter Faculty Details:");
    System.out.print("Faculty ID: ");
    scanner.nextLine(); // Consume the newline character
    int facultyId = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Name: ");
    String name = scanner.nextLine();
    System.out.print("Contact: ");
    String contact = scanner.nextLine();
    System.out.print("Email: ");
    String email = scanner.nextLine();

    Faculty faculty = new Faculty(facultyId, name, contact, email);

    return faculty;
  }

  public void showMessage(String message) {
    System.out.println(message);
  }

  public void showFacultyDetails(Faculty faculty) {
    System.out.println("Faculty Details:");
    System.out.println("ID: " + faculty.getFacultyId());
    System.out.println("Name: " + faculty.getName());
    System.out.println("Contact: " + faculty.getContact());
    System.out.println("Email: " + faculty.getEmail());
  }

  public void showAllFaculties(List<Faculty> faculties) {
    if (faculties.isEmpty()) {
      System.out.println("No faculties found.");
    } else {
      System.out.println("All Faculties:");
      for (Faculty faculty : faculties) {
        System.out.println("ID: " + faculty.getFacultyId() + ", Name: " + faculty.getName());
      }
    }
  }
}
