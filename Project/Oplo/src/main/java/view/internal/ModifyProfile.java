package view.internal;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import model.UserModel;
import model.utility.Display;
import model.utility.UserConnected;
import model.utility.ServerCommunication;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import view.*;

import controller.*;
import javax.swing.JComboBox;

/**
 *
 * @author gaeta
 */
public class ModifyProfile extends javax.swing.JInternalFrame {

    /**
     * Creates new form Profile
     */
    private UserConnected user = Home.getUser();
    private boolean add;
    
    public ModifyProfile()
    {
        initComponents();
        initDisplay(user);
        this.getContentPane().setBackground(new Color(35,35,40));
        Display.removeBorders(this);
        
        Image image = null;/* w  ww .  ja  v  a 2 s.c o m*/
        try {
            URL url = new URL("https://oplo.000webhostapp.com/resources/profiles/pictures/" + Home.getUser().getProfile_pic());
            image = ImageIO.read(url);
            Image scaled = image.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
            profilePicture.setIcon(new ImageIcon(scaled));
        } 
        catch (IOException e) {

        }
        
        changePasswordBtn.addActionListener(new ChangePasswordBtnController(this));
    }
    
    public final void initDisplay(UserConnected user)
    {
        
        firstname.setText(user.getFirstname());
        name.setText(user.getSurname());
        id.setText(user.getLogin());
        role.setText(user.getRole());
        ArrayList<String> list_of_skills = loadSkillList();
        ArrayList<String> list_of_my_skills = loadListOfMySkills();
        swapButton.setText("Ajouter");
        this.add = true;
        
        approveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (add){
                    addSkillToUser();
                }
                else
                {removeSkillFromUser();}
            }
        });
        
        writeBothJComboBoxes(skillSelector, skillsField, list_of_skills, list_of_my_skills);
        
        if (user.getAdmin())
        {
            admin.setText("Oui");
        } 
        else
        {
            admin.setText("Non");
        }
        bioInputField.setText(user.getOthers()); 
    }
    
    /**
     * This method grabs every name from the competence table of the database
     * @return an array of string
     */
     public ArrayList<String> loadSkillList()
    {
        ServerCommunication s = new ServerCommunication();
        String res = s.sendGetRequest("retrieveAllCompetence=true");
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;         
        
        ArrayList<String> competences = new ArrayList<String>();
        
        try{
            
        
        for(Object object:jsonArray)
        {
            if(object instanceof JSONObject)
            {
                JSONObject jsonObject = (JSONObject)object;

                Set<String> keys =jsonObject.keySet();
                
                for(String key:keys)
                {
                   competences.add(key);
                }               
            }
        }
        }
        catch(NullPointerException e){
            competences.add("erreur de chargement");
        }
        return competences;
    }
     /**
      * change le boolean d'ajout et indique à l'utlisateur la nouvelle utilité du bouton
      */
     public void swapAddVariable(){
         this.add = !this.add;
         swapButton.setText(swapButtonText(this.add));
     }
     /**
      * 
      * @param condition un pivot de décision
      * @return le text adéquat du bouton de swap
      */
     public String swapButtonText(boolean condition){
         String res;
         if (condition){
             res = "Ajouter";
         }
         else{res = "Supprimer";}
         return res;
     }
     
     public String getNewPasswordValue()
     {
         return newPasswordInputField.getText();
     }
     
     public void setNewPasswordValue(String val)
     {
         newPasswordInputField.setText(val);
     }
     
     public void addSkillToUser(){
         String res;
         ServerCommunication s = new ServerCommunication();
         String skill_to_add = (String) skillSelector.getSelectedItem();
         boolean possible = verifySkillIsNotAlreadyPresent(skill_to_add);
         
         if (possible){
            res = s.sendPostRequest("competenceName="+skill_to_add+"&login="+user.getLogin());
            System.out.print(res);
            String [] first_word = res.split(" ", 2);
            System.out.print("There has been no mistakes");
            /*
            sendPostRequest returns a string no matter what happens, but in the case of an error
            the string returned starts with 'Error'
            */
            if (!"Error".equals(first_word[0]) && !"L'action".equals(first_word[0])){
                skillsField.addItem(skill_to_add);
            }
         else{System.out.print(first_word[0]+"\n"+"There has been a mistake \n");
         }   
         }
     }
     
     public void removeSkillFromUser(){
         String res;
         ServerCommunication s = new ServerCommunication();
         String skill_to_remove = (String) skillSelector.getSelectedItem();
         res = s.sendPostRequest("deleteUserCompetence=true&competenceName="+skill_to_remove+"&login="+user.getLogin());
         String [] first_word = res.split(" ", 1);
         
         if (!"Error".equals(first_word[0]) && !"L'action".equals(first_word[0])){
                skillsField.removeItem(skill_to_remove);
             
            }
     }
     
     public ArrayList<String> loadListOfMySkills()
    {
        ServerCommunication s = new ServerCommunication();
        
        String res = s.sendPostRequest("retrieveCompetence="+user.getFirstname());
        System.out.print(res);
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;         
        
        ArrayList<String> competences = new ArrayList<String>();
        
        try{
            
        
        for(Object object:jsonArray)
        {
            if(object instanceof JSONObject)
            {
                JSONObject jsonObject = (JSONObject)object;

                Set<String> keys =jsonObject.keySet();
                
                for(String key:keys)
                {
                   competences.add(key);
                }               
            }
        }
        }
        catch(NullPointerException e){
            competences.add("pas de competences");
        }
        return competences;
    }  
     
     public static void writeBothJComboBoxes(JComboBox box1, JComboBox box2, ArrayList<String> box1Filler, ArrayList<String> box2Filler){
         for(String name:box1Filler)
        {
            box1.addItem(name);
        }
        
        for(String name:box2Filler)
        {
            box2.addItem(name);
        }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        admin = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bioInputField = new javax.swing.JTextArea();
        modifBioButton = new javax.swing.JToggleButton();
        name = new javax.swing.JLabel();
        firstname = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        modifResultLabel = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        profilePicture = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        skillSelector = new javax.swing.JComboBox<>();
        swapButton = new javax.swing.JButton();
        approveButton = new javax.swing.JButton();
        newPasswordInputField = new javax.swing.JTextField();
        changePasswordBtn = new com.k33ptoo.components.KButton();
        jLabel11 = new javax.swing.JLabel();
        skillsField = new javax.swing.JComboBox<>();

        setBorder(new javax.swing.border.MatteBorder(null));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modifier votre profil");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Identifiant");

        id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("idDuUser");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mot de passe");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Role");

        role.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        role.setForeground(new java.awt.Color(255, 255, 255));
        role.setText("roleDuUser");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Administrateur");

        admin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        admin.setForeground(new java.awt.Color(255, 255, 255));
        admin.setText("Oui/Non");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Bio :");

        bioInputField.setColumns(20);
        bioInputField.setRows(5);
        jScrollPane1.setViewportView(bioInputField);

        modifBioButton.setText("Modifier");
        modifBioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifBioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifBioButtonActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("nomDuUser");

        firstname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        firstname.setForeground(new java.awt.Color(255, 255, 255));
        firstname.setText("prenomDuUser");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nom de famille");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Prénom");

        jToggleButton2.setText("Se déconnecter");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        profilePicture.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 5));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mes compétences");

        skillSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skillSelectorActionPerformed(evt);
            }
        });

        swapButton.setText("Ajouter");
        swapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swapButtonActionPerformed(evt);
            }
        });

        approveButton.setText("Ok");

        changePasswordBtn.setText("Changer le mot de passe");
        changePasswordBtn.setkEndColor(new java.awt.Color(204, 0, 204));
        changePasswordBtn.setkHoverEndColor(new java.awt.Color(255, 0, 255));
        changePasswordBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        changePasswordBtn.setkStartColor(new java.awt.Color(204, 0, 204));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Compétences");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(748, 748, 748))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(modifResultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(202, 202, 202))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(admin, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1328, 1328, 1328))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(swapButton)
                                .addGap(34, 34, 34)
                                .addComponent(skillSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(approveButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(newPasswordInputField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(firstname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                                .addGap(58, 58, 58)
                                .addComponent(changePasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(skillsField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modifBioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel5});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(id, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(231, 231, 231))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 127, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newPasswordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(changePasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(role, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(admin))
                                .addGap(16, 16, 16)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(skillSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(swapButton)
                                    .addComponent(approveButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))))
                .addComponent(modifResultLabel)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skillsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modifBioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(350, 350, 350))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {admin, jLabel6, jLabel8, role});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {id, name});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modifBioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifBioButtonActionPerformed
        // TODO add your handling code here:
        UserModel.modifBio(this);
    }//GEN-LAST:event_modifBioButtonActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        
        (new ConnexionPanel()).setVisible(true);
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void swapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swapButtonActionPerformed
            // TODO add your handling code here:
            swapAddVariable();
    }//GEN-LAST:event_swapButtonActionPerformed

    private void skillSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skillSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skillSelectorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin;
    private javax.swing.JButton approveButton;
    public javax.swing.JTextArea bioInputField;
    private com.k33ptoo.components.KButton changePasswordBtn;
    private javax.swing.JLabel firstname;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton modifBioButton;
    private javax.swing.JLabel modifResultLabel;
    private javax.swing.JLabel name;
    private javax.swing.JTextField newPasswordInputField;
    private javax.swing.JLabel profilePicture;
    private javax.swing.JLabel role;
    private javax.swing.JComboBox<String> skillSelector;
    private javax.swing.JComboBox<String> skillsField;
    private javax.swing.JButton swapButton;
    // End of variables declaration//GEN-END:variables

    private boolean verifySkillIsNotAlreadyPresent(String skillToScanFor) {
        boolean res = true;
        ArrayList<String> list_of_skills = loadListOfMySkills();
        for(String name: list_of_skills){
            System.out.print(name);
            if (name.equals(skillToScanFor)){
                res = false;
            }
        }
        return res;
        
    }
}
