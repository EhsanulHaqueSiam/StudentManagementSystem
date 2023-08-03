package main.java.com.studentmanagementsystem.data.query;

/**
 * The `StudentQueryConstants` class provides SQL query constants for student-related operations.
 * These constants represent SQL statements for inserting, updating, deleting, and retrieving student records.
 */
public class StudentQueryConstants {

    /**
     * SQL query to insert a new student record into the 'student' table.
     * Parameters: S_ID, S_name, S_mail, S_contact, EnrollYear
     */
    public static final String INSERT_STUDENT = "INSERT INTO student(S_ID, S_name, S_mail, S_contact, EnrollYear) VALUES (?, ?, ?, ?, ?)";

    /**
     * SQL query to update an existing student record in the 'student' table.
     * Parameters: S_name, S_mail, S_contact, EnrollYear, S_ID
     */
    public static final String UPDATE_STUDENT = "UPDATE student SET S_name = ?, S_mail = ?, S_contact = ?, EnrollYear = ? WHERE S_ID = ?";

    /**
     * SQL query to delete a student record from the 'student' table by student ID.
     * Parameters: S_ID
     */
    public static final String DELETE_STUDENT = "DELETE FROM student WHERE S_ID = ?";

    /**
     * SQL query to retrieve specific student information from the 'student' table by student ID.
     * Parameters: S_ID
     */
    public static final String GET_STUDENT_BY_ID = "SELECT * FROM student WHERE S_ID = ?";

    /**
     * SQL query to retrieve all student records from the 'student' table.
     */
    public static final String GET_ALL_STUDENTS = "SELECT * FROM student";
}
