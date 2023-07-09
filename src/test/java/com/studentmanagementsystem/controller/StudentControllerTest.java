package test.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.controller.StudentController;
import main.java.com.studentmanagementsystem.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentControllerTest {
  private StudentController studentController;

  @BeforeEach
  public void setup() {
    studentController = new StudentController();
  }

  @Test
  public void testGetStudentByEmail() {
    String email = "test@test.com";
    Student student = studentController.getStudentByEmail(email);

    assertNotNull(student, "Expected a student object, but got null");
    assertEquals(email, student.getEmail(), "Expected email to match, but it did not");
  }

  @Test
  public void testGetStudentById() {
    String studentId = "1234";
    Student student = studentController.getStudentById(studentId);

    assertNotNull(student, "Expected a student object, but got null");
    assertEquals(studentId, student.getStudentId(), "Expected studentId to match, but it did not");
  }
}
