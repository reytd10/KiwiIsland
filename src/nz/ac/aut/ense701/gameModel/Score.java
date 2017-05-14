package nz.ac.aut.ense701.gameModel;


/**
 *
 * @author Michael Jordan (14868336)
 */
public class Score {
    public String name;
    public Integer score;
    public Integer kiwi;
    public Integer predator;
    public double stamina;
    public Integer items;
    
    public Score(String name, Integer kiwi, Integer predator, double stamina, Integer items){
        this.name = name;
        this.kiwi = kiwi;
        this.predator = predator;
        this.stamina = stamina;
        this.items = items;
        this.score = (int) Math.round((kiwi*100) + (predator*50) - (100-stamina)*5 - (items*25));
    }
    
    public String toString(){
        return "["+name+"]: Score: "+score+", Kiwis: "+kiwi+", Predators: "+predator+", Stamina left: "+stamina+", Items used: "+items;
    }
}
