package test.java.com.studentmanagementsystem.model;

import main.java.com.studentmanagementsystem.model.Exam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExamTest {

  private Exam exam;
  private SimpleDateFormat dateFormat;

  @BeforeEach
  public void setUp() throws ParseException {
    dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date examDate = dateFormat.parse("2023-08-10");
    exam = new Exam(1, examDate, 100, "Final", "Room 101");
  }

  @Test
  public void testGetExamID() {
    assertEquals(1, exam.getExamID());
  }

  @Test
  public void testGetExamDate() {
    try {
      Date expectedDate = dateFormat.parse("2023-08-10");
      assertEquals(expectedDate, exam.getExamDate());
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testGetTotalMark() {
    assertEquals(100, exam.getTotalMark());
  }

  @Test
  public void testGetExamType() {
    assertEquals("Final", exam.getExamType());
  }

  @Test
  public void testGetExamRoomNo() {
    assertEquals("Room 101", exam.getExamRoomNo());
  }

  @Test
  public void testSetExamID() {
    exam.setExamID(2);
    assertEquals(2, exam.getExamID());
  }

  @Test
  public void testSetExamDate() throws ParseException {
    Date newExamDate = dateFormat.parse("2023-08-15");
    exam.setExamDate(newExamDate);
    assertEquals(newExamDate, exam.getExamDate());
  }

  @Test
  public void testSetTotalMark() {
    exam.setTotalMark(90);
    assertEquals(90, exam.getTotalMark());
  }

  @Test
  public void testSetExamType() {
    exam.setExamType("Midterm");
    assertEquals("Midterm", exam.getExamType());
  }

  @Test
  public void testSetExamRoomNo() {
    exam.setExamRoomNo("Room 102");
    assertEquals("Room 102", exam.getExamRoomNo());
  }

  @Test
  public void testToString() {
    String expected = "Exam(examID=1, examDate=Wed Aug 10 00:00:00 UTC 2023, totalMark=100, examType=Final, examRoomNo=Room 101)";
    assertEquals(expected, exam.toString());
  }
}
