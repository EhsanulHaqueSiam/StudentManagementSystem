package test.java.com.studentmanagementsystem;

import main.java.com.studentmanagementsystem.controller.LoginController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
  @Test
  public void testMain() {
    Main.main(new String[]{});
    LoginController loginController = Main.getLoginController();
    assertNotNull(loginController, "LoginController should be initialized");
  }
}
