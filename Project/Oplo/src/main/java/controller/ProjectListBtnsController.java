/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Internal.*;

/**
 *
 * @author Clément
 */
public class ProjectListBtnsController implements ActionListener{

    private String projectName;
    
    public ProjectListBtnsController(String name)
    {
        this.projectName = name;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       HomeNavigationButtonsPanel.displayRightWindow(new ProjectView());
    }
    
}
