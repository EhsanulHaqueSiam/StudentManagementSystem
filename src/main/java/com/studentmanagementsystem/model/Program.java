package main.java.com.studentmanagementsystem.model;

/**
 * Represents a program in the student management system.
 * Each program has a program identifier, a program name, a program duration, and a program type.
 */
public class Program {

  private int programId;
  private String programName;
  private String programDuration;
  private String programType;


public Program(int programId, String programName, String programDuration, String programType) {
  this.programId = programId;
  this.programName = programName;
  this.programDuration = programDuration;
  this.programType = programType;
}

  public Program() {
  }

  public int getProgramId() {
    return this.programId;
  }

  public String getProgramName() {
    return this.programName;
  }

  public String getProgramDuration() {
    return this.programDuration;
  }

  public String getProgramType() {
    return this.programType;
  }

  public void setProgramId(int programId) {
    this.programId = programId;
  }

  public void setProgramName(String programName) {
    this.programName = programName;
  }

  public void setProgramDuration(String programDuration) {
    this.programDuration = programDuration;
  }

  public void setProgramType(String programType) {
    this.programType = programType;
  }

  public String toString() {
    return "Program(programId=" + this.getProgramId() + ", programName=" + this.getProgramName()
        + ", programDuration=" + this.getProgramDuration() + ", programType="
        + this.getProgramType() + ")";
  }
}
