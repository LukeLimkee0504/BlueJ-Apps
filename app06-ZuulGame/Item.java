
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String itemName;
    private int value;

    /**
     * Constructor for objects of class Item
     */
    public Item(String itemName, int value)
    {
       this.itemName = itemName;
       this.value = value;
    }

    /**
     * @return a string containing the name of an item
     */
     public String getName()
    {
        return itemName;
    }
    
    /**
     * @return a string containing the name of an item
     */
    public String toString()
    {
        return itemName;
    }
    
    /**
     * @return a iunt containing score value of an item
     */
    public int getValue()
    {
        return value;
    }
}
