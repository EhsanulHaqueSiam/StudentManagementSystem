package test.java.com.studentmanagementsystem.util;

import main.java.com.studentmanagementsystem.util.DatabaseHelper;
import main.java.com.studentmanagementsystem.model.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseHelperTest {
  private DatabaseHelper dbHelper;

  @Before
  public void setUp() {
    dbHelper = DatabaseHelper.getInstance();
  }

  @Test
  public void testCRUDOperations() {
    // Create a new student
    Student newStudent = new Student("S001", "John Doe", "A+", "2000-01-01", "1234567890",
        "john@sm.com", "BSc", "Male", "Spring 2023");
    dbHelper.addStudent(newStudent);
    // Read student from the database
    Student fetchedStudent = dbHelper.getStudentById("S001");
    Assert.assertNotNull(fetchedStudent);
    Assert.assertEquals(newStudent.getName(), fetchedStudent.getName());
    // Update student in the database
    fetchedStudent.setName("Jane Doe");
    dbHelper.updateStudent(fetchedStudent);
    fetchedStudent = dbHelper.getStudentById("S001");
    Assert.assertEquals("Jane Doe", fetchedStudent.getName());
    // Delete student from the database
    dbHelper.deleteStudent("S001");
    fetchedStudent = dbHelper.getStudentById("S001");
    Assert.assertNull(fetchedStudent);
  }
}
