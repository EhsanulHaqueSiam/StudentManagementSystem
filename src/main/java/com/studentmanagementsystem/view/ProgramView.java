package main.java.com.studentmanagementsystem.view;

import java.util.List;
import java.util.Scanner;
import main.java.com.studentmanagementsystem.model.Program;

public class ProgramView {
  private final Scanner scanner;

  public ProgramView() {
    scanner = new Scanner(System.in);
  }

  public void showMenu() {
    System.out.println("==== Program Management System ====");
    System.out.println("1. Add Program");
    System.out.println("2. Update Program");
    System.out.println("3. Delete Program");
    System.out.println("4. Get Program by ID");
    System.out.println("5. Get All Programs");
    System.out.println("0. Exit");
  }

  public int getInput(String prompt) {
    System.out.print(prompt);
    return scanner.nextInt();
  }

  public Program getInputProgram() {
    System.out.println("Enter Program Details:");
    System.out.print("Program ID: ");
    scanner.nextLine(); // Consume the newline character
    int programId = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Name: ");
    String name = scanner.nextLine();

    System.out.print("Duration: ");
    String duration = scanner.nextLine();

    System.out.print("Type: ");
    String type = scanner.nextLine();

    Program program = new Program();
    program.setProgramId(programId);
    program.setProgramName(name);
    program.setProgramDuration(duration);
    program.setProgramType(type);

    return program;
  }

  public void showMessage(String message) {
    System.out.println(message);
  }

  public void showProgramDetails(Program program) {
    System.out.println("Program Details:");
    System.out.println("ID: " + program.getProgramId());
    System.out.println("Name: " + program.getProgramName());
    System.out.println("Duration: " + program.getProgramDuration());
    System.out.println("Type: " + program.getProgramType());
  }

  public void showAllPrograms(List<Program> programs) {
    if (programs.isEmpty()) {
      System.out.println("No programs found.");
    } else {
      System.out.println("All Programs:");
      for (Program program : programs) {
        System.out.println("ID: " + program.getProgramId() + ", Name: " + program.getProgramName());
      }
    }
  }
}
