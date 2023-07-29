package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Grade;

import java.util.List;

public interface GradeDAO {
  void addGrade(Grade grade);
  void updateGrade(Grade grade);
  void deleteGrade(String gradeId);
  Grade getGradeById(String gradeId);
  List<Grade> getAllGrades();
}
