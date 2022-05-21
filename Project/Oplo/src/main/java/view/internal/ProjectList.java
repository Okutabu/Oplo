/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.internal;

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
import model.utility.User;
import model.utility.UserConnected;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import view.Home;
import static view.internal.HomeNavigationButtonsPanel.displayRightWindow;
import view.panel.ApproveUserPanel;
import view.panel.ProjectLineDisplay;

/**
 *
 * @author gaeta
 */
public class ProjectList extends javax.swing.JInternalFrame {

    /**
     * Creates new form ApproveUsers
     */
    public ProjectList() {
        initComponents();
        Display.removeBorders(this);
        this.getContentPane().setBackground(new Color(35, 35, 40));
        initialize();
    }
    
    private void adjustFromPermission(String role) {
        
        if(!role.equals("Chef de projet"))
        {
            auteurBool.setVisible(false);
        }
    }
    
    private void initialize() {
        UserConnected user = Home.getUser();
        String role = user.getRole();
        
        adjustFromPermission(role);
        
        Image image = null;
        try {
            
            image = ImageIO.read(new File("src/main/java/resources/loupe2.png"));
            Image scaled = image.getScaledInstance(35, 35, Image.SCALE_DEFAULT);
            loupe.setIcon(new ImageIcon(scaled));
        } 
        catch (IOException e) {
        }
        
        search(false, "");
        
        
    }
    
    public void search(boolean onlyAuteur, String projectSearched) {
        UserConnected user = Home.getUser();
        int auteur = 0;
        if (onlyAuteur) auteur = 1;
        
        ServerCommunication s = new ServerCommunication();

        String res = s.sendPostRequest("retrieveProjectFromNamePattern=" + projectSearched + "&onlyAuthor=" + auteur + "&login=" + user.getLogin());
        System.out.print(res);
        Object o = JSONValue.parse(res);

        JSONArray jsonArray = (JSONArray) o;
        
        //création du panel pour mettre les projets
        JPanel innerPanel = new JPanel();
        innerPanel.setBorder(null);
        int nbProjects = jsonArray.size();
        if (nbProjects < 10) {
            innerPanel.setLayout(new GridLayout(9, 1, 5, 5));
        } else {
            innerPanel.setLayout(new GridLayout(jsonArray.size(), 1, 5, 5));
        }
        innerPanel.setBackground(new Color(35, 35, 40));
        
        for(Object object:jsonArray)
        {
            if(object instanceof JSONObject) 
            {
                JSONObject newObj = (JSONObject)object;

                //recuperation des infos
                String name = newObj.get("name").toString();
                String description = newObj.get("description").toString();
                String start_date = newObj.get("start_date").toString();
                String end_date = newObj.get("end_date").toString();
                String creator_login = newObj.get("creator_login").toString();

                Project projet = new Project(name, description, start_date, end_date, creator_login);

                ProjectLineDisplay p = new ProjectLineDisplay(projet);
                //ajout au jpanel
                innerPanel.add(p);         
            }
        }
        //ajout du panel dans le scrollPane
        projectsScrollPane.setViewportView(innerPanel);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        projectsScrollPane = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        searchBarProject = new javax.swing.JTextField();
        loupe = new javax.swing.JLabel();
        auteurBool = new javax.swing.JCheckBox();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mes projets");

        jPanel2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(1698, 5));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        projectsScrollPane.setBackground(new java.awt.Color(35, 35, 40));
        projectsScrollPane.setBorder(null);
        projectsScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        projectsScrollPane.setPreferredSize(new java.awt.Dimension(1698, 1073));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rechercher un projet");

        searchBarProject.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchBarProject.setPreferredSize(new java.awt.Dimension(54, 22));
        searchBarProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarProjectActionPerformed(evt);
            }
        });

        loupe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loupe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loupeMouseClicked(evt);
            }
        });

        auteurBool.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        auteurBool.setForeground(new java.awt.Color(255, 255, 255));
        auteurBool.setText("Seulement les projets dont je suis le créateur");
        auteurBool.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                auteurBoolStateChanged(evt);
            }
        });
        auteurBool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auteurBoolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1308, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(projectsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(auteurBool)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBarProject, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loupe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchBarProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(auteurBool))
                            .addComponent(loupe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(projectsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBarProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarProjectActionPerformed

    private void auteurBoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auteurBoolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_auteurBoolActionPerformed

    private void auteurBoolStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_auteurBoolStateChanged
        search(auteurBool.isSelected(), searchBarProject.getText());
    }//GEN-LAST:event_auteurBoolStateChanged

    private void loupeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loupeMouseClicked
        search(auteurBool.isSelected(), searchBarProject.getText());
    }//GEN-LAST:event_loupeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox auteurBool;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel loupe;
    private javax.swing.JScrollPane projectsScrollPane;
    private javax.swing.JTextField searchBarProject;
    // End of variables declaration//GEN-END:variables

}
