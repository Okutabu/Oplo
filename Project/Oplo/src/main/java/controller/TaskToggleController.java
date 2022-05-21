/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

import view.*;
import model.*;
/**
 *
 * @author Clément
 */
public class TaskToggleController implements ActionListener 
{
    private JCheckBox checkbox;
    private ManageProjectModel model;
    
    public TaskToggleController(JCheckBox checkbox, ManageProjectModel model)
    {
        this.checkbox = checkbox;
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int state;
        
        if(checkbox.isSelected())
        {
            state = 1;
        }
        else
        {
            state = 0;
        }
        model.changeTaskStatus(state, checkbox.getText());
    }
    
}
