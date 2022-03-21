/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.utility.*;
import view.Internal.*;
import view.*;
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
    
}
