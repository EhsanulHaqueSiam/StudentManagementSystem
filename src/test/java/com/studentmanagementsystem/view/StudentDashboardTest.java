package test.java.com.studentmanagementsystem.view;

import main.java.com.studentmanagementsystem.controller.CourseController;
import main.java.com.studentmanagementsystem.model.Course;
import main.java.com.studentmanagementsystem.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class StudentDashboardTest {
  private CourseController mockCourseController;
  private Student mockStudent;
  private StudentDashboard studentDashboard;

  @BeforeEach
  public void setUp() {
    // Create mock objects
    mockCourseController = Mockito.mock(CourseController.class);
    mockStudent = Mockito.mock(Student.class);

    // Create a real StudentDashboard with the mock objects
    studentDashboard = new StudentDashboard(mockCourseController, mockStudent);
  }

  @Test
  public void testDisplayCourses() {
    // Create some mock courses and set up the controller to return them
    Course mockCourse1 = Mockito.mock(Course.class);
    Course mockCourse2 = Mockito.mock(Course.class);
    when(mockCourseController.getAllCourses()).thenReturn(Arrays.asList(mockCourse1, mockCourse2));

    // Call the method under test
    studentDashboard.displayCourses();

    // Verify that the controller's getAllCourses method was called
    verify(mockCourseController).getAllCourses();

    // Verify that the courses were displayed in the UI
    // This will depend on how your method works.
    // For instance, if it adds the courses to a JList, you could do:
    assertTrue(studentDashboard.getCourseList().contains(mockCourse1));
    assertTrue(studentDashboard.getCourseList().contains(mockCourse2));
  }
}
