package main.java.com.studentmanagementsystem.view;

import main.java.com.studentmanagementsystem.model.Course;

import java.util.List;
import java.util.Scanner;

public class CourseView {
  private final Scanner scanner;

  public CourseView() {
    scanner = new Scanner(System.in);
  }

  public void showMenu() {
    System.out.println("==== Course Management System ====");
    System.out.println("1. Add Course");
    System.out.println("2. Update Course");
    System.out.println("3. Delete Course");
    System.out.println("4. Get Course by ID");
    System.out.println("5. Get All Courses");
    System.out.println("0. Exit");
  }

  public int getInput(String prompt) {
    System.out.print(prompt);
    return scanner.nextInt();
  }

  public Course getInputCourse() {
    System.out.println("Enter Course Details:");
    System.out.print("Course ID: ");
    int courseId = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Name: ");
    String courseName = scanner.nextLine();
    System.out.print("Duration: ");
    String courseDuration = scanner.nextLine();
    System.out.print("Credits: ");
    int courseCredits = scanner.nextInt();

    return new Course(courseId, courseName, courseCredits, courseDuration);
  }

  public void showMessage(String message) {
    System.out.println(message);
  }

  public void showCourseDetails(Course course) {
    System.out.println("Course Details:");
    System.out.println("ID: " + course.getCourseId());
    System.out.println("Name: " + course.getCourseName());
    System.out.println("Duration: " + course.getCourseDuration());
    System.out.println("Credits: " + course.getCourseCredits());
  }

  public void showAllCourses(List<Course> courses) {
    if (courses.isEmpty()) {
      System.out.println("No courses found.");
    } else {
      System.out.println("All Courses:");
      for (Course course : courses) {
        System.out.println("ID: " + course.getCourseId() + ", Name: " + course.getCourseName());
      }
    }
  }
}
