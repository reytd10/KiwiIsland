/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.GameState;
import nz.ac.aut.ense701.main.Main;


/**
 *
 * @author Victor-PC
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Menu() {
        initComponents();
        Main.setGameState(GameState.MENU);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        StartButton = new javax.swing.JButton();
        HighscoreButton = new javax.swing.JButton();
        OptionsButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Title Screen");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel7.setLayout(new java.awt.GridLayout(0, 1));

        StartButton.setText("Start");
        StartButton.setToolTipText("");
        StartButton.setName(""); // NOI18N
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });
        jPanel7.add(StartButton);

        HighscoreButton.setText("Highscore");
        HighscoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HighscoreButtonActionPerformed(evt);
            }
        });
        jPanel7.add(HighscoreButton);

        OptionsButton.setText("Options");
        OptionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsButtonActionPerformed(evt);
            }
        });
        jPanel7.add(OptionsButton);

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        jPanel7.add(ExitButton);

        jPanel4.add(jPanel7, new java.awt.GridBagConstraints());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Victor-PC\\Documents\\NetBeansProjects\\JavaApplication8\\cooltext240439988433085.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(220, 220, 220))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 427, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    //create new game and GUI when start button is clicked
    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
        Main.setGameState(GameState.PLAYING);
        final Game game = new Game();
        final KiwiCountUI  gui  = new KiwiCountUI(game);
        dispose();
        
    }//GEN-LAST:event_StartButtonActionPerformed

    private void OptionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsButtonActionPerformed
        Main.setGameState(GameState.OPTIONS);
    }//GEN-LAST:event_OptionsButtonActionPerformed

    private void HighscoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HighscoreButtonActionPerformed
        
    }//GEN-LAST:event_HighscoreButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton HighscoreButton;
    private javax.swing.JButton OptionsButton;
    private javax.swing.JButton StartButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
