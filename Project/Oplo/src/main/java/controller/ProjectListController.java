/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.internal.ProjectView;
import view.internal.HomeNavigationButtonsPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 *
 * @author Clément
 */
public class ProjectListController extends MouseAdapter{

    private String projectName;
    
    public ProjectListController(String name)
    {
        this.projectName = name;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
       HomeNavigationButtonsPanel.displayRightWindow(new ProjectView(projectName));
    }
    
}
