package main.java.com.studentmanagementsystem.model;

import java.util.Date;

/**
 * Represents a student in the student management system.
 * Each student has a unique identifier, a name, a contact number,
 * an enrollment year, and an email address.
 */

public class Student {
  private String studentId;
  private String name;
  private String contact;
  private String email;
  private Date enrollYear;

  /**
   * Creates a new student with the specified details.
   *
   * @param studentId  The unique identifier of the student.
   * @param name       The name of the student.
   * @param contact    The contact number of the student.
   * @param enrollYear The enrollment year of the student.
   * @param email      The email address of the student.
   */

  // Constructor
  public Student(String studentId, String name, String contact, Date enrollYear, String email) {
    this.studentId = studentId;
    this.name = name;
    this.email = email;
    this.contact = contact;
    this.enrollYear = enrollYear;
  }

  // Getters
  public String getStudentId() {
    return studentId;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getContact() { 
    return contact;
  }
  
  public Date getEnrollYear() { 
    return enrollYear;
  }

  // Setters
  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public void setEnrollYear(Date enrollYear) {
    this.enrollYear = enrollYear;
  }

  // Override toString method for pretty print
  /**
   * Returns a string representation of the student.
   *
   * @return A string containing student details in a human-readable format.
   */
  @Override
  public String toString() {
    return "Student{" 
        +
        "studentId='" + studentId + '\'' 
        +
        ", name='" + name + '\'' 
        +
        ", erollYear=" + enrollYear 
        +
        ", contact='" + contact + '\'' 
        +
        ", email='" + email + '\'' 
        +
        '}';
  }
}
// CREATE TABLE Students (
//     studentId VARCHAR(255),
//     name VARCHAR(255),
//     enrollYear DATE,
//     email VARCHAR(255),
//     contact VARCHAR(100)
// );
