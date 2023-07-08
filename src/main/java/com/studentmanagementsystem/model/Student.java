package com.sm.model;

import java.time.LocalDate;

public class Student {
    private String studentId;
    private String name;
    private String bloodGroup;
    private LocalDate dob; // using java.time.LocalDate to represent date
    private String mobileNumber;
    private String email;
    private String program; // BSc, MSc, etc.
    private String gender; // could use an Enum here as well
    private String semester; // Fall 2022-2023, etc.

    // Constructor
    public Student(String studentId, String name, String bloodGroup, LocalDate dob, String mobileNumber, String email, String program, String gender, String semester) {
        this.studentId = studentId;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.program = program;
        this.gender = gender;
        this.semester = semester;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getProgram() {
        return program;
    }

    public String getGender() {
        return gender;
    }

    public String getSemester() {
        return semester;
    }

    // Setters
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    // Override toString method for pretty print
    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", dob=" + dob +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", program='" + program + '\'' +
                ", gender='" + gender + '\'' +
                ", semester='" + semester + '\'' +
                '}';
    }
}
// CREATE TABLE Students (
//     studentId VARCHAR(255),
//     name VARCHAR(255),
//     bloodGroup VARCHAR(3),
//     dob DATE,
//     mobileNumber VARCHAR(15),
//     email VARCHAR(255),
//     program VARCHAR(255),
//     gender CHAR(1),
//     semester VARCHAR(255)
// );
