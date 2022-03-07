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
    private static String login;
    private static String firstname;
    private static String surname;
    private static boolean admin;
    private static String role;
    private static String others;
    private static String profile_pic;
    
    public static void initialize(String id, String prenom, String nom, String administrateur, String role1, String description, String photo){
        login = id;
        firstname = prenom;
        surname = nom;
        if (administrateur == "1"){
            admin = true;
        } else {
            admin = false;
        }
        role = role1;
        others = description;
        profile_pic = photo;
    }
    
    public static String getLogin(){
        return login;
    }
    
    public static String getFirstname() {
	return firstname;
    }

    public static String getSurname() {
        return surname;
    }

    public static boolean getAdmin() {
        return admin;
    }
    
    public static String getRole() {
        return role;
    }

    public static String getOthers() {
        return others;
    }

    public static String getProfile_pic() {
        return profile_pic;
    }
    
    public static void saveCredentials()
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
    

    public static String getCredentials()
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
    
    public static void destroyCredentials(){
        String nomFichier = "credentials.oplo";
        File myFile = new File(nomFichier);
        if(myFile.delete()) 
        { 
            System.out.println("File successfully deleted"); 
        } 
        else
        { 
            System.out.println("Error : Can not delete " + nomFichier); 
        } 
    }

}
