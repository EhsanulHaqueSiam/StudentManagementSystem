package com.sm.view;

import com.sm.controller.LoginController;
import com.sm.model.Admin;
import com.sm.model.Student;
import com.sm.model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    private LoginController loginController;

    private JFrame frame;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton studentLoginButton;
    private JButton teacherLoginButton;
    private JButton adminLoginButton;

    public LoginPage(LoginController loginController) {
        this.loginController = loginController;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        // Create fields
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        studentLoginButton = new JButton("Student Login");
        teacherLoginButton = new JButton("Teacher Login");
        adminLoginButton = new JButton("Admin Login");

        // Add components to frame
        frame.add(new JLabel("Email:"));
        frame.add(emailField);
        frame.add(new JLabel("Password:"));
        frame.add(passwordField);
        frame.add(studentLoginButton);
        frame.add(teacherLoginButton);
        frame.add(adminLoginButton);

        // Add action listeners
        studentLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = loginController.validateStudentLogin(emailField.getText(), new String(passwordField.getPassword()));
                if (student != null) {
                    new StudentDashboard(student);
                    frame.dispose(); // Close the login window
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid email or password");
                }
            }
        });

        teacherLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teacher teacher = loginController.validateTeacherLogin(emailField.getText(), new String(passwordField.getPassword()));
                if (teacher != null) {
                    new TeacherDashboard(teacher);
                    frame.dispose(); // Close the login window
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid email or password");
                }
            }
        });

        adminLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin admin = loginController.validateAdminLogin(emailField.getText(), new String(passwordField.getPassword()));
                if (admin != null) {
                    new AdminDashboard(admin);
                    frame.dispose(); // Close the login window
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid email or password");
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
