/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.test.oplo;

import java.awt.event.KeyEvent;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import javax.servlet.http.Cookie;
/**
 *
 * @author Clément
 */
public class ConnexionPanel extends javax.swing.JFrame {

    /**
     * Creates new form ConnexionPanel
     */
    public ConnexionPanel() {
        initComponents();
    }
    
    public void connect(){
        /**
         * Traite la connexion
         */
        ServerCommunication s = new ServerCommunication();
        
        String connect = s.sendPostRequest("https://oplo.000webhostapp.com/", "login=" + inputLogin.getText() + "&password=" + String.valueOf(inputPassword.getPassword()));
        Object o = JSONValue.parse(connect);
        JSONObject connectionInfos = (JSONObject) o;
        
        if (connectionInfos.containsKey("error")){
            infoConnect.setText((String) connectionInfos.get("error"));
        } else {
            String login = inputLogin.getText();
            String prenom = (String) connectionInfos.get("firstname");
            String nom = (String) connectionInfos.get("surname");
            String admin = String.valueOf(connectionInfos.get("admin"));
            String role = (String) connectionInfos.get("role");
            String description = (String) connectionInfos.get("others");
            String photo = (String) connectionInfos.get("profile_pic");
            User.initialize(login, prenom, nom, admin, role, description, photo);
            if (loginRemember.getSelection().isSelected()){
                User.saveCredentials();
            }
            Home menu = new Home();
            this.setVisible(false);
            menu.setLocation(this.getLocation());
            menu.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginRemember = new javax.swing.ButtonGroup();
        infoConnect = new javax.swing.JLabel();
        connect = new javax.swing.JButton();
        inputLogin = new javax.swing.JTextField();
        inputPassword = new javax.swing.JPasswordField();
        justePourLeStyle = new javax.swing.JLabel();
        remember = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 255));
        setForeground(java.awt.Color.cyan);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(960, 600));

        infoConnect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoConnect.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        connect.setText("Connexion");
        connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectActionPerformed(evt);
            }
        });

        inputLogin.setText("Nom d'utilisateur");
        inputLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputLoginActionPerformed(evt);
            }
        });
        inputLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputLoginKeyPressed(evt);
            }
        });

        inputPassword.setText("Mot de passe");
        inputPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPasswordActionPerformed(evt);
            }
        });
        inputPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputPasswordKeyPressed(evt);
            }
        });

        loginRemember.add(remember);
        remember.setText("Se souvenir de mon identifiant");
        remember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(infoConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(justePourLeStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(connect, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(228, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(remember)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(inputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(remember)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connect, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(justePourLeStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectActionPerformed
        connect();
    }//GEN-LAST:event_connectActionPerformed

    private void inputPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPasswordActionPerformed

    private void inputPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputPasswordKeyPressed
        /**
        * Si dans le champ mot de passe la touche entrée est préssée, la connexion se fait
        */
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            connect();
        }
    }//GEN-LAST:event_inputPasswordKeyPressed

    private void inputLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputLoginKeyPressed
        /**
        * Si dans le champ login la touche entrée est préssée, la connexion se fait
        */
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            connect();
        }
    }//GEN-LAST:event_inputLoginKeyPressed

    private void inputLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputLoginActionPerformed

    private void rememberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rememberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rememberActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
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
            java.util.logging.Logger.getLogger(ConnexionPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnexionPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnexionPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnexionPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnexionPanel().setVisible(true);
            }
        });
    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connect;
    private javax.swing.JLabel infoConnect;
    private javax.swing.JTextField inputLogin;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JLabel justePourLeStyle;
    private javax.swing.ButtonGroup loginRemember;
    private javax.swing.JRadioButton remember;
    // End of variables declaration//GEN-END:variables
}
