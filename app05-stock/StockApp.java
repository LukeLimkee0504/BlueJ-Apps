
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
                System.out.println("Please input the name of the product");
                String name = input.getInput(); 
                
                System.out.println("Please input the id of the product");
                int id = input.getInt();
                
                stockManager.addProduct(new Product (name, id));
                System.out.println("Product added : " + name + " " +  id);
                
            }
            else if(choice.equals("Remove")) 
            {
                System.out.println("Please input the id of the product");
                int id = input.getInt();
                
                stockManager.removeProduct(id);
                System.out.println("Product removed : " +  id);
            }
            else if(choice.equals("PrintAll")) 
            {
                stockManager.printProductDetails();
                System.out.println("Products Printed");
            }
            else if(choice.equals("Delivery")) 
            {
                System.out.println("Please input the id of the product");
                int id = input.getInt();
                
                System.out.println("Please enter the amount delivered");
                int amount = input.getInt();
                stockManager.delivery(id, amount);
            }
            else if(choice.equals("Sell")) 
            {
                System.out.println("Please input the id of the product");
                int id = input.getInt();
                
                System.out.println("Please enter the amount sold");
                int amount = input.getInt();
                stockManager.sale(id, amount);
            }
            else if(choice.equals("Search")) 
            {
                System.out.println("Please enter the name of the product");
                String searchCriteria = input.getInput();
                stockManager.getProductByName(searchCriteria);
            }
            else if(choice.equals("Low Stock")) 
            {
                stockManager.printLowStockProducts();
            }
            else if(choice.equals("Quit")) 
            {
                System.out.println("Program ended");
                finished = true;
            }
            else
            {
               System.out.println("Invalid response, please input one of the following commands"); 
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
        System.out.println("    Delivery:   Receive a delivery of a product and add it to stock");
        System.out.println("    Sell:       Sell a product from stock");
        System.out.println("    Search:     Search for a product in stock");
        System.out.println("    Low Stock:  List products with low stock");
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
