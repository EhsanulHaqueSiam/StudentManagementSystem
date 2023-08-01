package main.java.com.studentmanagementsystem.view;

import main.java.com.studentmanagementsystem.model.Classes;

import java.util.List;
import java.util.Scanner;

public class ClassesView {
  private final Scanner scanner;

  public ClassesView() {
    scanner = new Scanner(System.in);
  }

  public void showMenu() {
    System.out.println("==== Classes Management System ====");
    System.out.println("1. Add Class");
    System.out.println("2. Update Class");
    System.out.println("3. Delete Class");
    System.out.println("4. Get Class by Name");
    System.out.println("5. Get All Classes");
    System.out.println("0. Exit");
  }

  public int getInputInt(String prompt) {
    System.out.print(prompt);
    return scanner.nextInt();
  }

  public String getInputString(String prompt) {
    System.out.print(prompt);
    return scanner.next();
  }

  public Classes getInputClass() {
    System.out.println("Enter Class Details:");
    scanner.nextLine(); // Consume the newline character left by previous nextInt()
    System.out.print("Class Name: ");
    String className = scanner.nextLine();
    System.out.print("Class Room No: ");
    String classRoomno = scanner.nextLine();
    System.out.print("Class Time: ");
    String classTime = scanner.nextLine();

    return new Classes(className, classRoomno, classTime);
  }

  public void showMessage(String message) {
    System.out.println(message);
  }

  public void showClassDetails(Classes classes) {
    System.out.println("Class Details:");
    System.out.println("Name: " + classes.getClassName());
    System.out.println("Room No: " + classes.getClassRoomno());
    System.out.println("Time: " + classes.getClassTime());
  }

  public void showAllClasses(List<Classes> classesList) {
    if (classesList.isEmpty()) {
      System.out.println("No classes found.");
    } else {
      System.out.println("All Classes:");
      for (Classes classes : classesList) {
        System.out.println("Name: " + classes.getClassName() + ", Room No: " + classes.getClassRoomno());
      }
    }
  }
}
