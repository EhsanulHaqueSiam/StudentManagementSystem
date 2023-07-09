package test.java.com.studentmanagementsystem.model;

import main.java.com.studentmanagementsystem.model.Teacher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeacherTest {
  private Teacher teacher;

  @Before
  public void setUp() {
    teacher = new Teacher("T001", "John Doe", "A+", "1980-01-01", "9876543210",
        "john@sm.com", "PhD", "Male", "Section A", 50000, 5000, 60000);
  }

  @Test
  public void testGetFullName() {
    Assert.assertEquals("John Doe", teacher.getName());
  }
}
