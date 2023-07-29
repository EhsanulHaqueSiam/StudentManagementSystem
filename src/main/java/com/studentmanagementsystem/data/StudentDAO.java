package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Student;
import java.util.List;

public interface StudentDAO {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
    Student getStudentById(int id);
    List<Student> getAllStudents();
}
