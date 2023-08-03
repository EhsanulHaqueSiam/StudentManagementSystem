package main.java.com.studentmanagementsystem.model;

/**
 * The `Course` class represents a course in the student management system.
 * Each course has a course identifier, a course name, course credits, and course duration.
 *
 * <p>This class serves as a data structure to hold information about courses within
 * the student management system. It encapsulates the essential attributes of a course
 * and provides methods to access and modify these attributes.
 */
public class Course {

  private int courseId;
  private String courseName;
  private int courseCredits;
  private String courseDuration;

  /**
   * Parameterized constructor for the `Course` class.
   *
   * @param courseId       The unique identifier of the course.
   * @param courseName     The name of the course.
   * @param courseCredits  The number of credits associated with the course.
   * @param courseDuration The duration of the course.
   *
   * <p>This constructor creates an instance of the `Course` class with provided
   * attribute values. It allows for the convenient creation of course objects with
   * specific details.
   */
  public Course(int courseId, String courseName, int courseCredits, String courseDuration) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.courseCredits = courseCredits;
    this.courseDuration = courseDuration;
  }

  /**
   * Default constructor for the `Course` class.
   *
   * <p>This constructor initializes an empty instance of the `Course` class.
   * The attributes are set to default values or remain uninitialized.
   */
  public Course() {
  }

  /**
   * Gets the unique identifier of the course.
   *
   * @return The course identifier.
   */
  public int getCourseId() {
    return this.courseId;
  }

  /**
   * Gets the name of the course.
   *
   * @return The name of the course.
   */
  public String getCourseName() {
    return this.courseName;
  }

  /**
   * Gets the number of credits associated with the course.
   *
   * @return The course credits.
   */
  public int getCourseCredits() {
    return this.courseCredits;
  }

  /**
   * Gets the duration of the course.
   *
   * @return The course duration.
   */
  public String getCourseDuration() {
    return this.courseDuration;
  }

  /**
   * Sets the unique identifier of the course.
   *
   * @param courseId The course identifier.
   */
  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  /**
   * Sets the name of the course.
   *
   * @param courseName The name of the course.
   */
  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  /**
   * Sets the number of credits associated with the course.
   *
   * @param courseCredits The course credits.
   */
  public void setCourseCredits(int courseCredits) {
    this.courseCredits = courseCredits;
  }

  /**
   * Sets the duration of the course.
   *
   * @param courseDuration The course duration.
   */
  public void setCourseDuration(String courseDuration) {
    this.courseDuration = courseDuration;
  }

  /**
   * Generates a string representation of the `Course` object.
   *
   * @return A string representation of the `Course` object.
   */
  public String toString() {
    return "Course(courseId=" + this.getCourseId() + ", courseName=" + this.getCourseName()
        + ", courseCredits=" + this.getCourseCredits() + ", courseDuration="
        + this.getCourseDuration() + ")";
  }
}
