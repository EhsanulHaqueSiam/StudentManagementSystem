package test.java.com.studentmanagementsystem.model;

import main.java.com.studentmanagementsystem.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

  private Course course;

  @BeforeEach
  public void setUp() {
    course = new Course(1, "Mathematics", 3, "12 weeks");
  }

  @Test
  public void testGetCourseId() {
    assertEquals(1, course.getCourseId());
  }

  @Test
  public void testGetCourseName() {
    assertEquals("Mathematics", course.getCourseName());
  }

  @Test
  public void testGetCourseCredits() {
    assertEquals(3, course.getCourseCredits());
  }

  @Test
  public void testGetCourseDuration() {
    assertEquals("12 weeks", course.getCourseDuration());
  }

  @Test
  public void testSetCourseId() {
    course.setCourseId(2);
    assertEquals(2, course.getCourseId());
  }

  @Test
  public void testSetCourseName() {
    course.setCourseName("Physics");
    assertEquals("Physics", course.getCourseName());
  }

  @Test
  public void testSetCourseCredits() {
    course.setCourseCredits(4);
    assertEquals(4, course.getCourseCredits());
  }

  @Test
  public void testSetCourseDuration() {
    course.setCourseDuration("10 weeks");
    assertEquals("10 weeks", course.getCourseDuration());
  }

  @Test
  public void testToString() {
    String expected = "Course(courseId=1, courseName=Mathematics, courseCredits=3, courseDuration=12 weeks)";
    assertEquals(expected, course.toString());
  }
}
