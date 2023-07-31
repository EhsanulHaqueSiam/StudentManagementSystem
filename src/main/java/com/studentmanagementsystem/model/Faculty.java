package main.java.com.studentmanagementsystem.model;

/**
 * Represents a faculty member in the student management system.
 * Each faculty member has a unique identifier, a name, a contact number,
 * and an email address.
 */
public class Faculty {
  private int facultyId;
  private String name;
  private String contact;
  private String email;


  public Faculty(int facultyId, String name, String contact, String email) {
    this.facultyId = facultyId;
    this.name = name;
    this.contact = contact;
    this.email = email;
  }

  public Faculty() {
  }

  public int getFacultyId() {
    return this.facultyId;
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

  public void setFacultyId(int facultyId) {
    this.facultyId = facultyId;
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

  public String toString() {
    return "Faculty(facultyId=" + this.getFacultyId() + ", name=" + this.getName() + ", contact="
        + this.getContact() + ", email=" + this.getEmail() + ")";
  }
}
