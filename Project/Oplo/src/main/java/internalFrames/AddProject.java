/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalFrames;
import classes.*;
/**
 *
 * @author Mélanie
 */
public class AddProject extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddProject
     */
    public AddProject() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
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
        intitule = new javax.swing.JTextField();
        startProject = new com.toedter.calendar.JDateChooser();
        datedebut = new javax.swing.JLabel();
        datefin = new javax.swing.JLabel();
        endProject = new com.toedter.calendar.JDateChooser();
        nbEmploye = new com.toedter.components.JSpinField();
        jLabel2 = new javax.swing.JLabel();
        competence = new javax.swing.JPanel();
        Comp = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        nbemployecomp = new javax.swing.JLabel();
        nbemployecompetence = new com.toedter.components.JSpinField();
        addSkill = new javax.swing.JButton();
        createProjectButton = new javax.swing.JButton();
        errorResult = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setBorder(new javax.swing.border.MatteBorder(null));

        titre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titre.setForeground(new java.awt.Color(0, 204, 0));
        titre.setText("Ajouter un projet ");

        intituleProjet.setText("Saisir l'intitulé du projet : ");

        startProject.setDateFormatString("d/m/y");

        datedebut.setText("Date de début du projet : ");

        datefin.setText("Date de fin de projet :");

        endProject.setDateFormatString("d/m/y");

        nbEmploye.setMinimum(0);

        jLabel2.setText("Nombre d'employés souhaités pour le projet :");

        competence.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 0), 2, true));

        Comp.setText("Compétence :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Concepteur", "Designer", "Développeur" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        nbemployecomp.setText("Nombre d'employés :");

        addSkill.setBackground(new java.awt.Color(0, 204, 0));
        addSkill.setText("Ajouter une autre compétence nécessaire");

        javax.swing.GroupLayout competenceLayout = new javax.swing.GroupLayout(competence);
        competence.setLayout(competenceLayout);
        competenceLayout.setHorizontalGroup(
            competenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(competenceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Comp)
                .addGap(18, 18, 18)
                .addGroup(competenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(competenceLayout.createSequentialGroup()
                        .addComponent(addSkill)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(competenceLayout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nbemployecomp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nbemployecompetence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        competenceLayout.setVerticalGroup(
            competenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(competenceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(competenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nbemployecompetence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(competenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Comp)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nbemployecomp)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addSkill)
                .addContainerGap())
        );

        createProjectButton.setText("Creer ce projet");
        createProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProjectButtonActionPerformed(evt);
            }
        });

        errorResult.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(intituleProjet)
                                .addGap(18, 18, 18)
                                .addComponent(intitule, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nbEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(datedebut)
                                        .addComponent(datefin))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(endProject, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(startProject, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(competence, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(errorResult, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createProjectButton)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(intituleProjet)
                    .addComponent(intitule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datedebut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(endProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datefin))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(nbEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(competence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createProjectButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errorResult)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void createProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProjectButtonActionPerformed
        // TODO add your handling code here:
        CreateProject();
    }//GEN-LAST:event_createProjectButtonActionPerformed

    private void CreateProject()
    {
        String projectName = intitule.getText();
        String projectDescription = projectDescriptionInput.getText();
        String projectStartDate = startProject.getDateFormatString();
        String projectEndDate = endProject.getDateFormatString();
        String authorLogin = "clem";//User.getLogin();
        
        ServerCommunication s = new ServerCommunication();
        errorResult.setText(s.sendPostRequest("https://oplo.000webhostapp.com/", "name=" + projectName + "&description=" + projectDescription + "&start_date=" + projectStartDate + "&end_date=" + projectEndDate + "&creator_login=" + authorLogin));
    
        //Move on
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Comp;
    private javax.swing.JButton addSkill;
    private javax.swing.JPanel competence;
    private javax.swing.JButton createProjectButton;
    private javax.swing.JLabel datedebut;
    private javax.swing.JLabel datefin;
    private com.toedter.calendar.JDateChooser endProject;
    private javax.swing.JLabel errorResult;
    private javax.swing.JTextField intitule;
    private javax.swing.JLabel intituleProjet;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JCalendar jCalendar2;
    private com.toedter.calendar.JCalendar jCalendar3;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private com.toedter.calendar.JDayChooser jDayChooser2;
    private javax.swing.JLabel jLabel2;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JScrollBar jScrollBar1;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private com.toedter.components.JSpinField nbEmploye;
    private javax.swing.JLabel nbemployecomp;
    private com.toedter.components.JSpinField nbemployecompetence;
    private com.toedter.calendar.JDateChooser startProject;
    private javax.swing.JLabel titre;
    // End of variables declaration//GEN-END:variables
}
