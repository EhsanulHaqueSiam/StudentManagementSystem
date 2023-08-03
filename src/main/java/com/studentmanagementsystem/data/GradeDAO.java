package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Grade;

import java.util.List;

/**
 * The GradeDAO interface defines the contract for accessing and managing Grade entities in the database.
 */
public interface GradeDAO {

  /**
   * Adds a new Grade entity to the database.
   *
   * @param grade The Grade object to be added.
   */
  void addGrade(Grade grade);

  /**
   * Updates an existing Grade entity in the database.
   *
   * @param grade The Grade object containing updated information.
   */
  void updateGrade(Grade grade);

  /**
   * Deletes a Grade entity from the database using its unique identifier.
   *
   * @param gradeId The unique identifier of the Grade to be deleted.
   */
  void deleteGrade(String gradeId);

  /**
   * Retrieves a Grade entity from the database using its unique identifier.
   *
   * @param gradeId The unique identifier of the Grade to retrieve.
   * @return The Grade object associated with the given gradeId, or null if not found.
   */
  Grade getGradeById(String gradeId);

  /**
   * Retrieves a list of all Grade entities stored in the database.
   *
   * @return A list of Grade objects representing all grades.
   */
  List<Grade> getAllGrades();
}
