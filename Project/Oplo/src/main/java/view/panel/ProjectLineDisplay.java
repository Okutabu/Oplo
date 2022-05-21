/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panel;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import model.utility.Project;
import static view.internal.HomeNavigationButtonsPanel.displayRightWindow;
import view.internal.ProjectView;

/**
 *
 * @author gaeta
 */
public class ProjectLineDisplay extends JPanel {

    private Project projet;
    /**
     * Creates new form ApproveUsersPanel
     * @param projet
     */
    public ProjectLineDisplay(Project projet) {
        initComponents();
        this.projet = projet;
        stylise();
        initialize();
    }
    
    private void stylise() {
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        
    }
    
    private void initialize() {
        Project p = getProjet();
        titre.setText(p.getName());
        endDate.setText(p.getEnd_date());
        startDate.setText(p.getStart_date());
        createur.setText(p.getCreator_login());
        desc.setText(p.getDescription());
        
        //quand on clique sur le projet ca nous envoie ou il faut
    }
    
    public Project getProjet() {
        return this.projet;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titre = new javax.swing.JLabel();
        startDate = new javax.swing.JLabel();
        endDate = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        createur = new javax.swing.JLabel();
        desc = new javax.swing.JLabel();

        setBackground(new java.awt.Color(35, 35, 40));
        setForeground(new java.awt.Color(35, 35, 40));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(1250, 67));
        setPreferredSize(new java.awt.Dimension(1250, 67));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        titre.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        titre.setForeground(new java.awt.Color(255, 255, 255));
        titre.setText("Nom");

        startDate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        startDate.setForeground(new java.awt.Color(255, 255, 255));
        startDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startDate.setText("Start_date");

        endDate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        endDate.setForeground(new java.awt.Color(255, 255, 255));
        endDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        endDate.setText("End_date");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("-");

        createur.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        createur.setForeground(new java.awt.Color(9, 184, 255));
        createur.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        createur.setText("Créateur");

        desc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        desc.setForeground(new java.awt.Color(255, 255, 255));
        desc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        desc.setText("Description");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createur, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titre)
                    .addComponent(startDate)
                    .addComponent(endDate)
                    .addComponent(jLabel9)
                    .addComponent(createur, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desc))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        ProjectView p = new ProjectView(titre.getText());
        displayRightWindow(p);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel createur;
    private javax.swing.JLabel desc;
    private javax.swing.JLabel endDate;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel startDate;
    private javax.swing.JLabel titre;
    // End of variables declaration//GEN-END:variables
}
