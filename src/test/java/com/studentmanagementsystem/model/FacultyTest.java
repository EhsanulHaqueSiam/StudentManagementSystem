package test.java.com.studentmanagementsystem.model;

import main.java.com.studentmanagementsystem.model.Faculty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FacultyTest {

  private Faculty faculty;

  @BeforeEach
  public void setUp() {
    faculty = new Faculty(1, "John Doe", "123-456-7890", "john.doe@example.com");
  }

  @Test
  public void testGetFacultyId() {
    assertEquals(1, faculty.getFacultyId());
  }

  @Test
  public void testGetName() {
    assertEquals("John Doe", faculty.getName());
  }

  @Test
  public void testGetContact() {
    assertEquals("123-456-7890", faculty.getContact());
  }

  @Test
  public void testGetEmail() {
    assertEquals("john.doe@example.com", faculty.getEmail());
  }

  @Test
  public void testSetFacultyId() {
    faculty.setFacultyId(2);
    assertEquals(2, faculty.getFacultyId());
  }

  @Test
  public void testSetName() {
    faculty.setName("Jane Smith");
    assertEquals("Jane Smith", faculty.getName());
  }

  @Test
  public void testSetContact() {
    faculty.setContact("987-654-3210");
    assertEquals("987-654-3210", faculty.getContact());
  }

  @Test
  public void testSetEmail() {
    faculty.setEmail("jane.smith@example.com");
    assertEquals("jane.smith@example.com", faculty.getEmail());
  }

  @Test
  public void testToString() {
    String expected = "Faculty(facultyId=1, name=John Doe, contact=123-456-7890, email=john.doe@example.com)";
    assertEquals(expected, faculty.toString());
  }
}
