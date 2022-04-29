/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.Internal.*;
/**
 *
 * @author Clément
 */
public class AddHumanNeedController implements ActionListener
{
    private AddProject view;
    private ProjectModel model;
    
    public AddHumanNeedController(AddProject view, ProjectModel model)
    {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
       model.addHumanNeed(view.getSkillSelected(), view.getHumanNeedNumber());
       model.refreshHumanNeedsArea();
    }
    
}
