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
    
    public UserAndSkills(){
        this.name = null;
        this.competences = null;
        this.nbProjets = 0;
    }
    
    public UserAndSkills(String name, ArrayList<String> competences, int nbProjets){
        this.name = name;
        this.competences = competences;
        this.nbProjets = nbProjets;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setCompetences(ArrayList<String> competences) {
        this.competences = competences;
    }
    
    public void setNbProjets(int nb) {
        this.nbProjets = nb;
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
