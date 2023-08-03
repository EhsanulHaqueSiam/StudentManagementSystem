package main.java.com.studentmanagementsystem.model;

/**
 * The `Classes` class represents a class in the student management system.
 * Each class has a class name, a location, and a date and time.
 *
 * <p>This class serves as a data structure to hold information about classes within
 * the student management system. It encapsulates the essential attributes of a class
 * and provides methods to access and modify these attributes.
 */
public class Classes {

  private String className;
  private String classRoomno;
  private String classTime;

  /**
   * Parameterized constructor for the `Classes` class.
   *
   * @param className   The name of the class.
   * @param classRoomno The room number where the class is held.
   * @param classTime   The date and time of the class.
   *
   * <p>This constructor creates an instance of the `Classes` class with provided
   * attribute values. It allows for the convenient creation of class objects with
   * specific details.
   */
  public Classes(String className, String classRoomno, String classTime) {
    this.className = className;
    this.classRoomno = classRoomno;
    this.classTime = classTime;
  }

  /**
   * Default constructor for the `Classes` class.
   *
   * <p>This constructor initializes an empty instance of the `Classes` class.
   * The attributes are set to default values or remain uninitialized.
   */
  public Classes() {
  }

  /**
   * Gets the name of the class.
   *
   * @return The name of the class.
   */
  public String getClassName() {
    return this.className;
  }

  /**
   * Gets the room number where the class is held.
   *
   * @return The room number where the class is held.
   */
  public String getClassRoomno() {
    return this.classRoomno;
  }

  /**
   * Gets the date and time of the class.
   *
   * @return The date and time of the class.
   */
  public String getClassTime() {
    return this.classTime;
  }

  /**
   * Sets the name of the class.
   *
   * @param className The name of the class.
   */
  public void setClassName(String className) {
    this.className = className;
  }

  /**
   * Sets the room number where the class is held.
   *
   * @param classRoomno The room number where the class is held.
   */
  public void setClassRoomno(String classRoomno) {
    this.classRoomno = classRoomno;
  }

  /**
   * Sets the date and time of the class.
   *
   * @param classTime The date and time of the class.
   */
  public void setClassTime(String classTime) {
    this.classTime = classTime;
  }

  /**
   * Generates a string representation of the `Classes` object.
   *
   * @return A string representation of the `Classes` object.
   */
  public String toString() {
    return "Classes(className=" + this.getClassName() + ", classRoomno=" + this.getClassRoomno()
        + ", classTime=" + this.getClassTime() + ")";
  }
}
