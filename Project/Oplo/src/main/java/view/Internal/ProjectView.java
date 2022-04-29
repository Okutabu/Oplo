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
import java.net.URLEncoder;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.utility.Display;
import model.utility.ServerCommunication;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import view.Home;
/**
 *
 * @author Okutabu
 */
public class ProjectView extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrameProjectDisplay
     */
    private String projectName;
    
    public ProjectView(String projectName)
    {
        initComponents();
        Display.removeBorders(this);
        this.getContentPane().setBackground(new Color(35,35,40));
        this.projectName = projectName;
        projectNameLabel.setText(projectName);
        retrieveToDoList();
        retrieveNews();
        TodoPanel.setLayout(new GridLayout(10, 1));
        NewsPanel.setLayout(new GridLayout(10, 1));
        NewsPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        TodoPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        initSendNews();
    }
    
    private void initSendNews() {
        if (Home.getUser().getRole().equals("Chef de projet")) {
            Image image = null;
            try {

                image = ImageIO.read(new File("src/main/java/resources/send.png"));
                Image scaled = image.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                sendButton.setIcon(new ImageIcon(scaled));
            } 
            catch (IOException e) {
            }
        } else {
            inputNews.setVisible(false);
            sendButton.setVisible(false);
        }
    }
    
    private void retrieveToDoList()
    {
        ServerCommunication s = new ServerCommunication();
        String res = s.sendPostRequest("https://oplo.000webhostapp.com/", "retrieveProjectTodoList&projectName=" + projectName);
        
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
                    Dimension minimumSize = new Dimension(100, 300);
                    line.setMinimumSize(minimumSize);
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
    }

   
    private void retrieveNews()
    {
        ServerCommunication s = new ServerCommunication();
        String res = s.sendPostRequest("https://oplo.000webhostapp.com/", "retrieveProjectNews&projectName=" + projectName.toString());
        
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
 
                    JLabel content = new JLabel(newObj.get("title").toString());
                    content.setForeground(Color.WHITE);
                    content.setFont(new Font("Verdana", Font.PLAIN, 15));
                    
                    JLabel date = new JLabel(newObj.get("date").toString());
                    date.setForeground(Color.WHITE);
                    line.add(content);
                    line.add(date);
                    
                    line.setBorder(new EmptyBorder(15, 15, 15, 15));
                    NewsPanel.add(line);
                }               
            }
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

        projectNameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TodoPanel = new javax.swing.JPanel();
        NewsPanel = new javax.swing.JPanel();
        inputNews = new javax.swing.JTextField();
        sendButton = new javax.swing.JLabel();

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

        NewsPanel.setBackground(new java.awt.Color(51, 51, 51));
        NewsPanel.setForeground(new java.awt.Color(51, 51, 51));
        NewsPanel.setMaximumSize(new java.awt.Dimension(500, 32767));
        NewsPanel.setPreferredSize(new java.awt.Dimension(400, 780));

        javax.swing.GroupLayout NewsPanelLayout = new javax.swing.GroupLayout(NewsPanel);
        NewsPanel.setLayout(NewsPanelLayout);
        NewsPanelLayout.setHorizontalGroup(
            NewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        NewsPanelLayout.setVerticalGroup(
            NewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        inputNews.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(9, 184, 255), 2, true));
        inputNews.setPreferredSize(new java.awt.Dimension(400, 143));
        inputNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNewsActionPerformed(evt);
            }
        });

        sendButton.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(projectNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(1078, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NewsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 649, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TodoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputNews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TodoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 647, Short.MAX_VALUE))
                    .addComponent(NewsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(inputNews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNewsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNewsActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel NewsPanel;
    private javax.swing.JPanel TodoPanel;
    private javax.swing.JTextField inputNews;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JLabel sendButton;
    // End of variables declaration//GEN-END:variables
}
