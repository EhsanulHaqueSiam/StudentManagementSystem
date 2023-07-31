package main.java.com.studentmanagementsystem.model;

import java.util.Date;

/**
 * Represents a student in the student management system.
 * Each student has a unique identifier, a name, a contact number,
 * an enrollment year, and an email address.
 */
public class Student {
  // Getters
  private int studentId;
  private String name;
  private String contact;
  private String email;
  private Date enrollYear;


  public Student(int studentId, String name, String contact, String email, Date enrollYear) {
    this.studentId = studentId;
    this.name = name;
    this.contact = contact;
    this.email = email;
    this.enrollYear = enrollYear;
  }

  public Student() {
  }

  public int getStudentId() {
    return this.studentId;
  }

  public String getName() {
    return this.name;
  }

  public String getContact() {
    return this.contact;
  }

  public String getEmail() {
    return this.email;
  }

  public Date getEnrollYear() {
    return this.enrollYear;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setEnrollYear(Date enrollYear) {
    this.enrollYear = enrollYear;
  }

  public String toString() {
    return "Student(studentId=" + this.getStudentId() + ", name=" + this.getName() + ", contact="
        + this.getContact() + ", email=" + this.getEmail() + ", enrollYear=" + this.getEnrollYear()
        + ")";
  }
}

