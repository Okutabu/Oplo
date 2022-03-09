/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package internalFrames;

import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Okutabu
 */
public class JInternalFrameControlPanel extends javax.swing.JInternalFrame {

    private javax.swing.JDesktopPane main;
    /**
     * Creates new form JInternalFrameControlPanel
     * @param affichage_elts
     */
    
    public JInternalFrameControlPanel(javax.swing.JDesktopPane affichage_elts) {
        main = affichage_elts;
        initComponents();
    }
    
    public javax.swing.JDesktopPane getMain(){
        return main;
    }
    
    public void displayRightWindow(javax.swing.JInternalFrame f){
        BasicInternalFrameUI bi = (BasicInternalFrameUI)f.getUI();
        bi.setNorthPane(null);
        main.removeAll();
        main.add(f).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

<<<<<<< Updated upstream
        homeOpenPanelButton = new javax.swing.JButton();
        addProjectOpenPanelButton = new javax.swing.JButton();
        approveAccountOpenPanelButton = new javax.swing.JButton();
        showProfileButton = new javax.swing.JButton();

        setBorder(new javax.swing.border.MatteBorder(null));

        homeOpenPanelButton.setText("Accueil");
        homeOpenPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeOpenPanelButtonActionPerformed(evt);
            }
        });

        addProjectOpenPanelButton.setText("Ajouter un projet");
        addProjectOpenPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProjectOpenPanelButtonActionPerformed(evt);
            }
        });

        approveAccountOpenPanelButton.setText("Approuver comptes");
        approveAccountOpenPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveAccountOpenPanelButtonActionPerformed(evt);
            }
        });

        showProfileButton.setText("Profil");
        showProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showProfileButtonActionPerformed(evt);
=======
        displayHomepage = new javax.swing.JButton();
        displayAddProject = new javax.swing.JButton();
        displayAccountApprove = new javax.swing.JButton();
        displayProfile = new javax.swing.JButton();

        setBorder(new javax.swing.border.MatteBorder(null));

        displayHomepage.setText("Accueil");
        displayHomepage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayHomepageActionPerformed(evt);
            }
        });

        displayAddProject.setText("Ajouter un projet");
        displayAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAddProjectActionPerformed(evt);
            }
        });

        displayAccountApprove.setText("Approuver comptes");
        displayAccountApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAccountApproveActionPerformed(evt);
            }
        });

        displayProfile.setText("Profil");
        displayProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayProfileActionPerformed(evt);
>>>>>>> Stashed changes
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< Updated upstream
                    .addComponent(homeOpenPanelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addProjectOpenPanelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(approveAccountOpenPanelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showProfileButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
=======
                    .addComponent(displayHomepage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayAddProject, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(displayAccountApprove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
>>>>>>> Stashed changes
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
<<<<<<< Updated upstream
                .addComponent(homeOpenPanelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addProjectOpenPanelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(approveAccountOpenPanelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showProfileButton)
=======
                .addComponent(displayHomepage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayAddProject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayAccountApprove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayProfile)
>>>>>>> Stashed changes
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

<<<<<<< Updated upstream
    private void homeOpenPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeOpenPanelButtonActionPerformed
        // TODO add your handling code here:
        switchToHome();
    }//GEN-LAST:event_homeOpenPanelButtonActionPerformed

    private void addProjectOpenPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProjectOpenPanelButtonActionPerformed
        // TODO add your handling code here:
        AddProject addProjectPanel = new AddProject();
        main.removeAll();
        main.add(addProjectPanel).setVisible(true);
    }//GEN-LAST:event_addProjectOpenPanelButtonActionPerformed

    private void approveAccountOpenPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveAccountOpenPanelButtonActionPerformed
        // TODO add your handling code here:
        AccountApprove approveAccountPanel = new AccountApprove();
        main.removeAll();
        main.add(approveAccountPanel).setVisible(true);
    }//GEN-LAST:event_approveAccountOpenPanelButtonActionPerformed

    private void showProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showProfileButtonActionPerformed
        // TODO add your handling code here:
        Profile profilePanel = new Profile();
        main.removeAll();
        main.add(profilePanel).setVisible(true);
    }//GEN-LAST:event_showProfileButtonActionPerformed
=======
    private void displayHomepageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayHomepageActionPerformed
        Homepage home = new Homepage();
        displayRightWindow(home);
    }//GEN-LAST:event_displayHomepageActionPerformed

    private void displayAccountApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAccountApproveActionPerformed
        AccountApprove a = new AccountApprove();
        displayRightWindow(a);
    }//GEN-LAST:event_displayAccountApproveActionPerformed

    private void displayAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAddProjectActionPerformed
        AddProject a = new AddProject();
        displayRightWindow(a);
    }//GEN-LAST:event_displayAddProjectActionPerformed

    private void displayProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayProfileActionPerformed
        Profile profile = new Profile();
        displayRightWindow(profile);
    }//GEN-LAST:event_displayProfileActionPerformed
>>>>>>> Stashed changes

    private void switchToHome()
    {
        main.removeAll();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
<<<<<<< Updated upstream
    private javax.swing.JButton addProjectOpenPanelButton;
    private javax.swing.JButton approveAccountOpenPanelButton;
    private javax.swing.JButton homeOpenPanelButton;
    private javax.swing.JButton showProfileButton;
=======
    private javax.swing.JButton displayAccountApprove;
    private javax.swing.JButton displayAddProject;
    private javax.swing.JButton displayHomepage;
    private javax.swing.JButton displayProfile;
>>>>>>> Stashed changes
    // End of variables declaration//GEN-END:variables
}
