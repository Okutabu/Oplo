/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Set;
import model.utility.Project;
import model.utility.ServerCommunication;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import view.internal.AffectPersonal;

/**
 *
 * @author gaeta
 */
public class SearchSkillMouseListener implements MouseListener {
    
    private AffectPersonal vue;
    private String skillSearched;

    public SearchSkillMouseListener(AffectPersonal aThis, String skill) {
        this.vue = aThis;
        this.skillSearched = skill;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ServerCommunication s = new ServerCommunication();

        String res = s.sendGetRequest("projectFromNeed=true&competence=" + getSkill());
        
        Object o = JSONValue.parse(res);

        JSONArray jsonArray = (JSONArray) o;         
        
        
        ArrayList<Project> projects = new ArrayList<Project>();

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
                   
                   String name = (String) newObj.get("name");
                   String description = (String) newObj.get("description");
                   String start_date = (String) newObj.get("start_date");
                   String end_date = (String) newObj.get("end_date");
                   String creator_login = (String) newObj.get("creator_login");
                   
                   //ajouter liste compétences pour y ajouter a la place de "yo"
                   
                   
                   Project projet = new Project(name, description, start_date, end_date, creator_login, "yo");
                   projects.add(projet);
                }               
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    public String getSkill() {
        return this.skillSearched;
    }
    
    public AffectPersonal getVue() {
        return this.vue;
    }
    
}
