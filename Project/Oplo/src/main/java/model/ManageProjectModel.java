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
    private String creatorName;
    
    public ManageProjectModel(ProjectView view, String projectName)
    {
        this.view = view;
        this.projectName = projectName;
        
        ServerCommunication s = new ServerCommunication();
        this.creatorName = s.sendPostRequest("retrieveCreatorName=true&projectName=" + projectName);
    }
    
    public void SendNews()
    {
        String newsContent = view.getNewsInput();
        
        ServerCommunication s = new ServerCommunication();
        s.sendPostRequest("sendProjectNews&projectName=" + projectName.toString() + "&newsContent=" + newsContent);
        
        view.setNewsInput("");
        view.retrieveNews();
    }
    
    public String getProjectName()
    {
        return projectName;
    }
    
    public String getCreator()
    {
        return creatorName;
    }
    
    public void createNewTask(String taskName)
    {
        ServerCommunication s = new ServerCommunication();
        s.sendPostRequest("newTask=true&taskName=" + taskName + "&projectName=" + projectName);
        view.retrieveToDoList();
    }
    
    public void changeTaskStatus(int state, String taskName)
    {
        ServerCommunication s = new ServerCommunication();
        s.sendPostRequest("changeTodoState=true&state=" + Integer.toString(state) + "&todoName=" + taskName + "&projectName=" + projectName);
    }
    
    public void sendMessage(String msgContent, String login)
    {
        ServerCommunication s = new ServerCommunication();
        System.out.println(s.sendPostRequest("messageContent=" + msgContent + "&login=" + login + "&projectName=" + projectName));
        view.retrieveMessages();
    }
    
    public void removeUser(String login)
    {
        ServerCommunication s = new ServerCommunication();
        System.out.println(s.sendPostRequest("removeUserFromProject=true&projectName=" + projectName + "&login=" + login));
        System.out.println("removeUserFromProject=true&projectName=" + projectName + "&login=" + login);
        view.retrieveMembersList();
    }
}
