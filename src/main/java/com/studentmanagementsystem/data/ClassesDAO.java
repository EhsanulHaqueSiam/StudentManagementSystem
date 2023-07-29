package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Classes;

import java.util.List;

public interface ClassesDAO {
  void addClass(Classes classes);
  void updateClass(Classes classes);
  void deleteClass(String className);
  Classes getClassByName(String className);
  List<Classes> getAllClasses();
}
