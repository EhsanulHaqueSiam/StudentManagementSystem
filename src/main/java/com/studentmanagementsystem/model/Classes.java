package main.java.com.studentmanagementsystem.model;

import java.time.LocalDateTime;

/**
 * Represents a class in the student management system.
 * Each class has a class name, a location, and a date and time.
 */

public class Classes {

  private String className;
  private String classLocation;
  private LocalDateTime time;

  /**
   * Creates a new class with the specified details.
   *
   * @param className     The name of the class.
   * @param classLocation The location of the class.
   * @param time          The date and time of the class.
   */
  //Parameterized Constructor
  public Classes(String className, String classLocation, LocalDateTime time) {
    this.className = className;
    this.classLocation = classLocation;
    this.time = time;
  }

  //Defalut Constructor
  public Classes() {
  }

  public String getClassName() {
    return this.className;
  }

  public String getClassLocation() {
    return this.classLocation;
  }

  public LocalDateTime getTime() {
    return this.time;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public void setClassLocation(String classLocation) {
    this.classLocation = classLocation;
  }

  public void setTime(LocalDateTime time) {
    this.time = time;
  }

  @Override
  public String toString() {
    return "Classes(className=" + this.getClassName() + ", classLocation=" + this.getClassLocation()
        + ", time=" + this.getTime() + ")";
  }
}
