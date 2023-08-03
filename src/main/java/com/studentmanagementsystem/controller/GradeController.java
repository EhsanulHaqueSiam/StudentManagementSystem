package main.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.data.GradeDAO;
import main.java.com.studentmanagementsystem.data.GradeDAOImpl;
import main.java.com.studentmanagementsystem.model.Grade;
import main.java.com.studentmanagementsystem.view.GradeView;

import java.util.List;

public class GradeController {
  private final GradeDAO gradeDAO;
  private final GradeView gradeView;

  public GradeController() {
    this.gradeDAO = new GradeDAOImpl();
    this.gradeView = new GradeView();
  }

  public void run() {
    boolean running = true;
    while (running) {
      gradeView.showMenu();
      int choice = gradeView.getInput("Enter your choice: ");

      switch (choice) {
        case 1:
          addGrade();
          break;
        case 2:
          updateGrade();
          break;
        case 3:
          deleteGrade();
          break;
        case 4:
          getGradeById();
          break;
        case 5:
          getAllGrades();
          break;
        case 0:
          running = false;
          break;
        default:
          gradeView.showMessage("Invalid choice. Please try again.");
          break;
      }
    }
  }

  private void addGrade() {
    Grade grade = gradeView.getInputGrade();
    gradeDAO.addGrade(grade);
    gradeView.showMessage("Grade added successfully!");
  }

  private void updateGrade() {
    int gradeId = gradeView.getInput("Enter the ID of the grade to update: ");
    Grade grade = gradeDAO.getGradeById(Integer.toString(gradeId));

    if (grade != null) {
      Grade updatedGrade = gradeView.getInputGrade();
      updatedGrade.setGradeId(gradeId);
      gradeDAO.updateGrade(updatedGrade);
      gradeView.showMessage("Grade updated successfully!");
    } else {
      gradeView.showMessage("Grade with ID " + gradeId + " not found.");
    }
  }

  private void deleteGrade() {
    int gradeId = gradeView.getInput("Enter the ID of the grade to delete: ");
    gradeDAO.deleteGrade(Integer.toString(gradeId));
    gradeView.showMessage("Grade deleted successfully!");
  }

  private void getGradeById() {
    int gradeId = gradeView.getInput("Enter the ID of the grade to retrieve: ");
    Grade grade = gradeDAO.getGradeById(Integer.toString(gradeId));

    if (grade != null) {
      gradeView.showGradeDetails(grade);
    } else {
      gradeView.showMessage("Grade with ID " + gradeId + " not found.");
    }
  }

  private void getAllGrades() {
    List<Grade> grades = gradeDAO.getAllGrades();
    gradeView.showAllGrades(grades);
  }

}
