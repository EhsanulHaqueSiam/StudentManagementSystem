package main.java.com.studentmanagementsystem.model;

import java.util.Date;

/**
 * Represents an exam in the student management system.
 * Each exam has an exam date, a total mark, an exam type, and an exam location.
 */
public class Exam {

  private int examID;
  private Date examDate;
  private int totalMark;
  private String examType;
  private String examRoomNo;


  public Exam(int examID, Date examDate, int totalMark, String examType, String examRoomNo) {
    this.examID = examID;
    this.examDate = examDate;
    this.totalMark = totalMark;
    this.examType = examType;
    this.examRoomNo = examRoomNo;
  }

  public Exam() {
  }

  public int getExamID() {
    return this.examID;
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

  public String getExamRoomNo() {
    return this.examRoomNo;
  }

  public void setExamID(int examID) {
    this.examID = examID;
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

  public void setExamRoomNo(String examRoomNo) {
    this.examRoomNo = examRoomNo;
  }

  public String toString() {
    return "Exam(examID=" + this.getExamID() + ", examDate=" + this.getExamDate() + ", totalMark="
        + this.getTotalMark() + ", examType=" + this.getExamType() + ", examRoomNo="
        + this.getExamRoomNo() + ")";
  }
}
