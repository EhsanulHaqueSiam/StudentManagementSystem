package main.java.com.studentmanagementsystem.model;

/**
 * Represents a grade in the student management system.
 * Each grade has a grade identifier, a year, a semester, and a numeric grade value.
 */

public class Grade {

  private String gradeId;
  private int year;
  private String semester;
  private Double grade;

  /**
   * Creates a new grade with the specified details.
   *
   * @param gradeId  The unique identifier of the grade.
   * @param year     The year associated with the grade.
   * @param semester The semester associated with the grade.
   * @param grade    The numeric value of the grade.
   */

  public Grade(String gradeId, int year, String semester, Double grade) {
    this.gradeId = gradeId;
    this.year = year;
    this.semester = semester;
    this.grade = grade;
  }

  public Grade() {
  }

  public String getGradeId() {
    return this.gradeId;
  }

  public int getYear() {
    return this.year;
  }

  public String getSemester() {
    return this.semester;
  }

  public Double getGrade() {
    return this.grade;
  }

  public void setGradeId(String gradeId) {
    this.gradeId = gradeId;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setSemester(String semester) {
    this.semester = semester;
  }

  public void setGrade(Double grade) {
    this.grade = grade;
  }

  public String toString() {
    return "Grade(gradeId=" + this.getGradeId() + ", year=" + this.getYear() + ", semester="
        + this.getSemester() + ", grade=" + this.getGrade() + ")";
  }
}
