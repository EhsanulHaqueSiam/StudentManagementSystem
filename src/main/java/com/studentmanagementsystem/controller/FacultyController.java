package main.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.data.FacultyDAO;
import main.java.com.studentmanagementsystem.data.FacultyDAOImpl;
import main.java.com.studentmanagementsystem.model.Faculty;

import java.util.List;

public class FacultyController {

  private final FacultyDAO facultyDAO;

  public FacultyController() {
    this.facultyDAO = new FacultyDAOImpl(); // Instantiate the FacultyDAO implementation
  }

  // Method to add a new faculty member
  public void addFaculty(Faculty faculty) {
    // Add any validation or business logic here, if needed
    facultyDAO.addFaculty(faculty);
  }

  // Method to update an existing faculty member
  public void updateFaculty(Faculty faculty) {
    // Add any validation or business logic here, if needed
    facultyDAO.updateFaculty(faculty);
  }

  // Method to delete a faculty member by their ID
  public void deleteFaculty(String facultyId) {
    // Add any validation or business logic here, if needed
    facultyDAO.deleteFaculty(facultyId);
  }

  // Method to get a faculty member by their ID
  public Faculty getFacultyById(String facultyId) {
    // Add any validation or business logic here, if needed
    return facultyDAO.getFacultyById(facultyId);
  }

  // Method to get all faculty members
  public List<Faculty> getAllFaculty() {
    // Add any validation or business logic here, if needed
    return facultyDAO.getAllFaculties();
  }

  // Add other methods as needed for specific functionality related to faculty management
  // For example, methods to handle assignments, courses, etc.
}
