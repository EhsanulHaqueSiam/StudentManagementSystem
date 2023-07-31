package main.java.com.studentmanagementsystem;

import java.sql.SQLException;
import main.java.com.studentmanagementsystem.controller.StudentController;
import main.java.com.studentmanagementsystem.util.DatabaseManager;

public class Main {

  public static void main(String[] args) throws SQLException {

    StudentController controller = new StudentController();

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      DatabaseManager.getInstance().close();
    }));

    controller.run();

  }
}
