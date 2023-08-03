package main.java.com.studentmanagementsystem.model;

/**
 * The `Department` class represents a department in the student management system.
 * Each department has a department identifier, a department name, and a department head.
 *
 * <p>This class serves as a data structure to hold information about departments within
 * the student management system. It encapsulates the essential attributes of a department
 * and provides methods to access and modify these attributes.
 */
public class Department {

  private int deptId;
  private String deptName;
  private String deptHead;

  /**
   * Parameterized constructor for the `Department` class.
   *
   * @param deptId   The unique identifier of the department.
   * @param deptName The name of the department.
   * @param deptHead The head of the department.
   *
   * <p>This constructor creates an instance of the `Department` class with provided
   * attribute values. It allows for the convenient creation of department objects with
   * specific details.
   */
  public Department(int deptId, String deptName, String deptHead) {
    this.deptId = deptId;
    this.deptName = deptName;
    this.deptHead = deptHead;
  }

  /**
   * Default constructor for the `Department` class.
   *
   * <p>This constructor initializes an empty instance of the `Department` class.
   * The attributes are set to default values or remain uninitialized.
   */
  public Department() {
  }

  /**
   * Gets the unique identifier of the department.
   *
   * @return The department identifier.
   */
  public int getDeptId() {
    return this.deptId;
  }

  /**
   * Gets the name of the department.
   *
   * @return The name of the department.
   */
  public String getDeptName() {
    return this.deptName;
  }

  /**
   * Gets the head of the department.
   *
   * @return The department head.
   */
  public String getDeptHead() {
    return this.deptHead;
  }

  /**
   * Sets the unique identifier of the department.
   *
   * @param deptId The department identifier.
   */
  public void setDeptId(int deptId) {
    this.deptId = deptId;
  }

  /**
   * Sets the name of the department.
   *
   * @param deptName The name of the department.
   */
  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  /**
   * Sets the head of the department.
   *
   * @param deptHead The department head.
   */
  public void setDeptHead(String deptHead) {
    this.deptHead = deptHead;
  }

  /**
   * Generates a string representation of the `Department` object.
   *
   * @return A string representation of the `Department` object.
   */
  public String toString() {
    return "Department(deptId=" + this.getDeptId() + ", deptName=" + this.getDeptName()
        + ", deptHead=" + this.getDeptHead() + ")";
  }
}
