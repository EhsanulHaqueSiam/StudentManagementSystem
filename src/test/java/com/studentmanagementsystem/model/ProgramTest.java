package test.java.com.studentmanagementsystem.model;

import main.java.com.studentmanagementsystem.model.Program;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramTest {

  private Program program;

  @BeforeEach
  public void setUp() {
    program = new Program(1, "Computer Science", "4 years", "Undergraduate");
  }

  @Test
  public void testGetProgramId() {
    assertEquals(1, program.getProgramId());
  }

  @Test
  public void testGetProgramName() {
    assertEquals("Computer Science", program.getProgramName());
  }

  @Test
  public void testGetProgramDuration() {
    assertEquals("4 years", program.getProgramDuration());
  }

  @Test
  public void testGetProgramType() {
    assertEquals("Undergraduate", program.getProgramType());
  }

  @Test
  public void testSetProgramId() {
    program.setProgramId(2);
    assertEquals(2, program.getProgramId());
  }

  @Test
  public void testSetProgramName() {
    program.setProgramName("Electrical Engineering");
    assertEquals("Electrical Engineering", program.getProgramName());
  }

  @Test
  public void testSetProgramDuration() {
    program.setProgramDuration("3 years");
    assertEquals("3 years", program.getProgramDuration());
  }

  @Test
  public void testSetProgramType() {
    program.setProgramType("Postgraduate");
    assertEquals("Postgraduate", program.getProgramType());
  }

  @Test
  public void testToString() {
    String expected = "Program(programId=1, programName=Computer Science, programDuration=4 years, programType=Undergraduate)";
    assertEquals(expected, program.toString());
  }
}
