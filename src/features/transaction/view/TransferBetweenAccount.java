/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package features.transaction.view;

import core.BaseApp;
import core.Session;
import features.account.controller.AccountController;
import features.account.model.Account;
import features.account.model.AccountStatus;
import features.account.model.AccountType;
import features.auth.model.User;
import features.transaction.controller.TransactionController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TransferBetweenAccount {
    private List<Account> accountList = new ArrayList<>();
    private List<String> allAccountList=new ArrayList<>();

    public void openPopup(JFrame frame) {
        fetchALlUserActiveAccount();
        showTransferPopup(frame);
    }

    private void showTransferPopup(JFrame parent) {
       
        String[] accountListCB;
        // Create a JDialog for the popup
        if(allAccountList.size() >= 3){
        accountListCB = new String[] {allAccountList.get(0),allAccountList.get(1),allAccountList.get(2)};
        } else {
        accountListCB = new String[] {allAccountList.get(0),allAccountList.get(1)};
        }
        
        JDialog popup = new JDialog(parent, "Transfer Between Accounts", true);
        popup.setSize(400, 400);
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

        JComboBox<String> fromAccountComboBox = new JComboBox<>(accountListCB);
        gbc.gridx = 1;
        gbc.gridy = 0;
        popup.add(fromAccountComboBox, gbc);

        // To Account
        JLabel toAccountLabel = new JLabel("To Account:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        popup.add(toAccountLabel, gbc);

        JComboBox<String> toAccountComboBox = new JComboBox<>(accountListCB);
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

        // Confirm Transfer Button
        JButton confirmButton = new JButton("Confirm Transfer");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        popup.add(confirmButton, gbc);

        // Action Listener for Confirm Button
        confirmButton.addActionListener((ActionEvent e) -> {
            String fromAccount = (String) fromAccountComboBox.getSelectedItem();
            String toAccount = (String) toAccountComboBox.getSelectedItem();
            String balance = balanceField.getText();
            String description = descriptionField.getText();
            String reference = referenceField.getText();

            // Validate the input
            if (fromAccount == null || toAccount == null || balance.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(popup, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (fromAccount.equals(toAccount)) {
                JOptionPane.showMessageDialog(popup, "From Account and To Account must be different.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double amount = Double.parseDouble(balance);
                if (amount <= 0) {
                    JOptionPane.showMessageDialog(popup, "Transfer amount Cannot be 0.","Error",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                String fromAccountNumber = fromAccount.split("/")[1];
                
                String toAccountNumber = toAccount.split("/")[1];
                // Show confirmation dialog
                int confirmationResponse = JOptionPane.showConfirmDialog(popup,
                        "Transfer confirmed:\n" +
                                "From: " + fromAccountNumber + "\n" +
                                "To: " + toAccountNumber + "\n" +
                                "Amount: Rs." + amount + "\n" +
                                "Description: " + description + "\n" +
                                (reference.isEmpty() ? "" : "Reference: " + reference),
                        "Success", JOptionPane.OK_CANCEL_OPTION);
                if(confirmationResponse == JOptionPane.OK_OPTION) {
                    TransactionController transactionController = BaseApp.getTransactionController();
                    Account fromAccountDetails = BaseApp.getAccountController().getActiveAccountFromAccountNumber(fromAccountNumber);
                    Double fromAccountBalance = fromAccountDetails.getBalance();
                    String fromAccountType = fromAccountDetails.getAccountType();
                    if (fromAccountBalance <= amount && !fromAccountType.equalsIgnoreCase(AccountType.LOAN.name())){
                        JOptionPane.showMessageDialog(popup, "Insufficient funds in your account","Error",JOptionPane.INFORMATION_MESSAGE);
                    return;
                    }
                    if(fromAccountType.equalsIgnoreCase(AccountType.LOAN.name()) && fromAccountBalance <= 0.0){
                        JOptionPane.showMessageDialog(popup, "You're already in Loan\nSo, You cannot make transfer","Error Insufficent Balance",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    boolean result = transactionController.transferBetweenAccount(fromAccountNumber, toAccountNumber, amount, description, reference.isEmpty() ? "" : reference);
                    if(result){
                        JOptionPane.showMessageDialog(popup, "You payment is successful.","Payment Success",JOptionPane.INFORMATION_MESSAGE);
                        popup.dispose();
                    } else {
                        JOptionPane.showMessageDialog(popup, "You payment was failed.","Payment Failed",JOptionPane.ERROR);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(popup, "Please enter a valid balance.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        popup.setVisible(true);
    }

    void fetchALlUserActiveAccount(){
        User user = Session.getSession().getLoggedInUser();
        AccountController accountController = BaseApp.getAccountController();
        accountList = accountController.getAllActiveUserAccount(user.getUserId())
                .stream()
                .filter(account -> (AccountType.NORMAL.name().equalsIgnoreCase(account.getAccountType()) || AccountType.SAVER.name().equalsIgnoreCase(account.getAccountType())))
                .collect(Collectors.toList());
        
        Account loanAccount = accountController.getAllUserAccount(user.getUserId())
                .stream()
                .filter(account -> (AccountType.LOAN.name().equalsIgnoreCase(account.getAccountType())))
                .collect(Collectors.toList()).getFirst();
        
        
        if(loanAccount != null){
            if(loanAccount.getStatus().equalsIgnoreCase(AccountStatus.ACTIVE.name())) {
                allAccountList.add(String.format("%s/%s", loanAccount.getAccountType(),loanAccount.getAccountNumber()));
            }  
        } 
        if(!accountList.isEmpty()){
            Account normalAccount = accountList.stream()
            .filter(account -> AccountType.NORMAL.name().equalsIgnoreCase(account.getAccountType()))
            .collect(Collectors.toList()).getFirst();
            
            
            Account saverAccount = accountList.stream()
            .filter(account -> AccountType.SAVER.name().equalsIgnoreCase(account.getAccountType()))
            .collect(Collectors.toList()).getFirst();
            
            allAccountList.add(String.format("%s/%s", normalAccount.getAccountType(),normalAccount.getAccountNumber()));
            allAccountList.add(String.format("%s/%s", saverAccount.getAccountType(),saverAccount.getAccountNumber()));
        }
    }
}
