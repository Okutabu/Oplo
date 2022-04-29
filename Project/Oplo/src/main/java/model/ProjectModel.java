/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.utility.*;
import org.json.simple.JSONObject;
import view.Internal.*;
import view.*;
import java.util.Iterator;
/**
 *
 * @author Clément
 */
public class ProjectModel 
{
    private JSONObject humanNeed;
    private AddProject view;
    
    public ProjectModel(AddProject view)
    {
        this.humanNeed = new JSONObject();
        this.view = view;
    }
    
    public void CreateProject()
    {
        String projectName = view.getProjectName();
        String projectDescription = view.getDescription();
        String projectStartDate = view.getStartDate();
        String projectEndDate = view.getEndDate();
        String authorLogin = Home.getUser().getLogin();
        
        ServerCommunication s = new ServerCommunication();
        s.sendPostRequest("https://oplo.000webhostapp.com/", "name=" + projectName + "&description=" + projectDescription + "&start_date=" + projectStartDate + "&end_date=" + projectEndDate + "&creator_login=" + authorLogin);
        //Move on
    }
    
    public void addHumanNeed(String categorie, int number)
    {
        if(humanNeed.containsKey(categorie))
        {
            humanNeed.put(categorie, Integer.parseInt(humanNeed.get(categorie).toString()) + number);
        }
        else
        {
            humanNeed.put(categorie, number);
        }
    }
    
    public void removeHumanNeed(String categorie, int number)
    {
        if(humanNeed.containsKey(categorie))
        {
            int currentVal = Integer.parseInt(humanNeed.get(categorie).toString());
            if(currentVal >= number)
            {
                if((currentVal - number) == 0)
                {
                    humanNeed.remove(categorie);
                }
                else
                {
                   humanNeed.put(categorie, currentVal - number); 
                }
            }
        }
    }
    
    public void refreshHumanNeedsArea()
    {
        String res = "";
        
        JSONObject jsonObject = new JSONObject(humanNeed);
        Iterator<String> keys = jsonObject.keySet().iterator();
        
        while(keys.hasNext())
        {
            String key = keys.next();
            System.out.println(key);
            
            res += key;
            res += " x" + humanNeed.get(key) + "\n";
        }
        view.setNeedsArea(res);
        view.setHumanNeedValue(1);
    }
}
