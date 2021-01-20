import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author (Luke Lim-kee)
 * @version (20/1/21)
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
    
     /**
     * @return string off all items in the players inventory
     */
    public String printInventory()
    {
        System.out.println (" You open up your bag, inside you have");
        
        for(Item item : inventory)
            { 
                System.out.println (item.toString());  
            }
            return null;
    }
    
     /**
     * @return player energy
     */
    public int getEnergy()
    {
        return energy;
    }
    
     /**
     * @return player score
     */
    public int getScore()
    {
        return score;
    }
    
     /**
     * @return player food amount
     */
    public int getFood()
    {
        return food;
    }
    
     /**
     * @adds an int of food to player food
     */
    public void addFood(int amount)
    {
        food = food + amount;
    }
    
     /**
     * @remove an int of food to player food
     */
    public void removeFood(int amount)
    {
        food = food - amount;
    }
    
      /**
     * @add an int value to the players score
     */
    public void addScore(int value)
    {
        score = score + value;
    }
    
      /**
     * @add an int value to the players energuy
     */
    public void addEnergy(int amount)
    {
        energy = energy + amount;
    }
    
      /**
     * @remove an int amount of energy from the players energy
     */
    public void useEnergy(int amount)
    {
        energy = energy - amount;
    }
    
      /**
     * @recives an items and adds it tot he player inventory
     */
    public void addToInventory(Item item)
    {
        inventory.add(item);
    }
    
      /**
     * @returns all items in the players inventory
     */
    public Item getInventory()
    {
       for(Item item : inventory)
            {
               return item;
            }
            return null;
    }
    
    
}
