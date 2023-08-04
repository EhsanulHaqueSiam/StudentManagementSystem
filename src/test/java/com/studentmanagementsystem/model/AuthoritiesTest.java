package test.java.com.studentmanagementsystem.model;

import main.java.com.studentmanagementsystem.model.Authorities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthoritiesTest {

  private Authorities authorities;

  @BeforeEach
  public void setUp() {
    authorities = new Authorities("John Doe", "Principal", "john.doe@example.com", "123-456-7890");
  }

  @Test
  public void testGetAuthorityName() {
    assertEquals("John Doe", authorities.getAuthorityName());
  }

  @Test
  public void testGetAuthorityRole() {
    assertEquals("Principal", authorities.getAuthorityRole());
  }

  @Test
  public void testGetAuthorityMail() {
    assertEquals("john.doe@example.com", authorities.getAuthorityMail());
  }

  @Test
  public void testGetAuthorityContact() {
    assertEquals("123-456-7890", authorities.getAuthorityContact());
  }

  @Test
  public void testSetAuthorityName() {
    authorities.setAuthorityName("Jane Smith");
    assertEquals("Jane Smith", authorities.getAuthorityName());
  }

  @Test
  public void testSetAuthorityRole() {
    authorities.setAuthorityRole("Vice Principal");
    assertEquals("Vice Principal", authorities.getAuthorityRole());
  }

  @Test
  public void testSetAuthorityMail() {
    authorities.setAuthorityMail("jane.smith@example.com");
    assertEquals("jane.smith@example.com", authorities.getAuthorityMail());
  }

  @Test
  public void testSetAuthorityContact() {
    authorities.setAuthorityContact("987-654-3210");
    assertEquals("987-654-3210", authorities.getAuthorityContact());
  }

  @Test
  public void testToString() {
    String expected = "Authorities(authorityName=John Doe, authorityRole=Principal, " +
        "authorityMail=john.doe@example.com, authorityContact=123-456-7890)";
    assertEquals(expected, authorities.toString());
  }
}
