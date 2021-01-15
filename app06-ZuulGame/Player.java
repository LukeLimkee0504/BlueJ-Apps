import java.util.ArrayList;
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
    public ArrayList<Item> inventory = new ArrayList<Item>();            // stores items of this room

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
    
    public void addScore(int poop)
    {
        score = score + poop;
    }
    
    public void useEnergy(int amount)
    {
        energy = energy - amount;
    }
    
    public void addToInventory(Item item)
    {
        inventory.add(item);
    }
    
    
}
