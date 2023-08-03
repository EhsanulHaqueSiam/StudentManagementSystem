package main.java.com.studentmanagementsystem.model;

import java.util.Date;

/**
 * The `Student` class represents a student in the student management system.
 * Each student has a unique identifier, a name, a contact number, an enrollment year,
 * and an email address.
 *
 * <p>This class encapsulates the essential attributes of a student and provides methods
 * to access and modify these attributes. It serves as a data structure to store information
 * about individual students within the student management system.
 */
public class Student {

  private int studentId;
  private String name;
  private String contact;
  private String email;
  private Date enrollYear;

  /**
   * Parameterized constructor for the `Student` class.
   *
   * @param studentId   The unique identifier of the student.
   * @param name        The name of the student.
   * @param contact     The contact number of the student.
   * @param email       The email address of the student.
   * @param enrollYear  The year in which the student enrolled.
   *
   * <p>This constructor creates an instance of the `Student` class with provided attribute values.
   * It allows for the convenient creation of student objects with specific details.
   */
  public Student(int studentId, String name, String contact, String email, Date enrollYear) {
    this.studentId = studentId;
    this.name = name;
    this.contact = contact;
    this.email = email;
    this.enrollYear = enrollYear;
  }

  /**
   * Default constructor for the `Student` class.
   *
   * <p>This constructor initializes an empty instance of the `Student` class.
   * The attributes are set to default values or remain uninitialized.
   */
  public Student() {
  }

  /**
   * Gets the unique identifier of the student.
   *
   * @return The student's unique identifier.
   */
  public int getStudentId() {
    return this.studentId;
  }

  /**
   * Gets the name of the student.
   *
   * @return The student's name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the contact number of the student.
   *
   * @return The student's contact number.
   */
  public String getContact() {
    return this.contact;
  }

  /**
   * Gets the email address of the student.
   *
   * @return The student's email address.
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Gets the year in which the student enrolled.
   *
   * @return The student's enrollment year.
   */
  public Date getEnrollYear() {
    return this.enrollYear;
  }

  /**
   * Sets the unique identifier of the student.
   *
   * @param studentId The student's unique identifier.
   */
  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  /**
   * Sets the name of the student.
   *
   * @param name The student's name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the contact number of the student.
   *
   * @param contact The student's contact number.
   */
  public void setContact(String contact) {
    this.contact = contact;
  }

  /**
   * Sets the email address of the student.
   *
   * @param email The student's email address.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Sets the year in which the student enrolled.
   *
   * @param enrollYear The student's enrollment year.
   */
  public void setEnrollYear(Date enrollYear) {
    this.enrollYear = enrollYear;
  }

  /**
   * Generates a string representation of the `Student` object.
   *
   * @return A string representation of the `Student` object.
   */
  public String toString() {
    return "Student(studentId=" + this.getStudentId() + ", name=" + this.getName() + ", contact="
        + this.getContact() + ", email=" + this.getEmail() + ", enrollYear=" + this.getEnrollYear()
        + ")";
  }
}
