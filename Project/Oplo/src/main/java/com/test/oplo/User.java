/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.oplo;

/**
 *
 * @author gaeta
 */
public class User {
    private String firstname;
    private String surname;
    private boolean admin;
    private String role;
    private String others;
    private String profile_pic;
    
    
    public User(String firstname, String surname, int admin, String role, String profile){
        this.firstname = firstname;
        this.surname = surname;
        if (admin == 1){
            this.admin = true;
        } else {
            this.admin = false;
        }
        this.role = role;
        this.others = "";
        this.profile_pic = profile;
    }
    
    public User(String firstname, String surname, int admin, String role, String others, String profile){
        this.firstname = firstname;
        this.surname = surname;
        if (admin == 1){
            this.admin = true;
        } else {
            this.admin = false;
        }
        this.role = role;
        this.others = others;
        this.profile_pic = profile;
    }
    
    public String getFirstname() {
	return firstname;
    }

    public String getSurname() {
            return surname;
    }

    public boolean getAdmin() {
            return admin;
    }
    
    public String getRole() {
            return role;
    }

    public String getOthers() {
            return others;
    }

    public String getProfile_pic() {
            return profile_pic;
    }

}
