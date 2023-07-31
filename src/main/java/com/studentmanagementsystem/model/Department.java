package main.java.com.studentmanagementsystem.model;

/**
 * Represents a department in the student management system.
 * Each department has a department identifier, a department name, and a department head.
 */
public class Department {

  private int deptId;
  private String deptName;
  private String deptHead;


public Department(int deptId, String deptName, String deptHead) {
  this.deptId = deptId;
  this.deptName = deptName;
  this.deptHead = deptHead;
}

  public Department() {
  }

  public int getDeptId() {
    return this.deptId;
  }

  public String getDeptName() {
    return this.deptName;
  }

  public String getDeptHead() {
    return this.deptHead;
  }

  public void setDeptId(int deptId) {
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
