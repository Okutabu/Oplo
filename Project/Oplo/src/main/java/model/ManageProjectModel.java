/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import view.internal.ProjectView;
import model.utility.ServerCommunication;
/**
 *
 * @author Clément
 */
public class ManageProjectModel {
    
    private ProjectView view;
    
    private String projectName;
    
    public ManageProjectModel(ProjectView view, String projectName)
    {
        this.view = view;
        this.projectName = projectName;
    }
    
    public void SendNews()
    {
        String newsContent = view.getNewsInput();
        
        ServerCommunication s = new ServerCommunication();
        s.sendPostRequest("https://oplo.000webhostapp.com/", "sendProjectNews&projectName=" + projectName.toString() + "&newsContent=" + newsContent);
        
        view.setNewsInput("");
        view.retrieveNews();
    }
    
    public String getProjectName()
    {
        return projectName;
    }
}
