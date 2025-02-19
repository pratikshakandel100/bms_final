package features.auth.view;

import core.BaseApp;
import core.MessageStringManager;
import core.Session;
import features.auth.model.User;
import features.kyc.controller.KYCController;
import features.kyc.model.KYCDetails;
import features.message.controller.MessageController;
import features.message.model.MessageInfo;
import features.message.model.MessageType;
import javax.swing.JOptionPane;


/**
 *
 * @author Pratiksha
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        MainAccountPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        pInfotitle = new javax.swing.JLabel();
        pInfoLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        requestBankAccountPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        requestLoanAccountPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel11.setText("Reuqest to open a bank account?");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        MainAccountPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainAccountPanel.setDoubleBuffered(false);
        MainAccountPanel.setEnabled(false);

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));
        infoPanel.setName("RequestBankAccountPannel"); // NOI18N

        pInfotitle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        pInfotitle.setText("KYC Info");

        pInfoLabel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        pInfoLabel.setForeground(new java.awt.Color(51, 0, 255));
        pInfoLabel.setText("You have already submitted the KYC details and it is waiting for approval.");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onCloseMessageInfo(evt);
            }
        });

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(pInfoLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(pInfotitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pInfotitle)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pInfoLabel)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        requestBankAccountPanel.setBackground(new java.awt.Color(255, 255, 255));
        requestBankAccountPanel.setName("RequestBankAccountPannel"); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel16.setText("Your Accounts");

        jLabel9.setText("Request to open a bank account?");

        jLabel12.setForeground(new java.awt.Color(0, 51, 255));
        jLabel12.setText("Request Here");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onRequestToOpenBankAccount(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/features/auth/view/assets/openBankAccount.jpg"))); // NOI18N

        javax.swing.GroupLayout requestBankAccountPanelLayout = new javax.swing.GroupLayout(requestBankAccountPanel);
        requestBankAccountPanel.setLayout(requestBankAccountPanelLayout);
        requestBankAccountPanelLayout.setHorizontalGroup(
            requestBankAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requestBankAccountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(requestBankAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(requestBankAccountPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        requestBankAccountPanelLayout.setVerticalGroup(
            requestBankAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requestBankAccountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(requestBankAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        requestLoanAccountPanel.setBackground(new java.awt.Color(255, 255, 255));
        requestLoanAccountPanel.setName("RequestBankAccountPannel"); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel17.setText("Your Loan Accounts");

        jLabel14.setText("Request to open a loan account?");

        jLabel15.setForeground(new java.awt.Color(0, 51, 255));
        jLabel15.setText("Request Here");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onRequestToOpenLoanAccount(evt);
            }
        });

        javax.swing.GroupLayout requestLoanAccountPanelLayout = new javax.swing.GroupLayout(requestLoanAccountPanel);
        requestLoanAccountPanel.setLayout(requestLoanAccountPanelLayout);
        requestLoanAccountPanelLayout.setHorizontalGroup(
            requestLoanAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requestLoanAccountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(requestLoanAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(requestLoanAccountPanelLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        requestLoanAccountPanelLayout.setVerticalGroup(
            requestLoanAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requestLoanAccountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(requestLoanAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addContainerGap())
        );

        jLabel2.setText("Pratiksha");

        javax.swing.GroupLayout MainAccountPanelLayout = new javax.swing.GroupLayout(MainAccountPanel);
        MainAccountPanel.setLayout(MainAccountPanelLayout);
        MainAccountPanelLayout.setHorizontalGroup(
            MainAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainAccountPanelLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(MainAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(requestLoanAccountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MainAccountPanelLayout.createSequentialGroup()
                        .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9))
                    .addGroup(MainAccountPanelLayout.createSequentialGroup()
                        .addComponent(requestBankAccountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
        MainAccountPanelLayout.setVerticalGroup(
            MainAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainAccountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(requestBankAccountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(requestLoanAccountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainAccountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainAccountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        User loggedInUser = Session.getSession().getLoggedInUser();
        MessageInfo message = new MessageController().getUserLastMessage();
        requestBankAccountPanel.setVisible(false);
        requestLoanAccountPanel.setVisible(false);
        if(message != null){
            pInfotitle.setText(message.getTitle());
            pInfoLabel.setText(message.getMessage());
            infoPanel.setVisible(true);
            System.out.println(message.getMessageType().toUpperCase());
            switch (message.getMessageType().toUpperCase()) {
                case "KYC" -> {
                    requestBankAccountPanel.setVisible(false);
                    requestLoanAccountPanel.setVisible(false);
                }
                case "ACCOUNT" -> {
                    requestBankAccountPanel.setVisible(false);
                    requestLoanAccountPanel.setVisible(true);
                }
                case "LOAN" -> {
                    requestBankAccountPanel.setVisible(false);
                    requestLoanAccountPanel.setVisible(false);
                }
                case "CARD" -> {
                    requestBankAccountPanel.setVisible(false);
                    requestLoanAccountPanel.setVisible(false);
                }
                default -> {
                    requestBankAccountPanel.setVisible(false);
                    requestLoanAccountPanel.setVisible(false);
                }
            }  
        } else {
            infoPanel.setVisible(false);

            KYCController kYCController = BaseApp.getKycController();
            KYCDetails kycDetails = kYCController.getKYCDetailsFromUserId(String.valueOf(loggedInUser.getUserId()));
            if(kycDetails.isVerified()){
            requestBankAccountPanel.setVisible(true);
            requestLoanAccountPanel.setVisible(true);
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void onRequestToOpenBankAccount(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onRequestToOpenBankAccount
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "Do you want to request to open bank account!", "Request Bank Account Opening", JOptionPane.OK_CANCEL_OPTION);
         if (response == JOptionPane.OK_OPTION) {
                // Open AccountScreen and close LoginScreen
                int userId = Session.getSession().getLoggedInUser().getUserId();
                boolean result = BaseApp.getAccountController().openBankAccount(userId);
                if(result){
                    JOptionPane.showMessageDialog(this, "You request to open bank account has received!", "Request Received", JOptionPane.INFORMATION_MESSAGE);
                    infoPanel.setVisible(true);
                    MessageInfo message = new MessageInfo(MessageStringManager.ACCOUNT_OPENED_INFO_TITLE, MessageStringManager.ACCOUNT_OPENED_INFO_MESSAGE);
                    new MessageController().deleteUserMessage();
                    new MessageController().saveUserMessage(message,MessageType.ACCOUNT);
                    requestBankAccountPanel.setVisible(false);
                }
            }              
         }
//GEN-LAST:event_onRequestToOpenBankAccount
    private void onRequestToOpenLoanAccount(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onRequestToOpenLoanAccount
        // TODO add your handling code here:
        String loanAmount = JOptionPane.showInputDialog(null, "Enter the Loan Amount to be request", "Request Loan Account Opening", JOptionPane.INFORMATION_MESSAGE);
        // Open AccountScreen and close LoginScreen
        int userId = Session.getSession().getLoggedInUser().getUserId();
        boolean result = BaseApp.getAccountController().openLoanAccount(userId,Integer.parseInt(loanAmount));
        if(result){
            JOptionPane.showMessageDialog(null, "You request to open loan account has received!", "Request Received", JOptionPane.INFORMATION_MESSAGE);
            infoPanel.setVisible(true);
            MessageInfo message = new MessageInfo(MessageStringManager.LOAN_ACCOUNT_OPENED_INFO_TITLE, MessageStringManager.LOAN_ACCOUNT_OPENED_INFO_MESSAGE);
            new MessageController().deleteUserMessage();
            new MessageController().saveUserMessage(message,MessageType.LOAN);
            requestLoanAccountPanel.setVisible(false);
        }
    }//GEN-LAST:event_onRequestToOpenLoanAccount

    private void onCloseMessageInfo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onCloseMessageInfo
        // TODO add your handling code here:
        infoPanel.setVisible(false);
    }//GEN-LAST:event_onCloseMessageInfo

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainAccountPanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel pInfoLabel;
    private javax.swing.JLabel pInfotitle;
    private javax.swing.JPanel requestBankAccountPanel;
    private javax.swing.JPanel requestLoanAccountPanel;
    // End of variables declaration//GEN-END:variables
}
