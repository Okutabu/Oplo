/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.Internal;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import model.utility.Display;
import model.utility.ServerCommunication;
import model.utility.UserConnected;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import view.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

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
    }
    
    private void AdjustButtonFromPermission()
    {
        UserConnected user = Home.getUser();
        
        if(user.getAdmin() == false)
        {
            displayAccountApprove.setVisible(false);
        }
   
        if(!user.getRole().equals("Chef de projet") && !user.getRole().equals("Responsable scientifique"))
        {
            displayAddProject.setVisible(false);
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
        displayAccountApprove1 = new com.k33ptoo.components.KButton();

        kButton1.setText("kButton1");

        setBorder(new javax.swing.border.MatteBorder(null));

        displayHome.setBackground(new java.awt.Color(105, 105, 105));
        displayHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 184, 255), 2));
        displayHome.setText("Accueil");
        displayHome.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
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
        displayAddProject.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
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
        displayAccountApprove.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
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

        displayAccountApprove1.setBackground(new java.awt.Color(105, 105, 105));
        displayAccountApprove1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 184, 255), 2));
        displayAccountApprove1.setText("Profil");
        displayAccountApprove1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        displayAccountApprove1.setkAllowGradient(false);
        displayAccountApprove1.setkBackGroundColor(new java.awt.Color(105, 105, 105));
        displayAccountApprove1.setkBorderRadius(0);
        displayAccountApprove1.setkHoverColor(new java.awt.Color(150, 150, 150));
        displayAccountApprove1.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        displayAccountApprove1.setkSelectedColor(new java.awt.Color(0, 0, 0));
        displayAccountApprove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAccountApprove1ActionPerformed(evt);
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
                    .addComponent(displayAccountApprove1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayHome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayAccountApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayAccountApprove1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayHomeActionPerformed
        ProjectList p = new ProjectList();
        displayRightWindow(p);
    }//GEN-LAST:event_displayHomeActionPerformed

    private void displayAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAddProjectActionPerformed
        AddProject a = new AddProject();
        displayRightWindow(a);
    }//GEN-LAST:event_displayAddProjectActionPerformed

    private void displayAccountApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAccountApproveActionPerformed
        ServerCommunication s = new ServerCommunication();

        String res = s.sendGetRequest("getNonApprovedAccount=true");
                System.out.println(res);
        Object o = JSONValue.parse(res);

        JSONArray jsonArray = (JSONArray) o;         
        
        JInternalFrame approveUsers = new JInternalFrame();
        approveUsers.setOpaque(false);
        approveUsers.setSize(main.getSize());
        approveUsers.setLayout(new GridLayout(5, 1, 5, 5));
        Display.removeBorders(approveUsers);
   
        JPanel infoPanel = new JPanel(new FlowLayout());
        infoPanel.setOpaque(false);
        
        JLabel title = new JLabel("Approuver les comptes des utilisateurs");
        title.setFont(new Font("Courier", Font.PLAIN, 40)); 
        title.setVerticalAlignment(CENTER);
        title.setHorizontalAlignment(CENTER);
        infoPanel.add(title);
        
        //on ajoute le paneau d'explication
        approveUsers.add(infoPanel);
        
        //on ajoute ensuite les compte a approuver
        for(Object object:jsonArray)
        {
            if(object instanceof JSONObject) 
            {
                JSONObject jsonObject = (JSONObject)object;

                Set<String> keys =jsonObject.keySet();
                
                for(String key:keys) 
                {
                   System.out.println(key +" :: "+jsonObject.get(key));
                   Object newJson = jsonObject.get(key);

                   JSONObject newObj = (JSONObject)newJson;
                   ApproveUsersPanel userPanel = new ApproveUsersPanel();
                   userPanel.setFirstname(newObj.get("firstname").toString());
                   userPanel.setSurname(newObj.get("surname").toString());
                   userPanel.setLogin(newObj.get("login").toString());
                   
                   approveUsers.add(userPanel);
                }               
            }
        }
        
        
        //on ajoute le panel a l'internal frame
        displayRightWindow(approveUsers);
        
    }//GEN-LAST:event_displayAccountApproveActionPerformed

    private void displayAccountApprove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAccountApprove1ActionPerformed
        Profile p = new Profile();
        displayRightWindow(p);
    }//GEN-LAST:event_displayAccountApprove1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton displayAccountApprove;
    private com.k33ptoo.components.KButton displayAccountApprove1;
    private com.k33ptoo.components.KButton displayAddProject;
    private com.k33ptoo.components.KButton displayHome;
    private com.k33ptoo.components.KButton kButton1;
    // End of variables declaration//GEN-END:variables


}
