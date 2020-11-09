import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }
    
    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
     /**
     * Checks to  see if the product id provided is eqeal to one in stock.
     * @param id The ID of the product.
     * @param product the product in the stock.
     */
    public boolean checkID(Product product, int id)
    {
        if (product.getID() == id)
        {
            return true;
        }
        return false;
    }
        
    /**
     * Remove a product from stock.
     * @param id The ID of the product.
     */
    public void removeProduct(int id)
    {
        for(Product product : stock)
        {
            if (checkID(product,id) == true)
            {
                stock.remove(product);
                return;
            }
        }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        for(Product product : stock)
        {
            if (checkID(product,id) == true)
            {
                product.increaseQuantity(amount);
            }
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for(Product product  : stock) {
            if (checkID(product,id) == true)
            {
                return product;
            }
    }   return null;
}
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        for(Product product : stock)
        {
            if (checkID(product,id) == true)
            {
                return product.getQuantity();
            }
        }
            return 0;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for(Product product : stock)
        {
            {
                System.out.println (product.toString());
            }
        }
        
    }
    
     /**
     * Print all products that are under 2 in quntity
     */
    public void  printLowStockProducts()
    {
        for(Product product : stock)
        {
            {
                if (product.getQuantity() <  2)
                {
                System.out.println (product.toString());
                }
            }
        }
        
    }
    
    /**
     * Searches for a product in stock containing searchstring.
     * @param searchstring The thing you want to search for.
     */
    public void getProductByName(String searchstring)
    {
        for(Product product  : stock) 
        {
            if (product.getName().contains (searchstring)) 
            {
                System.out.println (product.toString());
            }
        }  
    }
    
    /**
     * Searches for a product using the id and renames that product.
     * @param newName The new name for the product.
     * @param id The ID of the product you want to rename.
     */
     public void renameProduct(int id, String newName)
    {
        for(Product product  : stock) 
        {
            if (checkID(product,id) == true)
            {
                product.name = newName;
            }
        }  
    }
}
