/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Set;
import model.utility.ServerCommunication;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author gaeta
 */
public class Skills {
    /**
     * This method grabs every name from the competence table of the database
     * @return an array of string
     */
    
    public static ArrayList<String> loadSkillList()
    {
        ServerCommunication s = new ServerCommunication();
        String res = s.sendGetRequest("retrieveAllCompetence=true");
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;         
        
        ArrayList<String> competences = new ArrayList<String>();
        
        try{
            for(Object object:jsonArray)
            {
                if(object instanceof JSONObject)
                {
                    JSONObject jsonObject = (JSONObject)object;

                    Set<String> keys =jsonObject.keySet();

                    for(String key:keys)
                    {
                       competences.add(key);
                    }               
                }
            }
        }
        catch(NullPointerException e){
            competences.add("erreur de chargement");
        }
        return competences;
    }
}
