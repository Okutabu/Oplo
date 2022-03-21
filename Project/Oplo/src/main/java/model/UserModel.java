
package model;

import javax.swing.JFrame;
import model.utility.ServerCommunication;
import model.utility.UserConnected;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import view.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Clément
 */
public class UserModel {
   
    public static void connect(ConnexionPanel view)
    {
        /**
         * Traite la connexion
         */
        ServerCommunication s = new ServerCommunication();
        
        String c = s.sendPostRequest("https://oplo.000webhostapp.com/", "login=" + view.inputLogin.getText() + "&password=" + String.valueOf(view.inputPassword.getPassword()));
        Object o = JSONValue.parse(c);
        JSONObject connectionInfos = (JSONObject) o;
        
        if (connectionInfos.containsKey("error")){
            view.infoConnect.setText((String) connectionInfos.get("error"));
        } else {
            //Met a jour la classe User avec les infos de l'utilisateur, sorte de cache pour la session
            String login = view.inputLogin.getText();
            String prenom = (String) connectionInfos.get("firstname");
            String nom = (String) connectionInfos.get("surname");
            String admin = String.valueOf(connectionInfos.get("admin"));
            String role = (String) connectionInfos.get("role");
            String description = (String) connectionInfos.get("others");
            String photo = (String) connectionInfos.get("profile_pic");
            UserConnected myUser = new UserConnected(login, prenom, nom, admin, role, description, photo);
            //enregistre le login si la case esst cochée
            if (view.remember.isSelected()){
                myUser.saveCredentials();
            } else {
                myUser.destroyCredentials();
            }
            Home menu = new Home(myUser);
            view.setVisible(false);
            menu.setLocation(0,0);
            menu.setVisible(true);
            menu.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            
        }
    }
    
}
