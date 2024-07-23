package classes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Category3 extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton spaghetti, pizza, lasagna, back, order;
    private JLabel prspaghetti, prpizza, prlasagna, banner;
    private JCheckBox spaghettiCheckBox, pizzaCheckBox, lasagnaCheckBox;
    private JComboBox<String> spaghettiComboBox, pizzaComboBox, lasagnaComboBox;
    private String quantity[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String f;

    public Category3(String user) {
        ImageIcon framelogo = new ImageIcon("Image/logo.png");
        setIconImage(framelogo.getImage());

        f = user;

        Icon bicon = new ImageIcon("Image/italy.png");
        Icon spaghettiIcon = new ImageIcon("Image/spaghetti.png");
        Icon pizzaIcon = new ImageIcon("Image/pizza.png");
        Icon lasagnaIcon = new ImageIcon("Image/lasagna.png");

        setTitle("Category3 - Italian Plates");
        setBounds(0, 0, 900, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);
        panel.setBackground(new Color(32,18,77)); // Italian red color
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

        spaghetti = new JButton(spaghettiIcon);
        spaghetti.setBounds(120, 175, 200, 200);
        spaghetti.addActionListener(this);
        panel.add(spaghetti);

        spaghettiCheckBox = new JCheckBox("Spaghetti");
        spaghettiCheckBox.setBounds(120, 385, 200, 30);
        spaghettiCheckBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        spaghettiCheckBox.setForeground(Color.WHITE); // Text color
        spaghettiCheckBox.setBackground(new Color(128, 0, 0)); // Background color
        panel.add(spaghettiCheckBox);

        prspaghetti = new JLabel("120 DH");
        prspaghetti.setBounds(140, 420, 150, 20);
        prspaghetti.setForeground(Color.WHITE); // Text color
        prspaghetti.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        panel.add(prspaghetti);

        spaghettiComboBox = new JComboBox<>(quantity);
        spaghettiComboBox.setBounds(140, 455, 70, 20);
        panel.add(spaghettiComboBox);

        pizza = new JButton(pizzaIcon);
        pizza.setBounds(350, 175, 200, 200);
        pizza.addActionListener(this);
        panel.add(pizza);

        pizzaCheckBox = new JCheckBox("Pizza");
        pizzaCheckBox.setBounds(350, 385, 200, 30);
        pizzaCheckBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        pizzaCheckBox.setForeground(Color.WHITE); // Text color
        pizzaCheckBox.setBackground(new Color(128, 0, 0)); // Background color
        panel.add(pizzaCheckBox);

        prpizza = new JLabel("150 DH");
        prpizza.setBounds(370, 420, 150, 20);
        prpizza.setForeground(Color.WHITE); // Text color
        prpizza.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        panel.add(prpizza);

        pizzaComboBox = new JComboBox<>(quantity);
        pizzaComboBox.setBounds(370, 455, 70, 20);
        panel.add(pizzaComboBox);

        lasagna = new JButton(lasagnaIcon);
        lasagna.setBounds(600, 175, 200, 200);
        lasagna.addActionListener(this);
        panel.add(lasagna);

        lasagnaCheckBox = new JCheckBox("Lasagna");
        lasagnaCheckBox.setBounds(600, 385, 200, 30);
        lasagnaCheckBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lasagnaCheckBox.setForeground(Color.WHITE); // Text color
        lasagnaCheckBox.setBackground(new Color(128, 0, 0)); // Background color
        panel.add(lasagnaCheckBox);

        prlasagna = new JLabel("140 DH");
        prlasagna.setBounds(620, 420, 150, 20);
        prlasagna.setForeground(Color.WHITE); // Text color
        prlasagna.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        panel.add(prlasagna);

        lasagnaComboBox = new JComboBox<>(quantity);
        lasagnaComboBox.setBounds(620, 455, 70, 20);
        panel.add(lasagnaComboBox);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Restaurant(f);
            setVisible(false);
        } else if (e.getSource() == order) {
            double totalAmount = 0;
            double spaghettiAmount = 0;
            double pizzaAmount = 0;
            double lasagnaAmount = 0;
            int a = 0;
            int b = 0;
            int c = 0;

            if (spaghettiCheckBox.isSelected()) {
                a = (spaghettiComboBox.getSelectedIndex()) + 1;
                spaghettiAmount = a * 120;
            }
            if (pizzaCheckBox.isSelected()) {
                b = pizzaComboBox.getSelectedIndex() + 1;
                pizzaAmount = b * 150;
            }
            if (lasagnaCheckBox.isSelected()) {
                c = lasagnaComboBox.getSelectedIndex() + 1;
                lasagnaAmount = c * 140;
            }

            totalAmount = spaghettiAmount + pizzaAmount + lasagnaAmount;
            if (totalAmount != 0) {
                int x = JOptionPane.showConfirmDialog(null, "Your Bill = " + totalAmount + " DH. Confirm Order?",
                        " Confirmation of Order", 0);
                if (x == 0) {
                    setVisible(false);
                    new Payment(totalAmount, "Category3", f);

                    try {
                        File newfile = new File("data\\Last.txt");
                        newfile.createNewFile();
                        FileWriter file = new FileWriter("data\\Last.txt");

                        file.write("Spaghetti--- " + a + spaghettiAmount + " DH."
                                + "\n Pizza---" + b + pizzaAmount + " DH."
                                + "\n Lasagna---" + c + lasagnaAmount + " DH."
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
