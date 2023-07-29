package main.java.com.studentmanagementsystem.data.query;

public class ExamQueryConstants {
  public static final String INSERT_EXAM = "INSERT INTO exams (examDate, totalMark, examType, examLocation) VALUES (?, ?, ?, ?)";
  public static final String UPDATE_EXAM = "UPDATE exams SET totalMark=?, examLocation=? WHERE examDate=? AND examType=?";
  public static final String DELETE_EXAM = "DELETE FROM exams WHERE examDate=? AND examType=?";
  public static final String GET_EXAM_BY_DATE_AND_TYPE = "SELECT totalMark, examLocation FROM exams WHERE examDate=? AND examType=?";
  public static final String GET_ALL_EXAMS = "SELECT examDate, totalMark, examType, examLocation FROM exams";
}