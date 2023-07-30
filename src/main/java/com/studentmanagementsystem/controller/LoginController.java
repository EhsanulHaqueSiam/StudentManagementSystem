// package main.java.com.studentmanagementsystem.controller;

// import main.java.com.studentmanagementsystem.model.Student;
// import main.java.com.studentmanagementsystem.model.Faculty;
// import main.java.com.studentmanagementsystem.model.Admin;
// import main.java.com.studentmanagementsystem.util.DatabaseHelper;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

// public class LoginController {
//   private DatabaseHelper dbHelper;

//   public LoginController() {
//     dbHelper = DatabaseHelper.getInstance();
//   }

//   public Student validateStudentLogin(String email, String password) {
//     Student student = null;

//     String query = "SELECT * FROM students WHERE email = ? AND password = ?";
//     try (Connection conn = dbHelper.getConnection();
//         PreparedStatement stmt = conn.prepareStatement(query)) {

//       stmt.setString(1, email);
//       stmt.setString(2, password);
//       ResultSet rs = stmt.executeQuery();

//       if (rs.next()) {
//         student = new Student(rs.getInt("studentId"), rs.getString("name"), rs.getString("bloodGroup"),
//             rs.getString("dateOfBirth"), rs.getString("mobileNumber"), rs.getString("email"), rs.getString("program"),
//             rs.getString("gender"), rs.getString("semester"));
//       }
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//     return student;
//   }

//   public Faculty validateTeacherLogin(String email, String password) {
//     Faculty teacher = null;

//     String query = "SELECT * FROM teachers WHERE email = ? AND password = ?";
//     try (Connection conn = dbHelper.getConnection();
//         PreparedStatement stmt = conn.prepareStatement(query)) {

//       stmt.setString(1, email);
//       stmt.setString(2, password);
//       ResultSet rs = stmt.executeQuery();

//       if (rs.next()) {
//         teacher = new Faculty(/* fill in necessary parameters from the ResultSet*/);
//       }
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//     return teacher;
//   }

//   public Admin validateAdminLogin(String email, String password) {
//     Admin admin = null;

//     String query = "SELECT * FROM admins WHERE email = ? AND password = ?";
//     try (Connection conn = dbHelper.getConnection();
//         PreparedStatement stmt = conn.prepareStatement(query)) {

//       stmt.setString(1, email);
//       stmt.setString(2, password);
//       ResultSet rs = stmt.executeQuery();

//       if (rs.next()) {
//         admin = new Admin(/* fill in necessary parameters from the ResultSet*/);
//       }
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//     return admin;
//   }
// }
