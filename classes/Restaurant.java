package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restaurant extends JFrame implements ActionListener {

    private JPanel p, c;
    private JLabel title, c1, c2, c3, lprofile, m;
    private String s;
    private JButton lgout, profile, cat1, cat2, cat3;

    public Restaurant(String user) {
        super("Restaurant");
        ImageIcon logo = new ImageIcon("Image/logo.png");
        setIconImage(logo.getImage());

        s = user;

        Icon icon = new ImageIcon("Image/menubarger.png");
        Icon icon3 = new ImageIcon("Image/menuricebowl.png");
        Icon icon4 = new ImageIcon("Image/menudrinks.png");
        Icon iconl = new ImageIcon("Image/logout.png");
        Icon iconp = new ImageIcon("Image/profile.png");
        Icon micon = new ImageIcon("Image/mainbanner.png");

        setTitle("Restaurant");
        setBounds(0, 0, 900, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = new JPanel();
        c.setBounds(0, 0, 900, 600);
        c.setLayout(null);
        add(c);

        title = new JLabel("Mediterian Restaurant");
        title.setBounds(240, 5, 500, 50);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        title.setForeground(Color.decode("#F0E68C")); // Light yellow color
        c.add(title);


        m = new JLabel(micon);
        m.setBounds(0, 70, 900, 210);
        c.add(m);

        lgout = new JButton(iconl);
        lgout.setBounds(750, 5, 60, 60);
        lgout.addActionListener(this);
        c.add(lgout);

        profile = new JButton(iconp);
        profile.setBounds(820, 5, 60, 60);
        profile.addActionListener(this);
        c.add(profile);

        lprofile = new JLabel(user);
        lprofile.setBounds(50, 10, 60, 30);
        lprofile.setForeground(Color.decode("#000000"));
        lprofile.setBackground(Color.decode("#FFFFFF"));
        lprofile.setHorizontalAlignment(JLabel.CENTER);
        lprofile.setOpaque(true);
        c.add(lprofile);

        cat1 = new JButton(icon);
        cat1.setBounds(50, 300, 200, 200);
        cat1.addActionListener(this);
        c.add(cat1);

        c1 = new JLabel("MOROCCAN");
        c1.setBounds(90, 520, 120, 30);
        c.add(c1);
        c1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        c1.setForeground(Color.decode("#F0E68C")); // Light yellow color

        cat2 = new JButton(icon3);
        cat2.setBounds(350, 300, 200, 200);
        cat2.addActionListener(this);
        c.add(cat2);

        c2 = new JLabel("SPANISH");
        c2.setBounds(390, 520, 150, 30);
        c.add(c2);
        c2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        c2.setForeground(Color.decode("#F0E68C")); // Light yellow color


        cat3 = new JButton(icon4);
        cat3.setBounds(650, 300, 200, 200);
        cat3.addActionListener(this);
        c.add(cat3);

        c3 = new JLabel("ITALIAN");
        c3.setBounds(690, 520, 150, 30);
        c.add(c3);
        c3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        c3.setForeground(Color.decode("#F0E68C")); // Light yellow color


        p = new JPanel();
        p.setBounds(0, 0, 900, 700);
        p.setBackground(Color.decode("#C025252"));
        c.add(p);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cat1) {
            new Category1(s);
            dispose();
        } else if (e.getSource() == cat2) {
            new Category2(s);
            dispose();
        } else if (e.getSource() == cat3) {
            new Category3(s);
            dispose();
        } else if (e.getSource() == lgout) {
            new HomePage();
            setVisible(false); 
        }

        else if (e.getSource() == profile) {
            setVisible(false);
            new UProfile(s);
        }
    }
}
