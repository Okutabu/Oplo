/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

import controller.*;
import model.*;
/**
 *
 * @author Clément
 */
public class RemoveUserBtn extends JLabel {

    private String userLogin;
    private ManageProjectModel model;
    
    public RemoveUserBtn(String text, String userLogin, ManageProjectModel model)
    {
        super(text);
        this.userLogin = userLogin;
        this.addMouseListener(new RemoveUserFromProjectController(this, model));
        this.model = model;
    }
    
    public String getUserLogin()
    {
        return userLogin;
    }
}
