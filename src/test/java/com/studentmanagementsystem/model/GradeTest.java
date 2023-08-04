package test.java.com.studentmanagementsystem.model;

import main.java.com.studentmanagementsystem.model.Grade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeTest {

  private Grade grade;

  @BeforeEach
  public void setUp() {
    grade = new Grade(1, "2023 Spring", "Spring", 3.75);
  }

  @Test
  public void testGetGradeId() {
    assertEquals(1, grade.getGradeId());
  }

  @Test
  public void testGetSemesterYear() {
    assertEquals("2023 Spring", grade.getSemesterYear());
  }

  @Test
  public void testGetSemester() {
    assertEquals("Spring", grade.getSemester());
  }

  @Test
  public void testGetCGPA() {
    assertEquals(3.75, grade.getCGPA(), 0.01); // Delta is used for floating-point comparison
  }

  @Test
  public void testSetGradeId() {
    grade.setGradeId(2);
    assertEquals(2, grade.getGradeId());
  }

  @Test
  public void testSetSemesterYear() {
    grade.setSemesterYear("2023 Fall");
    assertEquals("2023 Fall", grade.getSemesterYear());
  }

  @Test
  public void testSetSemester() {
    grade.setSemester("Fall");
    assertEquals("Fall", grade.getSemester());
  }

  @Test
  public void testSetCGPA() {
    grade.setCGPA(3.9);
    assertEquals(3.9, grade.getCGPA(), 0.01);
  }

  @Test
  public void testToString() {
    String expected = "Grade(gradeId=1, semesterYear=2023 Spring, semester=Spring, CGPA=3.75)";
    assertEquals(expected, grade.toString());
  }
}
