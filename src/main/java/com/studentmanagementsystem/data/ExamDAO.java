package main.java.com.studentmanagementsystem.data;

import java.util.Date;
import main.java.com.studentmanagementsystem.model.Exam;

import java.util.List;

/**
 * An interface representing data access operations for Exam entities.
 */
public interface ExamDAO {

  /**
   * Adds a new exam record to the database.
   *
   * @param exam The exam object to be added.
   */
  void addExam(Exam exam);

  /**
   * Updates an existing exam record in the database.
   *
   * @param exam The exam object with updated information.
   */
  void updateExam(Exam exam);

  /**
   * Deletes an exam record from the database based on the exam date and type.
   *
   * @param examDate The date of the exam.
   * @param examType The type of the exam.
   */
  void deleteExam(Date examDate, String examType);

  /**
   * Retrieves an exam record from the database based on the exam date and type.
   *
   * @param examDate The date of the exam.
   * @param examType The type of the exam.
   * @return The retrieved Exam object, or null if not found.
   */
  Exam getExamByDateAndType(Date examDate, String examType);

  /**
   * Retrieves a list of all exam records from the database.
   *
   * @return A list containing all Exam objects.
   */
  List<Exam> getAllExams();
}
