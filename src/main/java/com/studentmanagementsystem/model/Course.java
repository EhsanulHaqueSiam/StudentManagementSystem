package main.java.com.studentmanagementsystem.model;

/**
 * Represents a course in the student management system.
 * Each course has a course identifier, a course name, course credits, and course duration.
 */
public class Course {

  private String courseId;
  private String courseName;
  private int courseCredits;
  private int courseDuration;

  /**
   * Creates a new course with the specified details.
   *
   * @param courseId       The unique identifier of the course.
   * @param courseName     The name of the course.
   * @param courseCredits  The number of credits associated with the course.
   * @param courseDuration The duration of the course in weeks.
   */
  public Course(String courseId, String courseName, int courseCredits, int courseDuration) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.courseCredits = courseCredits;
    this.courseDuration = courseDuration;
  }

  public Course() {
  }

  public String getCourseId() {
    return this.courseId;
  }

  public String getCourseName() {
    return this.courseName;
  }

  public int getCourseCredits() {
    return this.courseCredits;
  }

  public int getCourseDuration() {
    return this.courseDuration;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public void setCourseCredits(int courseCredits) {
    this.courseCredits = courseCredits;
  }

  public void setCourseDuration(int courseDuration) {
    this.courseDuration = courseDuration;
  }

  @Override
  public String toString() {
    return "Course(courseId=" + this.getCourseId() + ", courseName=" + this.getCourseName()
        + ", courseCredits=" + this.getCourseCredits() + ", courseDuration="
        + this.getCourseDuration() + ")";
  }
}
