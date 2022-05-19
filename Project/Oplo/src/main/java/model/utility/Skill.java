/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.utility;

/**
 *
 * @author gaeta
 */
public class Skill {
    private int nb;
    private String nom;
    private String descriptif;
    
    public Skill(int nb, String nom) {
        this.nb = nb;
        this.nom = nom;
    }
    public Skill( String nom, String desc) {
        this.nom = nom;
        this.descriptif = desc;
    }
    
    public int getNb() {
        return this.nb;
    }
    
    public String getNom() {
        return this.nom;
    }
}
