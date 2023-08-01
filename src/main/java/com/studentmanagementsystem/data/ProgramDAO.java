package main.java.com.studentmanagementsystem.data;

import main.java.com.studentmanagementsystem.model.Program;

import java.util.List;

public interface ProgramDAO {

  void addProgram(Program program);

  void updateProgram(Program program);

  void deleteProgram(int programId);

  Program getProgramById(int programId);

  List<Program> getAllPrograms();

}