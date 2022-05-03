/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.internal;

import java.awt.Color;
import view.*;
import model.utility.Display;
import java.io.File;
import model.UserModel;

/**
 *
 * @author gaeta
 */
public class Registration extends javax.swing.JInternalFrame {
    
    private javax.swing.JFrame parentTemp;
    /**
     * Creates new form Registration
     */
    public Registration(javax.swing.JFrame parent)
    {
        Display.removeBorders(this);
        initComponents();
        this.getContentPane().setBackground(new Color(35,35,40));
        this.parentTemp = parent;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        surname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inscription = new javax.swing.JToggleButton();
        infosInscription = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        others = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        profile = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        role = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        yes = new javax.swing.JRadioButton();
        no = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        skill1 = new javax.swing.JComboBox<>();
        skill2 = new javax.swing.JComboBox<>();
        skill3 = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(35, 35, 40));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setOpaque(true);

        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Identifiant*");

        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Mot de passe*");

        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Prénom*");

        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Nom*");

        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Bio");

        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });

        surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Inscription");

        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("*Champs obligatoires");

        inscription.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inscription.setText("M'inscrire");
        inscription.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscriptionActionPerformed(evt);
            }
        });

        infosInscription.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        infosInscription.setForeground(java.awt.Color.white);
        infosInscription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        others.setColumns(20);
        others.setRows(5);
        jScrollPane1.setViewportView(others);

        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("Photo de profil");

        profile.setSelected(true);
        profile.setText("Parcourir");
        profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });

        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Votre inscription sera soumise à validation auprès de votre responsable");

        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("Statut dans l'entreprise");

        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "Employé", "Chef de projet", "Responsable scientifique" }));

        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("Droits administrateur");
        jLabel11.setToolTipText("");

        admin.add(yes);
        yes.setForeground(java.awt.Color.white);
        yes.setText("Oui");
        yes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        admin.add(no);
        no.setForeground(java.awt.Color.white);
        no.setSelected(true);
        no.setText("Non");
        no.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });

        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText("Compétences");

        skill1.setMaximumRowCount(25);
        skill1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));
        skill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skill1ActionPerformed(evt);
            }
        });

        skill2.setMaximumRowCount(25);
        skill2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));
        skill2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skill2ActionPerformed(evt);
            }
        });

        skill3.setMaximumRowCount(25);
        skill3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));

        jToggleButton1.setText("Connexion");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(firstname, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(surname)
                                                .addComponent(login))
                                            .addGap(82, 82, 82)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel12))
                                            .addGap(77, 77, 77)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(role, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(yes)
                                                .addComponent(no)
                                                .addComponent(skill1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(skill2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(skill3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(397, 397, 397)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addComponent(inscription, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 431, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(infosInscription, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {no, role, skill1, skill2, skill3, yes});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jToggleButton1))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(yes))
                            .addComponent(password))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(no))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(skill1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(skill2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(skill3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profile)
                            .addComponent(jLabel9))
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel7)
                        .addGap(55, 55, 55))
                    .addComponent(inscription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(infosInscription, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {firstname, jLabel1, jLabel10, jLabel11, jLabel12, jLabel2, jLabel3, jLabel4, jLabel5, jLabel8, jLabel9, login, no, password, profile, role, skill1, skill2, skill3, surname, yes});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed

    private void surnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void inscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscriptionActionPerformed

        UserModel.register(this);
        
    }//GEN-LAST:event_inscriptionActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
       
        javax.swing.JFileChooser myJFileChooser = new javax.swing.JFileChooser();
        int response = myJFileChooser.showOpenDialog(null);
        
        if (response == myJFileChooser.APPROVE_OPTION)
        {
            File file = new File(myJFileChooser.getSelectedFile().getAbsolutePath());
            System.out.print(file);
        }
    }//GEN-LAST:event_profileActionPerformed

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noActionPerformed

    private void skill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skill1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skill1ActionPerformed

    private void skill2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skill2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skill2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.setVisible(false);
        this.parentTemp.setVisible(false);
        ConnexionPanel connect = new ConnexionPanel();
        connect.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup admin;
    public javax.swing.JTextField firstname;
    public javax.swing.JLabel infosInscription;
    private javax.swing.JToggleButton inscription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JTextField login;
    public javax.swing.JRadioButton no;
    public javax.swing.JTextArea others;
    public javax.swing.JPasswordField password;
    public javax.swing.JToggleButton profile;
    public javax.swing.JComboBox<String> role;
    private javax.swing.JComboBox<String> skill1;
    private javax.swing.JComboBox<String> skill2;
    private javax.swing.JComboBox<String> skill3;
    public javax.swing.JTextField surname;
    public javax.swing.JRadioButton yes;
    // End of variables declaration//GEN-END:variables
}
