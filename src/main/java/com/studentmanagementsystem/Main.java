package com.sm;

import com.sm.controller.LoginController;
import com.sm.util.DatabaseHelper;

public class Main {

    public static void main(String[] args) {
        
        DatabaseHelper dbHelper = new DatabaseHelper();
        dbHelper.initialize();

        // Create a new login controller, which will in turn create the login view
        LoginController loginController = new LoginController(dbHelper);
        loginController.showLoginView();

        // From here, the controller will handle interaction with the user
    }
}
