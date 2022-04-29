/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Set;
import javax.swing.JButton;
import model.utility.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import view.Internal.*;
import view.*;
import controller.*;
/**
 *
 * @author Clément
 */
public class ProjectModel 
{
    public static void CreateProject(AddProject source)
    {
        String projectName = source.intitule.getText();
        String projectDescription = source.projectDescriptionInput.getText();
        String projectStartDate = source.startProject.getDateFormatString();
        String projectEndDate = source.endProject.getDateFormatString();
        String authorLogin = Home.getUser().getLogin();
        
        ServerCommunication s = new ServerCommunication();
        source.errorResult.setText(s.sendPostRequest("https://oplo.000webhostapp.com/", "name=" + projectName + "&description=" + projectDescription + "&start_date=" + projectStartDate + "&end_date=" + projectEndDate + "&creator_login=" + authorLogin));
    
        //Move on
    }
    
    public static void InitializeProjectList(ProjectList source)
    {
        ServerCommunication s = new ServerCommunication();
        UserConnected user = Home.getUser();
        String res = s.sendGetRequest("retrieveProjects&login=" + user.getLogin());
        
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;         

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
                   JButton newBtn = new JButton(newObj.get("name").toString());
                   newBtn.addActionListener(new ProjectListBtnsController(newObj.get("name").toString()));
                   source.projectPanelList.add(newBtn);
                }               
            }
        }
    }
    
}
