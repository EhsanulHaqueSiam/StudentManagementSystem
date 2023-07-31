package main.java.com.studentmanagementsystem.data.query;

public class StudentQueryConstants {

    public static final String INSERT_STUDENT = "INSERT INTO student(S_ID, S_name ,S_mail ,S_contact,EnrollYear) VALUES (?, ?, ?, ?, ?)";

    public static final String UPDATE_STUDENT = "UPDATE student SET S_name  = ?, S_mail= ?, S_contact=?, EnrollYear=? WHERE S_ID  = ?";

    public static final String DELETE_STUDENT = "DELETE FROM student WHERE S_ID  = ?";

    public static final String GET_STUDENT_BY_ID = "SELECT * FROM student WHERE S_ID  = ?";

    public static final String GET_ALL_STUDENTS = "SELECT * FROM student";
}
