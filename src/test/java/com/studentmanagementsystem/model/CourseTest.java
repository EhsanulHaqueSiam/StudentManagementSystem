package test.java.com.studentmanagementsystem.model;

import main.java.com.studentmanagementsystem.model.Course;
import main.java.com.studentmanagementsystem.model.Student;
import main.java.com.studentmanagementsystem.model.Teacher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CourseTest {
  private Course course;
  private Teacher teacher;
  private List<Student> students;

  @Before
  public void setUp() {
    teacher = new Teacher("T001", "John Doe", "A+", "1980-01-01", "9876543210",
        "john@sm.com", "PhD", "Male", "Section A", 50000, 5000, 60000);
    students = Arrays.asList(
        new Student("S001", "Alice", "A+", "1998-12-12", "1234567890", "alice@sm.com", "BSc", "Female", "Fall 2022-2023"),
        new Student("S002", "Bob", "B+", "1998-01-01", "2345678901", "bob@sm.com", "MSc", "Male", "Fall 2022-2023")
    );
    course = new Course("C001", "Math 101", "This is a basic math course.", 3, teacher, students);
  }

  @Test
  public void testGetCourseId() {
    Assert.assertEquals("C001", course.getCourseId());
  }

  @Test
  public void testGetCourseName() {
    Assert.assertEquals("Math 101", course.getCourseName());
  }

  @Test
  public void testGetCourseDescription() {
    Assert.assertEquals("This is a basic math course.", course.getCourseDescription());
  }

  @Test
  public void testGetCourseCredits() {
    Assert.assertEquals(3, course.getCourseCredits());
  }

  @Test
  public void testGetCourseInstructor() {
    Assert.assertEquals(teacher, course.getCourseInstructor());
  }

  @Test
  public void testGetEnrolledStudents() {
    Assert.assertEquals(students, course.getEnrolledStudents());
  }
}
