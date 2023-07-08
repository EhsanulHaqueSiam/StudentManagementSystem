package com.sm.smTest;

import com.sm.controller.AdminController;
import com.sm.model.Admin;
import com.sm.model.Teacher;
import com.sm.model.Student;
import com.sm.model.Course;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdminControllerTest {
    private AdminController adminController;

    @Before
    public void setUp() {
        adminController = new AdminController();
    }

    @Test
    public void testGetAdminByEmail() {
        Admin admin = adminController.getAdminByEmail("admin@sm.com");
        Assert.assertNotNull(admin);
        Assert.assertEquals("admin@sm.com", admin.getEmail());
    }

    @Test
    public void testGetAllTeachers() {
        Assert.assertFalse(adminController.getAllTeachers().isEmpty());
    }

    @Test
    public void testGetAllStudents() {
        Assert.assertFalse(adminController.getAllStudents().isEmpty());
    }

    @Test
    public void testGetAllCourses() {
        Assert.assertFalse(adminController.getAllCourses().isEmpty());
    }

    // Note: for the tests below, make sure that the add and delete operations do not disrupt your actual database.
    // You might want to create a separate testing database, or use mocking techniques to simulate the database.
    @Test
    public void testAddAndDeleteTeacher() {
        Teacher teacher = new Teacher("T123", "John Doe", "A+", "1970-01-01", "1234567890", "jdoe@sm.com", 
                                      "BSc, MSc", "Male", "CSE101, CSE102", 50000.0, 5000.0, 60000.0);
        adminController.addTeacher(teacher);
        Assert.assertNotNull(adminController.getAllTeachers().stream().filter(t -> t.getTeacherId().equals("T123")).findFirst().orElse(null));
        
        adminController.deleteTeacher("T123");
        Assert.assertNull(adminController.getAllTeachers().stream().filter(t -> t.getTeacherId().equals("T123")).findFirst().orElse(null));
    }

    @Test
    public void testAddAndDeleteStudent() {
        Student student = new Student("S123", "Jane Doe", "B+", "2000-01-01", "0987654321", "jane@sm.com", 
                                      "BSc", "Female", "Spring 2023");
        adminController.addStudent(student);
        Assert.assertNotNull(adminController.getAllStudents().stream().filter(s -> s.getStudentId().equals("S123")).findFirst().orElse(null));
        
        adminController.deleteStudent("S123");
        Assert.assertNull(adminController.getAllStudents().stream().filter(s -> s.getStudentId().equals("S123")).findFirst().orElse(null));
    }

    @Test
    public void testAddAndDeleteCourse() {
        Course course = new Course("CSE105", "Introduction to Programming", "Basic programming concepts", 
                                   3, "T101");
        adminController.addCourse(course);
        Assert.assertNotNull(adminController.getAllCourses().stream().filter(c -> c.getCourseCode().equals("CSE105")).findFirst().orElse(null));
        
        adminController.deleteCourse("CSE105");
        Assert.assertNull(adminController.getAllCourses().stream().filter(c -> c.getCourseCode().equals("CSE105")).findFirst().orElse(null));
    }
}
