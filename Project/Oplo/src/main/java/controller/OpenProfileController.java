/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.utility.ServerCommunication;
import model.utility.User;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import static view.internal.HomeNavigationButtonsPanel.displayRightWindow;
import view.internal.ProfileView;

/**
 *
 * @author gaeta
 */
public class OpenProfileController extends MouseAdapter {
    
    private String login;
    
    public OpenProfileController(String login) {
        this.login = login;
    }
    
    private String getLogin() {
        return this.login;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
       String login = getLogin();
        
        ServerCommunication s = new ServerCommunication();
        
        String c = s.sendPostRequest("retrieveUser=true&login=" + login);
        System.out.print(c);
        Object o = JSONValue.parse(c);
        JSONObject connectionInfos = (JSONObject) o;
        
        try
        {
            //Met a jour la classe User avec les infos de l'utilisateur, sorte de cache pour la session
            String prenom = (String) connectionInfos.get("firstname");
            String nom = (String) connectionInfos.get("surname");
            String admin = String.valueOf(connectionInfos.get("admin"));
            String role = (String) connectionInfos.get("role");
            String description = (String) connectionInfos.get("description");
            String photo = (String) connectionInfos.get("profile_pic");
            String approved = (String) connectionInfos.get("approved");
            
            boolean isApproved = true;
            if(approved.equals("0")) isApproved = false;
            
            User utilisateur = new User(login, prenom, nom, admin, role, description, photo, isApproved);
            
            ProfileView p = new ProfileView(utilisateur);
            displayRightWindow(p);
        } catch (Exception ex) {
            
        }
        
    }
     
}
