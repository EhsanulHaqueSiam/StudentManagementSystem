package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Course;

import java.util.List;

public interface CourseDAO {
  void addCourse(Course course);

  void updateCourse(Course course);

  void deleteCourse(String courseId);

  Course getCourseById(String courseId);

  List<Course> getAllCourses();
}