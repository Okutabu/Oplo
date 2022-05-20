/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UserModel;

import view.internal.*;
/**
 *
 * @author Clément
 */
public class ChangePasswordBtnController implements ActionListener {

    private ModifyProfile view;    
    
    public ChangePasswordBtnController(ModifyProfile view)
    {
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        UserModel.changePassword(view.getNewPasswordValue());
        view.setNewPasswordValue("");
    }
    
}
