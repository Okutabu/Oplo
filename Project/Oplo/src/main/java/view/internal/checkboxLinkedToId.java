/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.internal;

import javax.swing.JCheckBox;

/**
 *
 * @author Okutabu
 */
public class checkboxLinkedToId extends JCheckBox {
    private int id;
    public checkboxLinkedToId(int number){
        this.id = number;
    }
    
    public int getId(){
        return this.id;
    }
}
