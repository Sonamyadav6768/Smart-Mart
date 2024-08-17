/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmart.gui;

import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import jmart.dao.ReceptionistDao;
import jmart.pojo.UserPojo;


public class AddReceptionistFrame extends javax.swing.JFrame {

    
    Map<String,String> receptionistList;
    public AddReceptionistFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadNonRegisteredReceptionist();
    }

    private int validateInput()
    {
        if(jPassword.getPassword().length<4 || jRePassword.getPassword().length<4)
            return 0;
        else if(txtUserId.getText().trim().isEmpty())
            return -1;
        return 1;
    }
    
    private boolean isPasswordMatched(String a, String b)
    {
        return a.equals(b);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblEmployeeId = new javax.swing.JLabel();
        lblEmployeeName = new javax.swing.JLabel();
        lblUserId = new javax.swing.JLabel();
        lblRePassword = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        txtEmployeeName = new javax.swing.JTextField();
        jComboEmployeeId = new javax.swing.JComboBox<>();
        jPassword = new javax.swing.JPasswordField();
        jRePassword = new javax.swing.JPasswordField();
        btnAddReceptionist = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        jPanel2.setBackground(new java.awt.Color(204, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Receptionist", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N

        btnBack.setBackground(new java.awt.Color(255, 0, 0));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(255, 0, 0));
        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(327, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(67, 67, 67)
                .addComponent(btnLogout)
                .addGap(52, 52, 52))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnLogout))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 0, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N

        lblEmployeeId.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblEmployeeId.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployeeId.setText("Employee Id");

        lblEmployeeName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblEmployeeName.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployeeName.setText("Employee Name");

        lblUserId.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblUserId.setForeground(new java.awt.Color(255, 255, 255));
        lblUserId.setText("User Id");

        lblRePassword.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblRePassword.setForeground(new java.awt.Color(255, 255, 255));
        lblRePassword.setText("Re password");

        lblPassword.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password");

        txtEmployeeName.setEditable(false);

        jComboEmployeeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEmployeeIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRePassword)
                    .addComponent(lblPassword)
                    .addComponent(lblUserId)
                    .addComponent(lblEmployeeName)
                    .addComponent(lblEmployeeId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUserId, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(txtEmployeeName, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(jComboEmployeeId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPassword)
                    .addComponent(jRePassword))
                .addGap(57, 57, 57))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployeeId)
                    .addComponent(jComboEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployeeName)
                    .addComponent(txtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserId)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRePassword)
                    .addComponent(jRePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        btnAddReceptionist.setBackground(new java.awt.Color(255, 0, 0));
        btnAddReceptionist.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnAddReceptionist.setForeground(new java.awt.Color(255, 255, 255));
        btnAddReceptionist.setText("Add");
        btnAddReceptionist.setEnabled(false);
        btnAddReceptionist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddReceptionistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(265, 265, 265)
                    .addComponent(btnAddReceptionist)
                    .addContainerGap(296, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(532, Short.MAX_VALUE)
                    .addComponent(btnAddReceptionist)
                    .addGap(6, 6, 6)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboEmployeeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEmployeeIdActionPerformed
        if(jComboEmployeeId.getItemCount()==0)
            return;
        txtEmployeeName.setText(receptionistList.get(jComboEmployeeId.getSelectedItem().toString()));
    }//GEN-LAST:event_jComboEmployeeIdActionPerformed

    private void btnAddReceptionistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddReceptionistActionPerformed
       if(validateInput()==-1)
       {
           JOptionPane.showMessageDialog(null, "Plase Fill UserId","ERROR",JOptionPane.ERROR_MESSAGE);
           return ;
       }
        
        if(validateInput()==0)
       {
           JOptionPane.showMessageDialog(null, "Password must be 4 Character long ","ERROR",JOptionPane.ERROR_MESSAGE);
           return ;
       }
        char [] pwd=jPassword.getPassword();
        char[] rePwd=jRePassword.getPassword();
        if(isPasswordMatched(String.valueOf(pwd),String.valueOf(rePwd))==false)
        {
            JOptionPane.showMessageDialog(null, "Password are not matching","ERROR",JOptionPane.ERROR_MESSAGE);
            jPassword.setText("");
            jRePassword.setText("");
           return ;
        }
        try
        {
            String empid=jComboEmployeeId.getSelectedItem().toString();
            String userId=txtUserId.getText().trim();
            String userName=txtEmployeeName.getText();
            UserPojo u=new UserPojo();
            u.setEmpId(empid);
            u.setUserId(userId);
            u.setUserName(userName);
            u.setPassword(String.valueOf(pwd));
            u.setUserType("Receptionist");
            boolean res=ReceptionistDao.addReceptionist(u);
            if(res==true)
            {
                JOptionPane.showMessageDialog(null,"RECEPTIONIST REGISTERED");
                loadNonRegisteredReceptionist();
                jPassword.setText("");
                jRePassword.setText("");
                txtUserId.setText("");
                return;
            }
            JOptionPane.showMessageDialog(null,"RECEPTIONIST NOT REGISTERED");
        }
        
         catch(SQLException sqle)
        {
           JOptionPane.showMessageDialog(null,"ERROR IN DB","ERROR",JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }
        
    }//GEN-LAST:event_btnAddReceptionistActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        ManageReceptionistFrame mf=new ManageReceptionistFrame();
        mf.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    public static void main(String args[]) {
       
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
            java.util.logging.Logger.getLogger(AddReceptionistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddReceptionistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddReceptionistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddReceptionistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddReceptionistFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddReceptionist;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout;
    private javax.swing.JComboBox<String> jComboEmployeeId;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JPasswordField jRePassword;
    private javax.swing.JLabel lblEmployeeId;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRePassword;
    private javax.swing.JLabel lblUserId;
    private javax.swing.JTextField txtEmployeeName;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration//GEN-END:variables

    private void loadNonRegisteredReceptionist() {
        try{
            jComboEmployeeId.removeAllItems();
            receptionistList=ReceptionistDao.getNonReceptionist();
            if(receptionistList.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "NO UNREGISTERED RECP.");
                txtEmployeeName.setText("");
                btnAddReceptionist.setEnabled(false);
                return;
            }
             btnAddReceptionist.setEnabled(true);
             
            for(String key:receptionistList.keySet())
            {
                jComboEmployeeId.addItem(key);
            }
            
        }
        catch(SQLException sqle)
        {
           JOptionPane.showMessageDialog(null,"ERROR IN DB","ERROR",JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }
    }
}
