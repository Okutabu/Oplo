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
public class Project {
    
    private String name;
    private String description;
    private String start_date;
    private String end_date;
    private String creator_login;
    private String last_news;
    private ArrayList<Skill> competences;
    
    public Project(String name, String description, String start_date, String end_date, String creator_login) {
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.creator_login = creator_login;
        this.last_news = null;
        this.competences = null;
    }
    
    public Project(String name, String description, String start_date, String end_date, String creator_login, String last_news) {
        this(name, description, start_date, end_date, creator_login);
        this.last_news = last_news;
    }
    
    public Project(String name, String description, String start_date, String end_date, String creator_login, ArrayList<Skill> skills) {
        this(name, description, start_date, end_date, creator_login);
        this.competences = skills;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getStart_date() {
        return this.start_date;
    }
    
    public String getEnd_date() {
        return this.end_date;
    }
    
    public String getCreator_login() {
        return this.creator_login;
    }
    
    public String getLastNews() {
        return this.last_news;
    }
    
    public ArrayList<Skill> getCompetences() {
        return this.competences;
    }
    
}
