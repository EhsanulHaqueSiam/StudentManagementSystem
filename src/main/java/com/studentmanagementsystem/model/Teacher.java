package main.java.com.studentmanagementsystem.model;

import java.time.LocalDate;
import java.util.List;

public class Teacher {
  private String teacherId;
  private String name;
  private String bloodGroup;
  private LocalDate dateOfBirth; // using java.time.LocalDate to represent date
  private String mobileNumber;
  private String email;
  private List<String> degrees; // BSc, MSc, etc. - This is a list because a teacher may have multiple degrees.
  private String gender; // could use an Enum here as well
  private List<String> sections; // sections that the teacher is assigned to.
  private double payscale;
  private double bonusAmount;
  private double salary;

  // Constructor
  public Teacher(String teacherId, String name, String bloodGroup, LocalDate dateOfBirth, String mobileNumber, String email, List<String> degrees, String gender, List<String> sections, double payscale, double bonusAmount, double salary) {
    this.teacherId = teacherId;
    this.name = name;
    this.bloodGroup = bloodGroup;
    this.dateOfBirth = dateOfBirth;
    this.mobileNumber = mobileNumber;
    this.email = email;
    this.degrees = degrees;
    this.gender = gender;
    this.sections = sections;
    this.payscale = payscale;
    this.bonusAmount = bonusAmount;
    this.salary = salary;
  }

  // Getters
  public String getTeacherId() {
    return teacherId;
  }

  public String getName() {
    return name;
  }

  public String getBloodGroup() {
    return bloodGroup;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public String getEmail() {
    return email;
  }

  public List<String> getDegrees() {
    return degrees;
  }

  public String getGender() {
    return gender;
  }

  public List<String> getSections() {
    return sections;
  }

  public double getPayscale() {
    return payscale;
  }

  public double getBonusAmount() {
    return bonusAmount;
  }

  public double getSalary() {
    return salary;
  }

  // Setters
  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setDegrees(List<String> degrees) {
    this.degrees = degrees;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setSections(List<String> sections) {
    this.sections = sections;
  }

  public void setPayscale(double payscale) {
    this.payscale = payscale;
  }

  public void setBonusAmount(double bonusAmount) {
    this.bonusAmount = bonusAmount;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  // Override toString method for pretty print
  @Override
  public String toString() {
    return "Teacher{" +
        "teacherId='" + teacherId + '\'' +
        ", name='" + name + '\'' +
        ", bloodGroup='" + bloodGroup + '\'' +
        ", dateOfBirth=" + dateOfBirth +
        ", mobileNumber='" + mobileNumber + '\'' +
        ", email='" + email + '\'' +
        ", degrees=" + degrees +
        ", gender='" + gender + '\'' +
        ", sections=" + sections +
        ", payscale=" + payscale +
        ", bonusAmount=" + bonusAmount +
        ", salary=" + salary +
        '}';
  }
}
