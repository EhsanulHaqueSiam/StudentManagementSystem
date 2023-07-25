package main.java.com.studentmanagementsystem.model;

/**
 * Represents a department in the student management system.
 * Each department has a department identifier, a department name, and a department head.
 */
public class Department {

  private String deptId;
  private String deptName;
  private String deptHead;
  
  /**
   * Creates a new department with the specified details.
   *
   * @param deptId   The unique identifier of the department.
   * @param deptName The name of the department.
   * @param deptHead The head of the department.
   */
  public Department(String deptId, String deptName, String deptHead) {
    this.deptId = deptId;
    this.deptName = deptName;
    this.deptHead = deptHead;
  }

  public Department() {
  }

  public String getDeptId() {
    return this.deptId;
  }

  public String getDeptName() {
    return this.deptName;
  }

  public String getDeptHead() {
    return this.deptHead;
  }

  public void setDeptId(String deptId) {
    this.deptId = deptId;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public void setDeptHead(String deptHead) {
    this.deptHead = deptHead;
  }

  public String toString() {
    return "Department(deptId=" + this.getDeptId() + ", deptName=" + this.getDeptName()
        + ", deptHead=" + this.getDeptHead() + ")";
  }
}
