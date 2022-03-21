/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.utility;

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
    
    public User(String id, String prenom, String nom, String administrateur, String role1, String description, String photo){
        this.login = id;
        this.firstname = prenom;
        this.surname = nom;
        this.admin = administrateur.equals("1");
        this.role = role1;
        this.others = description;
        this.profile_pic = photo;
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
    
    public void setOthers(String othersValue)
    {
        this.others = othersValue;
    }
}
