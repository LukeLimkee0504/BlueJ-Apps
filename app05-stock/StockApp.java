
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
     * Starts the program
     */
    public void run()
    {
        printHeading();
        getMenuChoice();
    }
    
    /**
     * All of the diffrent menu choices and thier given responses
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
                    while(name.length() < 1)
                    {
                        System.out.println("Product must have a name");
                        System.out.println("Please input a name for this product");
                        name = input.getInput();
                   }
                
                System.out.println("Please input the id of the product");
                int id = input.getInt();
                
                while(!stockManager.addProduct(new Product(name,id)))
                {
                    System.out.println("A product with that id already exists");
                    System.out.println("Please input a diffrent id for this product");
                    id = input.getInt();
                }
                
              
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
                System.out.println("Please enter the minimum stock level");
                int minimum = input.getInt();
                stockManager.printLowStockProducts(minimum);
            }
            else if(choice.equals("Restock")) 
            {
                System.out.println("Please enter the minimum stock level of items you want to restock");
                int minimum = input.getInt();
                stockManager.printLowStockProducts(minimum);
                System.out.println("Please enter the amount you would like to restock to");
                int restockAmount = input.getInt();
                stockManager.restockProducts(minimum, restockAmount);
            }
            else if(choice.equals("Quit")) 
            {
                System.out.println("Program ended");
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
        System.out.println("    Delivery:   Receive a delivery of a product and add it to stock");
        System.out.println("    Sell:       Sell a product from stock");
        System.out.println("    Search:     Search for a product in stock");
        System.out.println("    Low Stock:  List products with low stock");
        System.out.println("    Restock:    Restock low stock products to a given amount");
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
