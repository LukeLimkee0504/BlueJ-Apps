/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Luke Limkee
 */

import java.util.Date;

public class TicketMachine
{
    // The price of the currrently selected ticket of this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //the current date
    private Date currentDate  = new Date();
    // The destination of the currently selected ticket
    private String destination;
    //list of avalible tickets
    private Ticket[] tickets = new Ticket[3];
    //selected ticket
    private Ticket selectedTicket;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        price = 0;
        destination = "none";
        balance = 0;
        total = 0;
    }
    
    public void addAvalibleTicket1(Ticket newTicket)
    {
        tickets[0] = newTicket;
    }
    
    public void addAvalibleTicket2(Ticket newTicket)
    {
        tickets[1] = newTicket;
    }
    
    public void addAvalibleTicket3(Ticket newTicket)
    {
        tickets[2] = newTicket;
    }
    
    public void selectTicket(Ticket newSelectedTicket)
    {
        selectedTicket = newSelectedTicket;
        price = newSelectedTicket.getPrice();
        destination = newSelectedTicket.getDestination();
    }
        
    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }
  
    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# "+ destination);
            System.out.println("# "+ currentDate);
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else 
        {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
