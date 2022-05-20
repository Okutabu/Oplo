/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panel;

import java.util.ArrayList;
import model.utility.Project;
import model.utility.Skill;

/**
 *
 * @author gaeta
 */
public class miniProjectDisplayResponsable extends javax.swing.JPanel {

    private Project project;
    /**
     * Creates new form miniProjectDisplay
     * @param p
     */
    public miniProjectDisplayResponsable(Project p) {
        this.project = p;
        initComponents();
        initialize();
    }
    
    private void initialize() {
        title.setText(getProject().getName());
        beginDate.setText(getProject().getStart_date());
        finalDate.setText(getProject().getEnd_date());
        description.setText(getProject().getDescription());
        
        ArrayList<Skill> SkillsList = getProject().getCompetences();
        Skills.setText("");
        for(int i = 0 ; i < SkillsList.size() ; i++) {
            Skill skill = SkillsList.get(i);
            Skills.setText(Skills.getText() + String.valueOf(skill.getNb()) + "x " + skill.getNom() + "\n");
        }
        
        creator.setText(getProject().getCreator_login());
    }

    public Project getProject() {
        return this.project;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        beginDate = new javax.swing.JLabel();
        finalDate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Skills = new javax.swing.JTextArea();
        creator = new javax.swing.JLabel();

        setBackground(new java.awt.Color(70, 70, 100));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        title.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Titre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("-");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        beginDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        beginDate.setForeground(new java.awt.Color(255, 255, 255));
        beginDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        beginDate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        finalDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        finalDate.setForeground(new java.awt.Color(255, 255, 255));
        finalDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        finalDate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        description.setEditable(false);
        description.setBackground(new java.awt.Color(70, 70, 100));
        description.setColumns(20);
        description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        description.setForeground(new java.awt.Color(255, 255, 255));
        description.setLineWrap(true);
        description.setRows(3);
        description.setAutoscrolls(false);
        description.setBorder(null);
        description.setFocusable(false);
        description.setOpaque(false);
        description.setRequestFocusEnabled(false);
        description.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(description);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Compétences demandées");

        Skills.setEditable(false);
        Skills.setBackground(new java.awt.Color(70, 70, 100));
        Skills.setColumns(20);
        Skills.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Skills.setForeground(new java.awt.Color(255, 255, 255));
        Skills.setLineWrap(true);
        Skills.setRows(4);
        Skills.setAutoscrolls(false);
        Skills.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(9, 184, 255), 2));
        Skills.setFocusable(false);
        Skills.setOpaque(false);
        Skills.setRequestFocusEnabled(false);
        Skills.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(Skills);

        creator.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        creator.setForeground(new java.awt.Color(9, 184, 255));
        creator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        creator.setText("Créateur");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(creator, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(beginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {beginDate, finalDate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(beginDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(finalDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(creator, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Skills;
    private javax.swing.JLabel beginDate;
    private javax.swing.JLabel creator;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel finalDate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
