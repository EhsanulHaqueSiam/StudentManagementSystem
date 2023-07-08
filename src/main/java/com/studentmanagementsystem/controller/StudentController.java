package com.sm.controller;

import com.sm.model.Student;
import com.sm.util.DatabaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private DatabaseHelper dbHelper;

    public StudentController() {
        dbHelper = DatabaseHelper.getInstance();
    }

    public Student getStudent(int studentId) {
        Student student = null;

        String query = "SELECT * FROM students WHERE studentId = ?";
        try (Connection conn = dbHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                student = new Student(rs.getInt("studentId"), rs.getString("name"), rs.getString("bloodGroup"), 
                rs.getString("dateOfBirth"), rs.getString("mobileNumber"), rs.getString("email"), rs.getString("program"), 
                rs.getString("gender"), rs.getString("semester"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void addStudent(Student student) {
        String query = "INSERT INTO students (name, bloodGroup, dateOfBirth, mobileNumber, email, program, gender, semester) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getBloodGroup());
            stmt.setString(3, student.getDateOfBirth());
            stmt.setString(4, student.getMobileNumber());
            stmt.setString(5, student.getEmail());
            stmt.setString(6, student.getProgram());
            stmt.setString(7, student.getGender());
            stmt.setString(8, student.getSemester());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        String query = "UPDATE students SET name = ?, bloodGroup = ?, dateOfBirth = ?, mobileNumber = ?, " +
                "email = ?, program = ?, gender = ?, semester = ? WHERE studentId = ?";

        try (Connection conn = dbHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getBloodGroup());
            stmt.setString(3, student.getDateOfBirth());
            stmt.setString(4, student.getMobileNumber());
            stmt.setString(5, student.getEmail());
            stmt.setString(6, student.getProgram());
            stmt.setString(7, student.getGender());
            stmt.setString(8, student.getSemester());
            stmt.setInt(9, student.getStudentId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
