/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.internal.ApproveUsers;
import static view.internal.HomeNavigationButtonsPanel.displayRightWindow;

/**
 *
 * @author gaeta
 */
public class displayAccountApproveActionPerformed implements ActionListener {
    
    /**
     *
     * @param main
     */
    private JPanel main;
    
    public displayAccountApproveActionPerformed(JPanel main) {
        this.main = main;
    }   
    
    private JPanel getMain() {
        return this.main;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ApproveUsers approveUsers = new ApproveUsers(getMain());
        //on ajoute le panel a l'internal frame
        displayRightWindow(approveUsers);
    }
}
