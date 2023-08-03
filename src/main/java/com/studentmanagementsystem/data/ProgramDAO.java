package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Program;

import java.util.List;

/**
 * The ProgramDAO interface defines methods to interact with the database for Program entities.
 * It provides CRUD (Create, Read, Update, Delete) operations for Program records.
 */
public interface ProgramDAO {

  /**
   * Adds a new program to the database.
   *
   * @param program The Program object to be added.
   */
  void addProgram(Program program);

  /**
   * Updates an existing program in the database.
   *
   * @param program The updated Program object.
   */
  void updateProgram(Program program);

  /**
   * Deletes a program from the database based on its program ID.
   *
   * @param programId The ID of the program to be deleted.
   */
  void deleteProgram(int programId);

  /**
   * Retrieves a program from the database based on its program ID.
   *
   * @param programId The ID of the program to be retrieved.
   * @return The Program object representing the retrieved program, or null if not found.
   */
  Program getProgramById(int programId);

  /**
   * Retrieves a list of all programs stored in the database.
   *
   * @return A List of Program objects representing all stored programs.
   */
  List<Program> getAllPrograms();
}
