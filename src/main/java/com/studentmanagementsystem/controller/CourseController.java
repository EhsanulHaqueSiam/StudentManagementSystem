package main.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.data.CourseDAO;
import main.java.com.studentmanagementsystem.data.CourseDAOImpl;
import main.java.com.studentmanagementsystem.model.Course;
import main.java.com.studentmanagementsystem.view.CourseView;

import java.util.List;

/**
 * The CourseController class handles user interactions and business logic
 * related to
 * managing courses in the Student Management System.
 */
public class CourseController {
  private final CourseDAO courseDAO;
  private final CourseView courseView;

  /**
   * Initializes the CourseController with the required DAO and View instances.
   */
  public CourseController() {
    this.courseDAO = new CourseDAOImpl();
    this.courseView = new CourseView();
  }

  /**
   * Starts the main loop of the course management system, displaying the menu and
   * handling user input.
   */
  public void run() {
    boolean running = true;
    while (running) {
      courseView.showMenu();
      int choice = courseView.getInput("Enter your choice: ");

      switch (choice) {
        case 1:
          addCourse();
          break;
        case 2:
          updateCourse();
          break;
        case 3:
          deleteCourse();
          break;
        case 4:
          getCourseById();
          break;
        case 5:
          getAllCourses();
          break;
        case 0:
          running = false;
          break;
        default:
          courseView.showMessage("Invalid choice. Please try again.");
          break;
      }
    }
  }

  /**
   * Adds a new course to the system based on user input.
   */
  private void addCourse() {
    Course course = courseView.getInputCourse();
    courseDAO.addCourse(course);
    courseView.showMessage("Course added successfully!");
  }

  /**
   * Updates an existing course's information based on user input.
   */
  private void updateCourse() {
    int courseId = courseView.getInput("Enter the ID of the course to update: ");
    Course course = courseDAO.getCourseById(String.valueOf(courseId));

    if (course != null) {
      Course updatedCourse = courseView.getInputCourse();
      updatedCourse.setCourseId(courseId);
      courseDAO.updateCourse(updatedCourse);
      courseView.showMessage("Course updated successfully!");
    } else {
      courseView.showMessage("Course with ID " + courseId + " not found.");
    }
  }

  /**
   * Deletes an existing course from the system based on user input.
   */
  private void deleteCourse() {
    int courseId = courseView.getInput("Enter the ID of the course to delete: ");
    courseDAO.deleteCourse(String.valueOf(courseId));
    courseView.showMessage("Course deleted successfully!");
  }

  /**
   * Retrieves and displays details of a course based on user input.
   */
  private void getCourseById() {
    int courseId = courseView.getInput("Enter the ID of the course to retrieve: ");
    Course course = courseDAO.getCourseById(String.valueOf(courseId));

    if (course != null) {
      courseView.showCourseDetails(course);
    } else {
      courseView.showMessage("Course with ID " + courseId + " not found.");
    }
  }

  /**
   * Retrieves and displays details of all courses in the system.
   */
  private void getAllCourses() {
    List<Course> courses = courseDAO.getAllCourses();
    courseView.showAllCourses(courses);
  }

}
