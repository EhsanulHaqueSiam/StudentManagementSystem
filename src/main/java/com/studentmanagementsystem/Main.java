package main.java.com.studentmanagementsystem;

import java.sql.Connection;

//import main.java.com.studentmanagementsystem.controller.LoginController;
import java.sql.SQLException;
import main.java.com.studentmanagementsystem.controller.StudentController;
import main.java.com.studentmanagementsystem.util.DatabaseManager;

public class Main {

  public static void main(String[] args) throws SQLException {

    Connection dbHelper = DatabaseManager.getInstance().getConnection();
    StudentController controller = new StudentController();
    controller.run();
    // dbHelper.initialize();

    // Create a new login controller, which will in turn create the login view
    // LoginController loginController = new LoginController(dbHelper);
    // loginController.showLoginView();

    // From here, the controller will handle interaction with the user
  }
}
