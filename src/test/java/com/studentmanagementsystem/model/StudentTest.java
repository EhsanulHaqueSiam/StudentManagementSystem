package test.java.com.studentmanagementsystem.model;

import main.java.com.studentmanagementsystem.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

  private Student student;

  @BeforeEach
  public void setUp() {
    student = new Student();
  }

  @Test
  public void testGetAndSetStudentId() {
    student.setStudentId(12345);
    assertEquals(12345, student.getStudentId());
  }

  @Test
  public void testGetAndSetName() {
    student.setName("John Doe");
    assertEquals("John Doe", student.getName());
  }

  @Test
  public void testGetAndSetContact() {
    student.setContact("123-456-7890");
    assertEquals("123-456-7890", student.getContact());
  }

  @Test
  public void testGetAndSetEmail() {
    student.setEmail("john@example.com");
    assertEquals("john@example.com", student.getEmail());
  }

  @Test
  public void testGetAndSetEnrollYear() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date enrollYear = sdf.parse("2023-08-01");
    student.setEnrollYear(enrollYear);
    assertEquals(enrollYear, student.getEnrollYear());
  }

  @Test
  public void testToString() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date enrollYear = sdf.parse("2023-08-01");
    student.setStudentId(12345);
    student.setName("John Doe");
    student.setContact("123-456-7890");
    student.setEmail("john@example.com");
    student.setEnrollYear(enrollYear);

    String expectedToString = "Student(studentId=12345, name=John Doe, contact=123-456-7890, " +
        "email=john@example.com, enrollYear=" + enrollYear + ")";
    assertEquals(expectedToString, student.toString());
  }
}
