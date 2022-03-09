/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframes;

import classes.*;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
/**
 *
 * @author Ortav
 */
public class ConnexionPanel extends javax.swing.JFrame {

    /**
     * Creates new form ConnexionPanel
     */
    public ConnexionPanel() {
        initComponents();
        this.isRemembered();
    }
    
    public void connect(){
        /**
         * Traite la connexion
         */
        ServerCommunication s = new ServerCommunication();
        
        String c = s.sendPostRequest("https://oplo.000webhostapp.com/", "login=" + inputLogin.getText() + "&password=" + String.valueOf(inputPassword.getPassword()));
        Object o = JSONValue.parse(c);
        JSONObject connectionInfos = (JSONObject) o;
        
        if (connectionInfos.containsKey("error")){
            infoConnect.setText((String) connectionInfos.get("error"));
        } else {
            //Met a jour la classe User avec les infos de l'utilisateur, sorte de cache pour la session
            String login = inputLogin.getText();
            String prenom = (String) connectionInfos.get("firstname");
            String nom = (String) connectionInfos.get("surname");
            String admin = String.valueOf(connectionInfos.get("admin"));
            String role = (String) connectionInfos.get("role");
            String description = (String) connectionInfos.get("others");
            String photo = (String) connectionInfos.get("profile_pic");
            UserConnected myUser = new UserConnected(login, prenom, nom, admin, role, description, photo);
            //enregistre le login si la case esst cochée
            if (remember.isSelected()){
                myUser.saveCredentials();
            } else {
                myUser.destroyCredentials();
            }
            Home menu = new Home();
            this.setVisible(false);
            menu.setLocation(0,0);
            menu.setVisible(true);
            menu.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            
        }
    }
    
    public void isRemembered(){
        String display;
        if (UserConnected.getCredentials().equals("")){
            display = "Nom d'utilisateur";
        } else {
            display = UserConnected.getCredentials();
        }
        inputLogin.setText(display);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoConnect = new javax.swing.JLabel();
        connect = new javax.swing.JButton();
        inputLogin = new javax.swing.JTextField();
        inputPassword = new javax.swing.JPasswordField();
        justePourLeStyle = new javax.swing.JLabel();
        remember = new javax.swing.JCheckBox();
        inscrire = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Oplo : Connexion");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 255));
        setForeground(java.awt.Color.black);
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

        inputLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        inputLogin.setForeground(new java.awt.Color(128, 128, 128));
        inputLogin.setText("Nom d'utilisateur");
        inputLogin.setToolTipText("Entrez votre login d'Oplo");
        inputLogin.setActionCommand("<Not Set>");
        inputLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputLoginFocusLost(evt);
            }
        });
        inputLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputLoginMouseClicked(evt);
            }
        });
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

        inputPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputPassword.setText("Mot de passe");
        inputPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputPasswordFocusLost(evt);
            }
        });
        inputPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputPasswordMouseClicked(evt);
            }
        });
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

        remember.setSelected(true);
        remember.setText("Se souvenir de mon identifiant");

        inscrire.setText("Pas de compte ?");
        inscrire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscrireActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(infoConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(justePourLeStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(connect, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(377, Short.MAX_VALUE)
                .addComponent(remember, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(378, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inscrire, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(inscrire)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(inputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(remember)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(connect, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(justePourLeStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        pack();
        setLocationRelativeTo(null);
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

    private void inputLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputLoginMouseClicked

    }//GEN-LAST:event_inputLoginMouseClicked

    private void inputPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputPasswordMouseClicked

    }//GEN-LAST:event_inputPasswordMouseClicked

    private void inputLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputLoginFocusGained
        inputLogin.setBackground(new Color(255,255,255));
        inputLogin.setForeground(new Color(0,0,0));
        if (inputLogin.getText().equals("Nom d'utilisateur")){
            inputLogin.setText("");
        } 
    }//GEN-LAST:event_inputLoginFocusGained

    private void inputLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputLoginFocusLost
        if (inputLogin.getText().equals("") || inputLogin.getText().equals("Nom d'utilisateur")){ //au cas ou l'user reecrive nom d'utilisateur a la main
            inputLogin.setText("Nom d'utilisateur");
            inputLogin.setForeground(new Color(128,128,128));
            inputLogin.setBackground(new Color(255,255,255));
        } else {
            inputLogin.setBackground(new Color(128,255,128));
        }
    }//GEN-LAST:event_inputLoginFocusLost

    private void inputPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputPasswordFocusGained
        inputPassword.setBackground(new Color(255,255,255));
        inputPassword.setForeground(new Color(0,0,0));
        if (String.valueOf(inputPassword.getPassword()).equals("Mot de passe")){
            inputPassword.setText("");
        } 
    }//GEN-LAST:event_inputPasswordFocusGained

    private void inputPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputPasswordFocusLost
        if (String.valueOf(inputPassword.getPassword()).equals("")){ 
            inputPassword.setText("Mot de passe");
            inputPassword.setForeground(new Color(128,128,128));
            inputPassword.setBackground(new Color(255,255,255));
        } else {
            inputPassword.setBackground(new Color(128,255,128));
        }
    }//GEN-LAST:event_inputPasswordFocusLost

    private void inscrireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscrireActionPerformed
        Inscription ins = new Inscription();
        this.setVisible(false);
        ins.setVisible(true);
    }//GEN-LAST:event_inscrireActionPerformed

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
            @Override
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
    private javax.swing.JButton inscrire;
    private javax.swing.JLabel justePourLeStyle;
    private javax.swing.JCheckBox remember;
    // End of variables declaration//GEN-END:variables
}