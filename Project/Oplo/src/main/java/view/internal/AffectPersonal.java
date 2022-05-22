/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.internal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.utility.Display;
import model.utility.Project;
import model.utility.ServerCommunication;
import model.utility.Skill;
import model.utility.User;
import model.utility.UserAndSkills;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import static view.internal.HomeNavigationButtonsPanel.displayRightWindow;
import view.panel.Employee;
import view.panel.miniProjectDisplayResponsable;

/**
 *
 * @author gaeta
 */
public class AffectPersonal extends javax.swing.JInternalFrame {

    private static final int PAGINATION_STEP = 6;
    /**
     * Creates new form AffectPersonal
     */
    public AffectPersonal() {
        initComponents();
        Display.removeBorders(this);
        this.getContentPane().setBackground(new Color(35,35,40));
        initialize();
    }
    
    private void initialize(){
        
        displayProjects.setLayout(new GridLayout(2, 3, 5, 10));
        
        currentPage.setMinimumSize(new Dimension(0, 0));
        
        Image image = null;
        try {
            
            image = ImageIO.read(new File("src/main/java/resources/loupe1.png"));
            Image scaled = image.getScaledInstance(35, 35, Image.SCALE_DEFAULT);
            loupe1.setIcon(new ImageIcon(scaled));
            
            image = ImageIO.read(new File("src/main/java/resources/loupe2.png"));
            scaled = image.getScaledInstance(35, 35, Image.SCALE_DEFAULT);
            loupe2.setIcon(new ImageIcon(scaled));
        } 
        catch (IOException e) {
        }
        
        refreshTotal("", "");
        refreshEmployees();
        refreshProjects("", "", "", 0);
    }
    
    private void refreshEmployees() {
        ServerCommunication s = new ServerCommunication();
        
        String res = s.sendGetRequest("allUsers");

        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;
        
        JPanel innerPanel = new JPanel();
        innerPanel.setBorder(null);
        int nbEmployés = jsonArray.size();
        if (nbEmployés < 6) {
            innerPanel.setLayout(new GridLayout(6, 1, 5, 1));
        } else {
            innerPanel.setLayout(new GridLayout(nbEmployés, 1, 5, 1));
        }
        
        for(Object object:jsonArray)
        {
            if(object instanceof JSONObject) 
            {
                JSONObject jsonObject = (JSONObject)object;

                Set<String> keys =jsonObject.keySet();
                
                for(String key:keys) 
                {
                    Object newJson = jsonObject.get(key);

                    JSONObject newObj = (JSONObject)newJson;

                    //recuperation des infos
                    String login = key;
                    String name = newObj.get("nom").toString();
                    String numberOfProject = newObj.get("numberOfProject").toString();
                    JSONArray competences = (JSONArray) newObj.get("competence");

                    ArrayList<String> skills = new ArrayList<String>();
                    for(Object newKey:competences) 
                    {
                        skills.add(newKey.toString());
                    }

                    UserAndSkills user = new UserAndSkills(login, name, skills, Integer.parseInt(numberOfProject));
                    
                    Employee e = new Employee(user);
                    //ajout au jpanel
                    innerPanel.add(e);
                   

                }               
            }
        }
        displayPersonal.setViewportView(innerPanel);
    }
    
    private void refreshProjects(String competence, String projet, String sortBy, int page) {
        ServerCommunication s = new ServerCommunication();
        
        String res = s.sendPostRequest("retrieveProjectForRS=true&competence=" + competence + "&projectName=" + projet + "&limit=" + PAGINATION_STEP + "&offset=" + page * 6 + "&tri=" + sortBy);
        System.out.print(res);
        
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;
        
        for(Object object:jsonArray)
        {
            if(object instanceof JSONObject) 
            {
                JSONObject jsonObject = (JSONObject)object;


                //recuperation des infos
                String name = jsonObject.get("name").toString();
                String description = jsonObject.get("description").toString();
                String start_date = jsonObject.get("start_date").toString();
                String end_date = jsonObject.get("end_date").toString();
                String creator_login = jsonObject.get("creator_login").toString();

                JSONObject competences = (JSONObject) jsonObject.get("competences");
                Set<String> newKeys =competences.keySet();

                ArrayList<Skill> skills = new ArrayList<Skill>();
                for(Object newKey:newKeys) 
                {
                    String nom = newKey.toString();
                    String nb = competences.get(nom).toString();
                    skills.add(new Skill(Integer.parseInt(nb), nom));
                }

                Project p = new Project(name, description, start_date, end_date, creator_login, skills);

                miniProjectDisplayResponsable m = new miniProjectDisplayResponsable(p);
                //ajout au jpanel
                displayProjects.add(m);
            }
        }
        
        
    }
    
    private void refreshTotal(String competence, String projet) {
        ServerCommunication s = new ServerCommunication();
        
        total.setText(s.sendPostRequest("getTotalProject=true&competence=" + competence + "&projectName=" + projet));
    }
    
    private int getCurrentPage() {
        return Integer.parseInt((String) currentPage.getValue());
    }
    
    private void reinitializeCurrentPage() {
        currentPage.setValue("0");
    }

    private String getCompetenceSearched() {
        return searchBarSkill.getText();
    }
    
    private String getProjectSearched() {
        return searchBarProject.getText();
    }
    
