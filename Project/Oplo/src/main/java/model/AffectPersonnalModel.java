/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.utility.ServerCommunication;

/**
 *
 * @author gaeta
 */
public class AffectPersonnalModel {
    public String AffectPersonnal(String titre, String login) {
        ServerCommunication s = new ServerCommunication();
        
        String c = s.sendPostRequest("login=" + login + "&projectName=" + titre);

        return c;
        
    }
}