package main.java.com.studentmanagementsystem.view;

import main.java.com.studentmanagementsystem.model.Authorities;

import java.util.Scanner;

public class AuthoritiesView {
  private final Scanner scanner;

  public AuthoritiesView() {
    scanner = new Scanner(System.in);
  }

  public void showMenu() {
    System.out.println("==== Authorities Management System ====");
    System.out.println("1. Add Authority");
    System.out.println("2. Update Authority");
    System.out.println("3. Delete Authority");
    System.out.println("4. Get Authority by Name");
    System.out.println("0. Exit");
  }

  public int getInputInt(String prompt) {
    System.out.print(prompt);
    return scanner.nextInt();
  }

  public String getInputString(String prompt) {
    System.out.print(prompt);
    return scanner.next();
  }

  public Authorities getInputAuthority() {
    System.out.println("Enter Authority Details:");
    scanner.nextLine(); // Consume the newline character left by previous nextInt()
    System.out.print("Authority Mail: ");
    String authorityMail = scanner.nextLine();
    System.out.print("Authority Name: ");
    String authorityName = scanner.nextLine();
    System.out.print("Authority Role: ");
    String authorityRole = scanner.nextLine();
    System.out.print("Authority Contact: ");
    String authorityContact = scanner.nextLine();

    return new Authorities(authorityName, authorityRole, authorityMail, authorityContact);
  }

  public void showMessage(String message) {
    System.out.println(message);
  }

  public void showAuthorityDetails(Authorities authority) {
    System.out.println("Authority Details:");
    System.out.println("Mail: " + authority.getAuthorityMail());
    System.out.println("Name: " + authority.getAuthorityName());
    System.out.println("Role: " + authority.getAuthorityRole());
    System.out.println("Contact: " + authority.getAuthorityContact());
  }
}
