package main.java.com.studentmanagementsystem.model;

/**
 * The `Grade` class represents a grade in the student management system.
 * Each grade has a grade identifier, a year, a semester, and a numeric grade value.
 *
 * <p>This class serves as a data structure to hold information about a student's grade within
 * the student management system. It encapsulates the essential attributes of a grade and provides
 * methods to access and modify these attributes.
 */
public class Grade {

  private int gradeId;
  private String semesterYear;
  private String semester;
  private Double CGPA;

  /**
   * Parameterized constructor for the `Grade` class.
   *
   * @param gradeId      The unique identifier of the grade.
   * @param semesterYear The year and semester associated with the grade.
   * @param semester     The specific semester (e.g., "Fall", "Spring") of the grade.
   * @param CGPA         The Cumulative Grade Point Average (CGPA) achieved by the student.
   *
   * <p>This constructor creates an instance of the `Grade` class with provided attribute values.
   * It allows for the convenient creation of grade objects with specific details.
   */
  public Grade(int gradeId, String semesterYear, String semester, Double CGPA) {
    this.gradeId = gradeId;
    this.semesterYear = semesterYear;
    this.semester = semester;
    this.CGPA = CGPA;
  }

  /**
   * Default constructor for the `Grade` class.
   *
   * <p>This constructor initializes an empty instance of the `Grade` class.
   * The attributes are set to default values or remain uninitialized.
   */
  public Grade() {
  }

  /**
   * Gets the unique identifier of the grade.
   *
   * @return The grade's unique identifier.
   */
  public int getGradeId() {
    return this.gradeId;
  }

  /**
   * Gets the year and semester associated with the grade.
   *
   * @return The grade's semester year.
   */
  public String getSemesterYear() {
    return this.semesterYear;
  }

  /**
   * Gets the specific semester of the grade.
   *
   * @return The grade's semester (e.g., "Fall", "Spring").
   */
  public String getSemester() {
    return this.semester;
  }

  /**
   * Gets the Cumulative Grade Point Average (CGPA) achieved by the student.
   *
   * @return The student's CGPA.
   */
  public Double getCGPA() {
    return this.CGPA;
  }

  /**
   * Sets the unique identifier of the grade.
   *
   * @param gradeId The grade's unique identifier.
   */
  public void setGradeId(int gradeId) {
    this.gradeId = gradeId;
  }

  /**
   * Sets the year and semester associated with the grade.
   *
   * @param semesterYear The grade's semester year.
   */
  public void setSemesterYear(String semesterYear) {
    this.semesterYear = semesterYear;
  }

  /**
   * Sets the specific semester of the grade.
   *
   * @param semester The grade's semester (e.g., "Fall", "Spring").
   */
  public void setSemester(String semester) {
    this.semester = semester;
  }

  /**
   * Sets the Cumulative Grade Point Average (CGPA) achieved by the student.
   *
   * @param CGPA The student's CGPA.
   */
  public void setCGPA(Double CGPA) {
    this.CGPA = CGPA;
  }

  /**
   * Generates a string representation of the `Grade` object.
   *
   * @return A string representation of the `Grade` object.
   */
  public String toString() {
    return "Grade(gradeId=" + this.getGradeId() + ", semesterYear=" + this.getSemesterYear()
        + ", semester=" + this.getSemester() + ", CGPA=" + this.getCGPA() + ")";
  }
}
