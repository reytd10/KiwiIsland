
package nz.ac.aut.ense701.gameModel;

/**
 * Kiwi represents a kiwi living on the island
 * @author AS
 * @version July 2011
 */
public class Kiwi  extends Fauna
{
    private boolean counted;
    private Position pos;
    /**
     * Constructor for objects of class Kiwi
     * @param pos the position of the kiwi object
     * @param name the name of the kiwi object
     * @param description a longer description of the kiwi
     */
    public Kiwi(Position pos, String name, String description) 
    {
        super(pos, name, description);
        this.pos = pos;
        counted = false;
    } 
    
    /**
    * Count this kiwi
    */
    public void count() {
        counted = true;
    }
 
   /**
    * Has this kiwi been counted
    * @return true if counted.
    */
    public boolean counted() {
        return counted;
    }

    @Override
    public String getStringRepresentation() 
    {
        return "K";
    }
    
    public void moveKiwiPos(Position pos){
        this.pos = pos;
    }
    
}
