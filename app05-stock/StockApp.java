
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Student Name
 * @version 0.1
 */
public class StockApp
{
    // Use to get user input
    private InputReader input;
    private StockManager stockManager;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        input = new InputReader();
        stockManager = new StockManager();
    }

    /**
     * 
     */
    public void run()
    {
        printHeading();
        getMenuChoice();
    }
    
    /**
     * 
     */
    public void getMenuChoice()
    {
        boolean finished = false;
        printHeading();    
        while(!finished)
        {
            
            printMenuChoices();
            String choice = input.getInput();
            if(choice.startsWith("Add")) 
            {
                
                System.out.println("Product added");
            }
            if(choice.equals("Remove")) 
            {
                System.out.println("Product Removed");
            }
            if(choice.equals("PrintAll")) 
            {
                stockManager.printProductDetails();
                System.out.println("Products Printed");
            }
            if(choice.equals("Quit")) 
            {
                finished = true;
            }
        }
    }
    
   
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
   
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Luke Lim-kee");
        System.out.println("******************************");
    }
    
    
}
