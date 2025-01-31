package features.transaction.view;

import core.BaseApp;
import features.account.controller.AccountController;
import features.account.model.Account;
import features.auth.controller.UserController;
import features.auth.model.User;
import features.transaction.controller.TransactionController;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.*;

public class ATMWithdraw {

    public void openPopup(JFrame frame) {
        showDepositPopup(frame);
    }

    private static void showDepositPopup(JFrame parent) {
        // Create a JDialog for the popup
        JDialog popup = new JDialog(parent, "ATM Withdraw", true);
        popup.setSize(500, 300);
        popup.setLayout(new GridBagLayout());
        popup.setLocationRelativeTo(parent);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Receiver Account Number
        JLabel accountNumberLabel = new JLabel("From Account Number:");
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

        // User Found Panel (Initially Hidden)
        JPanel userFoundPanel = new JPanel();
        userFoundPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        userFoundPanel.setBackground(Color.LIGHT_GRAY);
        JLabel userFoundLabel = new JLabel("User Found:");
        JLabel userFullNameLabel = new JLabel(); // Placeholder for dynamic name
        userFullNameLabel.setForeground(Color.BLUE);
        userFoundPanel.add(userFoundLabel);
        userFoundPanel.add(userFullNameLabel);
        userFoundPanel.setVisible(false); // Initially hidden
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        popup.add(userFoundPanel, gbc);

        // Balance
        JLabel balanceLabel = new JLabel("Withdraw Amount:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        popup.add(balanceLabel, gbc);

        JTextField balanceField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        popup.add(balanceField, gbc);
        
        // Description
        JLabel descriptionLabel = new JLabel("Description:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        popup.add(descriptionLabel, gbc);

        JTextField descriptionField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        popup.add(descriptionField, gbc);

        // Reference
        JLabel referenceLabel = new JLabel("Reference (Optional):");
        gbc.gridx = 0;
        gbc.gridy = 5;
        popup.add(referenceLabel, gbc);

        JTextField referenceField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 5;
        popup.add(referenceField, gbc);
        
        
        // Confirm Deposit Button
        JButton confirmButton = new JButton("Confirm ATM Withdaraw");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        popup.add(confirmButton, gbc);
        
        accountNumberField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    String accountNumber = accountNumberField.getText();
                    if (accountNumber.isEmpty()) {
                        JOptionPane.showMessageDialog(popup, "Account Number is required.", "Error", JOptionPane.ERROR_MESSAGE);
                        accountNumberField.requestFocus();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(popup, "Invalid date. Please check your input.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        
        // Add FocusListener to validate DOB and show user panel
        dayField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    int yearValue = Integer.parseInt(yearField.getText().trim());
                    int monthValue = Integer.parseInt(monthField.getText().trim());
                    int dayValue = Integer.parseInt(dayField.getText().trim());

                    LocalDate dob = LocalDate.of(yearValue, monthValue, dayValue);

                    if (dob.isAfter(LocalDate.now())) {
                        JOptionPane.showMessageDialog(popup, "Date of birth cannot be in the future.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Simulate finding user
                        User user = getUserFromAccountNumber(accountNumberField.getText());
                        boolean isDobEqual = Date.valueOf(dob).equals(user.getDOB());
                        if (isDobEqual) {
                            String foundText = String.format("{Account Holder Name: '%s' & Phone: '%s'}", user.getName(),user.getPhone());
                            userFullNameLabel.setText(foundText);
                            userFoundPanel.setVisible(true);
                        }else {
                        JOptionPane.showMessageDialog(popup, "Either Account Number or Date of Birth is Incorrect. Please check your input.", "Error", JOptionPane.ERROR_MESSAGE);
                            accountNumberField.requestFocus();
                            return;
                        }
                        popup.revalidate();
                        popup.repaint();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(popup, "Invalid date. Please check your input.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        private User getUserFromAccountNumber(String accountNumber){
        AccountController ac = BaseApp.getAccountController();
        UserController uc = BaseApp.getUserController();
        Account account = ac.getActiveAccountFromAccountNumber(accountNumber);
        if(account == null){
            JOptionPane.showMessageDialog(popup, "Account number must is incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        User accountHolder = uc.getUserDetails(account.getUserId());
        return accountHolder;
    }

        });

       

        // Action Listener for Confirm Button
        confirmButton.addActionListener((ActionEvent e) -> {
            String accountNumber = accountNumberField.getText().trim();
            String year = yearField.getText().trim();
            String month = monthField.getText().trim();
            String day = dayField.getText().trim();
            String balance = balanceField.getText().trim();
            String description = descriptionField.getText();
            String reference = referenceField.getText();

            // Validate input
            if (accountNumber.isEmpty() || year.isEmpty() || month.isEmpty() || day.isEmpty() || balance.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(popup, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try {
                double amount = Double.parseDouble(balance);
                if (amount <= 0) {
                    throw new NumberFormatException();
                }
                
                // Show confirmation dialog
                int confirmationResponse = JOptionPane.showConfirmDialog(popup,
                        "ATM Withdraw confirmed:\n" +
                                "From Account: " + accountNumber + "\n" +
                                "Amount: Rs." + amount + "\n" +
                                "Description: " + description + "\n" +
                                (reference.isEmpty() ? "" : "Reference: " + reference),
                        "Success", JOptionPane.OK_CANCEL_OPTION);
                if(confirmationResponse == JOptionPane.OK_OPTION) {
                    TransactionController transactionController = BaseApp.getTransactionController();
                    String otp = transactionController.atmWithdraw(accountNumber, amount, description, reference.isEmpty() ? "" : reference);
                    if(!otp.isEmpty()){
                        JOptionPane.showMessageDialog(popup, "Your ATM Withdraw Code is: "+otp,"ATM Deposit Code",JOptionPane.INFORMATION_MESSAGE);
                        popup.dispose();
                    } else {
                        JOptionPane.showMessageDialog(popup, "Your deposit was failed.","Deposit Failed",JOptionPane.ERROR);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(popup, "Please enter valid numbers for the balance.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        popup.setVisible(true);
    }
}
