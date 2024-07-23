package classes;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;

public class Stafflogin implements ActionListener {

    private JFrame frame;
    private JLabel title, logo,banner, userName, userPass, confirmUserPass, su;
    private JButton loginButton, signUpButton1, exitButton, previous0, frgtpass;
    private JTextField tfUName;
    private JPasswordField pfUPass;
    private ImageIcon on, off;
    private JToggleButton toggleButton;
    private JPanel p1;



    public Stafflogin() {

        frame = new JFrame("CA Login");
        frame.setSize(820, 580);



        ImageIcon ban = new ImageIcon("Image/ban.png");
        ImageIcon icon = new ImageIcon("Image/logo1.png");
        ImageIcon framelogo = new ImageIcon("Image/logo1.png");

        title = new JLabel("CA Login");
        title.setForeground(Color.decode("#E4002B"));
        title.setFont(new Font("Forte", Font.PLAIN, 50));
        title.setBounds(290, 50, 250, 75);
        frame.add(title);
        title.setVisible(true);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Segoe UI", 1, 19));
        loginButton.setBounds(535, 320, 80, 30);
        loginButton.setBorder(new LineBorder(Color.decode("#000000"), 2));
        loginButton.setBackground(Color.decode("#E4002B"));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setForeground(Color.decode("#FFFFFF"));
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        frame.add(loginButton);

        signUpButton1 = new JButton("Sign Up");
        signUpButton1.setFont(new Font("Segoe UI", 1, 18));
        signUpButton1.setBounds(600, 380, 80, 30);
        signUpButton1.setBorder(new LineBorder(Color.decode("#000000"), 2));
        signUpButton1.setBackground(Color.decode("#E4002B"));
        signUpButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpButton1.addActionListener(this);
        signUpButton1.setFocusable(false);
        signUpButton1.setContentAreaFilled(false);
        signUpButton1.setBorderPainted(false);
        signUpButton1.setForeground(Color.decode("#E4002B"));
        frame.add(signUpButton1);

        su = new JLabel("Don't have an Account?");
        su.setFont(new Font("Segoe UI", 1, 17));
        su.setBounds(415, 380, 200, 30);
        frame.add(su);

        exitButton = new JButton("Go Back");
        exitButton.setFont(new Font("Segoe UI", 1, 18));
        exitButton.setBounds(700, 500, 80, 30);
        exitButton.setBackground(Color.decode("#37f9f8"));
        exitButton.setBorder(new LineBorder(Color.decode("#000000"), 2));
        exitButton.setBackground(Color.decode("#E4002B"));
        exitButton.setForeground(Color.decode("#FFFFFF"));
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        frame.add(exitButton);

        userName = new JLabel("Username: ");
        userName.setBounds(400, 140, 200, 30);
        userName.setFont(new Font("Segoe UI", 1, 22));
        userName.setVisible(true);
        frame.add(userName);

        userPass = new JLabel("Password: ");
        userPass.setBounds(400, 235, 200, 30);
        userPass.setFont(new Font("Segoe UI", 1, 22));
        userPass.setVisible(true);
        frame.add(userPass);

        confirmUserPass = new JLabel("Confirm Password: ");
        confirmUserPass.setBounds(180, 260, 180, 30);
        confirmUserPass.setFont(new Font("Calibri", Font.BOLD, 16));
        confirmUserPass.setForeground(Color.decode("#FFFF00"));
        confirmUserPass.setVisible(false);
        frame.add(confirmUserPass);

        tfUName = new JTextField();
        tfUName.setBounds(412, 190, 300, 27);
        tfUName.setBorder(BorderFactory.createLineBorder(Color.decode("#000000")));
        tfUName.setToolTipText("Enter your name here");
        tfUName.setVisible(true);
        frame.add(tfUName);

        pfUPass = new JPasswordField();
        pfUPass.setBounds(412, 280, 300, 27);
        pfUPass.setBorder(BorderFactory.createLineBorder(Color.decode("#000000")));
        pfUPass.setEchoChar('*');
        pfUPass.setToolTipText("Enter your password here");
        pfUPass.setVisible(true);
        frame.add(pfUPass);

        on = new ImageIcon("Image/tg1.png");
        off = new ImageIcon("Image/tg2.png");
        toggleButton = new JToggleButton(off);
        toggleButton.setBounds(715, 282, 30, 20);
        toggleButton.setBackground(Color.decode("#E4002B"));
        toggleButton.setForeground(new Color(173, 255, 47));
        toggleButton.setOpaque(true);
        toggleButton.setBorder(BorderFactory.createEmptyBorder());
        toggleButton.setFocusable(false);
        toggleButton.setToolTipText("Show Password");
        toggleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        toggleButton.setVisible(true);
        frame.add(toggleButton);
        toggleButton.addActionListener(this);

        banner= new JLabel(ban);
        banner.setBounds(390,130,360,240);
        frame.add(banner);

        logo = new JLabel(icon);
        logo.setBounds(-80, -20, 600, 600);
        frame.add(logo);


        frame.setIconImage(framelogo.getImage());
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == toggleButton) {
            if (toggleButton.isSelected()) {
                toggleButton.setIcon(on);
                pfUPass.setEchoChar((char) 0);
            } else {
                toggleButton.setIcon(off);
                pfUPass.setEchoChar('*');
            }
        }

        if (e.getSource() == signUpButton1) {

            new Staffsignup();
            frame.setVisible(false);

        }

        else if (e.getSource() == exitButton) {
            new HomePage();
            frame.setVisible(false);
        } else if (e.getSource() == previous0) {
            loginButton.setVisible(true);
            userName.setVisible(false);
            userPass.setVisible(false);
            tfUName.setVisible(false);
            pfUPass.setVisible(false);
            previous0.setVisible(false);
            signUpButton1.setVisible(true);
            toggleButton.setVisible(false);
        }

        else if (e.getSource() == loginButton) {
            String loginUser = tfUName.getText();
            String pass = pfUPass.getText();
            if (loginUser.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            }

            else {

                try {
                    String userNameS = "User Name : " + loginUser;
                    String passwordS = "Password : " + pass;
                    BufferedReader reader = new BufferedReader(new FileReader("data\\.staff_data.txt"));

                    int totalLines = 0;
                    while (reader.readLine() != null)
                        totalLines++;
                    reader.close();

                    for (int i = 0; i <= totalLines; i++) {
                        String line = Files.readAllLines(Paths.get("data\\.staff_data.txt")).get(i);
                        if (line.equals(userNameS)) {
                            String line2 = Files.readAllLines(Paths.get("data\\.staff_data.txt")).get((i + 1));
                            if (line2.equals(passwordS)) {
                                frame.setVisible(false);
                                new Accounts();
                                break;
                            }
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

        }

    }

}
