/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.internal.AddProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
/**
 *
 * @author Clément
 */
public class RemoveHumanNeedController implements ActionListener
{
    private AddProject view;
    private CreateProjectModel model;
    
    public RemoveHumanNeedController(AddProject view, CreateProjectModel model)
    {
        this.view = view;
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
       model.removeHumanNeed(view.getSkillSelected(), view.getHumanNeedNumber());
       model.refreshHumanNeedsArea();
    }
    
}
