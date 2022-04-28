/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.Internal;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import model.utility.UserConnected;
import model.utility.Display;
import javax.swing.ImageIcon;
import view.*;

/**
 *
 * @author Okutabu
 */
public class HomeUserInfo extends javax.swing.JInternalFrame
{
    public HomeUserInfo()
    {
        initComponents();
        this.getContentPane().setBackground(new Color(102, 102, 102));
        Display.removeBorders(this);
        initDisplayDataUser();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstname = new javax.swing.JLabel();
        surname = new javax.swing.JLabel();
        pp = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(210, 312));

        firstname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstname.setForeground(new java.awt.Color(255, 255, 255));

        surname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surname.setForeground(new java.awt.Color(255, 255, 255));

        pp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pp, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(firstname, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(surname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pp, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {firstname, surname});

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void initDisplayDataUser()
    {
        UserConnected user = Home.getUser();
        user.getProfile_pic();
        firstname.setText(user.getFirstname());
        surname.setText(user.getSurname());
        
        Image image = null;/* w  ww .  ja  v  a 2 s.c o m*/
        try {
            URL url = new URL("https://oplo.000webhostapp.com/resources/profiles/pictures/" + Home.getUser().getProfile_pic());
            image = ImageIO.read(url);
            Image scaled = image.getScaledInstance(225, 175, Image.SCALE_DEFAULT);
            pp.setIcon(new ImageIcon(scaled));
        } 
        catch (IOException e) {

        }
        
        Color colorBorder = user.getColor();
        this.setBorder(BorderFactory.createLineBorder(colorBorder, 2, true));
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel firstname;
    private javax.swing.JLabel pp;
    private javax.swing.JLabel surname;
    // End of variables declaration//GEN-END:variables
}
