package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Classes;

import java.util.List;

/**
 * The `ClassesDAO` interface defines methods for performing CRUD operations
 * on class records in the database.
 */
public interface ClassesDAO {

  /**
   * Adds a new class to the database.
   *
   * @param classes The `Classes` object representing the class to be added.
   */
  void addClass(Classes classes);

  /**
   * Updates an existing class in the database.
   *
   * @param classes The `Classes` object representing the updated class information.
   */
  void updateClass(Classes classes);

  /**
   * Deletes a class from the database based on its name.
   *
   * @param className The name of the class to be deleted.
   */
  void deleteClass(String className);

  /**
   * Retrieves a class from the database based on its name.
   *
   * @param className The name of the class to be retrieved.
   * @return The `Classes` object representing the retrieved class, or `null` if not found.
   */
  Classes getClassByName(String className);

  /**
   * Retrieves a list of all classes stored in the database.
   *
   * @return A list of `Classes` objects representing all classes in the database.
   */
  List<Classes> getAllClasses();
}
