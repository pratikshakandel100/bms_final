/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package features.message.view;




import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import javax.swing.*;

public class DepositPopup {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Deposit Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);

            // Create a button to trigger the deposit popup
            JButton depositButton = new JButton("Make a Deposit");
            depositButton.addActionListener(e -> showDepositPopup(frame));

            frame.setLayout(new FlowLayout());
            frame.add(depositButton);
            frame.setVisible(true);
        });
    }

    private static void showDepositPopup(JFrame parent) {
        // Create a JDialog for the popup
        JDialog popup = new JDialog(parent, "Deposit Funds", true);
        popup.setSize(500, 300);
        popup.setLayout(new GridBagLayout());
        popup.setLocationRelativeTo(parent);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Receiver Account Number
        JLabel accountNumberLabel = new JLabel("To Receiver Account:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        popup.add(accountNumberLabel, gbc);

        JTextField accountNumberField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        popup.add(accountNumberField, gbc);

        // Date of Birth
        JLabel dobLabel = new JLabel("Date of Birth (YYYY-MM-DD):");
        gbc.gridx = 0;
        gbc.gridy = 1;
        popup.add(dobLabel, gbc);

        JPanel dobPanel = new JPanel();
        dobPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JTextField yearField = new JTextField(4);
        JTextField monthField = new JTextField(2);
        JTextField dayField = new JTextField(2);
        dobPanel.add(yearField);
        dobPanel.add(new JLabel("-"));
        dobPanel.add(monthField);
        dobPanel.add(new JLabel("-"));
        dobPanel.add(dayField);
        gbc.gridx = 1;
        gbc.gridy = 1;
        popup.add(dobPanel, gbc);

        // Balance
        JLabel balanceLabel = new JLabel("Balance:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        popup.add(balanceLabel, gbc);

        JTextField balanceField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        popup.add(balanceField, gbc);

        // Description
        JLabel descriptionLabel = new JLabel("Description:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        popup.add(descriptionLabel, gbc);

        JTextField descriptionField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        popup.add(descriptionField, gbc);

        // Reference
        JLabel referenceLabel = new JLabel("Reference (Optional):");
        gbc.gridx = 0;
        gbc.gridy = 4;
        popup.add(referenceLabel, gbc);

        JTextField referenceField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        popup.add(referenceField, gbc);
        
        
        // Confirm Deposit Button
        JButton confirmButton = new JButton("Confirm Deposit");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        popup.add(confirmButton, gbc);

        // Action Listener for Confirm Button
        confirmButton.addActionListener((ActionEvent e) -> {
            String accountNumber = accountNumberField.getText().trim();
            String year = yearField.getText().trim();
            String month = monthField.getText().trim();
            String day = dayField.getText().trim();
            String balance = balanceField.getText().trim();
            String description = descriptionField.getText().trim();
            String reference = referenceField.getText().trim();

            // Validate the input
            if (accountNumber.isEmpty() || year.isEmpty() || month.isEmpty() || day.isEmpty() || balance.isEmpty()) {
                JOptionPane.showMessageDialog(popup, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!accountNumber.matches("\\d+")) {
                JOptionPane.showMessageDialog(popup, "Account number must be numeric.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int yearValue = Integer.parseInt(year);
                int monthValue = Integer.parseInt(month);
                int dayValue = Integer.parseInt(day);

                // Validate the date
                LocalDate dob = LocalDate.of(yearValue, monthValue, dayValue);
                if (dob.isAfter(LocalDate.now())) {
                    JOptionPane.showMessageDialog(popup, "Date of birth cannot be in the future.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate the balance
                double amount = Double.parseDouble(balance);
                if (amount <= 0) {
                    throw new NumberFormatException();
                }

                // Show confirmation dialog
                JOptionPane.showMessageDialog(popup,
                        "Deposit confirmed:\nTo Account: " + accountNumber +
                                "\nDate of Birth: " + year + "-" + month + "-" + day +
                                "\nAmount: $" + amount +
                                "\nDescription: " + description +
                                (reference.isEmpty() ? "" : "\nReference: " + reference),
                        "Success", JOptionPane.INFORMATION_MESSAGE);

                popup.dispose(); // Close the popup

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(popup, "Please enter valid numbers for the balance and date.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(popup, "Invalid date. Please check your input.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        popup.setVisible(true);
    }
}


