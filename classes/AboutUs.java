package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class AboutUs extends JFrame implements ActionListener {

    private JLabel logo;
    private JButton gobackbtn;

    public AboutUs() {

        super("AboutUs");
        setSize(1200, 780);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gobackbtn = new JButton("Back");
        gobackbtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
        gobackbtn.setBounds(1050, 690, 100, 30);
        gobackbtn.setBorder(new LineBorder(Color.BLACK, 2));
        gobackbtn.setBackground(Color.WHITE);
        gobackbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gobackbtn.setForeground(Color.BLACK);
        gobackbtn.addActionListener(this);
        gobackbtn.setFocusable(false);
        add(gobackbtn);

        ImageIcon bannerIcon = new ImageIcon("Image/aboutus.png");
        ImageIcon logoIcon = new ImageIcon("Image/logo.png");
        setIconImage(logoIcon.getImage());

        logo = new JLabel(bannerIcon);
        logo.setBounds(0, 0, 1200, 754);
        add(logo);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gobackbtn) {
            new HomePage();
            this.setVisible(false);
            this.dispose();
        }
    }
}
