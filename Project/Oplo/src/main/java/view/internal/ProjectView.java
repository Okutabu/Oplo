/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.internal;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import model.utility.*;
import org.json.simple.*;
import view.*;
import controller.*;
import javax.swing.JCheckBox;
import model.*;
/**
 *
 * @author Okutabu
 */
public class ProjectView extends javax.swing.JInternalFrame {

    private ManageProjectModel model;
    private JPanel NewsPanel;
    private JPanel TodoPanel;
    
    public ProjectView(String projectName)
    {
        initComponents();
        Display.removeBorders(this);
        this.getContentPane().setBackground(new Color(35,35,40));
        
        this.model = new ManageProjectModel(this, projectName);

        projectNameLabel.setText(projectName);
        NewsPanel = new JPanel();
        NewsPanel.setBackground(new Color(102, 102, 102));
        NewsPanel.setMaximumSize(new Dimension(400, 400));
        
        TodoPanel = new JPanel();
        TodoPanel.setBackground(new Color(102, 102, 102));
        TodoPanel.setLayout(new BoxLayout(TodoPanel, javax.swing.BoxLayout.Y_AXIS));
        //TodoPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        SendNewsBtn.addMouseListener(new SendMessagesController(model, this));
        
        projectOwnerLabel.setText("Chef de projet : " + model.getCreator());
        
        addTaskBtn.addActionListener(new AddTaskController(model, this));
        
        retrieveToDoList();
        retrieveNews();
        retrieveMembersList();
        InitSendNews();
    }
    
