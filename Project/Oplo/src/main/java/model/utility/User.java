/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.utility;

import java.awt.Color;

/**
 *
 * @author gaeta
 */
public class User {
    private String login;
    private String firstname;
    private String surname;
    private boolean admin;
    private String role;
    private String others;
    private String profile_pic;
    private boolean approved;
    private Color color;
    
    public User(String id, String prenom, String nom, String administrateur, String role1, String description, String photo){
        this.login = id;
        this.firstname = prenom;
        this.surname = nom;
        this.admin = administrateur.equals("1");
        this.role = role1;
        this.others = description;
        this.profile_pic = photo;
        this.approved = true;
        switch (role1) {
            case "Chef de projet" -> { this.color = new Color(128, 0, 255);
                break;
            }
            case "Employé" -> { this.color = new Color(64, 255, 0);
                break;
            }
            case "Responsable scientifique" -> { this.color = Color.RED;
                break;
            }
        }
    }
    
    public User(String id, String prenom, String nom, String administrateur, String role1, String description, String photo, boolean approved){
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
