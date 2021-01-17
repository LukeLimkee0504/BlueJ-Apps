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
    private int food;
    public ArrayList<Item> inventory = new ArrayList<Item>();            // stores items of this room

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise energy to max and score to 0 
        energy = 500;
        score = 0;
        food = 0;
    }
    
    public String printInventory()
    {
        System.out.println (" You open up your bag, inside you have");
        
        for(Item item : inventory)
            { 
                System.out.println (item.toString());  
            }
            return null;
    }
    
    public int getEnergy()
    {
        return energy;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public int getFood()
    {
        return food;
    }
    
    public void addFood(int amount)
    {
        food = food + amount;
    }
    
    public void removeFood(int amount)
    {
        food = food - amount;
    }
    
    public void addScore(int value)
    {
        score = score + value;
    }
    
    public void addEnergy(int amount)
    {
        energy = energy + amount;
    }
    
    public void useEnergy(int amount)
    {
        energy = energy - amount;
    }
    
    public void addToInventory(Item item)
    {
        inventory.add(item);
    }
    
    public Item getInventory()
    {
       for(Item item : inventory)
            {
               return item;
            }
            return null;
    }
    
    
}
