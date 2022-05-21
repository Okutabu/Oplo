/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.internal;

import controller.SearchSkillMouseListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.utility.Display;
import model.utility.Project;
import model.utility.ServerCommunication;
import model.utility.UserAndSkills;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import view.panel.ProjectLineDisplay;

/**
 *
 * @author gaeta
 */
public class AffectPersonal extends javax.swing.JInternalFrame {

    /**
     * Creates new form AffectPersonal
     */
    public AffectPersonal() {
        initComponents();
        Display.removeBorders(this);
        this.getContentPane().setBackground(new Color(35,35,40));
        initialize();
    }
    
    private void initialize(){
        displayProjects.setLayout(new GridLayout(3, 2));
        
        Image image = null;
        try {
            
            image = ImageIO.read(new File("src/main/java/resources/loupe1.png"));
            Image scaled = image.getScaledInstance(35, 35, Image.SCALE_DEFAULT);
            loupe1.setIcon(new ImageIcon(scaled));
            
            image = ImageIO.read(new File("src/main/java/resources/loupe2.png"));
            scaled = image.getScaledInstance(35, 35, Image.SCALE_DEFAULT);
            loupe2.setIcon(new ImageIcon(scaled));
        } 
        catch (IOException e) {
        }
        
        loupe1.addMouseListener(new SearchSkillMouseListener(this, searchBarSkill.getText()));
        
        refreshEmployees();
    }
    
    private void refreshEmployees() {
        ServerCommunication s = new ServerCommunication();
        
        String res = s.sendGetRequest("allUsers");
        System.out.print(res);
        
        Object o = JSONValue.parse(res);

        JSONArray jsonArray = (JSONArray) o;
        
        for(Object object:jsonArray)
        {
            if(object instanceof JSONObject) 
            {
                JSONObject jsonObject = (JSONObject)object;

                Set<String> keys =jsonObject.keySet();
                
                for(String key:keys) 
                {

                    UserAndSkills user = new UserAndSkills();
                    
                    Object newJson = jsonObject.get(key);

                    JSONObject newObj = (JSONObject)newJson;

                    //recuperation des infos
                    String name = newObj.get("name").toString();
                    String description = newObj.get("description").toString();
                    String start_date = newObj.get("start_date").toString();
                    String end_date = newObj.get("end_date").toString();
                    String creator_login = newObj.get("creator_login").toString();

                    Project projet = new Project(name, description, start_date, end_date, creator_login);

                    ProjectLineDisplay p = new ProjectLineDisplay(projet);
                    //ajout au jpanel
                   

                }               
            }
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

        titre = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        displayProjects = new javax.swing.JPanel();
        orderBy = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchBarSkill = new javax.swing.JTextField();
        searchBarProject = new javax.swing.JTextField();
        loupe2 = new javax.swing.JLabel();
        displayPersonal = new javax.swing.JScrollPane();
        loupe1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(35, 35, 40));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(1320, 1080));

        titre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titre.setForeground(new java.awt.Color(255, 255, 255));
        titre.setText("Attribuer du personnel");

        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        displayProjects.setBackground(new java.awt.Color(70, 70, 100));
        displayProjects.setForeground(new java.awt.Color(70, 70, 100));

        javax.swing.GroupLayout displayProjectsLayout = new javax.swing.GroupLayout(displayProjects);
        displayProjects.setLayout(displayProjectsLayout);
        displayProjectsLayout.setHorizontalGroup(
            displayProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1074, Short.MAX_VALUE)
        );
        displayProjectsLayout.setVerticalGroup(
            displayProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );

        orderBy.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        orderBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trier par", "Date : plus récent d'abord", "Date : plus ancien d'abord", "Compétences : les + rares", "Compétences : le + de besoin", "Compétences : le - de besoin" }));
        orderBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderByActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rechercher une compétence");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rechercher un projet");

        searchBarSkill.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchBarSkill.setPreferredSize(new java.awt.Dimension(54, 22));
        searchBarSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarSkillActionPerformed(evt);
            }
        });

        searchBarProject.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchBarProject.setPreferredSize(new java.awt.Dimension(54, 22));
        searchBarProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarProjectActionPerformed(evt);
            }
        });

        loupe2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        displayPersonal.setBackground(new java.awt.Color(40, 40, 60));
        displayPersonal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        displayPersonal.setOpaque(false);

        loupe1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Employés disponibles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1308, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(orderBy, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBarSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loupe1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBarProject, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loupe2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(displayProjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(displayPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchBarProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchBarSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(orderBy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loupe1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(displayPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(displayProjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(243, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loupe2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {searchBarProject, searchBarSkill});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderByActionPerformed

    private void searchBarSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarSkillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarSkillActionPerformed

    private void searchBarProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarProjectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane displayPersonal;
    private javax.swing.JPanel displayProjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loupe1;
    private javax.swing.JLabel loupe2;
    private javax.swing.JComboBox<String> orderBy;
    private javax.swing.JTextField searchBarProject;
    private javax.swing.JTextField searchBarSkill;
    private javax.swing.JLabel titre;
    // End of variables declaration//GEN-END:variables
}
