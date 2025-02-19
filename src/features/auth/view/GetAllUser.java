package features.auth.view;

import core.BaseApp;
import features.auth.controller.UserController;
import features.auth.model.User;
import features.auth.model.UserType;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Pratiksha
 */
public class GetAllUser extends javax.swing.JFrame {

    /**
     * Creates new form GetAllUser
     */
    public GetAllUser() {
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

        jPanel1 = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        pInfotitle1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfFullName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        tfPoints = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfPhone = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lblUserId = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        dobPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblDob = new javax.swing.JLabel();
        lblUserId2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        headerPanel.setBackground(new java.awt.Color(0, 0, 204));
        headerPanel.setName("RequestBankAccountPannel"); // NOI18N

        lblName.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(0, 0, 204));
        lblName.setText("Admin");

        lblBack.setForeground(new java.awt.Color(255, 255, 255));
        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/left-arrow-24.png"))); // NOI18N
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackonBackClick(evt);
            }
        });

        pInfotitle1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        pInfotitle1.setForeground(new java.awt.Color(204, 153, 255));
        pInfotitle1.setText("BANK MANAGEMENT SYSTEM");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pInfotitle1)
                .addGap(188, 188, 188)
                .addComponent(lblName)
                .addGap(28, 28, 28))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName))
                        .addGap(35, 35, 35))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(pInfotitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("Full Name:");

        tfFullName.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(255, 255, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setText("User Information");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("Email:");

        tfEmail.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        tfPoints.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Points");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setText("Phone:");

        tfPhone.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        btnUpdate.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblUser.setBackground(new java.awt.Color(204, 255, 204));
        tblUser.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "User ID", "Full Name", "Email", "Date of Birth", "Phone", "Points"
            }
        ));
        tblUser.setGridColor(new java.awt.Color(51, 51, 255));
        tblUser.setShowGrid(true);
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onSelectRow(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setText("User ID:");

        lblUserId.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblUserId.setForeground(new java.awt.Color(255, 153, 0));
        lblUserId.setText("0");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setText("Search");

        tfSearch.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        dobPanel.setBackground(new java.awt.Color(204, 204, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        jLabel7.setText("{DOB:");

        lblDob.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        lblDob.setForeground(new java.awt.Color(0, 51, 204));
        lblDob.setText("2025-01-01");

        lblUserId2.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        lblUserId2.setText("(YYYY-MM-DD)}");

        javax.swing.GroupLayout dobPanelLayout = new javax.swing.GroupLayout(dobPanel);
        dobPanel.setLayout(dobPanelLayout);
        dobPanelLayout.setHorizontalGroup(
            dobPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dobPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUserId2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dobPanelLayout.setVerticalGroup(
            dobPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dobPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7)
                .addComponent(lblDob)
                .addComponent(lblUserId2))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUserId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dobPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(btnUpdate)
                                .addGap(62, 62, 62)
                                .addComponent(btnDelete))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(75, 75, 75)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(138, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dobPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(lblUserId)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(tfFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(tfPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnUpdate)
                                    .addComponent(btnDelete)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        UserController uc = BaseApp.getUserController();
        if(tblUser.getSelectedRowCount()==1){
            int selectedRow = tblUser.getSelectedRow();
            String userId = tblUser.getValueAt(selectedRow, 0).toString();
            String fullName = tfFullName.getText();
            String email = tfEmail.getText();
            String phone = tfPhone.getText();
            String point = tfPoints.getText();
            
            User newUser  = new User();
            newUser.setUserId(Integer.parseInt(userId));
            newUser.setName(fullName);
            newUser.setEmail(email);
            newUser.setPhone(phone);
            newUser.setPoints(Integer.parseInt(point));
            
            boolean result = uc.updateUserDetail(newUser);

            if(result){
                JOptionPane.showMessageDialog(this, "User Detail are up-to-date now");
                tblUser.repaint();
                tblUser.validate();
                getAllUserTableData();
                lblUserId.setText("");
                tfEmail.setText("");
                tfFullName.setText("");
                tfPhone.setText("");
                tfPoints.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update user Detail");
            }
        } else {
        if(tblUser.getRowCount() == 0){
            JOptionPane.showMessageDialog(this, "Table is Empty");
        } else {
            JOptionPane.showMessageDialog(this, "Please Select Single row for update");
           }
        } 
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel userTable = (DefaultTableModel) tblUser.getModel();
        if(tblUser.getSelectedRowCount()==1){
            int selectedRow = tblUser.getSelectedRow();
//            String userId = tblUser.getValueAt(selectedRow, 0).toString();
            //TODO: delete user logic
            JOptionPane.showMessageDialog(this, "Close the bank Account First");
//            userTable.removeRow(tblUser.getSelectedRow());
        } else {
        if(tblUser.getRowCount() == 0){
            JOptionPane.showMessageDialog(this, "Table is Empty");
            } else {
            JOptionPane.showMessageDialog(this, "Please Select Single row for delete");
           }
        } 
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        dobPanel.setVisible(false);
        getAllUserTableData();
        
    }//GEN-LAST:event_formWindowOpened

    private void onSelectRow(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onSelectRow
        // TODO add your handling code here:
        if(tblUser.getSelectedRowCount()==1){
            dobPanel.setVisible(true);
            int selectedRow = tblUser.getSelectedRow();
            String userId = tblUser.getValueAt(selectedRow, 0).toString();
            String fullName = tblUser.getValueAt(selectedRow, 1).toString();
            String email = tblUser.getValueAt(selectedRow, 2).toString();
            String dob = tblUser.getValueAt(selectedRow, 3).toString();
            String phone = tblUser.getValueAt(selectedRow, 4).toString();
            String point = tblUser.getValueAt(selectedRow, 5).toString();
            
            // Now setText
            lblUserId.setText(userId);
            lblDob.setText(dob);
            tfFullName.setText(fullName);
            tfEmail.setText(email);
            tfPhone.setText(phone);
            tfPoints.setText(point);

        } else {
            dobPanel.setVisible(true);
        if(tblUser.getRowCount() == 0){
            JOptionPane.showMessageDialog(this, "Table is Empty");
            } else {
            JOptionPane.showMessageDialog(this, "Please Select Single row for update");
           }
        } 
        
    }//GEN-LAST:event_onSelectRow

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        // TODO add your handling code here:
        String searchCharacter = tfSearch.getText();
        searchAndFilter(searchCharacter);
    }//GEN-LAST:event_tfSearchKeyReleased

    private void lblBackonBackClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackonBackClick
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_lblBackonBackClick

   private void searchAndFilter(String searchText){
       DefaultTableModel userTable = (DefaultTableModel) tblUser.getModel();
       TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(userTable);
       tblUser.setRowSorter(tableRowSorter);
       tableRowSorter.setRowFilter(RowFilter.regexFilter(searchText));
   }

    private void getAllUserTableData() {
        UserController uc = BaseApp.getUserController();
        List<User> fetchedUserList = uc.getAllUser();
        DefaultTableModel userTable = (DefaultTableModel) tblUser.getModel();
        List<User> userList = fetchedUserList.stream().filter(user -> user.getRole().equalsIgnoreCase(UserType.USER.name())).collect(Collectors.toList());
        // Clear existing rows
        userTable.setRowCount(0);

        for (User user : userList) {
            // Retrieve transaction details with fallbacks for null or empty values
            String userId = String.valueOf(user.getUserId());
            String email = String.valueOf(user.getEmail());

            String fullName = user.getName();
            String phone = user.getPhone();
            System.out.println("DOB-->"+user.getDOB());
            String dob = String.valueOf(user.getDOB());

            String point = String.valueOf(user.getPoints()) != null
                    ? String.valueOf(user.getPoints())
                    : "-";

            // Add a row to the table
            userTable.addRow(new Object[] { userId, fullName, email, dob, phone, point });
        }
    }

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
            java.util.logging.Logger.getLogger(GetAllUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GetAllUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GetAllUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GetAllUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GetAllUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel dobPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblUserId;
    private javax.swing.JLabel lblUserId2;
    private javax.swing.JLabel pInfotitle1;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFullName;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JTextField tfPoints;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
