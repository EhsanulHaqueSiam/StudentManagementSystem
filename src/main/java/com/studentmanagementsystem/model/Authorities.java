package main.java.com.studentmanagementsystem.model;

/**
 * The `Authorities` class represents an authority in the student management system.
 * Each authority has a name, a role, an email address, and a contact number.
 *
 * <p>This class serves as a data structure to hold information about individuals who
 * have roles of authority within the student management system. It encapsulates the
 * essential attributes of an authority and provides methods to access and modify these
 * attributes.
 */
public class Authorities {

  private String authorityName;
  private String authorityRole;
  private String authorityMail;
  private String authorityContact;

  /**
   * Default constructor for the `Authorities` class.
   *
   * <p>This constructor initializes an empty instance of the `Authorities` class.
   * The attributes are set to default values or remain uninitialized.
   */
  public Authorities() {
  }

  /**
   * Parameterized constructor for the `Authorities` class.
   *
   * @param authorityName    The name of the authority.
   * @param authorityRole    The role of the authority.
   * @param authorityMail    The email address of the authority.
   * @param authorityContact The contact number of the authority.
   *
   * <p>This constructor creates an instance of the `Authorities` class with provided
   * attribute values. It allows for the convenient creation of authority objects
   * with specific details.
   */
  public Authorities(String authorityName, String authorityRole, String authorityMail,
      String authorityContact) {
    this.authorityName = authorityName;
    this.authorityRole = authorityRole;
    this.authorityMail = authorityMail;
    this.authorityContact = authorityContact;
  }

  /**
   * Gets the name of the authority.
   *
   * @return The name of the authority.
   */
  public String getAuthorityName() {
    return this.authorityName;
  }

  /**
   * Gets the role of the authority.
   *
   * @return The role of the authority.
   */
  public String getAuthorityRole() {
    return this.authorityRole;
  }

  /**
   * Gets the email address of the authority.
   *
   * @return The email address of the authority.
   */
  public String getAuthorityMail() {
    return this.authorityMail;
  }

  /**
   * Gets the contact number of the authority.
   *
   * @return The contact number of the authority.
   */
  public String getAuthorityContact() {
    return this.authorityContact;
  }

  /**
   * Sets the name of the authority.
   *
   * @param authorityName The name of the authority.
   */
  public void setAuthorityName(String authorityName) {
    this.authorityName = authorityName;
  }

  /**
   * Sets the role of the authority.
   *
   * @param authorityRole The role of the authority.
   */
  public void setAuthorityRole(String authorityRole) {
    this.authorityRole = authorityRole;
  }

  /**
   * Sets the email address of the authority.
   *
   * @param authorityMail The email address of the authority.
   */
  public void setAuthorityMail(String authorityMail) {
    this.authorityMail = authorityMail;
  }

  /**
   * Sets the contact number of the authority.
   *
   * @param authorityContact The contact number of the authority.
   */
  public void setAuthorityContact(String authorityContact) {
    this.authorityContact = authorityContact;
  }

  /**
   * Generates a string representation of the `Authorities` object.
   *
   * @return A string representation of the `Authorities` object.
   */
  public String toString() {
    return "Authorities(authorityName=" + this.getAuthorityName() + ", authorityRole="
        + this.getAuthorityRole() + ", authorityMail=" + this.getAuthorityMail()
        + ", authorityContact=" + this.getAuthorityContact() + ")";
  }
}
