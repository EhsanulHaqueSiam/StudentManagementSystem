// package main.java.com.studentmanagementsystem.controller;

// import main.java.com.studentmanagementsystem.model.Admin;
// import main.java.com.studentmanagementsystem.model.Faculty;
// import main.java.com.studentmanagementsystem.model.Student;
// import main.java.com.studentmanagementsystem.model.Course;
// import main.java.com.studentmanagementsystem.util.DatabaseHelper;

// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;

// public class AdminController {
//   private DatabaseHelper dbHelper;

//   public AdminController() {
//     dbHelper = new DatabaseHelper();
//   }

//   public Admin getAdminByEmail(String email) {
//     Admin admin = null;
//     try {
//       ResultSet resultSet = dbHelper.executeQuery("SELECT * FROM Admins WHERE Email = '" + email + "';");
//       if (resultSet.next()) {
//         admin = new Admin(resultSet.getString("AdminID"), resultSet.getString("Name"), resultSet.getString("BloodGroup"),
//             resultSet.getDate("DateOfBirth"), resultSet.getString("MobileNumber"), resultSet.getString("Email"),
//             resultSet.getString("Password"), resultSet.getString("Gender"));
//       }
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//     return admin;
//   }

//   public List<Faculty> getAllTeachers() {
//     List<Faculty> teachers = new ArrayList<>();
//     try {
//       ResultSet resultSet = dbHelper.executeQuery("SELECT * FROM Teachers;");
//       while (resultSet.next()) {
//         Faculty teacher = new Faculty(resultSet.getString("TeacherID"), resultSet.getString("Name"), resultSet.getString("BloodGroup"),
//             resultSet.getDate("DateOfBirth"), resultSet.getString("MobileNumber"), resultSet.getString("Email"),
//             resultSet.getString("Degrees"), resultSet.getString("Gender"), resultSet.getString("Sections"),
//             resultSet.getDouble("Payscale"), resultSet.getDouble("BonusAmount"), resultSet.getDouble("Salary"));
//         teachers.add(teacher);
//       }
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//     return teachers;
//   }

//   public List<Student> getAllStudents() {
//     List<Student> students = new ArrayList<>();
//     try {
//       ResultSet resultSet = dbHelper.executeQuery("SELECT * FROM Students;");
//       while (resultSet.next()) {
//         Student student = new Student(resultSet.getString("StudentID"), resultSet.getString("Name"), resultSet.getString("BloodGroup"),
//             resultSet.getDate("DateOfBirth"), resultSet.getString("MobileNumber"), resultSet.getString("Email"),
//             resultSet.getString("Program"), resultSet.getString("Gender"), resultSet.getString("Semester"));
//         students.add(student);
//       }
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//     return students;
//   }

//   public List<Course> getAllCourses() {
//     List<Course> courses = new ArrayList<>();
//     try {
//       ResultSet resultSet = dbHelper.executeQuery("SELECT * FROM Courses;");
//       while (resultSet.next()) {
//         Course course = new Course(resultSet.getString("CourseCode"), resultSet.getString("CourseTitle"),
//             resultSet.getString("CourseDescription"), resultSet.getInt("CourseCredit"),
//             resultSet.getString("CourseInstructor"));
//         courses.add(course);
//       }
//     } catch (SQLException e) {
//       e.printStackTrace();
//     }
//     return courses;
//   }

//   public void addTeacher(Faculty teacher) {
//     String query = String.format("INSERT INTO Teachers VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%f', '%f', '%f');",
//         teacher.getTeacherId(), teacher.getName(), teacher.getBloodGroup(), teacher.getDateOfBirth(),
//         teacher.getMobileNumber(), teacher.getEmail(), teacher.getDegrees(), teacher.getGender(),
//         teacher.getSections(), teacher.getPayscale(), teacher.getBonusAmount(), teacher.getSalary());
//     dbHelper.executeUpdate(query);
//   }

//   public void addStudent(Student student) {
//     String query = String.format("INSERT INTO Students VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
//         student.getStudentId(), student.getName(), student.getBloodGroup(), student.getDateOfBirth(),
//         student.getMobileNumber(), student.getEmail(), student.getProgram(), student.getGender(),
//         student.getSemester());
//     dbHelper.executeUpdate(query);
//   }

//   public void addCourse(Course course) {
//     String query = String.format("INSERT INTO Courses VALUES('%s', '%s', '%s', '%d', '%s');",
//         course.getCourseCode(), course.getCourseTitle(), course.getCourseDescription(),
//         course.getCourseCredit(), course.getCourseInstructor());
//     dbHelper.executeUpdate(query);
//   }

//   public void deleteTeacher(String teacherId) {
//     String query = "DELETE FROM Teachers WHERE TeacherID = '" + teacherId + "';";
//     dbHelper.executeUpdate(query);
//   }

//   public void deleteStudent(String studentId) {
//     String query = "DELETE FROM Students WHERE StudentID = '" + studentId + "';";
//     dbHelper.executeUpdate(query);
//   }

//   public void deleteCourse(String courseCode) {
//     String query = "DELETE FROM Courses WHERE CourseCode = '" + courseCode + "';";
//     dbHelper.executeUpdate(query);
//   }
// }
