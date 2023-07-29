package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Faculty;

import java.util.List;

public interface FacultyDAO {
  void addFaculty(Faculty faculty);

  void updateFaculty(Faculty faculty);

  void deleteFaculty(String facultyId);

  Faculty getFacultyById(String facultyId);

  List<Faculty> getAllFaculties();
}
