package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.border.LineBorder;

public class ReviewPage extends JFrame implements ActionListener {

    private JLabel userNameLabel, reviewLabel;
    private JTextField userNameField;
    private JTextArea reviewArea;
    private JButton submitButton, returnButton;

    Color btnColor = new Color(0xF9E8D8);

    public ReviewPage() {
        super("Write a Review");
        setSize(600, 400);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 400);
        add(panel);

        userNameLabel = new JLabel("Your Name:");
        userNameLabel.setBounds(50, 50, 100, 30);
        panel.add(userNameLabel);

        userNameField = new JTextField();
        userNameField.setBounds(150, 50, 400, 30);
        panel.add(userNameField);

        reviewLabel = new JLabel("Your Review:");
        reviewLabel.setBounds(50, 100, 100, 30);
        panel.add(reviewLabel);

        reviewArea = new JTextArea();
        reviewArea.setBounds(150, 100, 400, 200);
        reviewArea.setLineWrap(true);
        panel.add(reviewArea);

        submitButton = new JButton("Submit Review");
        submitButton.setBounds(100, 320, 150, 30);
        submitButton.setBackground(btnColor);
        submitButton.setForeground(Color.BLACK);
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.addActionListener(this);
        panel.add(submitButton);

        returnButton = new JButton("Return to Home");
        returnButton.setBounds(300, 320, 150, 30);
        returnButton.setBackground(btnColor);
        returnButton.setForeground(Color.BLACK);
        returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnButton.addActionListener(this);
        panel.add(returnButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String userName = userNameField.getText();
            String reviewText = reviewArea.getText();
            if (!userName.isEmpty() && !reviewText.isEmpty()) {
                saveReview(userName, reviewText);
                JOptionPane.showMessageDialog(this, "Review submitted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                userNameField.setText("");
                reviewArea.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in both fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == returnButton) {
            new HomePage();
            dispose(); // Close the current frame
        }
    }

    private void saveReview(String userName, String reviewText) {
        try {
            // Create the data directory if it doesn't exist
            File dataDir = new File("data");
            if (!dataDir.exists()) {
                dataDir.mkdir();
            }

            // Write the review to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/reviews.txt", true));
            writer.write(userName + ":" + reviewText);
            writer.newLine();
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save review.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new ReviewPage();
    }
}
