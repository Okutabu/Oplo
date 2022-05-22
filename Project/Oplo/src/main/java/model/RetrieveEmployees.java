/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JPanel;
import model.utility.ServerCommunication;
import model.utility.UserAndSkills;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import view.panel.Employee;

/**
 *
 * @author gaeta
 */
public class RetrieveEmployees {
    public ArrayList<UserAndSkills> retrieveEmployees() {
        ServerCommunication s = new ServerCommunication();
        
        String res = s.sendGetRequest("allUsers");

        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;
        
        ArrayList<UserAndSkills> users = new ArrayList<UserAndSkills>();
        
        for(Object object:jsonArray)
        {
            if(object instanceof JSONObject) 
            {
                JSONObject jsonObject = (JSONObject)object;

                Set<String> keys =jsonObject.keySet();
                
                for(String key:keys) 
                {
                    Object newJson = jsonObject.get(key);

                    JSONObject newObj = (JSONObject)newJson;

                    //recuperation des infos
                    String login = key;
                    String name = newObj.get("nom").toString();
                    String numberOfProject = newObj.get("numberOfProject").toString();
                    JSONArray competences = (JSONArray) newObj.get("competence");

                    ArrayList<String> skills = new ArrayList<String>();
                    for(Object newKey:competences) 
                    {
                        skills.add(newKey.toString());
                    }

                    UserAndSkills user = new UserAndSkills(login, name, skills, Integer.parseInt(numberOfProject));
                    
                    users.add(user);
                   

                }               
            }
        }
        return users;
    }
}
