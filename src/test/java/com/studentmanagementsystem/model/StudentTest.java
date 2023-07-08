package com.sm.smTest;

import com.sm.model.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
    private Student student;

    @Before
    public void setUp() {
        student = new Student("S001", "John Doe", "A+", "2000-01-01", "1234567890", 
                              "john@sm.com", "BSc", "Male", "Spring 2023");
    }

    @Test
    public void testGetFullName() {
        Assert.assertEquals("John Doe", student.getName());
    }
}
