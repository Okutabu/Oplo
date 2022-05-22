/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panel;

import controller.OpenProfileController;
import java.util.ArrayList;
import model.utility.UserAndSkills;

/**
 *
 * @author gaeta
 */
public class Employee extends javax.swing.JPanel {

    private UserAndSkills user;
    /**
     * Creates new form Employee
     * @param u
     */
    public Employee(UserAndSkills u) {
        this.user = u;
        initComponents();
        initialize();
    }
    
    private void initialize(){
        UserAndSkills utilisateur = getUser();
        String name = utilisateur.getName();
        String login = utilisateur.getLogin();
        ArrayList<String> competences = utilisateur.getCompetences();
        
        names.setText(login + " - " + name + " (" + user.getNbProjets() + ")");
        
        for(String competence:competences){
            skills.setText(skills.getText() + competence + "\n");
        }
        
        //ajout mouseListeners
        this.addMouseListener(new OpenProfileController(login));
        skills.addMouseListener(new OpenProfileController(login));
    }

    private UserAndSkills getUser() {
        return this.user;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        names = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        skills = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(40, 40, 46));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        names.setForeground(new java.awt.Color(255, 255, 255));
        names.setText("nom prénom + nbProjet");
        names.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                namesMouseClicked(evt);
            }
        });

        skills.setEditable(false);
        skills.setBackground(new java.awt.Color(45, 45, 52));
        skills.setColumns(14);
        skills.setForeground(new java.awt.Color(255, 255, 255));
        skills.setRows(3);
        skills.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        skills.setOpaque(false);
        skills.setSelectionColor(new java.awt.Color(45, 45, 52));
        skills.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                skillsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(skills);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(names, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(names, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void namesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_namesMouseClicked
       
    }//GEN-LAST:event_namesMouseClicked

    private void skillsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skillsMouseClicked
        
    }//GEN-LAST:event_skillsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel names;
    private javax.swing.JTextArea skills;
    // End of variables declaration//GEN-END:variables
}
