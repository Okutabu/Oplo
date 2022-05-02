/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.utility.Display;
import model.utility.ServerCommunication;
import model.utility.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import view.panel.ApproveUsersPanel;
import static view.Internal.HomeNavigationButtonsPanel.displayRightWindow;

/**
 *
 * @author gaeta
 */
public class displayAccountActionPerformed implements ActionListener {
    
    /**
     *
     * @param main
     */
    private JPanel main;
    
    public displayAccountActionPerformed(JPanel main) {
        this.main = main;
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        ServerCommunication s = new ServerCommunication();

        String res = s.sendGetRequest("getNonApprovedAccount=true");
        
        Object o = JSONValue.parse(res);

        JSONArray jsonArray = (JSONArray) o;         
        
        JInternalFrame approveUsers = new JInternalFrame();
        approveUsers.setSize(main.getSize());
        approveUsers.setLayout(new GridLayout(5, 1, 5, 5));
        Display.removeBorders(approveUsers);
        approveUsers.getContentPane().setBackground(new Color(35, 35, 40));
   
        JPanel infoPanel = new JPanel(new FlowLayout());
        infoPanel.setBackground(new Color(35, 35, 40));
        
        JLabel title = new JLabel("Approuver les comptes des utilisateurs");
        title.setFont(new Font("Verdana", Font.PLAIN, 24));
        title.setForeground(Color.WHITE);
        infoPanel.add(title);
        
        //on ajoute le paneau d'explication
        approveUsers.add(infoPanel);
        
        //on ajoute ensuite les comptes a approuver
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
                   //recuperation des infos
                   String firstname = newObj.get("firstname").toString();
                   String surname = newObj.get("surname").toString();
                   String login = newObj.get("login").toString();
                   String role = newObj.get("role").toString();
                   String admin = newObj.get("admin").toString();
                   String pp = newObj.get("profile_pic").toString();
                   String description = newObj.get("others").toString();
                   
                   User user = new User(login, firstname, surname, admin, role, description, pp);
                   
                   ApproveUsersPanel userPanel = new ApproveUsersPanel(user);
                   //ajout au jpanel
                   approveUsers.add(userPanel);
                }               
            }
        }
        //on ajoute le panel a l'internal frame
        displayRightWindow(approveUsers);
    }
}
