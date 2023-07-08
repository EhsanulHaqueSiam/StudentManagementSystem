package com.sm.smTest;

import com.sm.controller.LoginController;
import com.sm.model.Student;
import com.sm.model.Teacher;
import com.sm.model.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest {
    private LoginController loginController;

    @BeforeEach
    public void setup() {
        loginController = new LoginController();
    }

    @Test
    public void testValidateStudentLogin() {
        String email = "test@test.com";
        String password = "password";
        Student student = loginController.validateStudentLogin(email, password);

        assertNotNull(student, "Expected a student object, but got null");
        assertEquals(email, student.getEmail(), "Expected email to match, but it did not");
    }
    
    @Test
    public void testValidateTeacherLogin() {
        String email = "test2@test.com";
        String password = "password";
        Teacher teacher = loginController.validateTeacherLogin(email, password);

        assertNotNull(teacher, "Expected a teacher object, but got null");
        assertEquals(email, teacher.getEmail(), "Expected email to match, but it did not");
    }
    
    @Test
    public void testValidateAdminLogin() {
        String email = "test3@test.com";
        String password = "password";
        Admin admin = loginController.validateAdminLogin(email, password);

        assertNotNull(admin, "Expected an admin object, but got null");
        assertEquals(email, admin.getEmail(), "Expected email to match, but it did not");
    }
}
