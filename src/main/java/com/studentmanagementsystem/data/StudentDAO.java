package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Student;
import java.util.List;

/**
 * The StudentDAO interface defines methods for performing CRUD (Create, Read, Update, Delete)
 * operations related to Student entities in the database.
 */
public interface StudentDAO {

    /**
     * Adds a new student to the database.
     *
     * @param student The student object to be added.
     */
    void addStudent(Student student);

    /**
     * Updates an existing student's information in the database.
     *
     * @param student The updated student object.
     */
    void updateStudent(Student student);

    /**
     * Deletes a student from the database based on the provided student ID.
     *
     * @param id The ID of the student to be deleted.
     */
    void deleteStudent(int id);

    /**
     * Retrieves a student from the database based on the provided student ID.
     *
     * @param id The ID of the student to retrieve.
     * @return The retrieved student object, or null if not found.
     */
    Student getStudentById(int id);

    /**
     * Retrieves a list of all students stored in the database.
     *
     * @return A list of student objects.
     */
    List<Student> getAllStudents();
}
