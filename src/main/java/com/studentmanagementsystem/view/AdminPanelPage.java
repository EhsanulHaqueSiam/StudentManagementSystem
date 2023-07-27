package main.java.com.studentmanagementsystem.view;

import main.java.com.studentmanagementsystem.controller.AdminController;
import main.java.com.studentmanagementsystem.model.Faculty;
import main.java.com.studentmanagementsystem.model.Student;
import main.java.com.studentmanagementsystem.model.Course;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminPanelPage {
  private JFrame frame;
  private JTextArea textArea;
  private JButton viewTeachersButton, viewStudentsButton, viewCoursesButton;
  private JButton addTeacherButton, addStudentButton, addCourseButton;
  private JButton removeTeacherButton, removeStudentButton, removeCourseButton;

  private AdminController adminController;

  public AdminPanelPage(AdminController adminController) {
    this.adminController = adminController;
    createAndShowGUI();
  }

  private void createAndShowGUI() {
    frame = new JFrame("Admin Panel");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    textArea = new JTextArea(20, 50);
    viewTeachersButton = new JButton("View All Teachers");
    viewStudentsButton = new JButton("View All Students");
    viewCoursesButton = new JButton("View All Courses");
    addTeacherButton = new JButton("Add Teacher");
    addStudentButton = new JButton("Add Student");
    addCourseButton = new JButton("Add Course");
    removeTeacherButton = new JButton("Remove Teacher");
    removeStudentButton = new JButton("Remove Student");
    removeCourseButton = new JButton("Remove Course");

    frame.add(textArea);
    frame.add(viewTeachersButton);
    frame.add(viewStudentsButton);
    frame.add(viewCoursesButton);
    frame.add(addTeacherButton);
    frame.add(addStudentButton);
    frame.add(addCourseButton);
    frame.add(removeTeacherButton);
    frame.add(removeStudentButton);
    frame.add(removeCourseButton);

    viewTeachersButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        List<Faculty> teachers = adminController.getAllTeachers();
        textArea.setText(teachers.toString());
      }
    });

    viewStudentsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        List<Student> students = adminController.getAllStudents();
        textArea.setText(students.toString());
      }
    });

    viewCoursesButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        List<Course> courses = adminController.getAllCourses();
        textArea.setText(courses.toString());
      }
    });

    // add action listeners for add and remove buttons
    // you need to add input dialogs and modify the corresponding functions in AdminController

    frame.pack();
    frame.setVisible(true);
  }
}
