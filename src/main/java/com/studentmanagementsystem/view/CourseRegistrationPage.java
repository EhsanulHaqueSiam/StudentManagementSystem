package main.java.com.studentmanagementsystem.view;

import main.java.com.studentmanagementsystem.controller.CourseController;
import main.java.com.studentmanagementsystem.model.Course;
import main.java.com.studentmanagementsystem.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CourseRegistrationPage {
  private JFrame frame;
  private JComboBox<Course> courseComboBox;
  private JButton registerButton;

  private CourseController courseController;
  private Student student;

  public CourseRegistrationPage(CourseController courseController, Student student) {
    this.courseController = courseController;
    this.student = student;
    createAndShowGUI();
  }

  private void createAndShowGUI() {
    frame = new JFrame("Course Registration");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    List<Course> courses = courseController.getAllCourses();
    courseComboBox = new JComboBox<>(courses.toArray(new Course[0]));
    registerButton = new JButton("Register");

    frame.add(new JLabel("Select Course:"));
    frame.add(courseComboBox);
    frame.add(registerButton);

    registerButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Course selectedCourse = (Course) courseComboBox.getSelectedItem();
        boolean registered = courseController.registerStudentForCourse(student, selectedCourse);

        if (registered) {
          JOptionPane.showMessageDialog(frame, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(frame, "Registration failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    frame.pack();
    frame.setVisible(true);
  }
}
