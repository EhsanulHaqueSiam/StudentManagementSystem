package main.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.data.ProgramDAO;
import main.java.com.studentmanagementsystem.data.ProgramDAOImpl;
import main.java.com.studentmanagementsystem.model.Program;
import main.java.com.studentmanagementsystem.view.ProgramView;

import java.util.List;

public class ProgramController {
  private final ProgramDAO programDAO;
  private final ProgramView programView;

  public ProgramController() {
    this.programDAO = new ProgramDAOImpl();
    this.programView = new ProgramView();
  }

  public void run() {
    boolean running = true;
    while (running) {
      programView.showMenu();
      int choice = programView.getInput("Enter your choice: ");

      switch (choice) {
        case 1:
          addProgram();
          break;
        case 2:
          updateProgram();
          break;
        case 3:
          deleteProgram();
          break;
        case 4:
          getProgramById();
          break;
        case 5:
          getAllPrograms();
          break;
        case 0:
          running = false;
          break;
        default:
          programView.showMessage("Invalid choice. Please try again.");
          break;
      }
    }
  }

  private void addProgram() {
    Program program = programView.getInputProgram();
    programDAO.addProgram(program);
    programView.showMessage("Program added successfully!");
  }

  private void updateProgram() {
    int programId = programView.getInput("Enter the ID of the program to update: ");
    Program program = programDAO.getProgramById(programId);

    if (program != null) {
      Program updatedProgram = programView.getInputProgram();
      updatedProgram.setProgramId(programId);
      programDAO.updateProgram(updatedProgram);
      programView.showMessage("Program updated successfully!");
    } else {
      programView.showMessage("Program with ID " + programId + " not found.");
    }
  }

  private void deleteProgram() {
    int programId = programView.getInput("Enter the ID of the program to delete: ");
    programDAO.deleteProgram(programId);
    programView.showMessage("Program deleted successfully!");
  }

  private void getProgramById() {

    int programId = programView.getInput("Enter the ID of the program to retrieve: ");
    Program program = programDAO.getProgramById(programId);

    if (program != null) {
      programView.showProgramDetails(program);
    } else {
      programView.showMessage("Program with ID " + programId + " not found.");
    }
  }

  private void getAllPrograms() {
    List<Program> programs = programDAO.getAllPrograms();
    programView.showAllPrograms(programs);
  }

}
