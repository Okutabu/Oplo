/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.internal;

import controller.DisplayAccountApproveActionPerformed;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import model.utility.Display;
import model.utility.UserConnected;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import model.utility.ServerCommunication;
import view.*;

/**
 *
 * @author Okutabu
 */
public class HomeNavigationButtonsPanel extends JInternalFrame {

    private static JPanel main;
    /**
     * Creates new form JInternalFrameControlPanel
     * @param affichage_elts
     */
    
    public HomeNavigationButtonsPanel(JPanel affichage_elts) {
        main = affichage_elts;
        Display.removeBorders(this);
        initComponents();
        this.getContentPane().setBackground(new Color(102, 102, 102));
        AdjustButtonFromPermission();//THIS FUNCTION MAKES VISIBLE OR NOT CERTAIN BUTTON FOLLOWING THE ROLE OF THE USER
        refreshApproveAccountNotifs();
        refreshProjectsNotifs();
        
        Cursor hand = new Cursor(Cursor.HAND_CURSOR);
                
        displayAccountApprove.setCursor(hand);
        displayAddProject.setCursor(hand);
        displayAssocierPersonnel.setCursor(hand);
        displayHome.setCursor(hand);
        profile.setCursor(hand);
        displayProjectList.setCursor(hand);
        
        //ajout d'un action listener sur approuver les comptes 
        displayAccountApprove.addActionListener(new DisplayAccountApproveActionPerformed(this));
    }
    
    private void AdjustButtonFromPermission()
    {
        UserConnected user = Home.getUser();
        String role = user.getRole();
        
        if(user.getAdmin() == false)
        {
            displayAccountApprove.setVisible(false);
        }
   
        if(!role.equals("Chef de projet"))
        {
            displayAddProject.setVisible(false);
        }
        
        if (!role.equals("Responsable scientifique")) {
            displayAssocierPersonnel.setVisible(false);
        }
    }
    
    public javax.swing.JPanel getMain()
    {
        return main;
    }
    
    public static void displayRightWindow(JInternalFrame f)
    {
        javax.swing.JInternalFrame window = Home.getCurrentWindow();
        window.setVisible(false);
        main.removeAll();
        Home.setCurrentWindow(f);
        main.add(f).setVisible(true);
    }
    
    //s'actualise a chaque approbation ou suppression de comptes non approuvés
    public void refreshApproveAccountNotifs() {
        
        ServerCommunication s = new ServerCommunication();
        
        int nbAccounts = Integer.parseInt(s.sendGetRequest("userNotApprovedNum=true"));
        
        displayAccountApprove.setText("Approuver les comptes");
        if (nbAccounts != 0) {
            displayAccountApprove.setText(displayAccountApprove.getText() + " (" + String.valueOf(nbAccounts) + ")");
            displayAccountApprove.setFont(new Font("Segoe UI Bold", Font.BOLD, 14));
        } else {
            displayAccountApprove.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        }
    }
    
