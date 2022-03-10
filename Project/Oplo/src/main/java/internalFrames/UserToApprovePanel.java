/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package internalFrames;

import classes.Display;
import classes.ServerCommunication;

/**
 *
 * @author Clément
 */
public class UserToApprovePanel extends javax.swing.JInternalFrame {

    /**
     * Creates new form UserToApprovePanel
     */
    public UserToApprovePanel() {
        initComponents();
        Display.removeBorders(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userFirstname = new javax.swing.JLabel();
        userSurname = new javax.swing.JLabel();
        userLogin = new javax.swing.JLabel();
        approveUserButton = new javax.swing.JButton();
        revokeUserButton = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        userFirstname.setText("prenom");

        userSurname.setText("nom");

        userLogin.setText("login");

        approveUserButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        approveUserButton.setText("Approuver");
        approveUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveUserButtonActionPerformed(evt);
            }
        });

        revokeUserButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        revokeUserButton.setText("Revoquer");
        revokeUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revokeUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userSurname)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(revokeUserButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                                .addComponent(approveUserButton)))
                        .addGap(153, 153, 153))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userLogin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userFirstname)
                            .addComponent(approveUserButton))
                        .addGap(18, 18, 18)
                        .addComponent(userSurname)
                        .addGap(4, 4, 4)
                        .addComponent(revokeUserButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void approveUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveUserButtonActionPerformed
        // TODO add your handling code here:
        String loginS = userLogin.getText();
        
        ServerCommunication s = new ServerCommunication();
        System.out.println(s.sendPostRequest("https://oplo.000webhostapp.com/", "approveAccount=true&login=" + loginS));
        //Move on
    }//GEN-LAST:event_approveUserButtonActionPerformed

    public void setLogin(String log)
    {
        userLogin.setText(log);
    }
    
    public void setFirstname(String log)
    {
        userFirstname.setText(log);
    }
    
    public void setSurname(String log)
    {
        userSurname.setText(log);
    }
    
    private void revokeUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revokeUserButtonActionPerformed
        // TODO add your handling code here:
        String loginS = userLogin.getText();
        
        ServerCommunication s = new ServerCommunication();
        s.sendPostRequest("https://oplo.000webhostapp.com/", "revokeAccount=true&login=" + loginS);
        
    }//GEN-LAST:event_revokeUserButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveUserButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton revokeUserButton;
    private javax.swing.JLabel userFirstname;
    private javax.swing.JLabel userLogin;
    private javax.swing.JLabel userSurname;
    // End of variables declaration//GEN-END:variables
}
