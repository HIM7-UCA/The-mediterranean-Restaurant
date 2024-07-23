package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.border.LineBorder;

public class HomePage extends JFrame implements ActionListener, MouseListener {


    private JFrame frame;
    private JTextField tfUName;
    private JToggleButton toggleButton;
    private JPasswordField pfUPass;
    private JPanel panel;
    private ImageIcon on, off;
    private JLabel logo,su,userName,userPass, confirmUserPass;
    private JButton aboutusbtn, staffbtn,adminbtn , loginButton,signUpButton1;

    Color btnColor = new Color(0xF9E8D8);

    public HomePage() {

        super("HomePage");
        setSize(820, 580);


        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 820, 580);
        add(panel);
	
        aboutusbtn = new JButton("About Us");
        aboutusbtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        aboutusbtn.setBounds(655, 485, 130, 38);
        aboutusbtn.setBackground(btnColor);
        aboutusbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        aboutusbtn.setForeground(Color.BLACK);
        aboutusbtn.addMouseListener(this);
        aboutusbtn.addActionListener(this);
        panel.add(aboutusbtn);

        staffbtn = new JButton("CA Login");
        staffbtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        staffbtn.setBounds(500, 485, 130, 38);
        staffbtn.setBackground(btnColor);
        staffbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        staffbtn.setForeground(Color.BLACK);
        staffbtn.addMouseListener(this);
        staffbtn.addActionListener(this);
        panel.add(staffbtn);
     // Inside your HomePage class
        JButton reviewsButton = new JButton("Reviews");
        reviewsButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        reviewsButton.setBounds(350, 485, 130, 38); // Adjust the position and size as needed
        reviewsButton.setBackground(btnColor);
        reviewsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reviewsButton.setForeground(Color.BLACK);
        reviewsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the ReviewPage frame
                ReviewPage reviewPage = new ReviewPage();
                reviewPage.setVisible(true);
            }
        });
        panel.add(reviewsButton);
        
        JButton checkReviewsButton = new JButton("Check Reviews");
        checkReviewsButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        checkReviewsButton.setBounds(200, 485, 150, 38);
        checkReviewsButton.setBackground(btnColor);
        checkReviewsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        checkReviewsButton.setForeground(Color.BLACK);
        checkReviewsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the CheckReviewsPage frame
                CheckReviewsPage checkReviewsPage = new CheckReviewsPage();
                checkReviewsPage.setVisible(true);
            }
        });
        panel.add(checkReviewsButton);



      
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Segoe UI", 1, 19));
        loginButton.setBounds(549, 400, 80, 30);
        loginButton.setBorder(new LineBorder(Color.decode("#000000"), 2));
        loginButton.setBackground(Color.decode("#E4002B"));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setForeground(Color.decode("#FFFFFF"));
        loginButton.addActionListener(this);
        panel.add(loginButton);

        signUpButton1 = new JButton("Sign Up");
        signUpButton1.setFont(new Font("Segoe UI", 3, 18));
        signUpButton1.setBounds(725, 147, 80, 30);
        signUpButton1.setBorder(new LineBorder(Color.white, 0));
        signUpButton1.setBackground(Color.white);
        signUpButton1.setForeground(Color.red);
        signUpButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpButton1.addActionListener(this);
        signUpButton1.setContentAreaFilled(false);
        signUpButton1.setBorderPainted(false);
        panel.add(signUpButton1);


        userName = new JLabel("Username: ");
        userName.setBounds(425, 215, 200, 30);
        userName.setFont(new Font("Segoe UI", 1, 20));
        userName.setVisible(true);
        panel.add(userName);

        tfUName = new JTextField();
        tfUName.setBounds(437, 260, 325, 25);
        tfUName.setBorder(BorderFactory.createLineBorder(Color.decode("#000000")));
        tfUName.setToolTipText("Enter your name here");
        tfUName.setVisible(true);
        tfUName.setFocusable(true);
        panel.add(tfUName);

        userPass = new JLabel("Password: ");
        userPass.setBounds(425, 300, 200, 30);
        userPass.setFont(new Font("Segoe UI", 1, 20));
        userPass.setVisible(true);
        panel.add(userPass);

        confirmUserPass = new JLabel("Confirm Password: ");
        confirmUserPass.setBounds(475, 275, 180, 30);
        confirmUserPass.setFont(new Font("Calibri", Font.BOLD, 16));
        confirmUserPass.setForeground(Color.decode("#FFFF00"));
        confirmUserPass.setVisible(false);
        panel.add(confirmUserPass);


        pfUPass = new JPasswordField();
        pfUPass.setBounds(437, 345, 325, 25);
        pfUPass.setBorder(BorderFactory.createLineBorder(Color.decode("#000000")));
        pfUPass.setEchoChar('*');
        pfUPass.setToolTipText("Enter your password here");
        pfUPass.setVisible(true);
        pfUPass.setFocusable(true);
        panel.add(pfUPass);


        su = new JLabel("Don't have an Account?");
        su.setFont(new Font("Segoe UI", 1, 17));
        su.setBounds(538, 147, 200, 30);
        panel.add(su);


        on = new ImageIcon("Image/tg1.png");
        off = new ImageIcon("Image/tg2.png");
        toggleButton = new JToggleButton(off);
        toggleButton.setBounds(768, 348, 25, 20);
        toggleButton.setBackground(Color.decode("#E4002B"));
        toggleButton.setForeground(new Color(173, 255, 47));
        toggleButton.setOpaque(true);
        toggleButton.setBorder(BorderFactory.createEmptyBorder());
        toggleButton.setToolTipText("Show Password");
        toggleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        toggleButton.setVisible(true);
        toggleButton.addActionListener(this);
        panel.add(toggleButton);

        ImageIcon background= new ImageIcon("Image/background.png");
        ImageIcon logoIcon = new ImageIcon("Image/logo.png");
        setIconImage(logoIcon.getImage());

        logo = new JLabel(background);
        logo.setBounds(0, 0, 800, 550);
        panel.add(logo);



