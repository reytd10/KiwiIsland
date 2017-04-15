package nz.ac.aut.ense701.main;

import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.GameState;
import nz.ac.aut.ense701.gui.KiwiCountUI;
import nz.ac.aut.ense701.gui.Menu;

/**
 * Kiwi Count Project
 * 
 * @author AS
 * @version 2011
 */
public class Main 
{
    /**
     * Main method of Kiwi Count.
     * 
     * @param args the command line arguments
     */
    private static GameState state = GameState.MENU;
    public static void main(String[] args) 
    {
         //create a start / title scren menu
        final Menu menuGUI = new Menu();

        // make the GUI visible
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                menuGUI.setVisible(true);
            }
        });
    }

      public static GameState getState(){
        return state;
    }
    
    public static void setGameState(GameState s){
        state = s;
    }
    
    
}
