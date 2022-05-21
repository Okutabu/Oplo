/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.internal.ApproveUsers;
import view.internal.HomeNavigationButtonsPanel;
import static view.internal.HomeNavigationButtonsPanel.displayRightWindow;

/**
 *
 * @author gaeta
 */
public class DisplayAccountApproveActionPerformed implements ActionListener {
    

    private HomeNavigationButtonsPanel button;
    
    public DisplayAccountApproveActionPerformed(HomeNavigationButtonsPanel button) {
        this.button = button;
    }
    
    private HomeNavigationButtonsPanel getButton() {
        return this.button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ApproveUsers approveUsers = new ApproveUsers(getButton());
        //on ajoute le panel a l'internal frame
        displayRightWindow(approveUsers);
    }
}
