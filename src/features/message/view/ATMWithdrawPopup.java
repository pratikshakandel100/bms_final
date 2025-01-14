/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package features.message.view;


import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ATMWithdrawPopup {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ATM Withdraw Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);

            // Create a button to trigger the withdraw popup
            JButton withdrawButton = new JButton("Withdraw Funds");
            withdrawButton.addActionListener(e -> showWithdrawPopup(frame));

            frame.setLayout(new FlowLayout());
            frame.add(withdrawButton);
            frame.setVisible(true);
        });
    }

    private static void showWithdrawPopup(JFrame parent) {
        // Create a JDialog for the popup
        JDialog popup = new JDialog(parent, "ATM Withdraw", true);
        popup.setSize(400, 250);
        popup.setLayout(new GridBagLayout());
        popup.setLocationRelativeTo(parent);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Account Number
        JLabel accountNumberLabel = new JLabel("Account Number:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        popup.add(accountNumberLabel, gbc);

        JTextField accountNumberField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        popup.add(accountNumberField, gbc);

        // Withdrawal Balance
        JLabel balanceLabel = new JLabel("Withdrawal Amount:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        popup.add(balanceLabel, gbc);

        JTextField balanceField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        popup.add(balanceField, gbc);

        // Confirm Withdraw Button
        JButton confirmButton = new JButton("Confirm Withdraw");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        popup.add(confirmButton, gbc);

        // Action Listener for Confirm Button
        confirmButton.addActionListener((ActionEvent e) -> {
            String accountNumber = accountNumberField.getText().trim();
            String balance = balanceField.getText().trim();

            // Validate the input
            if (accountNumber.isEmpty() || balance.isEmpty()) {
                JOptionPane.showMessageDialog(popup, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!accountNumber.matches("\\d+")) {
                JOptionPane.showMessageDialog(popup, "Account number must be numeric.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double amount = Double.parseDouble(balance);
                if (amount <= 0) {
                    throw new NumberFormatException();
                }

                // Show confirmation dialog
                JOptionPane.showMessageDialog(popup,
                        "Withdrawal confirmed:\nAccount: " + accountNumber +
                                "\nAmount: $" + amount,
                        "Success", JOptionPane.INFORMATION_MESSAGE);

                popup.dispose(); // Close the popup

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(popup, "Please enter a valid withdrawal amount.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        popup.setVisible(true);
    }
}
