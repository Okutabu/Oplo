package model;

import view.internal.Accueil;
import view.internal.ModifyProfile;
import view.internal.Registration;
import view.panel.ApproveUserPanel;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JFrame;
import model.utility.Project;
import model.utility.ServerCommunication;
import model.utility.UserConnected;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import view.*;
/**
 *
 * @author Clément
 */
public class UserModel
{   
    public static void connect(ConnexionPanel view)
    {
        ServerCommunication s = new ServerCommunication();
        
        //String c = s.sendPostRequest("login=" + view.inputLogin.getText() + "&password=" + String.valueOf(view.inputPassword.getPassword()));
        String c = s.sendPostRequest("login=" + "clem" + "&password=" + "mdp");
        Object o = JSONValue.parse(c);
        JSONObject connectionInfos = (JSONObject) o;
        
        try
        {
            if (connectionInfos.containsKey("error"))
            {
                view.infoConnect.setText((String) connectionInfos.get("error"));
            }
            else
            {
                //Met a jour la classe User avec les infos de l'utilisateur, sorte de cache pour la session
                String login = view.inputLogin.getText();
                String prenom = (String) connectionInfos.get("firstname");
                String nom = (String) connectionInfos.get("surname");
                String admin = String.valueOf(connectionInfos.get("admin"));
                String role = (String) connectionInfos.get("role");
                String description = (String) connectionInfos.get("others");
                String photo = (String) connectionInfos.get("profile_pic");
                UserConnected myUser = new UserConnected(login, prenom, nom, admin, role, description, photo);
                //enregistre le login si la case est cochée
                if (view.remember.isSelected())
                {
                    myUser.saveCredentials();
                } 
                else
                {
                    myUser.destroyCredentials();
                }

                Home menu = new Home(myUser);
                view.setVisible(false);
                menu.setLocation(0,0);
                menu.setVisible(true);
                menu.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            }
        }
        catch(Exception e)
        {
            view.infoConnect.setText("Erreur serveur, réessayer");
        }
        
        
    }
    
    public static void register(Registration source)
    {
        ServerCommunication s = new ServerCommunication();
        
        String identifiant = source.login.getText();
        String motPasse = String.valueOf(source.password.getPassword());
        String role1 = source.role.getSelectedItem().toString();
        File file = source.getFile();
        if (!(file==null)){
            // uploadProfilePicture();
        }
        if (role1.equals("---")) role1 = "";
        source.yes.setActionCommand("yes");
        source.no.setActionCommand("no");
        int administrateur = 0;
        
        if (source.admin.getSelection() != null)
        {
            if(source.admin.getSelection().getActionCommand().equals("yes"))
            {
                administrateur = 1;
            } 
        }
        String prenom = source.firstname.getText();
        String nom = source.surname.getText();
        String bio = source.others.getText();
        String picName = "profile.png"; // a randomiser
        
        String inscription = s.sendPostRequest("login=" + identifiant + "&password=" + motPasse + 
                "&role=" + role1 + "&admin=" + administrateur + "&firstname=" + prenom + "&surname=" + nom + "&others=" + bio + "&profile_pic=" + picName);
        
        if (inscription.equals("ok"))
        {
            source.infosInscription.setForeground(new Color(0,255,0));
            source.infosInscription.setText("Inscription prise en compte");
        } 
        else 
        {
            source.infosInscription.setForeground(new Color(255,0,0));
            source.infosInscription.setText(inscription);
        }
    }
    
    public static void modifBio(ModifyProfile source)
    {
        UserConnected user = Home.getUser();
        
        String newOthers = source.bioInputField.getText();
        
        ServerCommunication s = new ServerCommunication();
        String req = s.sendPostRequest("updateOthers=true&login=" + user.getLogin() + "&others=" + newOthers);
        
        if(req.equals("ok"))
        {
            user.setOthers(newOthers);
        }
    }
    
    public static void isRemembered(ConnexionPanel source)
    {
        String display;
        if (UserConnected.getCredentials().equals("")){
            display = "Nom d'utilisateur";
        } else {
            display = UserConnected.getCredentials();
        }
        source.inputLogin.setText(display);
    }
    
    public static void approveUser(ApproveUserPanel source)
    {
        String loginS = source.userLogin.getText();
        
        ServerCommunication s = new ServerCommunication();
        s.sendPostRequest("approveAccount=true&login=" + loginS);
    }
    
    public static void revokeUser(ApproveUserPanel source)
    {
        String loginS = source.userLogin.getText();
        
        ServerCommunication s = new ServerCommunication();
        s.sendPostRequest("revokeAccount=true&login=" + loginS);
    }
    
    public static ArrayList<Project> InitializeProjectList(Accueil source)
    {
        ServerCommunication s = new ServerCommunication();
        UserConnected user = Home.getUser();
        String res = s.sendPostRequest("homeProjects=true&login=" + user.getLogin());
        
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;         
        
        ArrayList<Project> projects = new ArrayList<Project>();

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
                   String name = (String) newObj.get("name");
                   String description = (String) newObj.get("description");
                   String start_date = (String) newObj.get("start_date");
                   String end_date = (String) newObj.get("end_date");
                   String creator_login = (String) newObj.get("creator_login");
                   String last_news = (String) newObj.get("last_news");
                   
                   
                   Project projet = new Project(name, description, start_date, end_date, creator_login, last_news);
                   projects.add(projet);
                }               
            }
        }
        return projects;
    }
    
    public static void changePassword(String newPassword)
    {
        UserConnected user = Home.getUser();
        String login = user.getLogin();
        
        ServerCommunication s = new ServerCommunication();
        s.sendPostRequest("newPassword=" + newPassword + "&userLogin=" + login);
    }
    
    public void uploadProfilePicture(){
        
    }
    
}
