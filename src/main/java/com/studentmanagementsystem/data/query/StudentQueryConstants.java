package main.java.com.studentmanagementsystem.data.query;

public class StudentQueryConstants {
  public static final String CREATE_TABLE =
      "CREATE TABLE IF NOT EXISTS students (" +
          "id INT AUTO_INCREMENT PRIMARY KEY," +
          "name VARCHAR(100) NOT NULL," +
          "age INT NOT NULL" +
          ")";

  public static final String INSERT_STUDENT =
      "INSERT INTO students (name, age) VALUES (?, ?)";

  public static final String UPDATE_STUDENT =
      "UPDATE students SET name = ?, age = ? WHERE id = ?";

  public static final String DELETE_STUDENT =
      "DELETE FROM students WHERE id = ?";

  public static final String GET_STUDENT_BY_ID =
      "SELECT * FROM students WHERE id = ?";

  public static final String GET_ALL_STUDENTS =
      "SELECT * FROM students";
}
