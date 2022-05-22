/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;
import view.internal.AddProject;
import java.io.Writer;
import model.utility.*;
import org.json.simple.JSONObject;
import view.*;
import java.util.Iterator;
/**
 *
 * @author Clément
 */
public class CreateProjectModel 
{
    private JSONObject humanNeed;
    private AddProject view;
    
    public CreateProjectModel(AddProject view)
    {
        this.humanNeed = new JSONObject();
        this.view = view;
    }
    /**
     * Cree un projet à partir des informations rentrées par l'utilisateur
     * @param feedback Un texte provenent 
     */
    public void CreateProject()
    {
        String projectName = view.getProjectName();
        String projectDescription = view.getDescription();
        
        String projectStartDate;
        String projectEndDate;
        /**
         * On ne peut pas appeler toString sur des valeures null alors on s'assure 
         * qu'elles ne le sont pas
         */
        if (view.getStartDate()!= null && view.getStartDate() !=  null){
            projectStartDate = view.getStartDate().toString();
            projectEndDate = view.getEndDate().toString();
        }
        else{
            projectStartDate = null;
            projectEndDate = null;
        }   
        
        String authorLogin = Home.getUser().getLogin();
                
        boolean requirements = projectName != null && projectDescription != null && projectStartDate != null && projectEndDate != null;
        ServerCommunication s = new ServerCommunication();
        if (requirements){
            try {
                s.sendPostRequest("name=" + projectName + "&description=" + projectDescription + "&start_date=" + projectStartDate + "&end_date=" + projectEndDate + "&creator_login=" + authorLogin + "&humanNeed=" + humanNeed);
                view.getErrorDisplayLabel().setText("Le projet a bien été crée");
                view.getErrorDisplayLabel().setForeground(new Color(0,255,0));
            }
            catch(NullPointerException e){
                view.getErrorDisplayLabel().setText("Renseignez tous les champs");
                view.getErrorDisplayLabel().setForeground(new Color(255,0,0));
            }
        }
        else{
            view.getErrorDisplayLabel().setText("Renseignez tous les champs");
            view.getErrorDisplayLabel().setForeground(new Color(255,0,0));
        }
    }
    
    public void addHumanNeed(String categorie, int number)
    {
        if(humanNeed.containsKey(categorie))
        {
            humanNeed.put(categorie, Integer.parseInt(humanNeed.get(categorie).toString()) + number);
        }
        else
        {
            humanNeed.put(categorie, number);
        }
    }
    
    public void removeHumanNeed(String categorie, int number)
    {
        if(humanNeed.containsKey(categorie))
        {
            int currentVal = Integer.parseInt(humanNeed.get(categorie).toString());
            if(currentVal >= number)
            {
                if((currentVal - number) == 0)
                {
                    humanNeed.remove(categorie);
                }
                else
                {
                   humanNeed.put(categorie, currentVal - number); 
                }
            }
        }
    }
    
    public void refreshHumanNeedsArea()
    {
        String res = "";
        
        JSONObject jsonObject = new JSONObject(humanNeed);
        Iterator<String> keys = jsonObject.keySet().iterator();
        
        while(keys.hasNext())
        {
            String key = keys.next();
            res += key;
            res += " x" + humanNeed.get(key) + "\n";
        }
        view.setNeedsArea(res);
        view.setHumanNeedValue(1);
    }

    private Writer FileWriter(String persoTempoplo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
