package com.sm.view;

import com.sm.controller.AdminController;
import com.sm.model.Teacher;
import com.sm.model.Student;
import com.sm.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class AdminPanelPageTest {
    private AdminController mockAdminController;
    private AdminPanelPage adminPanelPage;

    @BeforeEach
    public void setUp() {
        // Create a mock AdminController
        mockAdminController = Mockito.mock(AdminController.class);

        // Create a real AdminPanelPage with the mock controller
        adminPanelPage = new AdminPanelPage(mockAdminController);
    }

    @Test
    public void testViewTeachersButtonAction() {
        // Create mock Teacher list and set up the controller to return it
        List<Teacher> mockTeachers = Arrays.asList(Mockito.mock(Teacher.class), Mockito.mock(Teacher.class));
        when(mockAdminController.getAllTeachers()).thenReturn(mockTeachers);

        // Simulate clicking the View All Teachers button
        adminPanelPage.viewTeachersButton.doClick();

        // Verify that the controller's getAllTeachers method was called
        verify(mockAdminController).getAllTeachers();

        // Verify that the textArea's setText method was called with the correct parameters
        verify(adminPanelPage.textArea).setText(mockTeachers.toString());
    }

    // Repeat similar tests for viewStudentsButton and viewCoursesButton
}
