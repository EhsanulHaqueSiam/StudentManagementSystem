package main.java.com.studentmanagementsystem.model;

import java.util.Date;

/**
 * Represents an exam in the student management system.
 * Each exam has an exam date, a total mark, an exam type, and an exam location.
 */
public class Exam {

  private Date examDate;
  private int totalMark;
  private String examType;
  private String examLocation;

  /**
   * Creates a new exam with the specified details.
   *
   * @param examDate     The date of the exam.
   * @param totalMark    The total mark of the exam.
   * @param examType     The type of the exam.
   * @param examLocation The location of the exam.
   */
  public Exam(Date examDate, int totalMark, String examType, String examLocation) {
    this.examDate = examDate;
    this.totalMark = totalMark;
    this.examType = examType;
    this.examLocation = examLocation;
  }

  public Exam() {
  }

  public Date getExamDate() {
    return this.examDate;
  }

  public int getTotalMark() {
    return this.totalMark;
  }

  public String getExamType() {
    return this.examType;
  }

  public String getExamLocation() {
    return this.examLocation;
  }

  public void setExamDate(Date examDate) {
    this.examDate = examDate;
  }

  public void setTotalMark(int totalMark) {
    this.totalMark = totalMark;
  }

  public void setExamType(String examType) {
    this.examType = examType;
  }

  public void setExamLocation(String examLocation) {
    this.examLocation = examLocation;
  }

  public String toString() {
    return "Exam(examDate=" + this.getExamDate() + ", totalMark=" + this.getTotalMark()
        + ", examType=" + this.getExamType() + ", examLocation=" + this.getExamLocation() + ")";
  }
}
