package test.java.com.studentmanagementsystem.model;

import main.java.com.studentmanagementsystem.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentTest {

  private Department department;

  @BeforeEach
  public void setUp() {
    department = new Department(1, "Computer Science", "Dr. Smith");
  }

  @Test
  public void testGetDeptId() {
    assertEquals(1, department.getDeptId());
  }

  @Test
  public void testGetDeptName() {
    assertEquals("Computer Science", department.getDeptName());
  }

  @Test
  public void testGetDeptHead() {
    assertEquals("Dr. Smith", department.getDeptHead());
  }

  @Test
  public void testSetDeptId() {
    department.setDeptId(2);
    assertEquals(2, department.getDeptId());
  }

  @Test
  public void testSetDeptName() {
    department.setDeptName("Physics");
    assertEquals("Physics", department.getDeptName());
  }

  @Test
  public void testSetDeptHead() {
    department.setDeptHead("Prof. Johnson");
    assertEquals("Prof. Johnson", department.getDeptHead());
  }

  @Test
  public void testToString() {
    String expected = "Department(deptId=1, deptName=Computer Science, deptHead=Dr. Smith)";
    assertEquals(expected, department.toString());
  }
}
