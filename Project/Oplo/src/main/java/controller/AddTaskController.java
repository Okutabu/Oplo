/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.internal.*;
/**
 *
 * @author Clément
 */
public class AddTaskController implements ActionListener {

    private ManageProjectModel model;
    private ProjectView view;
    
    public AddTaskController(ManageProjectModel model, ProjectView view)
    {
        this.model = model;
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        model.createNewTask(view.getNewTaskInput());
    }
    
}
