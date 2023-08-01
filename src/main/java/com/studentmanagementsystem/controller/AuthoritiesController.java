package main.java.com.studentmanagementsystem.controller;

import main.java.com.studentmanagementsystem.data.AuthoritiesDAO;
import main.java.com.studentmanagementsystem.data.AuthoritiesDAOImpl;
import main.java.com.studentmanagementsystem.model.Authorities;
import main.java.com.studentmanagementsystem.view.AuthoritiesView;

public class AuthoritiesController {
  private final AuthoritiesDAO authoritiesDAO;
  private final AuthoritiesView authoritiesView;

  public AuthoritiesController() {
    this.authoritiesDAO = new AuthoritiesDAOImpl();
    this.authoritiesView = new AuthoritiesView();
  }

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

  private void addAuthority() {
    Authorities authority = authoritiesView.getInputAuthority();
    authoritiesDAO.addAuthority(authority);
    authoritiesView.showMessage("Authority added successfully!");
  }

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

  private void deleteAuthority() {
    String authorityMail = authoritiesView.getInputString("Enter the email of the authority to delete: ");
    authoritiesDAO.deleteAuthority(authorityMail);
    authoritiesView.showMessage("Authority deleted successfully!");
  }

  private void getAuthorityByName() {
    String authorityMail = authoritiesView.getInputString("Enter the email of the authority to retrieve: ");
    Authorities authority = authoritiesDAO.getAuthorityByName(authorityMail);

    if (authority != null) {
      authoritiesView.showAuthorityDetails(authority);
    } else {
      authoritiesView.showMessage("Authority with email \"" + authorityMail + "\" not found.");
    }
  }

  public static void main(String[] args) {
    AuthoritiesController controller = new AuthoritiesController();
    controller.run();
  }
}
