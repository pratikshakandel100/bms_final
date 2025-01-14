/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package features.message.view;



import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class AccountTransferPopup {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Account Transfer Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);

            // Create a button to trigger the transfer popup
            JButton transferButton = new JButton("Transfer Between Accounts");
            transferButton.addActionListener(e -> showTransferPopup(frame));

            frame.setLayout(new FlowLayout());
            frame.add(transferButton);
            frame.setVisible(true);
        });
    }
    
    public static void openPopup(JFrame frame){
        showTransferPopup(frame);
    }

    private static void showTransferPopup(JFrame parent) {
        // Create a JDialog for the popup
        JDialog popup = new JDialog(parent, "Transfer Between Accounts", true);
        popup.setSize(400, 300);
        popup.setLayout(new GridBagLayout());
        popup.setLocationRelativeTo(parent);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // From Account
        JLabel fromAccountLabel = new JLabel("From Account:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        popup.add(fromAccountLabel, gbc);

        JComboBox<String> fromAccountComboBox = new JComboBox<>(new String[]{"Item1", "Item2"});
        gbc.gridx = 1;
        gbc.gridy = 0;
        popup.add(fromAccountComboBox, gbc);

        // To Account
        JLabel toAccountLabel = new JLabel("To Account:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        popup.add(toAccountLabel, gbc);

        JComboBox<String> toAccountComboBox = new JComboBox<>(new String[]{"Item1", "Item2"});
        gbc.gridx = 1;
        gbc.gridy = 1;
        popup.add(toAccountComboBox, gbc);

        // Balance
        JLabel balanceLabel = new JLabel("Balance:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        popup.add(balanceLabel, gbc);

        JTextField balanceField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        popup.add(balanceField, gbc);

        // Confirm Transfer Button
        JButton confirmButton = new JButton("Confirm Transfer");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        popup.add(confirmButton, gbc);

        // Action Listener for Confirm Button
        confirmButton.addActionListener((ActionEvent e) -> {
            String fromAccount = (String) fromAccountComboBox.getSelectedItem();
            String toAccount = (String) toAccountComboBox.getSelectedItem();
            String balance = balanceField.getText();

            // Validate the input
            if (fromAccount == null || toAccount == null || balance.isEmpty()) {
                JOptionPane.showMessageDialog(popup, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (fromAccount.equals(toAccount)) {
                JOptionPane.showMessageDialog(popup, "From Account and To Account must be different.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double amount = Double.parseDouble(balance);
                if (amount <= 0) {
                    throw new NumberFormatException();
                }

                // Show confirmation dialog
                JOptionPane.showMessageDialog(popup,
                        "Transfer confirmed:\nFrom: " + fromAccount + "\nTo: " + toAccount + "\nAmount: $" + amount,
                        "Success", JOptionPane.INFORMATION_MESSAGE);

                popup.dispose(); // Close the popup

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(popup, "Please enter a valid balance.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        popup.setVisible(true);
    }
}

