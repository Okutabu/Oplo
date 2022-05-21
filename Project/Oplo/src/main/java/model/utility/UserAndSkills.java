/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.utility;

import java.awt.Color;
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
    
    public UserAndSkills(String id, String prenom, String nom, String administrateur, String role1, String description, String photo, boolean approved){
        this(id, prenom, nom, administrateur, role1, description, photo);
        this.approved = approved;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public String getFirstname() {
	return this.firstname;
    }

    public String getSurname() {
        return this.surname;
    }

    public boolean getAdmin() {
        return this.admin;
    }
    
    public String getRole() {
        return this.role;
    }

    public String getOthers() {
        return this.others;
    }

    public String getProfile_pic() {
        return this.profile_pic;
    }
    
    public Color getColor() {
        return this.color;
    }
    
    public void setOthers(String othersValue)
    {
        this.others = othersValue;
    }
    
    public boolean getApproved() {
        return this.approved;
    }
}
