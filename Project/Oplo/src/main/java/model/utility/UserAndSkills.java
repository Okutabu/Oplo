/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.utility;

import java.util.ArrayList;

/**
 *
 * @author gaeta
 */
public class UserAndSkills {
    private String name;
    private ArrayList<String> competences;
    private int nbProjets;
    
    public UserAndSkills(String name, ArrayList<String> competences, int nbProjets){
        this.name = name;
        this.competences = competences;
        this.nbProjets = nbProjets;
    }

    public String getName() {
        return this.name;
    }
    
    public ArrayList<String> getCompetences() {
        return this.competences;
    }
    
    public int getNbProjets() {
        return this.nbProjets;
    }
}
