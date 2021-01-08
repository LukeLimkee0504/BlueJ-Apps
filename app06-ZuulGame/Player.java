
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private int energy;
    private int score;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise energy to max and score to 0 
        energy = 500;
        score = 0;
    }
    
    public int getEnergy()
    {
        return energy;
    }
    
    public int getScore()
    {
        return score;
    }
    
}
