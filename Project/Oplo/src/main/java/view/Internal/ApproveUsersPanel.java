/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.Internal;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import model.UserModel;
import view.Home;

/**
 *
 * @author gaeta
 */
public class ApproveUsersPanel extends javax.swing.JPanel {

    /**
     * Creates new form ApproveUsersPanel
     * @param prenom
     * @param nom
     * @param login
     */
    public ApproveUsersPanel(String prenom, String nom, String login) {
        initComponents();
        setBackground(new Color(35,35,40));
        initialize(prenom, nom, login);
    }
    
    private void initialize(String prenom, String nom, String login) {
        
        //initialise la photo de profil
        Image image = null;
        try {
            URL url = new URL("https://oplo.000webhostapp.com/resources/profiles/pictures/" + Home.getUser().getProfile_pic());
            image = ImageIO.read(url);
            Image scaled = image.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
            profilePic.setIcon(new ImageIcon(scaled));
        } 
        catch (IOException e) {

        }
        
        //initialisation infos utilisateurs
        userLogin.setText(prenom);
        userFirstname.setText(nom);
        userSurname.setText(login);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        profilePic = new javax.swing.JLabel();
        userLogin = new javax.swing.JLabel();
        userFirstname = new javax.swing.JLabel();
        userSurname = new javax.swing.JLabel();
        approveUserButton = new com.k33ptoo.components.KButton();
        kButton1 = new com.k33ptoo.components.KButton();
        jPanel1 = new javax.swing.JPanel();

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Prénom :");

        setBackground(new java.awt.Color(35, 35, 40));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(9, 184, 255), 3, true));
        setForeground(new java.awt.Color(35, 35, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login :");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Prénom :");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nom :");

        userLogin.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        userLogin.setForeground(new java.awt.Color(255, 255, 255));
        userLogin.setText("login");

        userFirstname.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        userFirstname.setForeground(new java.awt.Color(255, 255, 255));
        userFirstname.setText("prenom");

        userSurname.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        userSurname.setForeground(new java.awt.Color(255, 255, 255));
        userSurname.setText("nom");

        approveUserButton.setForeground(new java.awt.Color(0, 0, 0));
        approveUserButton.setText("Approuver");
        approveUserButton.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        approveUserButton.setkBorderRadius(30);
        approveUserButton.setkStartColor(new java.awt.Color(0, 255, 0));
        approveUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveUserButtonActionPerformed(evt);
            }
        });

        kButton1.setForeground(new java.awt.Color(0, 0, 0));
        kButton1.setText("Supprimer");
        kButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        kButton1.setkBorderRadius(30);
        kButton1.setkEndColor(new java.awt.Color(255, 0, 0));
        kButton1.setkHoverStartColor(new java.awt.Color(204, 0, 0));
        kButton1.setkStartColor(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(approveUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(kButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {userFirstname, userLogin});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(approveUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userFirstname))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(userSurname))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 4, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, userFirstname, userSurname});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {approveUserButton, kButton1});

    }// </editor-fold>//GEN-END:initComponents

    private void approveUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveUserButtonActionPerformed
        UserModel.approveUser(this);
    }//GEN-LAST:event_approveUserButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton approveUserButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private com.k33ptoo.components.KButton kButton1;
    private javax.swing.JLabel profilePic;
    private javax.swing.JLabel userFirstname;
    public javax.swing.JLabel userLogin;
    private javax.swing.JLabel userSurname;
    // End of variables declaration//GEN-END:variables
}
