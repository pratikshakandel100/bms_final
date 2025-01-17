/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package features.account.view.screens;

import core.BaseApp;
import core.Session;
import features.account.controller.AccountController;
import features.account.model.Account;
import features.transaction.view.TransferBetweenAccount;
import features.transaction.controller.TransactionController;
import features.transaction.model.Transaction;
import features.transaction.view.ATMDeposit;
import features.transaction.view.ATMWithdraw;
import features.transaction.view.PaySomeone;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pratiksha
 */
public class AccountDetailScreen extends javax.swing.JFrame {
    private String accountNumber;

    /**
     * Creates new form AcccountDetailScreen
     */
    public AccountDetailScreen(String accountNumber) {
        this.accountNumber = accountNumber;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        accountnumberLabel = new javax.swing.JLabel();
        accountypeLabel = new javax.swing.JLabel();
        branchnameLevel = new javax.swing.JLabel();
        lblAccName = new javax.swing.JLabel();
        lblAccNumber = new javax.swing.JLabel();
        lblAccType = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnPaySomeone = new javax.swing.JButton();
        btnTransferBetweenAccount = new javax.swing.JButton();
        btnATMDeposit = new javax.swing.JButton();
        btnATMWithdraw = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransactionTable = new javax.swing.JTable();
        lblBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }

            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }

            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        nameLabel.setText("Name");

        accountnumberLabel.setText("Account Number");

        accountypeLabel.setText("Account Type");

        branchnameLevel.setText("Balance");

        lblAccName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAccName.setText("Anil Kesari Shah");

        lblAccNumber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAccNumber.setText("9202923320423");

        lblAccType.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAccType.setText("Saving Account");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Rs.");

        lblAmount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAmount.setText("289555");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 0));
        jLabel14.setText("Account Information");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(nameLabel,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(accountnumberLabel,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE, 116,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(branchnameLevel,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addComponent(accountypeLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 116,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(25, 25, 25)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(lblAccName)
                                                                .addComponent(lblAccNumber,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE, 110,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(lblAccType,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel11)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lblAmount,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel14)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(lblAccName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(accountnumberLabel)
                                        .addComponent(lblAccNumber))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(branchnameLevel)
                                        .addComponent(lblAmount))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAccType)
                                        .addComponent(accountypeLabel))
                                .addContainerGap(15, Short.MAX_VALUE)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnPaySomeone.setBackground(new java.awt.Color(255, 153, 51));
        btnPaySomeone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPaySomeone.setForeground(new java.awt.Color(255, 255, 255));
        btnPaySomeone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-pay-21.png"))); // NOI18N
        btnPaySomeone.setText("Pay Someone");
        btnPaySomeone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaySomeoneActionPerformed(evt);
            }
        });

        btnTransferBetweenAccount.setBackground(new java.awt.Color(255, 153, 51));
        btnTransferBetweenAccount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTransferBetweenAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnTransferBetweenAccount
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-transfer-21.png"))); // NOI18N
        btnTransferBetweenAccount.setText("Transfer Between Account");
        btnTransferBetweenAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferBetweenAccountActionPerformed(evt);
            }
        });

        btnATMDeposit.setBackground(new java.awt.Color(255, 153, 51));
        btnATMDeposit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnATMDeposit.setForeground(new java.awt.Color(255, 255, 255));
        btnATMDeposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-atm-21.png"))); // NOI18N
        btnATMDeposit.setText("ATM Deposit");
        btnATMDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnATMDepositActionPerformed(evt);
            }
        });

        btnATMWithdraw.setBackground(new java.awt.Color(255, 153, 51));
        btnATMWithdraw.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnATMWithdraw.setForeground(new java.awt.Color(255, 255, 255));
        btnATMWithdraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-withdraw-21.png"))); // NOI18N
        btnATMWithdraw.setText("ATM Withdraw");
        btnATMWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnATMWithdrawActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnPaySomeone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTransferBetweenAccount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnATMDeposit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnATMWithdraw)
                                .addContainerGap(195, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnPaySomeone)
                                        .addComponent(btnTransferBetweenAccount)
                                        .addComponent(btnATMDeposit)
                                        .addComponent(btnATMWithdraw))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("Payment History");

        tblTransactionTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null }
                },
                new String[] {
                        "Date", "Amount", "Type", "Description", "Reference"
                }));
        jScrollPane1.setViewportView(tblTransactionTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312,
                                        Short.MAX_VALUE)));

        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-back-25.png"))); // NOI18N
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onBackClick(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        new AccountListScreen().setVisible(true);
        dispose();
    }// GEN-LAST:event_formWindowClosing

    private void btnPaySomeoneActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
        new PaySomeone().openPopup(this, accountNumber);
    }

    private void btnTransferBetweenAccountActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTransferActionPerformed
        // TODO add your handling code here:
        new TransferBetweenAccount().openPopup(this);
    }// GEN-LAST:event_btnTransferActionPerformed

    private void btnATMDepositActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDepositActionPerformed
        // TODO add your handling code here:
        new ATMDeposit().openPopup(this);
    }// GEN-LAST:event_btnDepositActionPerformed

    private void btnATMWithdrawActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnWithdrawActionPerformed
        // TODO add your handling code here:
        new ATMWithdraw().openPopup(this);
    }// GEN-LAST:event_btnWithdrawActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        AccountController ac = BaseApp.getAccountController();
        Account account = ac.getActiveAccountFromAccountNumber(accountNumber);
        setAccountInformation(account);
        setTransactionHistory(account);

    }// GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        AccountController ac = BaseApp.getAccountController();
        Account account = ac.getActiveAccountFromAccountNumber(accountNumber);
        setAccountInformation(account);
        refreshTransactionHistory(account);
    }// GEN-LAST:event_formWindowGainedFocus

    private void onBackClick(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_onBackClick
        // TODO add your handling code here:
        new AccountListScreen().setVisible(true);
        dispose();
    }// GEN-LAST:event_onBackClick

    public void setAccountInformation(Account account) {
        String fullname = Session.getSession().getLoggedInUser().getName();
        // For Normal Account
        lblAccName.setText(fullname);
        lblAccNumber.setText(account.getAccountNumber());
        lblAmount.setText(String.valueOf(account.getBalance()));
        lblAccType.setText(String.format("%s Account", account.getAccountType()).toUpperCase());
    }

    void refreshTransactionHistory(Account account) {
        setTransactionHistory(account);
    }

    public void setTransactionHistory(Account account) {
        TransactionController transactionController = BaseApp.getTransactionController();
        List<Transaction> transactionList = transactionController.getAllUserTransaction(account.getAccountId());
        DefaultTableModel transactionTable = (DefaultTableModel) tblTransactionTable.getModel();

        // Clear existing rows
        transactionTable.setRowCount(0);

        for (Transaction transaction : transactionList) {
            System.out.println(transaction.getTransactionDateTime());
            // Retrieve transaction details with fallbacks for null or empty values
            String date = transaction.getTransactionDateTime() != null
                    ? transaction.getTransactionDateTime().toString()
                    : "-";
            String amount = String.valueOf(transaction.getAmount());

            String type = transaction.getTransactionType() != null && !transaction.getTransactionType().isEmpty()
                    ? transaction.getTransactionType()
                    : "-";
            String description = transaction.getDescription() != null && !transaction.getDescription().isEmpty()
                    ? transaction.getDescription()
                    : "-";
            String reference = transaction.getReference() != null && !transaction.getReference().isEmpty()
                    ? transaction.getReference()
                    : "-";

            // Add a row to the table
            transactionTable.addRow(new Object[] { date, amount, type, description, reference });
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountDetailScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountDetailScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountDetailScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountDetailScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountDetailScreen("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountnumberLabel;
    private javax.swing.JLabel accountypeLabel;
    private javax.swing.JLabel branchnameLevel;
    private javax.swing.JButton btnATMDeposit;
    private javax.swing.JButton btnATMWithdraw;
    private javax.swing.JButton btnPaySomeone;
    private javax.swing.JButton btnTransferBetweenAccount;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAccName;
    private javax.swing.JLabel lblAccNumber;
    private javax.swing.JLabel lblAccType;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable tblTransactionTable;
    // End of variables declaration//GEN-END:variables
}
