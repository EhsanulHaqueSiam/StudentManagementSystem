package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Faculty;

import java.util.List;

/**
 * An interface that defines data access operations for Faculty entities.
 */
public interface FacultyDAO {

  /**
   * Adds a new Faculty to the database.
   *
   * @param faculty The Faculty object to be added.
   */
  void addFaculty(Faculty faculty);

  /**
   * Updates an existing Faculty in the database.
   *
   * @param faculty The Faculty object containing updated information.
   */
  void updateFaculty(Faculty faculty);

  /**
   * Deletes a Faculty from the database based on its ID.
   *
   * @param facultyId The ID of the Faculty to be deleted.
   */
  void deleteFaculty(String facultyId);

  /**
   * Retrieves a Faculty from the database based on its ID.
   *
   * @param facultyId The ID of the Faculty to retrieve.
   * @return The Faculty object if found, otherwise null.
   */
  Faculty getFacultyById(String facultyId);

  /**
   * Retrieves a list of all Faculties stored in the database.
   *
   * @return A list of Faculty objects representing all Faculties.
   */
  List<Faculty> getAllFaculties();
}
