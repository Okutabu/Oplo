/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.internal;

import controller.AffectController;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import model.RetrieveEmployees;
import static model.Skills.loadSkillList;
import model.utility.Display;
import model.utility.Project;
import model.utility.ServerCommunication;
import model.utility.Skill;
import model.utility.UserAndSkills;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
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
        
        displayProjects.setLayout(new GridLayout(2, 3, 8, 8));
        displayProjects.setBorder(new EmptyBorder(8, 8, 8, 8));
        
        currentPage.setMinimumSize(new Dimension(1, 2));
        
        Image image = null;
        try {
            
            image = ImageIO.read(new File("src/main/java/resources/loupe2.png"));
            Image scaled = image.getScaledInstance(35, 35, Image.SCALE_DEFAULT);
            loupe2.setIcon(new ImageIcon(scaled));
        } 
        catch (IOException e) {
        }
        
        refreshTotal("", "");
        refreshEmployees();
        refreshProjects("", "", "", 1);
        refreshTotal("", "");
        
        initializeSkills();
    }
    
    public void initializeSkills() {
        ArrayList<String> skills = loadSkillList();
        for (String skill:skills){
            searchBarSkill.addItem(skill);
        }
    }
    
    
    
    private void refreshEmployees() {
        RetrieveEmployees e = new RetrieveEmployees();
        ArrayList<UserAndSkills> users = e.retrieveEmployees();
        
        JPanel innerPanel = new JPanel();
        innerPanel.setBorder(null);
        innerPanel.setBackground(new Color(40, 40, 46));
        int nbEmployés = users.size();
        if (nbEmployés < 6) {
            innerPanel.setLayout(new GridLayout(6, 1, 5, 5));
        } else {
            innerPanel.setLayout(new GridLayout(nbEmployés, 1, 5, 1));
        }
        
        for (UserAndSkills user:users) {
            
            Employee em = new Employee(user);
            //ajout au jpanel
            innerPanel.add(em);
        }
        displayPersonal.setViewportView(innerPanel);
    }
    
    private void refreshProjects(String competence, String projet, String sortBy, int page) {
        if (page != 0) page -= 1; //pour reguler le offset
        if (competence.equals("Sélectionner")) competence = "";
        
        ServerCommunication s = new ServerCommunication();

        String res = s.sendPostRequest("retrieveProjectForRS=true&competence=" + competence + "&projectName=" + projet + "&limit=" + PAGINATION_STEP + "&offset=" + page * 6 + "&tri=" + sortBy);
        System.out.println("retrieveProjectForRS=true&competence=" + competence + "&projectName=" + projet + "&limit=" + PAGINATION_STEP + "&offset=" + page * 6 + "&tri=" + sortBy);
        displayProjects.removeAll();
        
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;
        
        if (jsonArray != null) {
            
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

                    JSONArray competences = (JSONArray) jsonObject.get("competences");    
                    ArrayList<Skill> skills = new ArrayList<Skill>();
                    

                    if (!competences.isEmpty()) {
                        JSONObject JSONcompetences = (JSONObject) competences.get(0);
                        Set<String> newKeys =JSONcompetences.keySet();


                        for(Object newKey:newKeys) 
                        {
                            String nom = newKey.toString();
                            String nb = JSONcompetences.get(nom).toString();
                            skills.add(new Skill(Integer.parseInt(nb), nom));
                        }
                    }


                    Project p = new Project(name, description, start_date, end_date, creator_login, skills);

                    miniProjectDisplayResponsable m = new miniProjectDisplayResponsable(p);
                    m.addMouseListener(new AffectController(name));
                    //ajout au jpanel
                    displayProjects.add(m);
                }
            }
        }
        validate();
        repaint();
    }
    
    private int getTotalpages(String competence, String projet){
        ServerCommunication s = new ServerCommunication();
        
        String nbProjetsString = s.sendPostRequest("getTotalProject=true&competence=" + competence + "&projectName=" + projet);
        int nbProjets = Integer.parseInt(nbProjetsString);
        return (int) Math.ceil((float) nbProjets/6); //arrondi au superieur du nombre de page
    }
    
    private void refreshTotal(String competence, String projet) {
        int nbPages = getTotalpages(competence, projet);
        if(nbPages == 0) nbPages = 1;
        //on set le total
        total.setText(String.valueOf(nbPages));
        //et on set le total du jspinner
        currentPage.setModel(new SpinnerNumberModel(1, 1, nbPages, 1));
    }
    
    
    private int getCurrentPage() {
        return (int) currentPage.getValue();
    }

    private String getCompetenceSearched() {
        return (String) searchBarSkill.getSelectedItem();
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
        searchBarProject = new javax.swing.JTextField();
        loupe2 = new javax.swing.JLabel();
        displayPersonal = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        next = new com.k33ptoo.components.KButton();
        previous = new com.k33ptoo.components.KButton();
        total = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        currentPage = new javax.swing.JSpinner();
        searchBarSkill = new javax.swing.JComboBox<>();

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

        displayProjects.setBackground(new java.awt.Color(61, 61, 72));
        displayProjects.setForeground(new java.awt.Color(70, 70, 100));
        displayProjects.setMaximumSize(new java.awt.Dimension(1074, 615));
        displayProjects.setMinimumSize(new java.awt.Dimension(1074, 615));

        javax.swing.GroupLayout displayProjectsLayout = new javax.swing.GroupLayout(displayProjects);
        displayProjects.setLayout(displayProjectsLayout);
        displayProjectsLayout.setHorizontalGroup(
            displayProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
        jLabel1.setText("Compétence :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Projet :");

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
        displayPersonal.setBorder(null);
        displayPersonal.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        displayPersonal.setOpaque(false);

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

        currentPage.setBorder(null);
        currentPage.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                currentPageStateChanged(evt);
            }
        });
        currentPage.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                currentPagePropertyChange(evt);
            }
        });
        currentPage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                currentPageKeyPressed(evt);
            }
        });

        searchBarSkill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchBarSkill.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sélectionner" }));
        searchBarSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarSkillActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(orderBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(searchBarSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(searchBarProject, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loupe2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(currentPage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(total)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(displayProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 1035, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(displayPersonal)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(orderBy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBarProject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addComponent(loupe2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(searchBarSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(total)
                                .addComponent(jLabel5)
                                .addComponent(currentPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayProjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addGap(23, 23, 23)
                        .addComponent(displayPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(252, 252, 252))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {orderBy, searchBarSkill});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderByActionPerformed
        refreshProjects(getCompetenceSearched(), getProjectSearched(), getSort(), 1);
        refreshTotal(getCompetenceSearched(), getProjectSearched());
    }//GEN-LAST:event_orderByActionPerformed

    private void searchBarProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarProjectActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        if (getCurrentPage() > 1) currentPage.setValue(getCurrentPage() - 1);
    }//GEN-LAST:event_previousActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        if (getCurrentPage() < Integer.parseInt(total.getText())) currentPage.setValue(getCurrentPage() + 1);
    }//GEN-LAST:event_nextActionPerformed

    private void currentPageStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_currentPageStateChanged
        refreshProjects(getCompetenceSearched(), getProjectSearched(), getSort(), getCurrentPage());
    }//GEN-LAST:event_currentPageStateChanged

    private void loupe2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loupe2MouseClicked
        refreshProjects(getCompetenceSearched(), getProjectSearched(), getSort(), 1);
        refreshTotal(getCompetenceSearched(), getProjectSearched());
    }//GEN-LAST:event_loupe2MouseClicked

    private void currentPageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_currentPageKeyPressed
        
    }//GEN-LAST:event_currentPageKeyPressed

    private void currentPagePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_currentPagePropertyChange
        
    }//GEN-LAST:event_currentPagePropertyChange

    private void searchBarSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarSkillActionPerformed
        refreshProjects(getCompetenceSearched(), getProjectSearched(), getSort(), 0);
        refreshTotal(getCompetenceSearched(), getProjectSearched());
    }//GEN-LAST:event_searchBarSkillActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner currentPage;
    private javax.swing.JScrollPane displayPersonal;
    private javax.swing.JPanel displayProjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loupe2;
    private com.k33ptoo.components.KButton next;
    private javax.swing.JComboBox<String> orderBy;
    private com.k33ptoo.components.KButton previous;
    private javax.swing.JTextField searchBarProject;
    private javax.swing.JComboBox<String> searchBarSkill;
    private javax.swing.JLabel titre;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
