/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import view.AssociateProjectXMember;

/**
 *
 * @author gaeta
 */
public class addMemberToProjectController extends MouseAdapter {
    
    private JPanel container;
    
    public addMemberToProjectController(JPanel container) {
        this.container = container;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        new AssociateProjectXMember().setVisible(true);
    }
}
