package main.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.data.ClassesDAO;
import main.java.com.studentmanagementsystem.data.ClassesDAOImpl;
import main.java.com.studentmanagementsystem.model.Classes;
import main.java.com.studentmanagementsystem.view.ClassesView;

import java.util.List;

public class ClassesController {
  private final ClassesDAO classesDAO;
  private final ClassesView classesView;

  public ClassesController() {
    this.classesDAO = new ClassesDAOImpl();
    this.classesView = new ClassesView();
  }

  public void run() {
    boolean running = true;
    while (running) {
      classesView.showMenu();
      int choice = classesView.getInputInt("Enter your choice: ");

      switch (choice) {
        case 1:
          addClass();
          break;
        case 2:
          updateClass();
          break;
        case 3:
          deleteClass();
          break;
        case 4:
          getClassByName();
          break;
        case 5:
          getAllClasses();
          break;
        case 0:
          running = false;
          break;
        default:
          classesView.showMessage("Invalid choice. Please try again.");
          break;
      }
    }
  }

  private void addClass() {
    Classes classes = classesView.getInputClass();
    classesDAO.addClass(classes);
    classesView.showMessage("Class added successfully!");
  }

  private void updateClass() {
    String className = classesView.getInputString("Enter the name of the class to update: ");
    Classes classes = classesDAO.getClassByName(className);

    if (classes != null) {
      Classes updatedClass = classesView.getInputClass();
      classesDAO.updateClass(updatedClass);
      classesView.showMessage("Class updated successfully!");
    } else {
      classesView.showMessage("Class with name \"" + className + "\" not found.");
    }
  }

  private void deleteClass() {
    String className = classesView.getInputString("Enter the name of the class to delete: ");
    classesDAO.deleteClass(className);
    classesView.showMessage("Class deleted successfully!");
  }

  private void getClassByName() {
    String className = classesView.getInputString("Enter the name of the class to retrieve: ");
    Classes classes = classesDAO.getClassByName(className);

    if (classes != null) {
      classesView.showClassDetails(classes);
    } else {
      classesView.showMessage("Class with name \"" + className + "\" not found.");
    }
  }

  private void getAllClasses() {
    List<Classes> classesList = classesDAO.getAllClasses();
    classesView.showAllClasses(classesList);
  }

  public static void main(String[] args) {
    ClassesController controller = new ClassesController();
    controller.run();
  }
}
