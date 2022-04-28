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

    private JPanel main;
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
    
    public void displayRightWindow(javax.swing.JInternalFrame f)
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
        displayAddProject = new javax.swing.JButton();
        displayAccountApprove = new javax.swing.JButton();
        displayProfile = new javax.swing.JButton();
        kButton2 = new com.k33ptoo.components.KButton();

        kButton1.setText("kButton1");

        setBorder(new javax.swing.border.MatteBorder(null));

        displayAddProject.setBackground(new java.awt.Color(102, 102, 102));
        displayAddProject.setText("Ajouter un projet");
        displayAddProject.setBorder(BorderFactory.createLineBorder(Home.getUser().getColor(), 2, true));
        displayAddProject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        displayAddProject.setOpaque(false);
        displayAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAddProjectActionPerformed(evt);
            }
        });

        displayAccountApprove.setBackground(new java.awt.Color(102, 102, 102));
        displayAccountApprove.setText("Approuver comptes");
        displayAccountApprove.setBorder(BorderFactory.createLineBorder(Home.getUser().getColor(), 2, true));
        displayAccountApprove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        displayAccountApprove.setOpaque(false);
        displayAccountApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAccountApproveActionPerformed(evt);
            }
        });

        displayProfile.setBackground(new java.awt.Color(102, 102, 102));
        displayProfile.setText("Profil");
        displayProfile.setBorder(BorderFactory.createLineBorder(Home.getUser().getColor(), 2, true));
        displayProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        displayProfile.setOpaque(false);
        displayProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayProfileActionPerformed(evt);
            }
        });

        kButton2.setBackground(new java.awt.Color(105, 105, 105));
        kButton2.setText("Accueil");
        kButton2.setkAllowGradient(false);
        kButton2.setkBackGroundColor(new java.awt.Color(105, 105, 105));
        kButton2.setkBorderRadius(0);
        kButton2.setkHoverColor(new java.awt.Color(150, 150, 150));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayAddProject, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayAccountApprove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(displayProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayAddProject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayAccountApprove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {displayAccountApprove, displayAddProject, displayProfile});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayAccountApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAccountApproveActionPerformed

        /////////////////////////////////////////////////////////////////////////////////////
        ServerCommunication s = new ServerCommunication();

        String res = s.sendGetRequest("https://oplo.000webhostapp.com/?getNonApprovedAccount=true");
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

    private void displayAddProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAddProjectActionPerformed
        AddProject a = new AddProject();
        displayRightWindow(a);
    }//GEN-LAST:event_displayAddProjectActionPerformed

    private void displayProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayProfileActionPerformed
        Profile profile = new Profile();
        displayRightWindow(profile);
    }//GEN-LAST:event_displayProfileActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton displayAccountApprove;
    private javax.swing.JButton displayAddProject;
    private javax.swing.JButton displayProfile;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    // End of variables declaration//GEN-END:variables


}