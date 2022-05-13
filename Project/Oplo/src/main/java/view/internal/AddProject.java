/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.internal;

import java.awt.Color;
import model.*;
import controller.*;
/**
 *
 * @author Mélanie
 */
public class AddProject extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddProject
     */
    private CreateProjectModel model;
    
    public AddProject()
    {
        initComponents();
        this.getContentPane().setBackground(new Color(35,35,40));
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        model = new CreateProjectModel(this);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        addHumanNeed.addActionListener(new AddHumanNeedController(this, model));
        removeHumanNeed.addActionListener(new RemoveHumanNeedController(this, model));
    }
    
    public void setNeedsArea(String val)
    {
        humanNeedArea.setText(val);
    }
    
    public void setHumanNeedValue(int val)
    {
        humanNeedNumber.setValue(val);
    }
    
    public String getSkillSelected()
    {
        return skillSelector.getSelectedItem().toString();
    }
    
    public int getHumanNeedNumber()
    {
        return humanNeedNumber.getValue();
    }
    
    public String getProjectName()
    {
        return projectName.getText();
    }
    
    public String getDescription()
    {
        return projectDescription.getText();
    }
    
    public String getStartDate()
    {
        return startDate.getDate().toString();
    }
    
    public String getEndDate()
    {
        return endDate.getDate().toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jSpinField1 = new com.toedter.components.JSpinField();
        jDayChooser2 = new com.toedter.calendar.JDayChooser();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jTextField1 = new javax.swing.JTextField();
        jCalendar3 = new com.toedter.calendar.JCalendar();
        jScrollBar1 = new javax.swing.JScrollBar();
        titre = new javax.swing.JLabel();
        intituleProjet = new javax.swing.JLabel();
        projectName = new javax.swing.JTextField();
        startDate = new com.toedter.calendar.JDateChooser();
        datedebut = new javax.swing.JLabel();
        datefin = new javax.swing.JLabel();
        endDate = new com.toedter.calendar.JDateChooser();
        competence = new javax.swing.JPanel();
        Comp = new javax.swing.JLabel();
        skillSelector = new javax.swing.JComboBox<>();
        nbemployecomp = new javax.swing.JLabel();
        humanNeedNumber = new com.toedter.components.JSpinField();
        addHumanNeed = new javax.swing.JButton();
        removeHumanNeed = new javax.swing.JButton();
        createProjectButton = new javax.swing.JButton();
        errorResult = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectDescription = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        humanNeedsArea = new javax.swing.JScrollPane();
        humanNeedArea = new javax.swing.JTextArea();

        jTextField1.setText("jTextField1");

        setBackground(new java.awt.Color(35, 35, 40));
        setBorder(new javax.swing.border.MatteBorder(null));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        titre.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titre.setForeground(new java.awt.Color(255, 255, 255));
        titre.setText("Ajouter un projet ");

        intituleProjet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        intituleProjet.setForeground(new java.awt.Color(255, 255, 255));
        intituleProjet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        intituleProjet.setText("Saisir l'intitulé du projet : ");

        startDate.setDateFormatString("d/m/y");

        datedebut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        datedebut.setForeground(new java.awt.Color(255, 255, 255));
        datedebut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datedebut.setText("Date de début du projet : ");

        datefin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        datefin.setForeground(new java.awt.Color(255, 255, 255));
        datefin.setText("Date de fin de projet :");

        endDate.setDateFormatString("d/m/y");

        competence.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 0), 2, true));
        competence.setMaximumSize(new java.awt.Dimension(425, 85));
        competence.setPreferredSize(new java.awt.Dimension(425, 85));

        Comp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Comp.setText("Compétence :");

        skillSelector.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        skillSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Concepteur", "Designer", "Développeur" }));

        nbemployecomp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nbemployecomp.setText("Nombre d'employés :");

        humanNeedNumber.setMaximum(100);
        humanNeedNumber.setMinimum(1);
        humanNeedNumber.setValue(1);

        addHumanNeed.setBackground(new java.awt.Color(0, 204, 0));
        addHumanNeed.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addHumanNeed.setText("Ajouter ce besoin");
        addHumanNeed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        removeHumanNeed.setBackground(new java.awt.Color(255, 0, 51));
        removeHumanNeed.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        removeHumanNeed.setForeground(new java.awt.Color(255, 255, 255));
        removeHumanNeed.setText("Retirer ce besoin");

        javax.swing.GroupLayout competenceLayout = new javax.swing.GroupLayout(competence);
        competence.setLayout(competenceLayout);
        competenceLayout.setHorizontalGroup(
            competenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(competenceLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Comp, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(competenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skillSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeHumanNeed, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(competenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(competenceLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(nbemployecomp)
                        .addGap(31, 31, 31)
                        .addComponent(humanNeedNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(competenceLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(addHumanNeed)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        competenceLayout.setVerticalGroup(
            competenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(competenceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(competenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(competenceLayout.createSequentialGroup()
                        .addGroup(competenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(competenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(skillSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nbemployecomp))
                            .addComponent(Comp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(competenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addHumanNeed)
                            .addComponent(removeHumanNeed))
                        .addContainerGap())
                    .addGroup(competenceLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(humanNeedNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        createProjectButton.setText("Créer ce projet");
        createProjectButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createProjectButton.setMaximumSize(null);
        createProjectButton.setPreferredSize(null);
        createProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProjectButtonActionPerformed(evt);
            }
        });

        errorResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        projectDescription.setColumns(20);
        projectDescription.setRows(3);
        projectDescription.setTabSize(6);
        jScrollPane1.setViewportView(projectDescription);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Description :");

        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1731, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        humanNeedArea.setEditable(false);
        humanNeedArea.setColumns(20);
        humanNeedArea.setRows(5);
        humanNeedsArea.setViewportView(humanNeedArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1731, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 187, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(intituleProjet))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(projectName, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(datefin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datedebut))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorResult, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(competence, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(humanNeedsArea, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(632, 632, 632))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(titre)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(errorResult))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(intituleProjet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(projectName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(datedebut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(datefin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(competence, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(humanNeedsArea, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(createProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProjectButtonActionPerformed
        model.CreateProject();// TODO add your handling code here:
    }//GEN-LAST:event_createProjectButtonActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Comp;
    private javax.swing.JButton addHumanNeed;
    private javax.swing.JPanel competence;
    private javax.swing.JButton createProjectButton;
    private javax.swing.JLabel datedebut;
    private javax.swing.JLabel datefin;
    public com.toedter.calendar.JDateChooser endDate;
    public javax.swing.JLabel errorResult;
    private javax.swing.JTextArea humanNeedArea;
    private com.toedter.components.JSpinField humanNeedNumber;
    private javax.swing.JScrollPane humanNeedsArea;
    private javax.swing.JLabel intituleProjet;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JCalendar jCalendar2;
    private com.toedter.calendar.JCalendar jCalendar3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private com.toedter.calendar.JDayChooser jDayChooser2;
    private javax.swing.JLabel jLabel1;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JLabel nbemployecomp;
    public javax.swing.JTextArea projectDescription;
    public javax.swing.JTextField projectName;
    private javax.swing.JButton removeHumanNeed;
    private javax.swing.JComboBox<String> skillSelector;
    public com.toedter.calendar.JDateChooser startDate;
    private javax.swing.JLabel titre;
    // End of variables declaration//GEN-END:variables
}
