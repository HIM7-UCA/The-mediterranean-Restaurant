package classes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Category2 extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton paella, tortillas, escalivada, back, order;
    private JLabel prpaella, prtortillas, prescalivada, banner;
    private JCheckBox paellaCheckBox, tortillasCheckBox, escalivadaCheckBox;
    private JComboBox<String> paellaComboBox, tortillasComboBox, escalivadaComboBox;
    private String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String f;

    public Category2(String user) {
        ImageIcon framelogo = new ImageIcon("Image/logo.png");
        setIconImage(framelogo.getImage());

        f = user;

        Icon bicon = new ImageIcon("Image/spain.png");
        Icon paellaIcon = new ImageIcon("Image/paella.png");
        Icon tortillasIcon = new ImageIcon("Image/tortillas.png");
        Icon escalivadaIcon = new ImageIcon("Image/escalivada.png");

        setTitle("Category2 - Spanish Plates");
        setBounds(0, 0, 900, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);
        panel.setBackground(new Color(244,67,54)); // Spanish red color
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

        paella = new JButton(paellaIcon);
        paella.setBounds(120, 175, 200, 200);
        paella.addActionListener(this);
        panel.add(paella);
        
        paellaCheckBox = new JCheckBox("Paella");
        paellaCheckBox.setBounds(120, 385, 200, 30);
        paellaCheckBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        paellaCheckBox.setForeground(Color.WHITE); // Couleur du texte
        paellaCheckBox.setBackground(new Color(128, 0, 0)); // Couleur de fond
        panel.add(paellaCheckBox);

        prpaella = new JLabel("120 DH");
        prpaella.setBounds(140, 420, 150, 20);
        prpaella.setForeground(Color.WHITE); // Couleur du texte
        prpaella.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        panel.add(prpaella);

        paellaComboBox = new JComboBox<>(quantity);
        paellaComboBox.setBounds(140, 455, 70, 20);
        panel.add(paellaComboBox);
        
        tortillas = new JButton(tortillasIcon);
        tortillas.setBounds(350, 175, 200, 200);
        tortillas.addActionListener(this);
        panel.add(tortillas);
   
        tortillasCheckBox = new JCheckBox("Tortillas");
        tortillasCheckBox.setBounds(350, 385, 200, 30);
        tortillasCheckBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        tortillasCheckBox.setForeground(Color.WHITE); // Couleur du texte
        tortillasCheckBox.setBackground(new Color(128, 0, 0)); // Couleur de fond
        panel.add(tortillasCheckBox);

        prtortillas = new JLabel("150 DH");
        prtortillas.setBounds(370, 420, 150, 20);
        prtortillas.setForeground(Color.WHITE); // Couleur du texte
        prtortillas.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));        
        panel.add(prtortillas);

        tortillasComboBox = new JComboBox<>(quantity);
        tortillasComboBox.setBounds(370, 455, 70, 20);
        panel.add(tortillasComboBox);

        escalivada = new JButton(escalivadaIcon);
        escalivada.setBounds(600, 175, 200, 200);
        escalivada.addActionListener(this);
        panel.add(escalivada);

        escalivadaCheckBox = new JCheckBox("Escalivada");
        escalivadaCheckBox.setBounds(600, 385, 200, 30);
        escalivadaCheckBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        escalivadaCheckBox.setForeground(Color.WHITE); // Couleur du texte
        escalivadaCheckBox.setBackground(new Color(128, 0, 0)); // Couleur de fond
        panel.add(escalivadaCheckBox);

        prescalivada = new JLabel("140 DH");
        prescalivada.setBounds(620, 420, 150, 20);
        prescalivada.setForeground(Color.WHITE); // Couleur du texte
        prescalivada.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        panel.add(prescalivada);

        escalivadaComboBox = new JComboBox<>(quantity);
        escalivadaComboBox.setBounds(620, 455, 70, 20);
        panel.add(escalivadaComboBox);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Restaurant(f);
            setVisible(false);
        } else if (e.getSource() == order) {
            double totalAmount = 0;
            double paellaAmount = 0;
            double tortillasAmount = 0;
            double escalivadaAmount = 0;
            int a = 0;
            int b = 0;
            int c = 0;

            if (paellaCheckBox.isSelected()) {
                a = (paellaComboBox.getSelectedIndex()) + 1;
                paellaAmount = a * 120;
            }
            if (tortillasCheckBox.isSelected()) {
                b = tortillasComboBox.getSelectedIndex() + 1;
                tortillasAmount = b * 150;
            }
            if (escalivadaCheckBox.isSelected()) {
                c = escalivadaComboBox.getSelectedIndex() + 1;
                escalivadaAmount = c * 140;
            }

            totalAmount = paellaAmount + tortillasAmount + escalivadaAmount;
            if (totalAmount != 0) {
                int x = JOptionPane.showConfirmDialog(null, "Your Bill = " + totalAmount + " DH. Confirm Order?",
                        " Confirmation of Order", 0);
                if (x == 0) {
                    setVisible(false);
                    new Payment(totalAmount, "Category2", f);

                    try {
                        File newfile = new File("data\\Last.txt");
                        newfile.createNewFile();
                        FileWriter file = new FileWriter("data\\Last.txt");

                        file.write("Paella--- " + a + paellaAmount + " DH."
                                + "\n Tortillas---" + b + tortillasAmount + " DH."
                                + "\n Escalivada---" + c + escalivadaAmount + " DH."
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
