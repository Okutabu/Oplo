/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.*;

/**
 *
 * @author Clément
 */
public class TaskToggleController implements ActionListener 
{
    private CheckboxLinkedToTask checkbox;
    
    public TaskToggleController(CheckboxLinkedToTask checkbox)
    {
        this.checkbox = checkbox;
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
        checkbox.getModele().changeTaskStatus(state, checkbox.getTaskName());
    }
    
}
