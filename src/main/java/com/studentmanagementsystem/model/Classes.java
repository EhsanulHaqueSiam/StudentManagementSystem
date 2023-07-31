package main.java.com.studentmanagementsystem.model;

/**
 * Represents a class in the student management system.
 * Each class has a class name, a location, and a date and time.
 */
public class Classes {

  private String className;
  private String classRoomno;
  private String classTime;


public Classes(String className, String classRoomno, String classTime) {
  this.className = className;
  this.classRoomno = classRoomno;
  this.classTime = classTime;
}

  public Classes() {
  }

  public String getClassName() {
    return this.className;
  }

  public String getClassRoomno() {
    return this.classRoomno;
  }

  public String getClassTime() {
    return this.classTime;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public void setClassRoomno(String classRoomno) {
    this.classRoomno = classRoomno;
  }

  public void setClassTime(String classTime) {
    this.classTime = classTime;
  }

  public String toString() {
    return "Classes(className=" + this.getClassName() + ", classRoomno=" + this.getClassRoomno()
        + ", classTime=" + this.getClassTime() + ")";
  }
}
