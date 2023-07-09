package main.java.com.studentmanagementsystem.model;

import java.util.List;

public class Course {
  private String courseId;
  private String courseName;
  private String courseDescription;
  private int courseCredits;
  private Teacher courseInstructor;
  private List<Student> enrolledStudents;

  // Constructor
  public Course(String courseId, String courseName, String courseDescription, int courseCredits, Teacher courseInstructor, List<Student> enrolledStudents) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.courseDescription = courseDescription;
    this.courseCredits = courseCredits;
    this.courseInstructor = courseInstructor;
    this.enrolledStudents = enrolledStudents;
  }

  // Getters
  public String getCourseId() {
    return courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public String getCourseDescription() {
    return courseDescription;
  }

  public int getCourseCredits() {
    return courseCredits;
  }

  public Teacher getCourseInstructor() {
    return courseInstructor;
  }

  public List<Student> getEnrolledStudents() {
    return enrolledStudents;
  }

  // Setters
  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public void setCourseDescription(String courseDescription) {
    this.courseDescription = courseDescription;
  }

  public void setCourseCredits(int courseCredits) {
    this.courseCredits = courseCredits;
  }

  public void setCourseInstructor(Teacher courseInstructor) {
    this.courseInstructor = courseInstructor;
  }

  public void setEnrolledStudents(List<Student> enrolledStudents) {
    this.enrolledStudents = enrolledStudents;
  }

  // Override toString method for pretty print
  @Override
  public String toString() {
    return "Course{" +
        "courseId='" + courseId + '\'' +
        ", courseName='" + courseName + '\'' +
        ", courseDescription='" + courseDescription + '\'' +
        ", courseCredits=" + courseCredits +
        ", courseInstructor=" + courseInstructor +
        ", enrolledStudents=" + enrolledStudents +
        '}';
  }
}
