package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Course;

import java.util.List;

/**
 * The `CourseDAO` interface defines the contract for performing CRUD operations
 * on course records in the database.
 */
public interface CourseDAO {

  /**
   * Adds a new course to the database.
   *
   * @param course The course to be added.
   */
  void addCourse(Course course);

  /**
   * Updates an existing course in the database.
   *
   * @param course The updated course information.
   */
  void updateCourse(Course course);

  /**
   * Deletes a course from the database based on the course ID.
   *
   * @param courseId The ID of the course to be deleted.
   */
  void deleteCourse(String courseId);

  /**
   * Retrieves a course from the database based on the course ID.
   *
   * @param courseId The ID of the course to retrieve.
   * @return The retrieved course, or null if not found.
   */
  Course getCourseById(String courseId);

  /**
   * Retrieves all courses from the database.
   *
   * @return A list of all courses in the database.
   */
  List<Course> getAllCourses();
}
