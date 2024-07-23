package classes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PaymentSuccess implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JLabel tcs;
    private JLabel ap;
    private JButton home;
    private JButton recipt;
    private String f;

    public PaymentSuccess(double amount, String user) {

        frame = new JFrame("PaymentSuccess");

        ImageIcon framelogo = new ImageIcon("Image/logo.png");
        frame.setIconImage(framelogo.getImage());

        f = user;

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 500);
        frame.add(panel);

        tcs = new JLabel("Transaction Completed Successfully");
        tcs.setVerticalTextPosition(JLabel.BOTTOM);
        tcs.setHorizontalTextPosition(JLabel.CENTER);
        tcs.setForeground(Color.BLACK);
        tcs.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
        tcs.setBounds(135, 00, 520, 200);
        panel.add(tcs);

        ap = new JLabel("Amount Paid :    " + amount + " tk");
        ap.setForeground(Color.BLACK);
        ap.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        ap.setBounds(300, 200, 400, 100);
        panel.add(ap);

        home = new JButton("Home");
        home.setBounds(250, 300, 100, 30);
        home.setFocusable(false);
        home.setBackground(Color.decode("#BF1A1A"));
        home.setForeground(Color.WHITE);
        home.setBorder(BorderFactory.createEmptyBorder());
        home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        home.addActionListener(this);
        panel.add(home);

        recipt = new JButton("Print Receipt");
        recipt.setBounds(450, 300, 130, 30);
        recipt.setFocusable(false);
        recipt.setBackground(Color.decode("#BF1A1A"));
        recipt.setForeground(Color.WHITE);
        recipt.setBorder(BorderFactory.createEmptyBorder());
        recipt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        recipt.addActionListener(this);
        panel.add(recipt);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.getContentPane().setBackground(Color.decode("#F2F2F2"));
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void generateReceipt(double amount) {
        try {
            // Sample items and quantities
            String[] items = {"Tajine", "Chicken", "Bastilla"};
            int[] quantities = {2, 1, 3};

            File receipt = new File("data\\Receipt.txt");
            FileWriter writer = new FileWriter(receipt);

            writer.write("Receipt\n\n");

            // Write each item and its quantity to the receipt
            for (int i = 0; i < items.length; i++) {
                writer.write(items[i] + " x" + quantities[i] + "\n");
            }

            writer.write("\nAmount Paid: " + amount + " tk\n");
            writer.write("////////////////////////////\n");
            writer.write("\nThank You for using our service :) ");

            writer.close();

            JOptionPane.showMessageDialog(null, "Receipt printed here: " + receipt.getAbsolutePath());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred and failed to create the file");
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home) {
            frame.setVisible(false);
            new Restaurant(f);
        } else if (e.getSource() == recipt) {
            double amount = 0; // Set the correct amount here
            generateReceipt(amount);
        }
    }

}