    public void InitSendNews() 
    {
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
        TodoPanel.removeAll();
        ServerCommunication s = new ServerCommunication();
        String res = s.sendPostRequest("retrieveProjectTodoList&projectName=" + model.getProjectName());
        
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;
        
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
                    
                    String taskTitle = newObj.get("title").toString();
                    //CheckboxLinkedToTask checkbox = new CheckboxLinkedToTask(taskTitle, model);
                    JCheckBox checkbox = new JCheckBox(taskTitle);
                    checkbox.setForeground(Color.white);
                    checkbox.addActionListener(new TaskToggleController(checkbox, model));
                    checkbox.setSize(30, 30);
                    checkbox.setOpaque(true);
                    checkbox.setBackground(new Color(61, 61, 72));
                    
                    if(Integer.parseInt(newObj.get("done").toString()) == 0)
                    {
                        checkbox.setSelected(false);
                    }
                    else
                    {
                        checkbox.setSelected(true);
                    }
                    
                    line.add(checkbox);
                    //JLabel label = new JLabel(newObj.get("title").toString());
                    //label.setOpaque(true);
                    //label.setBackground(new Color(61, 61, 72));
                    //label.setForeground(Color.WHITE);
                    //line.add(label);
                    TodoPanel.add(line);
                }               
            }
        }
        
        TodoScrollPanel.setViewportView(TodoPanel);
        revalidate();
    }
    
    public void retrieveNews()
    {
        NewsPanel.removeAll();
        
        ServerCommunication s = new ServerCommunication();
        String res = s.sendPostRequest("retrieveProjectNews&projectName=" + model.getProjectName());
        
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;
        
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
                    content.setOpaque(true);
                    content.setEditable(false);    
                    content.setWrapStyleWord(true);
                    content.setLineWrap(true);
                    content.setBackground(new Color(51, 51, 51));
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
        
        NewsScrollView.setViewportView(NewsPanel);
        revalidate();
    }
    
    public void retrieveMembersList()
    {
        ServerCommunication s = new ServerCommunication();
        String res = s.sendPostRequest("retrieveMembersList&projectName=" + model.getProjectName());
        
        JPanel innerPanel = new JPanel();
        innerPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        innerPanel.setBackground(new Color(102, 102, 102));
        innerPanel.setForeground(new Color(102, 102, 102));
        
        Object o = JSONValue.parse(res);
        JSONArray jsonArray = (JSONArray) o;     
        
        innerPanel.setLayout(new GridLayout(jsonArray.size(), 1));
        
        for(Object object:jsonArray)
        {
            if(object instanceof JSONObject)
            {
                JSONObject jsonObject = (JSONObject)object;
                Set<String> keys = jsonObject.keySet();
                
                for(String key:keys)
                {
                    Object newJson = jsonObject.get(key);
                    //JSONObject newObj = (JSONObject)newJson;  

                    JLabel newLabel = new JLabel(key);
                    newLabel.setForeground(Color.white);
                    innerPanel.add(newLabel);
                }               
            }
        }
        
        MembersListPanel.setViewportView(innerPanel);
    }
    
    public String getNewsInput()
    {
        return NewsInputField.getText();
    }
    
    public void setNewsInput(String val)
    {
        NewsInputField.setText(val);
    }
    
    public String getNewTaskInput()
    {
        return newTaskInputField.getText();
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        projectNameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NewsInputField = new javax.swing.JTextField();
        SendNewsBtn = new javax.swing.JLabel();
        MembersListPanel = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        NewsScrollView = new javax.swing.JScrollPane();
        addTaskBtn = new com.k33ptoo.components.KButton();
        newTaskInputField = new javax.swing.JTextField();
        projectOwnerLabel = new javax.swing.JLabel();
        TodoScrollPanel = new javax.swing.JScrollPane();

        setPreferredSize(new java.awt.Dimension(1320, 1080));

        projectNameLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        projectNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        projectNameLabel.setText("Nom du projet");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Les news :");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Todo list :");

        NewsInputField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(9, 184, 255), 2, true));

        SendNewsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SendNewsBtn.setPreferredSize(new java.awt.Dimension(50, 50));

        MembersListPanel.setBackground(new java.awt.Color(102, 102, 102));
        MembersListPanel.setForeground(new java.awt.Color(102, 102, 102));
        MembersListPanel.setMaximumSize(new java.awt.Dimension(213, 300));
        MembersListPanel.setMinimumSize(new java.awt.Dimension(213, 300));
        MembersListPanel.setPreferredSize(new java.awt.Dimension(213, 300));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Les membres :");

        addTaskBtn.setText("Ajouter cette tâche");
        addTaskBtn.setkEndColor(new java.awt.Color(204, 0, 204));
        addTaskBtn.setkHoverEndColor(new java.awt.Color(255, 0, 255));
        addTaskBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        addTaskBtn.setkStartColor(new java.awt.Color(204, 0, 204));

        newTaskInputField.setText("Nouvelle tache...");

        projectOwnerLabel.setBackground(new java.awt.Color(255, 255, 255));
        projectOwnerLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectOwnerLabel.setForeground(new java.awt.Color(255, 255, 255));
        projectOwnerLabel.setText("Chef de projet :");

        TodoScrollPanel.setMaximumSize(new java.awt.Dimension(185, 285));
        TodoScrollPanel.setMinimumSize(new java.awt.Dimension(185, 285));
        TodoScrollPanel.setPreferredSize(new java.awt.Dimension(185, 285));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NewsInputField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(projectNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NewsScrollView))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SendNewsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(projectOwnerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 593, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28))
                        .addComponent(MembersListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(newTaskInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TodoScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projectNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TodoScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(newTaskInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MembersListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NewsScrollView, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SendNewsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NewsInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(projectOwnerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(293, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane MembersListPanel;
    private javax.swing.JTextField NewsInputField;
    private javax.swing.JScrollPane NewsScrollView;
    private javax.swing.JLabel SendNewsBtn;
    private javax.swing.JScrollPane TodoScrollPanel;
    private com.k33ptoo.components.KButton addTaskBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField newTaskInputField;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JLabel projectOwnerLabel;
    // End of variables declaration//GEN-END:variables
}
