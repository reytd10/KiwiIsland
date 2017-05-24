package nz.ac.aut.ense701.gui;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.Kiwi;
import nz.ac.aut.ense701.gameModel.Occupant;
import nz.ac.aut.ense701.gameModel.Position;
import nz.ac.aut.ense701.gameModel.Terrain;

/*
 * Panel for representing a single GridSquare of the island on the GUI.
 * 
 * @author AS
 * @version 1.0 - created
 */

public class GridSquarePanel extends javax.swing.JPanel 
{
    /** 
     * Creates new GridSquarePanel.
     * @param game the game to represent
     * @param row the row to represent
     * @param column the column to represent
     */
    public GridSquarePanel(Game game, int row, int column)
    {
        this.game   = game;
        this.row    = row;
        this.column = column;
        initComponents();
    }

    /**
     * Updates the representation of the grid square panel.
     */
    public void update() throws IOException
    {
        // get the GridSquare object from the world
        Terrain terrain   = game.getTerrain(row, column);
        boolean squareVisible = game.isVisible(row, column);
        boolean squareExplored = game.isExplored(row, column);
        
        Color      color;
        
        switch ( terrain )
        {
            case SAND     : color = Color.YELLOW; break;
            case FOREST   : color = Color.GREEN;  break;
            case WETLAND : color = Color.BLUE; break;
            case SCRUB : color = Color.DARK_GRAY;   break;
            case WATER    : color = Color.CYAN;   break;
            default  : color = Color.LIGHT_GRAY; break;
        }
        
        if ( squareExplored || squareVisible )
        {
            // Set the text of the JLabel according to the occupant
            lblText.setText(game.getOccupantStringRepresentation(row,column));
               //Adding icon image to tool tiles.
             if(game.getOccupantStringRepresentation(row, column).equals("T")){
                System.out.print("A Tool");
                if(game.getOccupantName(row, column).equals("Trap")) {
                     System.out.print("A Trap");
                     Image image = ImageIO.read(getClass().getResource("/assets/trap1.png"));
                     ImageIcon icon = new ImageIcon(image);                      
                     lblText.setIcon(icon);
                     lblText.setText("");   
                 }
                 if(game.getOccupantName(row, column).equals("Screwdriver")) {
                     System.out.print("A Screwdriver");
                     Image image = ImageIO.read(getClass().getResource("/assets/screwdriver1.png"));
                     ImageIcon icon = new ImageIcon(image); 
                    lblText.setIcon(icon);
                     lblText.setText(""); 
                     
                 }                                   
             }
             else{
                 lblText.setIcon(null);
             }
            //Adding icon image to Kiwi tiles.
            if(game.getOccupantStringRepresentation(row,column).contains("K")){
                Image image = ImageIO.read(getClass().getResource("/assets/kiwi.png"));
                ImageIcon icon = new ImageIcon(image); 
                lblText.setIcon(icon);
                lblText.setText("");
                boolean isNotCounted = false;
                Occupant[] occupants = game.getIsland().getOccupants(new Position(game.getIsland(), row, column));
                for(int i = 0 ; i < occupants.length; i++){
                    if(occupants[i] instanceof Kiwi){
                        if(!((Kiwi) occupants[i]).counted()){
                            isNotCounted = true;
                            break;
                        }
                    }
                }
                if(isNotCounted)
                    color = new Color(Math.min(255, color.getGreen()));
            }
            //Adding icon image to Predator tiles.
             if(game.getOccupantStringRepresentation(row,column).equals("P")){
                 
                Image image = ImageIO.read(getClass().getResource("/assets/predatorB.png"));
                ImageIcon icon = new ImageIcon(image); 
                lblText.setIcon(icon);
                lblText.setText("");                 
            }
            
             
            // Set the colour. 
            if ( squareVisible && !squareExplored ) 
            {
                // When explored the colour is brighter
                color = new Color(Math.min(255, color.getRed()   + 128), 
                                  Math.min(255, color.getGreen() + 128), 
                                  Math.min(255, color.getBlue()  + 128));
            }
            lblText.setBackground(color);
            // set border colour according to 
            // whether the player is in the grid square or not
            setBorder(game.hasPlayer(row,column) ? activeBorder : normalBorder);
        }
        else
        {
            lblText.setText("");
            lblText.setBackground(null);
            lblText.setIcon(null);
            setBorder(normalBorder);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblText = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.BorderLayout());

        lblText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setText("content");
        lblText.setOpaque(true);
        add(lblText, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
    
    private Game game;
    private int row, column;
    
    private static final Border normalBorder = new LineBorder(Color.BLACK, 1);
    private static final Border activeBorder = new LineBorder(Color.RED, 3);
}
