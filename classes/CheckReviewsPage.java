package classes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckReviewsPage extends JFrame implements ActionListener {

    private JPanel reviewsPanel;
    private JButton closeButton;
    private final Font usernameFont = new Font("SansSerif", Font.BOLD, 14); // Font for username
    private final Font reviewFont = new Font("SansSerif", Font.PLAIN, 14); // Font for review text

    public CheckReviewsPage() {
        super("Check Reviews");
        setSize(800, 500); // Adjust size for better viewing area
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(10, 10)); // Add spacing between components
        setContentPane(contentPane);

        reviewsPanel = new JPanel();
        reviewsPanel.setLayout(new BoxLayout(reviewsPanel, BoxLayout.Y_AXIS));
        reviewsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(reviewsPanel);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        closeButton = new JButton("Close");
        closeButton.setFont(new Font("SansSerif", Font.BOLD, 16)); // Make close button stand out
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(closeButton);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // Read reviews from the file and display them
        displayReviews();

        setVisible(true);
    }

    private void displayReviews() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/reviews.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(":", 2); // Split line into username and review
                    if (parts.length == 2) {
                        JPanel reviewBox = createReviewBox(parts[0], parts[1]); // Create review box with username and review
                        reviewsPanel.add(reviewBox);
                        reviewsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between reviews
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JPanel createReviewBox(String username, String reviewText) {
        JPanel reviewPanel = new JPanel(new BorderLayout());
        reviewPanel.setBorder(new LineBorder(Color.GRAY, 1)); // Add border around each review

        JLabel usernameLabel = new JLabel(username);
        usernameLabel.setFont(usernameFont); // Apply the username font
        reviewPanel.add(usernameLabel, BorderLayout.NORTH);

        JTextArea reviewArea = new JTextArea(reviewText);
        reviewArea.setFont(reviewFont); // Apply the review font
        reviewArea.setEditable(false);
        reviewArea.setLineWrap(true); // Enable line wrapping for long reviews
        reviewArea.setWrapStyleWord(true); // Wrap on word boundaries
        reviewPanel.add(reviewArea, BorderLayout.CENTER);

        return reviewPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeButton) {
            dispose(); // Close the current frame
        }
    }

    public static void main(String[] args) {
        new CheckReviewsPage();
    }
}
