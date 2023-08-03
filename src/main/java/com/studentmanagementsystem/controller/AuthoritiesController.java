package main.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.data.AuthoritiesDAO;
import main.java.com.studentmanagementsystem.data.AuthoritiesDAOImpl;
import main.java.com.studentmanagementsystem.model.Authorities;
import main.java.com.studentmanagementsystem.view.AuthoritiesView;

/**
 * The AuthoritiesController class handles user interactions and business logic
 * related to
 * managing authorities in the Student Management System.
 */
public class AuthoritiesController {
  private final AuthoritiesDAO authoritiesDAO;
  private final AuthoritiesView authoritiesView;

  /**
   * Initializes the AuthoritiesController with the required DAO and View
   * instances.
   */
  public AuthoritiesController() {
    this.authoritiesDAO = new AuthoritiesDAOImpl();
    this.authoritiesView = new AuthoritiesView();
  }

  /**
   * Starts the main loop of the authorities management system, displaying the
   * menu and
   * handling user input.
   */
  public void run() {
    boolean running = true;
    while (running) {
      authoritiesView.showMenu();
      int choice = authoritiesView.getInputInt("Enter your choice: ");

      switch (choice) {
        case 1:
          addAuthority();
          break;
        case 2:
          updateAuthority();
          break;
        case 3:
          deleteAuthority();
          break;
        case 4:
          getAuthorityByName();
          break;
        case 0:
          running = false;
          break;
        default:
          authoritiesView.showMessage("Invalid choice. Please try again.");
          break;
      }
    }
  }

  /**
   * Adds a new authority to the system based on user input.
   */
  private void addAuthority() {
    Authorities authority = authoritiesView.getInputAuthority();
    authoritiesDAO.addAuthority(authority);
    authoritiesView.showMessage("Authority added successfully!");
  }

  /**
   * Updates an existing authority's information based on user input.
   */
  private void updateAuthority() {
    String authorityMail = authoritiesView.getInputString("Enter the email of the authority to update: ");
    Authorities authority = authoritiesDAO.getAuthorityByName(authorityMail);

    if (authority != null) {
      Authorities updatedAuthority = authoritiesView.getInputAuthority();
      authoritiesDAO.updateAuthority(updatedAuthority);
      authoritiesView.showMessage("Authority updated successfully!");
    } else {
      authoritiesView.showMessage("Authority with email \"" + authorityMail + "\" not found.");
    }
  }

  /**
   * Deletes an existing authority from the system based on user input.
   */
  private void deleteAuthority() {
    String authorityMail = authoritiesView.getInputString("Enter the email of the authority to delete: ");
    authoritiesDAO.deleteAuthority(authorityMail);
    authoritiesView.showMessage("Authority deleted successfully!");
  }

  /**
   * Retrieves and displays details of an authority based on user input.
   */
  private void getAuthorityByName() {
    String authorityMail = authoritiesView.getInputString("Enter the email of the authority to retrieve: ");
    Authorities authority = authoritiesDAO.getAuthorityByName(authorityMail);

    if (authority != null) {
      authoritiesView.showAuthorityDetails(authority);
    } else {
      authoritiesView.showMessage("Authority with email \"" + authorityMail + "\" not found.");
    }
  }

}
