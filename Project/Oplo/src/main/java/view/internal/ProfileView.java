/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.internal;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.utility.Display;
import model.utility.ServerCommunication;
import model.utility.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author gaeta
 */
public class ProfileView extends javax.swing.JInternalFrame {

    private User user;
    /**
     * Creates new form ProfileView
     * @param user
     */
    public ProfileView(User user) {
        initComponents();
        Display.removeBorders(this);
        this.user = user;
        stylise();
        initializeElts();
    }

    private void initializeElts(){
        User user1 = getUser();
        
        //init image
        Image image = null;
        try {
            URL url = new URL("https://oplo.000webhostapp.com/resources/profiles/pictures/" + user1.getProfile_pic());
            image = ImageIO.read(url);
            Image scaled = image.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
            pp.setIcon(new ImageIcon(scaled));
        } 
        catch (IOException e) {

        }
        
        //init infos user
        login.setText(user1.getLogin());
        firstname.setText(user1.getFirstname());
        surname.setText(user1.getSurname());
        bio.setText(user1.getOthers());
        
        boolean approved = user1.getApproved();
        
        String textAdmin = "L'utilisateur ";
        
        if (user1.getAdmin()) {
            if (!approved) {
                textAdmin = textAdmin + "souhaite posséder ";
            } else {
                textAdmin = textAdmin + "possède ";
            }
            
        } else {
            if (!approved) {
                textAdmin = textAdmin + "ne souhaite pas posséder ";
            } else {
                textAdmin = textAdmin + "ne possède pas ";
            }
        }
        textAdmin = textAdmin + "les droits administrateur.";
        admin.setText(textAdmin);
        
        String textRole = "";
        if (!approved) textRole = "futur ";
        
        role.setText(user1.getFirstname() + " est un " + textRole + user1.getRole() + ".");
        
        //initialisation compétences
        ArrayList<String> competences = retrieveSkills();
        
        if (competences.isEmpty()) {
            titleSkills.setFont(new Font("Segoe UI Bold", Font.BOLD, 14));
            titleSkills.setText("L'utilisateur n'a pas déclaré de compétences.");
            skills.setVisible(false);
        } else {
            
            JPanel innerPanel = new JPanel();
            innerPanel.setBorder(null);
            innerPanel.setBackground(new Color(35, 35, 40));
            int nbCompetences = competences.size();
            
            if(nbCompetences < 6) {
                innerPanel.setLayout(new GridLayout(3, 2));
            } else {
                innerPanel.setLayout(new GridLayout(nbCompetences/2 + 1, 2));
            }
            
            for (int i = 0; i < nbCompetences ; i++) {
                JLabel competence = new JLabel(competences.get(i));
                competence.setHorizontalAlignment(JLabel.CENTER);
                competence.setForeground(Color.WHITE);
                competence.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));

                competence.setBorder(BorderFactory.createLineBorder(Color.white, 1));
                innerPanel.add(competence);
            
            }
            skills.setViewportView(innerPanel);
        }
        
        //initialisation projets
        ArrayList<String> projects = retrieveProjects();
        
        if (projects.isEmpty()) {
            titleProjects.setFont(new Font("Segoe UI Bold", Font.BOLD, 14));
            titleProjects.setText("L'utilisateur n'est dans aucun projet.");
            projectsListing.setVisible(false);
        } else {
            
            JPanel innerPanel2 = new JPanel();
            innerPanel2.setBorder(null);
            innerPanel2.setBackground(new Color(35, 35, 40));
            int nbProjets = projects.size();
            
            if(nbProjets < 6) {
                innerPanel2.setLayout(new GridLayout(3, 2));
            } else {
                innerPanel2.setLayout(new GridLayout(nbProjets/2, 2));
            }
            
            for (int i = 0; i < nbProjets ; i++) {
                JLabel competence = new JLabel(projects.get(i));
                competence.setHorizontalAlignment(JLabel.CENTER);
                competence.setForeground(Color.WHITE);
                competence.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));

                competence.setBorder(BorderFactory.createLineBorder(Color.white, 1));
                innerPanel2.add(competence);
            
            }
            projectsListing.setViewportView(innerPanel2);
        }
        
    }
    
    private void stylise() {
        this.getContentPane().setBackground(new Color(35,35,40));
        pp.setBorder(BorderFactory.createLineBorder(getUser().getColor(), 4, true));
    }
    
    private ArrayList<String> retrieveSkills(){
        ServerCommunication s = new ServerCommunication();
        
        String res = s.sendPostRequest("retrieveCompetence=" + getUser().getLogin());
        
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;         
        
        ArrayList<String> skills = new ArrayList<String>();

        for(Object object:jsonArray)
        {
            if(object instanceof JSONObject)
            {
                JSONObject jsonObject = (JSONObject)object;

                Set<String> keys =jsonObject.keySet();
                
                for(String key:keys)
                {
                   skills.add(key);
                }               
            }
        }
        
        return skills;
    }
    
    private ArrayList<String> retrieveProjects(){
        ServerCommunication s = new ServerCommunication();

        String res = s.sendPostRequest("retrieveProjectFromNamePattern=&onlyAuthor=0&login=" + getUser().getLogin());
 
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;
        
        ArrayList<String> projets = new ArrayList<String>();
        
        for(Object object:jsonArray)
        {
            if(object instanceof JSONObject) 
            {
                JSONObject newObj = (JSONObject)object;

                //recuperation des infos
                String name = newObj.get("name").toString();
                projets.add(name);
            }
        }
        return projets;
    }
    
    public User getUser() {
        return this.user;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pp = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bio = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        firstname = new javax.swing.JLabel();
        surname = new javax.swing.JLabel();
        admin = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        titleSkills = new javax.swing.JLabel();
        titleProjects = new javax.swing.JLabel();
        projectsListing = new javax.swing.JScrollPane();
        skills = new javax.swing.JScrollPane();

        setBackground(new java.awt.Color(35, 35, 40));

        login.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login.setText("login");

        bio.setEditable(false);
        bio.setBackground(new java.awt.Color(35, 35, 40));
        bio.setColumns(20);
        bio.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        bio.setForeground(new java.awt.Color(255, 255, 255));
        bio.setLineWrap(true);
        bio.setRows(4);
        bio.setFocusable(false);
        bio.setOpaque(false);
        bio.setRequestFocusEnabled(false);
        bio.setSelectionColor(new java.awt.Color(35, 35, 40));
        jScrollPane1.setViewportView(bio);

        jPanel1.setBackground(new java.awt.Color(40, 40, 46));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(70, 70, 100)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(9, 184, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fiche employé");

        firstname.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        firstname.setForeground(new java.awt.Color(255, 255, 255));
        firstname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstname.setText("prenom");

        surname.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        surname.setForeground(new java.awt.Color(255, 255, 255));
        surname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        surname.setText("nom");

        admin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        admin.setForeground(new java.awt.Color(255, 255, 255));
        admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin.setText("admin");

        role.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        role.setForeground(new java.awt.Color(255, 255, 255));
        role.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        role.setText("role");

        titleSkills.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleSkills.setForeground(new java.awt.Color(255, 255, 255));
        titleSkills.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleSkills.setText("Compétences :");

        titleProjects.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleProjects.setForeground(new java.awt.Color(255, 255, 255));
        titleProjects.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleProjects.setText("Membre des projets :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titleSkills, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(skills))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titleProjects, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(projectsListing)))
                    .addComponent(admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(role, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surname)
                    .addComponent(firstname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(role)
                .addGap(18, 18, 18)
                .addComponent(admin)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleSkills, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(projectsListing, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(skills))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(579, 579, 579))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(506, Short.MAX_VALUE)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(502, 502, 502))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(pp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(login)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin;
    private javax.swing.JTextArea bio;
    private javax.swing.JLabel firstname;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel login;
    private javax.swing.JLabel pp;
    private javax.swing.JScrollPane projectsListing;
    private javax.swing.JLabel role;
    private javax.swing.JScrollPane skills;
    private javax.swing.JLabel surname;
    private javax.swing.JLabel titleProjects;
    private javax.swing.JLabel titleSkills;
    // End of variables declaration//GEN-END:variables
}
