package classes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Category1 extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton tajine, chicken, couscous, back, order;
    private JLabel prtajine, prchicken, prcouscous, banner;
    private JCheckBox tajineCheckBox, chickenCheckBox, couscousCheckBox;
    private JComboBox<String> tajineComboBox, chickenComboBox, couscousComboBox;
    private String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String f;

    public Category1(String user) {
        ImageIcon framelogo = new ImageIcon("Image/logo.png");
        setIconImage(framelogo.getImage());

        f = user;

        Icon bicon = new ImageIcon("Image/burgermenu.png");
        Icon tajineIcon = new ImageIcon("Image/tajine.png");
        Icon chickenIcon = new ImageIcon("Image/chicken.png");
        Icon couscousIcon = new ImageIcon("Image/couscous.png");

        setTitle("Category1 - Moroccan Plates");
        setBounds(0, 0, 900, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);
        panel.setBackground(new Color(153,0,0)); // Moroccan red color
        add(panel);

        back = new JButton("Back");
        back.setBounds(145, 500, 150, 50);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.setOpaque(true);
        back.addActionListener(this);
        panel.add(back);

        order = new JButton("Place Order");
        order.setBounds(625, 500, 150, 50);
        order.setBackground(Color.BLACK);
        order.setForeground(Color.WHITE);
        order.setOpaque(true);
        order.addActionListener(this);
        panel.add(order);

        banner = new JLabel(bicon);
        banner.setBounds(0, 0, 900, 150);
        panel.add(banner);

        tajine = new JButton(tajineIcon);
        tajine.setBounds(120, 175, 200, 200);
        tajine.addActionListener(this);
        panel.add(tajine);
        
        

        tajineCheckBox = new JCheckBox("Tajine");
        tajineCheckBox.setBounds(120, 385, 200, 30);
        tajineCheckBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        tajineCheckBox.setForeground(Color.WHITE); // Couleur du texte
        tajineCheckBox.setBackground(new Color(128, 0, 0)); // Couleur de fond

        panel.add(tajineCheckBox);

        prtajine = new JLabel("120 DH");
        prtajine.setBounds(140, 420, 150, 20);
        prtajine.setForeground(Color.WHITE); // Couleur du texte
        prtajine.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        panel.add(prtajine);

        tajineComboBox = new JComboBox<>(quantity);
        tajineComboBox.setBounds(140, 455, 70, 20);
        panel.add(tajineComboBox);
        
        
       
        chicken = new JButton(chickenIcon);
        chicken.setBounds(350, 175, 200, 200);
        chicken.addActionListener(this);
        panel.add(chicken);
   
        chickenCheckBox = new JCheckBox("Chicken");
        chickenCheckBox.setBounds(350, 385, 200, 30);
        chickenCheckBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        chickenCheckBox.setForeground(Color.WHITE); // Couleur du texte
        chickenCheckBox.setBackground(new Color(128, 0, 0)); // Couleur de fond
        panel.add(chickenCheckBox);

        prchicken = new JLabel("150 DH");
        prchicken.setBounds(370, 420, 150, 20);
        prchicken.setForeground(Color.WHITE); // Couleur du texte
        prchicken.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));        
        panel.add(prchicken);

        chickenComboBox = new JComboBox<>(quantity);
        chickenComboBox.setBounds(370, 455, 70, 20);
        panel.add(chickenComboBox);

        couscous = new JButton(couscousIcon);
        couscous.setBounds(600, 175, 200, 200);
        couscous.addActionListener(this);
        panel.add(couscous);

        couscousCheckBox = new JCheckBox("couscous");
        couscousCheckBox.setBounds(600, 385, 200, 30);
        couscousCheckBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        couscousCheckBox.setForeground(Color.WHITE); // Couleur du texte
        couscousCheckBox.setBackground(new Color(128, 0, 0)); // Couleur de fond
        panel.add(couscousCheckBox);

        prcouscous = new JLabel("140 DH");
        prcouscous.setBounds(620, 420, 150, 20);
        prcouscous.setForeground(Color.WHITE); // Couleur du texte
        prcouscous.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));


        panel.add(prcouscous);

        couscousComboBox = new JComboBox<>(quantity);
        couscousComboBox.setBounds(620, 455, 70, 20);
        panel.add(couscousComboBox);
        
        

     
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Restaurant(f);
            setVisible(false);
        } else if (e.getSource() == order) {
            double totalAmount = 0;
            double tajineAmount = 0;
            double chickenAmount = 0;
            double couscousAmount = 0;
            int a = 0;
            int b = 0;
            int c = 0;

            if (tajineCheckBox.isSelected()) {
                a = (tajineComboBox.getSelectedIndex()) + 1;
                tajineAmount = a * 120;
            }
            if (chickenCheckBox.isSelected()) {
                b = chickenComboBox.getSelectedIndex() + 1;
                chickenAmount = b * 150;
            }
            if (couscousCheckBox.isSelected()) {
                c = couscousComboBox.getSelectedIndex() + 1;
                couscousAmount = c * 140;
            }

            totalAmount = tajineAmount + chickenAmount + couscousAmount;
            if (totalAmount != 0) {
                int x = JOptionPane.showConfirmDialog(null, "Your Bill = " + totalAmount + " DH. Confirm Order?",
                        " Confirmation of Order", 0);
                if (x == 0) {
                    setVisible(false);
                    new Payment(totalAmount, "Category1", f);

                    try {
                        File newfile = new File("data\\Last.txt");
                        newfile.createNewFile();
                        FileWriter file = new FileWriter("data\\Last.txt");

                        file.write("Tajine--- " + a + tajineAmount + " DH."
                                + "\n Chicken---" + b + chickenAmount + " DH."
                                + "\n couscous---" + c + couscousAmount + " DH."
                                + "\n" + totalAmount + " DH Total.");
                        file.close();

                    } catch (IOException io) {
                        JOptionPane.showMessageDialog(null, "An error occurred and failed to create the file");
                        io.printStackTrace();
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select something before placing an order!", "Message", 0);
            }
        }
    }
}
