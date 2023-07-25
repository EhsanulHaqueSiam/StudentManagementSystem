package main.java.com.studentmanagementsystem.model;

/**
 * Represents a faculty member in the student management system.
 * Each faculty member has a unique identifier, a name, a contact number,
 * and an email address.
 */

public class Faculty {
  private String facultyId;
  private String name;
  private String contact;
  private String email;

  /**
   * Creates a new faculty member with the specified details.
   *
   * @param facultyId The unique identifier of the faculty member.
   * @param name      The name of the faculty member.
   * @param contact   The contact number of the faculty member.
   * @param email     The email address of the faculty member.
   */

  // Constructor
  public Faculty(String facultyId, String name, String contact, String email) {
    this.facultyId = facultyId;
    this.name = name;
    this.contact = contact;
    this.email = email;
  }

  // Getters
  public String getfacultyId() {
    return facultyId;
  }

  public String getName() {
    return name;
  }

  public String getcontact() {
    return contact;
  }

  public String getEmail() {
    return email;
  }


  // Setters
  public void setfacultyId(String facultyId) {
    this.facultyId = facultyId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setcontact(String contact) {
    this.contact = contact;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // Override toString method for pretty print
  @Override
  public String toString() {
    return "Faculty{" 
        +
        "facultyId='" + facultyId + '\'' 
        +
        ", name='" + name + '\'' 
        +
        ", contact='" + contact + '\'' 
        +
        ", email='" + email + '\'' 
        +
        '}';
  }
}
