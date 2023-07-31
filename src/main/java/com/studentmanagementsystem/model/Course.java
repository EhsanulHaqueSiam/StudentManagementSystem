package main.java.com.studentmanagementsystem.model;

/**
 * Represents a course in the student management system.
 * Each course has a course identifier, a course name, course credits, and course duration.
 */
public class Course {

  private int courseId;
  private String courseName;
  private int courseCredits;
  private String courseDuration;


public Course(int courseId, String courseName, int courseCredits, String courseDuration) {
  this.courseId = courseId;
  this.courseName = courseName;
  this.courseCredits = courseCredits;
  this.courseDuration = courseDuration;
}

  public Course() {
  }

  public int getCourseId() {
    return this.courseId;
  }

  public String getCourseName() {
    return this.courseName;
  }

  public int getCourseCredits() {
    return this.courseCredits;
  }

  public String getCourseDuration() {
    return this.courseDuration;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public void setCourseCredits(int courseCredits) {
    this.courseCredits = courseCredits;
  }

  public void setCourseDuration(String courseDuration) {
    this.courseDuration = courseDuration;
  }

  public String toString() {
    return "Course(courseId=" + this.getCourseId() + ", courseName=" + this.getCourseName()
        + ", courseCredits=" + this.getCourseCredits() + ", courseDuration="
        + this.getCourseDuration() + ")";
  }
}
