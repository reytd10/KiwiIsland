
package nz.ac.aut.ense701.database;

import java.sql.SQLException;
import java.util.Random;
import org.junit.Test;

/**
 *
 * @author Michael Jordan (14868336)
 */
public class ManagerTest extends junit.framework.TestCase{
    private Manager manager;
    private Random rnd;
    
    public ManagerTest(){
        
    }
    
    @Override
    protected void setUp(){
        manager = new Manager("TestDB","SCORES");
        rnd = new Random();
    }
    @Override
    protected void tearDown(){
        try {
            manager.close();
            manager = null;
            rnd = null;
        } catch (SQLException ex) {
            System.err.println("ERROR: "+ex);
        }
    }
    /**
     * Tests if a single score can be added to a new database.
     */
    @Test
    public void testPushToDatabase(){
        try {
            manager.clearTable();
            //Generate a random score.
            Score score = new Score("Test <1>", rnd.nextInt(10), rnd.nextInt(10), 0 + (100*rnd.nextDouble()), rnd.nextInt(10));
            manager.pushToDB(score);
            assertEquals(score.score, manager.getScore(1).score);
        } catch (SQLException ex) {
            assertFalse("Exception created: "+ex, false);
        }
    }
    /**
     * Tests if a single score can be added to a full database.
     */
    @Test
    public void testFullBoard(){
        try {
            manager.clearTable();
            //Generate a random scores.
            for(int i = 1; i <= 10; i++){
                Score score = new Score("Test <"+i+">", rnd.nextInt(10), rnd.nextInt(10), 0 + (100*rnd.nextDouble()), rnd.nextInt(10));
                manager.pushToDB(score);
            }
            //Generate a new Score inwhich will definitly reach the top of the board.
            Score score = new Score("Test <11>",100,100,100,0);
            manager.pushToDB(score);
            assertEquals(score.score, manager.getScore(1).score); //Note: index of 1 is the highest score.
        } catch (SQLException ex) {
            assertFalse("Exception created: "+ex, false);
        }
    }
}
