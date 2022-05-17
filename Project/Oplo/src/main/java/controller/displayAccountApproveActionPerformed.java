/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.k33ptoo.components.KButton;
import java.awt.Font;
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
    private KButton button;
    
    public displayAccountApproveActionPerformed(JPanel main, KButton button) {
        this.main = main;
        this.button = button;
    }   
    
    private JPanel getMain() {
        return this.main;
    }
    
    private KButton getButton() {
        return this.button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ApproveUsers approveUsers = new ApproveUsers(getMain());
        
        int nbAccounts = approveUsers.getNbAccountToApprove();
        
        button.setText("Approuver les comptes");
        if (nbAccounts != 0) {
            button.setText(button.getText() + " (" + String.valueOf(nbAccounts) + ")");
            button.setFont(new Font("Segoe UI Bold", Font.BOLD, 14));
        } else {
            button.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        }
        //on ajoute le panel a l'internal frame
        displayRightWindow(approveUsers);
    }
}
