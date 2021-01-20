import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    private String inspection;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> items = new ArrayList<Item>();
    private int food;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     * @param inspection The rooms inspection description.
     * @param food The room's amount of food.
     */
    public Room(String description, String inspection, int food) 
    {
        this.description = description;
        this.inspection = inspection;
        this.food = food;
        items = new ArrayList<>();
        exits = new HashMap<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n\n" + getExitString();
    }
    
     /**
     * @return The inspection description of the room
     */
     public String getInspectDescription()
    {
        return inspection;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    /**
     * removes all items from a room
     */
    public void removeRoomItems()
    {
        for (Item item : items)
        {
            items.remove(item);
            return;
        } 
    }
    
    /**
     * @return The rooms arraylist
     */
    public ArrayList<Item> getItemsArray()
    {
       return items;
    }
    
    /**
     * @return a string containing all the names of the items in the room
     */
    public String getItemsString()
    {
       for(Item item : items)
            {
               return item.toString();
            }
            return null;
    }
    
    /**
     * @return a string containing all the names of the items in the room
     */
    public void printItems()
    {
        for(Item item : items)
            { 
                 System.out.println (item.toString());  
            }
    }
    
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * @return a in amount of food in a room
     */
    public int getFoodAmount()
    {
        return food;
    }
    
    /**
     * remove all the food in a room
     */
    public void removeFood()
    {
        food = 0;
    }
}

