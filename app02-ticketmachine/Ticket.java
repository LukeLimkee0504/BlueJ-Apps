
/**
 * Class which can create ticket objects to be used with a ticket machine object.
 *
 * @author (Luke Limkee)
 * @version (18.10.2020)
 */
public class Ticket
{
    // price of ticket
    private int price;
    //destination of ticket
    private String destination;

    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(String ticketDestination, int ticketPrice)
    {
       price = ticketPrice;
       destination = ticketDestination;
    }
    
     /**
     * Return The price of this ticket
     */
    public int getPrice()
    {
        return price;
    }
    
     /**
     * Return The price of this ticket
     */
    public String getDestination()
    {
        return destination;
    }


}