setVisible(true);	
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {

        if (me.getSource() == aboutusbtn) {
            aboutusbtn.setBackground(Color.white);
            aboutusbtn.setForeground(Color.black);
        }else if (me.getSource() == staffbtn) {
            staffbtn.setBackground(Color.white);
            staffbtn.setForeground(Color.black);
        }else if (me.getSource() == adminbtn) {
            adminbtn.setBackground(Color.white);
            adminbtn.setForeground(Color.black);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == aboutusbtn) {
            aboutusbtn.setBackground(btnColor);
            aboutusbtn.setForeground(Color.BLACK);
        } else if (me.getSource() == staffbtn) {
            staffbtn.setBackground(btnColor);
            staffbtn.setForeground(Color.BLACK);
        } else if (me.getSource() == adminbtn) {
            adminbtn.setBackground(btnColor);
            adminbtn.setForeground(Color.BLACK);
        }
    }
    

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aboutusbtn) {
            new AboutUs();
            this.setVisible(false);
        } else if (e.getSource() == staffbtn) {
            new Stafflogin();
            this.setVisible(false);
        
            this.setVisible(false);
        }




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

            new CustomerSignUp();
            panel.setVisible(false);

        } else if (e.getSource() == loginButton){
            String user = tfUName.getText();
            String pass = pfUPass.getText();
            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in the blanks.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            }

            else {

                try { String userNameS = "User Name : " + user;
                    String passwordS = "Password : " + pass;
                    BufferedReader reader = new BufferedReader(new FileReader("data\\.user_data.txt"));

                    int totalLines = 0;
                    while (reader.readLine() != null)
                        totalLines++;
                    reader.close();

                    for (int i = 0; i <= totalLines; i++) {
                        String line = Files.readAllLines(Paths.get("data\\.user_data.txt")).get(i);
                        if (line.equals(userNameS)) {
                            String line2 = Files.readAllLines(Paths.get("data\\.user_data.txt")).get((i + 1));
                            if (line2.equals(passwordS)) {
                                panel.setVisible(false);
                                new Restaurant(user);
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