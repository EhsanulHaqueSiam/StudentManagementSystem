package main.java.com.studentmanagementsystem.model;

/**
 * The `Program` class represents an academic program in the student management system.
 * Each program has a program identifier, a program name, a program duration, and a program type.
 *
 * <p>This class encapsulates the essential attributes of an academic program and provides methods
 * to access and modify these attributes. It serves as a data structure to store information about
 * various academic programs offered within the student management system.
 */
public class Program {

  private int programId;
  private String programName;
  private String programDuration;
  private String programType;

  /**
   * Parameterized constructor for the `Program` class.
   *
   * @param programId       The unique identifier of the program.
   * @param programName     The name of the program.
   * @param programDuration The duration of the program (e.g., "4 years").
   * @param programType     The type of the program (e.g., "Undergraduate", "Postgraduate").
   *
   * <p>This constructor creates an instance of the `Program` class with provided attribute values.
   * It allows for the convenient creation of program objects with specific details.
   */
  public Program(int programId, String programName, String programDuration, String programType) {
    this.programId = programId;
    this.programName = programName;
    this.programDuration = programDuration;
    this.programType = programType;
  }

  /**
   * Default constructor for the `Program` class.
   *
   * <p>This constructor initializes an empty instance of the `Program` class.
   * The attributes are set to default values or remain uninitialized.
   */
  public Program() {
  }

  /**
   * Gets the unique identifier of the program.
   *
   * @return The program's unique identifier.
   */
  public int getProgramId() {
    return this.programId;
  }

  /**
   * Gets the name of the program.
   *
   * @return The program's name.
   */
  public String getProgramName() {
    return this.programName;
  }

  /**
   * Gets the duration of the program.
   *
   * @return The program's duration (e.g., "4 years").
   */
  public String getProgramDuration() {
    return this.programDuration;
  }

  /**
   * Gets the type of the program.
   *
   * @return The program's type (e.g., "Undergraduate", "Postgraduate").
   */
  public String getProgramType() {
    return this.programType;
  }

  /**
   * Sets the unique identifier of the program.
   *
   * @param programId The program's unique identifier.
   */
  public void setProgramId(int programId) {
    this.programId = programId;
  }

  /**
   * Sets the name of the program.
   *
   * @param programName The program's name.
   */
  public void setProgramName(String programName) {
    this.programName = programName;
  }

  /**
   * Sets the duration of the program.
   *
   * @param programDuration The program's duration (e.g., "4 years").
   */
  public void setProgramDuration(String programDuration) {
    this.programDuration = programDuration;
  }

  /**
   * Sets the type of the program.
   *
   * @param programType The program's type (e.g., "Undergraduate", "Postgraduate").
   */
  public void setProgramType(String programType) {
    this.programType = programType;
  }

  /**
   * Generates a string representation of the `Program` object.
   *
   * @return A string representation of the `Program` object.
   */
  public String toString() {
    return "Program(programId=" + this.getProgramId() + ", programName=" + this.getProgramName()
        + ", programDuration=" + this.getProgramDuration() + ", programType="
        + this.getProgramType() + ")";
  }
}
