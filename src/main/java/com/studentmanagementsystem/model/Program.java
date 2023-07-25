package main.java.com.studentmanagementsystem.model;

/**
 * Represents a program in the student management system.
 * Each program has a program identifier, a program name, a program duration, and a program type.
 */
public class Program {

  private String programId;
  private String programName;
  private int programDuration;
  private String programType;

  /**
   * Creates a new program with the specified details.
   *
   * @param programId       The unique identifier of the program.
   * @param programName     The name of the program.
   * @param programDuration The duration of the program in months.
   * @param programType     The type of the program (e.g., "Bachelor", "Master", etc.).
   */
  public Program(String programId, String programName, int programDuration, String programType) {
    this.programId = programId;
    this.programName = programName;
    this.programDuration = programDuration;
    this.programType = programType;
  }

  public Program() {
  }

  public String getProgramId() {
    return this.programId;
  }

  public String getProgramName() {
    return this.programName;
  }

  public int getProgramDuration() {
    return this.programDuration;
  }

  public String getProgramType() {
    return this.programType;
  }

  public void setProgramId(String programId) {
    this.programId = programId;
  }

  public void setProgramName(String programName) {
    this.programName = programName;
  }

  public void setProgramDuration(int programDuration) {
    this.programDuration = programDuration;
  }

  public void setProgramType(String programType) {
    this.programType = programType;
  }

  /**
   * Returns a string representation of the program.
   *
   * @return A string containing program details.
   */
  @Override
  public String toString() {
    return "Program(programId=" + this.getProgramId() + ", programName=" + this.getProgramName()
        + ", programDuration=" + this.getProgramDuration() + ", programType="
        + this.getProgramType() + ")";
  }
}
