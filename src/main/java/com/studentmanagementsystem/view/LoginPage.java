package main.java.com.studentmanagementsystem.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The LoginPage class represents a graphical user interface for a login page.
 * It provides fields and buttons to enter the user ID and password for authentication.
 */

public class LoginPage {


  private JFrame frame;
  private JTextField idField;
  private JTextField passwordField;
  private JPanel backgroundPanel;
  private JLabel background;
  private JLabel loginLbl;
  private JLabel idLbl;
  private JLabel passwordLbl;
  private JButton loginBtn;
  private JButton signInBtn;
  private JButton forgetPassBtn;

  /**
 * Create the application.
 */
  public LoginPage() {
    initialize();
  }

  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 758, 627);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    backgroundPanel = new JPanel();
    backgroundPanel.setBackground(new Color(241, 237, 255));
    backgroundPanel.setBounds(58, 76, 347, 426);
    frame.getContentPane().add(backgroundPanel);
    backgroundPanel.setLayout(null);
    
    background = new JLabel("");
    background.setBounds(173, 5, 0, 0);
    backgroundPanel.add(background);
    
    
    loginLbl = new JLabel("LOGIN");
    loginLbl.setForeground(new Color(100, 109, 189));
    loginLbl.setFont(new Font("Snap ITC", Font.PLAIN, 20));
    loginLbl.setBounds(117, 11, 85, 31);
    backgroundPanel.add(loginLbl);
    
    idLbl = new JLabel("ID");
    idLbl.setForeground(new Color(128, 0, 255));
    idLbl.setFont(new Font("QK Marisa", Font.BOLD, 15));
    idLbl.setBounds(38, 94, 68, 24);
    backgroundPanel.add(idLbl);
    
    passwordLbl = new JLabel("PASSWORD");
    passwordLbl.setForeground(new Color(128, 0, 255));
    passwordLbl.setFont(new Font("QK Marisa", Font.BOLD, 15));
    passwordLbl.setBounds(38, 198, 95, 24);
    backgroundPanel.add(passwordLbl);
    
    idField = new JTextField();
    idField.setBackground(new Color(100, 109, 189));
    idField.setForeground(Color.BLACK);
    idField.setBounds(38, 129, 274, 31);
    backgroundPanel.add(idField);
    idField.setColumns(10);
    
    passwordField = new JTextField();
    passwordField.setBackground(new Color(100, 109, 189));
    passwordField.setColumns(10);
    passwordField.setBounds(38, 233, 274, 31);
    backgroundPanel.add(passwordField);
    
    loginBtn = new JButton("LOGIN");
    loginBtn.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
    loginBtn.setForeground(new Color(100, 109, 189));
    loginBtn.setBackground(new Color(100, 109, 189));
    loginBtn.setBounds(51, 346, 95, 31);
    backgroundPanel.add(loginBtn);
    
    signInBtn = new JButton("SIGN IN");
    signInBtn.setForeground(new Color(100, 109, 189));
    signInBtn.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
    signInBtn.setBackground(new Color(100, 109, 189));
    signInBtn.setBounds(204, 346, 95, 31);
    backgroundPanel.add(signInBtn);
    
    forgetPassBtn = new JButton("Forget Password");
    forgetPassBtn.setForeground(new Color(100, 109, 189));
    forgetPassBtn.setFont(new Font("Rage Italic", Font.BOLD, 15));
    forgetPassBtn.setBackground(new Color(100, 109, 189));
    forgetPassBtn.setBounds(173, 265, 139, 23);
    backgroundPanel.add(forgetPassBtn);
  }
}
