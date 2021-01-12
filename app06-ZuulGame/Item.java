
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


     public String getName()
    {
        return itemName;
    }
    
    public String toString()
    {
        return itemName;
    }
}
