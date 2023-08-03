package main.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.data.FacultyDAO;
import main.java.com.studentmanagementsystem.data.FacultyDAOImpl;
import main.java.com.studentmanagementsystem.model.Faculty;
import main.java.com.studentmanagementsystem.view.FacultyView;

import java.util.List;

public class FacultyController {
  private final FacultyDAO facultyDAO;
  private final FacultyView facultyView;

  public FacultyController() {
    this.facultyDAO = new FacultyDAOImpl();
    this.facultyView = new FacultyView();
  }

  public void run() {
    boolean running = true;
    while (running) {
      facultyView.showMenu();
      int choice = facultyView.getInput("Enter your choice: ");

      switch (choice) {
        case 1:
          addFaculty();
          break;
        case 2:
          updateFaculty();
          break;
        case 3:
          deleteFaculty();
          break;
        case 4:
          getFacultyById();
          break;
        case 5:
          getAllFaculties();
          break;
        case 0:
          running = false;
          break;
        default:
          facultyView.showMessage("Invalid choice. Please try again.");
          break;
      }
    }
  }

  private void addFaculty() {
    Faculty faculty = facultyView.getInputFaculty();
    facultyDAO.addFaculty(faculty);
    facultyView.showMessage("Faculty added successfully!");
  }

  private void updateFaculty() {
    int facultyId = facultyView.getInput("Enter the ID of the faculty to update: ");
    Faculty faculty = facultyDAO.getFacultyById(Integer.toString(facultyId));

    if (faculty != null) {
      Faculty updatedFaculty = facultyView.getInputFaculty();
      updatedFaculty.setFacultyId(facultyId);
      facultyDAO.updateFaculty(updatedFaculty);
      facultyView.showMessage("Faculty updated successfully!");
    } else {
      facultyView.showMessage("Faculty with ID " + facultyId + " not found.");
    }
  }

  private void deleteFaculty() {
    int facultyId = facultyView.getInput("Enter the ID of the faculty to delete: ");
    facultyDAO.deleteFaculty(Integer.toString(facultyId));
    facultyView.showMessage("Faculty deleted successfully!");
  }

  private void getFacultyById() {
    int facultyId = facultyView.getInput("Enter the ID of the faculty to retrieve: ");
    Faculty faculty = facultyDAO.getFacultyById(Integer.toString(facultyId));

    if (faculty != null) {
      facultyView.showFacultyDetails(faculty);
    } else {
      facultyView.showMessage("Faculty with ID " + facultyId + " not found.");
    }
  }

  private void getAllFaculties() {
    List<Faculty> faculties = facultyDAO.getAllFaculties();
    facultyView.showAllFaculties(faculties);
  }

}
