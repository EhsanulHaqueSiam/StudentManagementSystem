package com.sm.view;

import com.sm.controller.CourseController;
import com.sm.model.Course;
import com.sm.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.event.ActionEvent;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CourseRegistrationPageTest {
    private CourseController mockCourseController;
    private Student mockStudent;
    private CourseRegistrationPage courseRegistrationPage;

    @BeforeEach
    public void setUp() {
        // Create mock objects
        mockCourseController = Mockito.mock(CourseController.class);
        mockStudent = Mockito.mock(Student.class);

        // Create a real CourseRegistrationPage with the mock objects
        courseRegistrationPage = new CourseRegistrationPage(mockCourseController, mockStudent);
    }

    @Test
    public void testActionPerformed() {
        // Create some mock courses and set up the controller to return them
        Course mockCourse1 = Mockito.mock(Course.class);
        Course mockCourse2 = Mockito.mock(Course.class);
        when(mockCourseController.getAllCourses()).thenReturn(Arrays.asList(mockCourse1, mockCourse2));

        // Call the method under test
        courseRegistrationPage.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        // Verify that the controller's registerStudentForCourse method was called with the correct arguments
        verify(mockCourseController).registerStudentForCourse(eq(mockStudent), eq(mockCourse1));
    }
}
