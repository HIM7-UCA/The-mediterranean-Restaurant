package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Accounts extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel foodCostLabel, salaryLabel, rentLabel, otherExpenseLabel, incomeLabel;
    private JTextField foodCostTF, salaryTF, rentTF, otherExpenseTF, incomeTF;
    private JButton enterBtn, gobackbtn;


    public Accounts() {

        super("Accounts");
        this.setSize(400, 600);



        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        incomeLabel = new JLabel("Income:");
        incomeLabel.setBounds(25, 50, 80, 25);
        panel.add(incomeLabel);

        foodCostLabel = new JLabel("Food Cost:");
        foodCostLabel.setBounds(25, 100, 80, 25);
        panel.add(foodCostLabel);

        salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(25, 150, 80, 25);
        panel.add(salaryLabel);

        rentLabel = new JLabel("Rent:");
        rentLabel.setBounds(25, 200, 80, 25);
        panel.add(rentLabel);

        otherExpenseLabel = new JLabel("Other Expense:");
        otherExpenseLabel.setBounds(25, 250, 100, 25);
        panel.add(otherExpenseLabel);

        incomeTF = new JTextField();
        incomeTF.setBounds(100, 50, 200, 25);
        panel.add(incomeTF);

        foodCostTF = new JTextField();
        foodCostTF.setBounds(100, 100, 200, 25);
        panel.add(foodCostTF);

        salaryTF = new JTextField();
        salaryTF.setBounds(100, 150, 200, 25);
        panel.add(salaryTF);

        rentTF = new JTextField();
        rentTF.setBounds(100, 200, 200, 25);
        panel.add(rentTF);

        otherExpenseTF = new JTextField();
        otherExpenseTF.setBounds(130, 250, 170, 25);
        panel.add(otherExpenseTF);

        enterBtn = new JButton("Enter");
        enterBtn.setBounds(100, 300, 100, 25);
        enterBtn.addActionListener(this);
        panel.add(enterBtn);

        gobackbtn = new JButton("Go Back");
        gobackbtn.setBounds(180, 300, 100, 25);
        gobackbtn.addActionListener(this);
        panel.add(gobackbtn);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gobackbtn) {
            new Stafflogin();
            this.setVisible(false);
        } else if (e.getSource() == enterBtn) {
            try {
                double incomeAmount = Double.parseDouble(incomeTF.getText());
                double foodCostAmount = Double.parseDouble(foodCostTF.getText());
                double salaryAmount = Double.parseDouble(salaryTF.getText());
                double rentAmount = Double.parseDouble(rentTF.getText());
                double otherExpenseAmount = Double.parseDouble(otherExpenseTF.getText());

                double totalExpense = foodCostAmount + salaryAmount + rentAmount + otherExpenseAmount;
                double netProfitAmount = incomeAmount - totalExpense;

                JOptionPane.showMessageDialog(null, "Net Profit = " + netProfitAmount, "Net Profit",
                        JOptionPane.INFORMATION_MESSAGE);

                File file = new File("data/.Accounts.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println("Income : " + incomeAmount);
                pw.println("Food Cost : " + foodCostAmount);
                pw.println("Salary : " + salaryAmount);
                pw.println("Rent : " + rentAmount);
                pw.println("Other Expense : " + otherExpenseAmount);
                pw.println("Total Expense : " + totalExpense);
                pw.println("Net Profit : " + netProfitAmount);
                pw.println("===============================================");
                pw.close();

                JOptionPane.showMessageDialog(null, "Data saved successfully.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);

                incomeTF.setText("");
                foodCostTF.setText("");
                salaryTF.setText("");
                rentTF.setText("");
                otherExpenseTF.setText("");
            } catch (NumberFormatException | IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input or something went wrong. Please check your input and try again.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
