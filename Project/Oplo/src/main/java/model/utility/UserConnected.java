/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.utility;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author gaeta
 */
public class UserConnected extends User {
    
    private Color color;
    /**
     * cette classe represente l'utilisateur connecté
     * @param id
     * @param prenom
     * @param nom
     * @param administrateur
     * @param role1
     * @param description
     * @param photo
     */
    public UserConnected(String id, String prenom, String nom, String administrateur, String role1, String description, String photo){
        super(id, prenom, nom, administrateur, role1, description, photo);
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
           try (FileWriter myWriter = new FileWriter("credentials.oplo")) {
               myWriter.write(this.getLogin());
           }
            System.out.println("Successfully wrote to the file.");
       }
       catch(IOException e)
       {

       }
    }
    

    public static String getCredentials()
    {
        String data = "";

        try
        {
            File myFile = new File("credentials.oplo");
            try (Scanner myReader = new Scanner(myFile)) {
                while (myReader.hasNextLine())
                {
                    data = myReader.nextLine();
                }
            }
        }
        catch(FileNotFoundException e)
        {

        }

        return data.trim();
    }
    
    public void destroyCredentials(){
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
    
    public Color getColor(){
        return this.color;
    }

}
