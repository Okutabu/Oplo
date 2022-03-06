/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.oplo;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

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
    
    
    public User(String login, String firstname, String surname, int admin, String role, String profile){
        this.login = login;
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
        this.login = login;
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
    
    public String getLogin(){
        return login;
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
    
    public void saveCredentials()
    {
       try
       {
            File myObj = new File("credentials.oplo");
            if (myObj.createNewFile())
            {
              System.out.println("File created: " + myObj.getName());
            } 
            else 
            {
              System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter("credentials.oplo");
            myWriter.write(login);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
       }
       catch(Exception e)
       {

       }
    }

    public String getCredentials()
    {
        String data = "";

        try
        {
            File myFile = new File("credentials.oplo");
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine())
            {
                data = myReader.nextLine();
            }

            myReader.close();
        }
        catch(Exception e)
        {

        }

        return data.trim();
    }

}
