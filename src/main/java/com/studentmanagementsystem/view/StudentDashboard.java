package main.java.com.studentmanagementsystem.view;

import main.java.com.studentmanagementsystem.controller.LoginController;
import main.java.com.studentmanagementsystem.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDashboard {
  private Student student;
  private LoginController loginController;

  private JFrame frame;
  private JLabel studentIdLabel;
  private JLabel nameLabel;
  private JButton logoutButton;

  public StudentDashboard(Student student, LoginController loginController) {
    this.student = student;
    this.loginController = loginController;
    createAndShowGUI();
  }

  private void createAndShowGUI() {
    frame = new JFrame("Student Dashboard");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(3, 2));

    // Create components
    studentIdLabel = new JLabel("Student ID: " + student.getStudentId());
    nameLabel = new JLabel("Name: " + student.getName());
    logoutButton = new JButton("Log out");

    // Add components to frame
    frame.add(studentIdLabel);
    frame.add(nameLabel);
    frame.add(logoutButton);

    // Add action listeners
    logoutButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new LoginPage(loginController); // Show the login window
        frame.dispose(); // Close the student dashboard window
      }
    });

    frame.pack();
    frame.setVisible(true);
  }
}
