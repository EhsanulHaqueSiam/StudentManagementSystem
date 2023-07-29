package main.java.com.studentmanagementsystem.data;

import java.util.Date;
import main.java.com.studentmanagementsystem.model.Exam;

import java.util.List;

public interface ExamDAO {

  void addExam(Exam exam);

  void updateExam(Exam exam);

  void deleteExam(Date examDate, String examType);

  Exam getExamByDateAndType(Date examDate, String examType);

  List<Exam> getAllExams();
}