package main.java.com.studentmanagementsystem.model;

/**
 * Represents an authority in the student management system.
 * Each authority has a name, a role, an email address, and a contact number.
 */
public class Authorities {

  private String authorityName;
  private String authorityRole;
  private String authorityMail;
  private String authorityContact;

  public Authorities() {
  }

  public Authorities(String authorityName, String authorityRole, String authorityMail,
      String authorityContact) {
    this.authorityName = authorityName;
    this.authorityRole = authorityRole;
    this.authorityMail = authorityMail;
    this.authorityContact = authorityContact;
  }


  public String getAuthorityName() {
    return this.authorityName;
  }

  public String getAuthorityRole() {
    return this.authorityRole;
  }

  public String getAuthorityMail() {
    return this.authorityMail;
  }

  public String getAuthorityContact() {
    return this.authorityContact;
  }

  public void setAuthorityName(String authorityName) {
    this.authorityName = authorityName;
  }

  public void setAuthorityRole(String authorityRole) {
    this.authorityRole = authorityRole;
  }

  public void setAuthorityMail(String authorityMail) {
    this.authorityMail = authorityMail;
  }

  public void setAuthorityContact(String authorityContact) {
    this.authorityContact = authorityContact;
  }

  public String toString() {
    return "Authorities(authorityName=" + this.getAuthorityName() + ", authorityRole="
        + this.getAuthorityRole() + ", authorityMail=" + this.getAuthorityMail()
        + ", authorityContact=" + this.getAuthorityContact() + ")";
  }
}
