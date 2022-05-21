/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panel;

import java.util.ArrayList;
import model.utility.ServerCommunication;
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
        ArrayList<String> competences = utilisateur.getCompetences();
        
        names.setText(name + " (" + user.getNbProjets() + ")");
        
        for(String competence:competences){
            skills.setText(skills.getText() + competence + "\n");
        }
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

        names.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        names.setForeground(new java.awt.Color(255, 255, 255));
        names.setText("nom prénom + nbProjet");

        skills.setEditable(false);
        skills.setBackground(new java.awt.Color(45, 45, 52));
        skills.setColumns(16);
        skills.setRows(4);
        skills.setOpaque(false);
        skills.setSelectionColor(new java.awt.Color(45, 45, 52));
        jScrollPane1.setViewportView(skills);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(names, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(names)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel names;
    private javax.swing.JTextArea skills;
    // End of variables declaration//GEN-END:variables
}
