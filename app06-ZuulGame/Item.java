
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

    /**
     * Constructor for objects of class Item
     */
    public Item(String name)
    {
       itemName = name;
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
