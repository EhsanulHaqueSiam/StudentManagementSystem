package test.java.com.studentmanagementsystem.model;

import main.java.com.studentmanagementsystem.model.Classes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassesTest {

  private Classes classes;

  @BeforeEach
  public void setUp() {
    classes = new Classes("Math101", "Room A", "Monday, 9:00 AM");
  }

  @Test
  public void testGetClassName() {
    assertEquals("Math101", classes.getClassName());
  }

  @Test
  public void testGetClassRoomno() {
    assertEquals("Room A", classes.getClassRoomno());
  }

  @Test
  public void testGetClassTime() {
    assertEquals("Monday, 9:00 AM", classes.getClassTime());
  }

  @Test
  public void testSetClassName() {
    classes.setClassName("Physics101");
    assertEquals("Physics101", classes.getClassName());
  }

  @Test
  public void testSetClassRoomno() {
    classes.setClassRoomno("Room B");
    assertEquals("Room B", classes.getClassRoomno());
  }

  @Test
  public void testSetClassTime() {
    classes.setClassTime("Tuesday, 10:30 AM");
    assertEquals("Tuesday, 10:30 AM", classes.getClassTime());
  }

  @Test
  public void testToString() {
    String expected = "Classes(className=Math101, classRoomno=Room A, classTime=Monday, 9:00 AM)";
    assertEquals(expected, classes.toString());
  }
}