    //s'actualise a chaque redemarrage du projet, pas besoin de plus
    public void refreshProjectsNotifs() {
        
        ServerCommunication s = new ServerCommunication();
        
        UserConnected user = Home.getUser();
        String login = user.getLogin();
        
        int nbProjects = Integer.parseInt(s.sendPostRequest("numberOfProjects=true&login=" + login));
        
        displayProjectList.setText("Mes projets");
        if (nbProjects != 0) {
            displayProjectList.setText(displayProjectList.getText() + " (" + String.valueOf(nbProjects) + ")");
            displayProjectList.setFont(new Font("Segoe UI Bold", Font.BOLD, 14));
        } else {
            displayProjectList.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
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

        kButton1 = new com.k33ptoo.components.KButton();
        displayHome = new com.k33ptoo.components.KButton();
        displayAddProject = new com.k33ptoo.components.KButton();
        displayAccountApprove = new com.k33ptoo.components.KButton();
        profile = new com.k33ptoo.components.KButton();
        displayAssocierPersonnel = new com.k33ptoo.components.KButton();
        displayProjectList = new com.k33ptoo.components.KButton();

        kButton1.setText("kButton1");

        setBorder(new javax.swing.border.MatteBorder(null));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        displayHome.setBackground(new java.awt.Color(105, 105, 105));
        displayHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 184, 255), 2));
        displayHome.setText("Accueil");
        displayHome.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        displayHome.setkAllowGradient(false);
        displayHome.setkBackGroundColor(new java.awt.Color(105, 105, 105));
        displayHome.setkBorderRadius(0);
        displayHome.setkHoverColor(new java.awt.Color(150, 150, 150));
        displayHome.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        displayHome.setkSelectedColor(new java.awt.Color(0, 0, 0));
        displayHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayHomeActionPerformed(evt);
            }
        });

        displayAddProject.setBackground(new java.awt.Color(105, 105, 105));
        displayAddProject.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 184, 255), 2));
        displayAddProject.setText("Ajouter un projet");
        displayAddProject.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        displayAddProject.setkAllowGradient(false);
        displayAddProject.setkBackGroundColor(new java.awt.Color(105, 105, 105));
        displayAddProject.setkBorderRadius(0);
        displayAddProject.setkHoverColor(new java.awt.Color(150, 150, 150));
        displayAddProject.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        displayAddProject.setkSelectedColor(new java.awt.Color(0, 0, 0));
        displayAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAddProjectActionPerformed(evt);
            }
        });

        displayAccountApprove.setBackground(new java.awt.Color(105, 105, 105));
        displayAccountApprove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 184, 255), 2));
        displayAccountApprove.setText("Approuver les comptes");
        displayAccountApprove.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        displayAccountApprove.setkAllowGradient(false);
        displayAccountApprove.setkBackGroundColor(new java.awt.Color(105, 105, 105));
        displayAccountApprove.setkBorderRadius(0);
        displayAccountApprove.setkHoverColor(new java.awt.Color(150, 150, 150));
        displayAccountApprove.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        displayAccountApprove.setkSelectedColor(new java.awt.Color(0, 0, 0));
        displayAccountApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAccountApproveActionPerformed(evt);
            }
        });

        profile.setBackground(new java.awt.Color(105, 105, 105));
        profile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 184, 255), 2));
        profile.setText("Profil");
        profile.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        profile.setkAllowGradient(false);
        profile.setkBackGroundColor(new java.awt.Color(105, 105, 105));
        profile.setkBorderRadius(0);
        profile.setkHoverColor(new java.awt.Color(150, 150, 150));
        profile.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        profile.setkSelectedColor(new java.awt.Color(0, 0, 0));
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });

        displayAssocierPersonnel.setBackground(new java.awt.Color(105, 105, 105));
        displayAssocierPersonnel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 184, 255), 2));
        displayAssocierPersonnel.setText("Gérer le personnel");
        displayAssocierPersonnel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        displayAssocierPersonnel.setkAllowGradient(false);
        displayAssocierPersonnel.setkBackGroundColor(new java.awt.Color(105, 105, 105));
        displayAssocierPersonnel.setkBorderRadius(0);
        displayAssocierPersonnel.setkHoverColor(new java.awt.Color(150, 150, 150));
        displayAssocierPersonnel.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        displayAssocierPersonnel.setkSelectedColor(new java.awt.Color(0, 0, 0));
        displayAssocierPersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAssocierPersonnelActionPerformed(evt);
            }
        });

        displayProjectList.setBackground(new java.awt.Color(105, 105, 105));
        displayProjectList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 184, 255), 2));
        displayProjectList.setText("Mes projets");
        displayProjectList.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        displayProjectList.setkAllowGradient(false);
        displayProjectList.setkBackGroundColor(new java.awt.Color(105, 105, 105));
        displayProjectList.setkBorderRadius(0);
        displayProjectList.setkHoverColor(new java.awt.Color(150, 150, 150));
        displayProjectList.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        displayProjectList.setkSelectedColor(new java.awt.Color(0, 0, 0));
        displayProjectList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayProjectListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayHome, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(displayAddProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayAccountApprove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayAssocierPersonnel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayProjectList, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayHome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayProjectList, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayAccountApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayAssocierPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayHomeActionPerformed
        Accueil p = new Accueil();
        displayRightWindow(p);
    }//GEN-LAST:event_displayHomeActionPerformed

    private void displayAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAddProjectActionPerformed
        AddProject a = new AddProject();
        displayRightWindow(a);
    }//GEN-LAST:event_displayAddProjectActionPerformed

    private void displayAccountApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAccountApproveActionPerformed
        
        
    }//GEN-LAST:event_displayAccountApproveActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        ModifyProfile p = new ModifyProfile();
        displayRightWindow(p);
    }//GEN-LAST:event_profileActionPerformed

    private void displayAssocierPersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAssocierPersonnelActionPerformed
        AffectPersonal a = new AffectPersonal();
        displayRightWindow(a);
    }//GEN-LAST:event_displayAssocierPersonnelActionPerformed

    private void displayProjectListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayProjectListActionPerformed
        ProjectList p = new ProjectList();
        displayRightWindow(p);
    }//GEN-LAST:event_displayProjectListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton displayAccountApprove;
    private com.k33ptoo.components.KButton displayAddProject;
    private com.k33ptoo.components.KButton displayAssocierPersonnel;
    private com.k33ptoo.components.KButton displayHome;
    private com.k33ptoo.components.KButton displayProjectList;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton profile;
    // End of variables declaration//GEN-END:variables


}
