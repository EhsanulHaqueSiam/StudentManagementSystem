package main.java.com.studentmanagementsystem.model;

/**
 * Represents a grade in the student management system.
 * Each grade has a grade identifier, a year, a semester, and a numeric grade value.
 */
public class Grade {

  private int gradeId;
  private String semesterYear;
  private String semester;
  private Double CGPA;


public Grade(int gradeId, String semesterYear, String semester, Double CGPA) {
  this.gradeId = gradeId;
  this.semesterYear = semesterYear;
  this.semester = semester;
  this.CGPA = CGPA;
}

  public Grade() {
  }

  public int getGradeId() {
    return this.gradeId;
  }

  public String getSemesterYear() {
    return this.semesterYear;
  }

  public String getSemester() {
    return this.semester;
  }

  public Double getCGPA() {
    return this.CGPA;
  }

  public void setGradeId(int gradeId) {
    this.gradeId = gradeId;
  }

  public void setSemesterYear(String semesterYear) {
    this.semesterYear = semesterYear;
  }

  public void setSemester(String semester) {
    this.semester = semester;
  }

  public void setCGPA(Double CGPA) {
    this.CGPA = CGPA;
  }

  public String toString() {
    return "Grade(gradeId=" + this.getGradeId() + ", semesterYear=" + this.getSemesterYear()
        + ", semester=" + this.getSemester() + ", CGPA=" + this.getCGPA() + ")";
  }
}
