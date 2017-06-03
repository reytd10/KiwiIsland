/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import nz.ac.aut.ense701.database.Manager;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.GameState;
import nz.ac.aut.ense701.main.Main;


/**
 *
 * @author Victor-PC
 */
public class Menu extends javax.swing.JFrame {
    private Manager database;
    private int itemCount = 0;
    /**
     * Creates new form NewJFrame
     */
    public Menu() {
        initComponents();
        Main.setGameState(GameState.MENU);      
        setResizable(false);
        setLocationRelativeTo(null);
    }

    

    
    /**
     * Screen change happens by changing the setVisible method 
     * The Frames in the starting frame should not have key functionality
     * therefore not affect the invisible frames invisible 
     * 
     * **Need to look for better solution
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new ImagePanel(loadTitleImage());
        buttonPanel = new javax.swing.JPanel();
        StartButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        HighscoreButton = new javax.swing.JButton();
        levelSelect = new javax.swing.JScrollPane();
        mapList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Title Screen");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );

        getContentPane().add(titlePanel, java.awt.BorderLayout.PAGE_START);

        StartButton.setText("Start");
        StartButton.setToolTipText("");
        StartButton.setName(""); // NOI18N
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        HighscoreButton.setText("Highscore");
        HighscoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HighscoreButtonActionPerformed(evt);
            }
        });

        mapList.setModel(getMapItems());
        mapList.setSelectedIndex(0);
        levelSelect.setViewportView(mapList);

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(levelSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addComponent(StartButton, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addComponent(HighscoreButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(372, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(StartButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(levelSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HighscoreButton)
                .addGap(35, 35, 35)
                .addComponent(ExitButton)
                .addGap(0, 50, Short.MAX_VALUE))
        );

        getContentPane().add(buttonPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    //create new game and GUI when start button is clicked
    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
        final Game game;
        if(mapList.getSelectedIndex() <= 0) randomSelectMap();
            
        game = new Game(mapList.getSelectedValue(), true);
        final KiwiCountUI  gui  = new KiwiCountUI(game);
        gui.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_StartButtonActionPerformed
    private DefaultListModel getMapItems(){
        File directory = new File("./Maps");
        File[] files = directory.listFiles();
        DefaultListModel<String> maps = new DefaultListModel<String>();
        maps.addElement("Random Map");
        for(int i = 0; i < files.length; i++){
            if(files[i].getName().endsWith(".txt")){
                String temp = files[i].getName();
                String filename = temp.substring(0, temp.length()-4);
                maps.addElement(filename);
                itemCount++;
            }
        }
        return maps;
    }
    private Image loadTitleImage(){
        try {
            return ImageIO.read(getClass().getResource("/assets/menuLogo.png"));
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private void randomSelectMap(){
        Random rnd = new Random();
        int result = rnd.nextInt(itemCount)+1; // 1...2
        mapList.setSelectedIndex(result);
    }
    private void HighscoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HighscoreButtonActionPerformed
        database = new Manager("HighscoreDB","Scores");
        DatabaseUI databaseUI = new DatabaseUI(database);
        databaseUI.setVisible(true);
    }//GEN-LAST:event_HighscoreButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton HighscoreButton;
    private javax.swing.JButton StartButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JScrollPane levelSelect;
    private javax.swing.JList<String> mapList;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables
}
