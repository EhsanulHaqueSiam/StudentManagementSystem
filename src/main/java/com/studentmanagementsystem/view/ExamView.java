package main.java.com.studentmanagementsystem.view;

import main.java.com.studentmanagementsystem.model.Exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ExamView {
  private final Scanner scanner;

  public ExamView() {
    scanner = new Scanner(System.in);
  }

  public void showMenu() {
    System.out.println("==== Exam Management System ====");
    System.out.println("1. Add Exam");
    System.out.println("2. Update Exam");
    System.out.println("3. Delete Exam");
    System.out.println("4. Get Exam by Date and Type");
    System.out.println("5. Get All Exams");
    System.out.println("0. Exit");
  }

  public int getInputInt(String prompt) {
    System.out.print(prompt);
    return scanner.nextInt();
  }

  public String getInputString(String prompt) {
    System.out.print(prompt);
    scanner.nextLine(); // Consume the newline character
    return scanner.nextLine();
  }

  public Exam getInputExam() {
    System.out.println("Enter Exam Details:");
    int examID = getInputInt("Exam ID: ");

    System.out.print("Exam Date (yyyy-MM-dd): ");
    String examDateStr = getInputString("");
    Date examDate = parseDate(examDateStr);

    int totalMark = getInputInt("Total Mark: ");

    String examType = getInputString("Exam Type: ");

    String examRoomNo = getInputString("Exam Room No: ");

    return new Exam(examID, examDate, totalMark, examType, examRoomNo);
  }

  public Date parseDate(String dateStr) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      return dateFormat.parse(dateStr);
    } catch (ParseException e) {
      System.out.println("Invalid date format. Please use yyyy-MM-dd format.");
      return null;
    }
  }

  public void showMessage(String message) {
    System.out.println(message);
  }

  public void showExamDetails(Exam exam) {
    System.out.println("Exam Details:");
    System.out.println("ID: " + exam.getExamID());
    System.out.println("Date: " + exam.getExamDate());
    System.out.println("Total Mark: " + exam.getTotalMark());
    System.out.println("Type: " + exam.getExamType());
    System.out.println("Room No: " + exam.getExamRoomNo());
  }

  public void showAllExams(List<Exam> exams) {
    if (exams.isEmpty()) {
      System.out.println("No exams found.");
    } else {
      System.out.println("All Exams:");
      for (Exam exam : exams) {
        System.out.println("ID: " + exam.getExamID() + ", Date: " + exam.getExamDate() + ", Type: " + exam.getExamType());
      }
    }
  }
}
