package main.java.com.studentmanagementsystem.model;

/**
 * The `Faculty` class represents a faculty member in the student management system.
 * Each faculty member has a unique identifier, a name, a contact number, and an email address.
 *
 * <p>This class serves as a data structure to hold information about faculty members within
 * the student management system. It encapsulates the essential attributes of a faculty member
 * and provides methods to access and modify these attributes.
 */
public class Faculty {
  private int facultyId;
  private String name;
  private String contact;
  private String email;

  /**
   * Parameterized constructor for the `Faculty` class.
   *
   * @param facultyId The unique identifier of the faculty member.
   * @param name      The name of the faculty member.
   * @param contact   The contact number of the faculty member.
   * @param email     The email address of the faculty member.
   *
   * <p>This constructor creates an instance of the `Faculty` class with provided attribute values.
   * It allows for the convenient creation of faculty member objects with specific details.
   */
  public Faculty(int facultyId, String name, String contact, String email) {
    this.facultyId = facultyId;
    this.name = name;
    this.contact = contact;
    this.email = email;
  }

  /**
   * Default constructor for the `Faculty` class.
   *
   * <p>This constructor initializes an empty instance of the `Faculty` class.
   * The attributes are set to default values or remain uninitialized.
   */
  public Faculty() {
  }

  /**
   * Gets the unique identifier of the faculty member.
   *
   * @return The faculty member's unique identifier.
   */
  public int getFacultyId() {
    return this.facultyId;
  }

  /**
   * Gets the name of the faculty member.
   *
   * @return The faculty member's name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the contact number of the faculty member.
   *
   * @return The faculty member's contact number.
   */
  public String getContact() {
    return this.contact;
  }

  /**
   * Gets the email address of the faculty member.
   *
   * @return The faculty member's email address.
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Sets the unique identifier of the faculty member.
   *
   * @param facultyId The faculty member's unique identifier.
   */
  public void setFacultyId(int facultyId) {
    this.facultyId = facultyId;
  }

  /**
   * Sets the name of the faculty member.
   *
   * @param name The faculty member's name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the contact number of the faculty member.
   *
   * @param contact The faculty member's contact number.
   */
  public void setContact(String contact) {
    this.contact = contact;
  }

  /**
   * Sets the email address of the faculty member.
   *
   * @param email The faculty member's email address.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Generates a string representation of the `Faculty` object.
   *
   * @return A string representation of the `Faculty` object.
   */
  public String toString() {
    return "Faculty(facultyId=" + this.getFacultyId() + ", name=" + this.getName() + ", contact="
        + this.getContact() + ", email=" + this.getEmail() + ")";
  }
}