    private String getSort() {
        return orderBy.getSelectedItem().toString();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titre = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        displayProjects = new javax.swing.JPanel();
        orderBy = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchBarSkill = new javax.swing.JTextField();
        searchBarProject = new javax.swing.JTextField();
        loupe2 = new javax.swing.JLabel();
        displayPersonal = new javax.swing.JScrollPane();
        loupe1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        next = new com.k33ptoo.components.KButton();
        previous = new com.k33ptoo.components.KButton();
        total = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        currentPage = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(35, 35, 40));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(1320, 1080));

        titre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titre.setForeground(new java.awt.Color(255, 255, 255));
        titre.setText("Attribuer du personnel");

        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        displayProjects.setBackground(new java.awt.Color(70, 70, 100));
        displayProjects.setForeground(new java.awt.Color(70, 70, 100));

        javax.swing.GroupLayout displayProjectsLayout = new javax.swing.GroupLayout(displayProjects);
        displayProjects.setLayout(displayProjectsLayout);
        displayProjectsLayout.setHorizontalGroup(
            displayProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1074, Short.MAX_VALUE)
        );
        displayProjectsLayout.setVerticalGroup(
            displayProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );

        orderBy.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        orderBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trier par", "Date de départ : plus tot d'abord", "Date de départ : plus tard d'abord", "Compétences : les + rares", "Compétences : le + de besoin", "Compétences : le - de besoin" }));
        orderBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderByActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rechercher une compétence");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rechercher un projet");

        searchBarSkill.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchBarSkill.setPreferredSize(new java.awt.Dimension(54, 22));
        searchBarSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarSkillActionPerformed(evt);
            }
        });

        searchBarProject.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchBarProject.setPreferredSize(new java.awt.Dimension(54, 22));
        searchBarProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarProjectActionPerformed(evt);
            }
        });

        loupe2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loupe2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loupe2MouseClicked(evt);
            }
        });

        displayPersonal.setBackground(new java.awt.Color(40, 40, 60));
        displayPersonal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        displayPersonal.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        displayPersonal.setOpaque(false);

        loupe1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loupe1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loupe1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Employés disponibles");

        next.setText("Suivant");
        next.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        next.setkEndColor(new java.awt.Color(9, 184, 255));
        next.setkHoverEndColor(new java.awt.Color(9, 150, 200));
        next.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        next.setkHoverStartColor(new java.awt.Color(9, 150, 200));
        next.setkPressedColor(new java.awt.Color(5, 120, 160));
        next.setkSelectedColor(new java.awt.Color(5, 120, 160));
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        previous.setText("Précédent");
        previous.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        previous.setkEndColor(new java.awt.Color(9, 184, 255));
        previous.setkHoverEndColor(new java.awt.Color(9, 150, 200));
        previous.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        previous.setkHoverStartColor(new java.awt.Color(9, 150, 200));
        previous.setkPressedColor(new java.awt.Color(5, 120, 160));
        previous.setkSelectedColor(new java.awt.Color(5, 120, 160));
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });

        total.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        total.setText("total");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("/");

        currentPage.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                currentPageStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1308, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(displayProjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(275, 275, 275)
                        .addComponent(currentPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(displayPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(orderBy, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBarSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loupe1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBarProject, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loupe2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchBarProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchBarSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(orderBy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loupe1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(total)
                                .addComponent(jLabel5)
                                .addComponent(currentPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(displayPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(displayProjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(242, 242, 242))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loupe2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {searchBarProject, searchBarSkill});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderByActionPerformed
        refreshProjects(getCompetenceSearched(), getProjectSearched(), getSort(), 0);
        reinitializeCurrentPage();
    }//GEN-LAST:event_orderByActionPerformed

    private void searchBarSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarSkillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarSkillActionPerformed

    private void searchBarProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarProjectActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        currentPage.setValue(Integer.parseInt((String) currentPage.getValue()) - 1);
    }//GEN-LAST:event_previousActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        currentPage.setValue(Integer.parseInt((String) currentPage.getValue()) + 1);
    }//GEN-LAST:event_nextActionPerformed

    private void currentPageStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_currentPageStateChanged
        refreshProjects(getCompetenceSearched(), getProjectSearched(), getSort(), getCurrentPage());
    }//GEN-LAST:event_currentPageStateChanged

    private void loupe1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loupe1MouseClicked
        refreshProjects(getCompetenceSearched(), getProjectSearched(), getSort(), 0);
        reinitializeCurrentPage();
    }//GEN-LAST:event_loupe1MouseClicked

    private void loupe2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loupe2MouseClicked
        refreshProjects(getCompetenceSearched(), getProjectSearched(), getSort(), 0);
        reinitializeCurrentPage();
    }//GEN-LAST:event_loupe2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner currentPage;
    private javax.swing.JScrollPane displayPersonal;
    private javax.swing.JPanel displayProjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loupe1;
    private javax.swing.JLabel loupe2;
    private com.k33ptoo.components.KButton next;
    private javax.swing.JComboBox<String> orderBy;
    private com.k33ptoo.components.KButton previous;
    private javax.swing.JTextField searchBarProject;
    private javax.swing.JTextField searchBarSkill;
    private javax.swing.JLabel titre;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
