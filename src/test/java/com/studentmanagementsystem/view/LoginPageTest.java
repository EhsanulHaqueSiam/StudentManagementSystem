package com.sm.view;

import com.sm.controller.LoginController;
import com.sm.model.Admin;
import com.sm.model.Student;
import com.sm.model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class LoginPageTest {
    private LoginController mockLoginController;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        // Create a mock LoginController
        mockLoginController = Mockito.mock(LoginController.class);

        // Create a real LoginPage with the mock controller
        loginPage = new LoginPage(mockLoginController);
    }

    @Test
    public void testStudentLoginButtonAction() {
        // Simulate text entered into the email and password fields
        loginPage.emailField.setText("test@example.com");
        loginPage.passwordField.setText("password123");

        // Create a mock Student and set up the controller to return it
        Student mockStudent = Mockito.mock(Student.class);
        when(mockLoginController.validateStudentLogin("test@example.com", "password123")).thenReturn(mockStudent);

        // Simulate clicking the Student Login button
        loginPage.studentLoginButton.doClick();

        // Verify that the controller's validateStudentLogin method was called with the correct parameters
        verify(mockLoginController).validateStudentLogin("test@example.com", "password123");
    }

    // Repeat similar tests for teacherLoginButton and adminLoginButton
}
