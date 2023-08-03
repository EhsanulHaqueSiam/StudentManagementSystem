package main.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.data.ExamDAO;
import main.java.com.studentmanagementsystem.data.ExamDAOImpl;
import main.java.com.studentmanagementsystem.model.Exam;
import main.java.com.studentmanagementsystem.view.ExamView;

import java.util.Date;
import java.util.List;

public class ExamController {
  private final ExamDAO examDAO;
  private final ExamView examView;

  public ExamController() {
    this.examDAO = new ExamDAOImpl();
    this.examView = new ExamView();
  }

  public void run() {
    boolean running = true;
    while (running) {
      examView.showMenu();
      int choice = examView.getInputInt("Enter your choice: ");

      switch (choice) {
        case 1:
          addExam();
          break;
        case 2:
          updateExam();
          break;
        case 3:
          deleteExam();
          break;
        case 4:
          getExamByDateAndType();
          break;
        case 5:
          getAllExams();
          break;
        case 0:
          running = false;
          break;
        default:
          examView.showMessage("Invalid choice. Please try again.");
          break;
      }
    }
  }

  private void addExam() {
    Exam exam = examView.getInputExam();
    examDAO.addExam(exam);
    examView.showMessage("Exam added successfully!");
  }

  private void updateExam() {
    int examID = examView.getInputInt("Enter the ID of the exam to update: ");
    Exam exam = examDAO.getExamByDateAndType(examView.parseDate(""), "");

    if (exam != null) {
      Exam updatedExam = examView.getInputExam();
      updatedExam.setExamID(examID);
      examDAO.updateExam(updatedExam);
      examView.showMessage("Exam updated successfully!");
    } else {
      examView.showMessage("Exam with ID " + examID + " not found.");
    }
  }

  private void deleteExam() {
    String examDateStr = examView.getInputString("Enter the Exam Date (yyyy-MM-dd): ");
    String examType = examView.getInputString("Enter the Exam Type: ");
    examDAO.deleteExam(examView.parseDate(examDateStr), examType);
    examView.showMessage("Exam deleted successfully!");
  }

  private void getExamByDateAndType() {
    String examDateStr = examView.getInputString("Enter the Exam Date (yyyy-MM-dd): ");
    String examType = examView.getInputString("Enter the Exam Type: ");
    Date examDate = examView.parseDate(examDateStr);
    if (examDate != null) {
      Exam exam = examDAO.getExamByDateAndType(examDate, examType);
      if (exam != null) {
        examView.showExamDetails(exam);
      } else {
        examView.showMessage("Exam not found for the specified date and type.");
      }
    }
  }

  private void getAllExams() {
    List<Exam> exams = examDAO.getAllExams();
    examView.showAllExams(exams);
  }

}
