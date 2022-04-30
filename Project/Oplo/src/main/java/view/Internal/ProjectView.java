/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.Internal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import model.utility.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import view.*;
import controller.*;
import model.*;
/**
 *
 * @author Okutabu
 */
public class ProjectView extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrameProjectDisplay
     */
    private ManageProjectModel model;
    
    public ProjectView(String projectName)
    {
        initComponents();
        Display.removeBorders(this);
        this.getContentPane().setBackground(new Color(35,35,40));
        
        this.model = new ManageProjectModel(this, projectName);

        projectNameLabel.setText(projectName);
        TodoPanel.setLayout(new GridLayout(10, 1));
        NewsPanel.setLayout(new BoxLayout(NewsPanel, javax.swing.BoxLayout.Y_AXIS));
        NewsPanel.setMaximumSize(new Dimension(400, 400));
        NewsPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        TodoPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        SendNewsBtn.addMouseListener(new SendMessagesController(model, this));
        
        retrieveToDoList();
        retrieveNews();
        InitSendNews();
    }
    
    public void InitSendNews() {
        //si le='utilisateur est un chef de projet alors il peut envoyer des news
        if (Home.getUser().getRole().equals("Chef de projet")) {
            Image image = null;
            try {

                image = ImageIO.read(new File("src/main/java/resources/send.png"));
                Image scaled = image.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                SendNewsBtn.setIcon(new ImageIcon(scaled));
            } 
            catch (IOException e) {
            }
        } else {
            NewsInputField.setVisible(false);
            SendNewsBtn.setVisible(false);
        }
    }
    
    public void retrieveToDoList()
    {
        ServerCommunication s = new ServerCommunication();
        String res = s.sendPostRequest("https://oplo.000webhostapp.com/", "retrieveProjectTodoList&projectName=" + model.getProjectName());
        
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;     
        
        System.out.println("res request : " + res);
        
        for(Object object:jsonArray)
        {
            if(object instanceof JSONObject)
            {
                JSONObject jsonObject = (JSONObject)object;

                Set<String> keys = jsonObject.keySet();
                
                for(String key:keys)
                {
                    Object newJson = jsonObject.get(key);

                    JSONObject newObj = (JSONObject)newJson;
                    
                    JPanel line = new JPanel();
                    line.setLayout(new GridLayout(1, 2));
                    line.setBackground(new Color(0, 0, 0, 0));
                    JCheckBox checkbox = new JCheckBox();
                    
                    if(Integer.parseInt(newObj.get("done").toString()) == 0)
                    {
                        checkbox.setSelected(false);
                    }
                    else
                    {
                        checkbox.setSelected(true);
                    }
                    
                    line.add(checkbox);
                    JLabel label = new JLabel(newObj.get("title").toString());
                    label.setForeground(Color.WHITE);
                    line.add(label);
                    TodoPanel.add(line);
                }               
            }
        }
        revalidate();
    }
    
    public void retrieveNews()
    {
        NewsPanel.removeAll();
        
        ServerCommunication s = new ServerCommunication();
        String res = s.sendPostRequest("https://oplo.000webhostapp.com/", "retrieveProjectNews&projectName=" + model.getProjectName());
        
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;     
        
        System.out.println(res);
        
         for(Object object:jsonArray)
        {
            if(object instanceof JSONObject)
            {
                JSONObject jsonObject = (JSONObject)object;

                Set<String> keys = jsonObject.keySet();
                
                for(String key:keys)
                {
                    Object newJson = jsonObject.get(key);

                    JSONObject newObj = (JSONObject)newJson;
                    
                    JPanel line = new JPanel();
                    line.setLayout(new GridLayout(2, 1));
                    line.setBackground(new Color(0, 0, 0, 50));
 
                    JTextArea content = new JTextArea(newObj.get("title").toString());
                    content.setEditable(false);    
                    content.setWrapStyleWord(true);
                    content.setLineWrap(true);
                    content.setBackground(new Color(172, 174, 179));
                    content.setForeground(Color.WHITE);
                    content.setBorder(null);
                    content.setFont(new Font("Verdana", Font.PLAIN, 15));
                    
                    
                    JLabel date = new JLabel(newObj.get("date").toString());
                    date.setForeground(Color.WHITE);
                    line.add(content);
                    line.add(date);
                    
               
                    line.setBorder(new EmptyBorder(15, 15, 15, 15));
                  
                   /* JPanel line = new JPanel();
                    line.add(new JLabel("coucou"));
                    line.add(new JLabel("coucou2"));
                    line.setBackground(Color.red);*/
                    
                    NewsPanel.add(line);
                }               
            }
        }
         
        revalidate();
    }
    
    public String getNewsInput()
    {
        return NewsInputField.getText();
    }
    
    public void setNewsInput(String val)
    {
        NewsInputField.setText(val);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        projectNameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TodoPanel = new javax.swing.JPanel();
        NewsInputField = new javax.swing.JTextField();
        SendNewsBtn = new javax.swing.JLabel();
        NewsPanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1320, 1080));

        projectNameLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        projectNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        projectNameLabel.setText("Nom du projet");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Les news :");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Todo list :");

        TodoPanel.setBackground(new java.awt.Color(61, 61, 72));
        TodoPanel.setForeground(new java.awt.Color(61, 61, 72));

        javax.swing.GroupLayout TodoPanelLayout = new javax.swing.GroupLayout(TodoPanel);
        TodoPanel.setLayout(TodoPanelLayout);
        TodoPanelLayout.setHorizontalGroup(
            TodoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );
        TodoPanelLayout.setVerticalGroup(
            TodoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        NewsInputField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(9, 184, 255), 2, true));

        SendNewsBtn.setPreferredSize(new java.awt.Dimension(50, 50));

        NewsPanel.setBackground(new java.awt.Color(102, 102, 102));
        NewsPanel.setForeground(new java.awt.Color(102, 102, 102));
        NewsPanel.setMaximumSize(new java.awt.Dimension(400, 385));

        javax.swing.GroupLayout NewsPanelLayout = new javax.swing.GroupLayout(NewsPanel);
        NewsPanel.setLayout(NewsPanelLayout);
        NewsPanelLayout.setHorizontalGroup(
            NewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        NewsPanelLayout.setVerticalGroup(
            NewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NewsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NewsInputField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(projectNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SendNewsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(651, 651, 651)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TodoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)))
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projectNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NewsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SendNewsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NewsInputField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TodoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(493, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NewsInputField;
    private javax.swing.JPanel NewsPanel;
    private javax.swing.JLabel SendNewsBtn;
    private javax.swing.JPanel TodoPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel projectNameLabel;
    // End of variables declaration//GEN-END:variables
}
