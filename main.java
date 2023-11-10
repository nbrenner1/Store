import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;

public class main implements Serializable
{
    public static store store = new store();
    public static inventory inventory;
    public static ArrayList<customer> customers;
    public static ArrayList<product> shopInventory;
    public static ArrayList<cartitem> savedShoppingCart;

    @SuppressWarnings("unchecked")
    public static void main(String args[])
    {
        shopInventory = (ArrayList<product>) filemanager.loadObject("shopInventory.ser");   // Load in inventory
        if (shopInventory == null)
        {
            shopInventory = new ArrayList<product>();        // If no inventory to load in, create a new inventory with the base products
            shopInventory.add(new product("Football", 60, 25));
            shopInventory.add(new product("Basketball shoes", 20, 100));
            shopInventory.add(new product("Cornhole set", 50, 80));
            shopInventory.add(new product("Water bottle", 200, 15));
            shopInventory.add(new product("Soccer goal", 30, 120));
        }
        inventory.shopInventory = shopInventory;

        customers = (ArrayList<customer>) filemanager.loadObject("users.ser");      // Load in customer
        if (customers == null)
        {
            customers = new ArrayList<customer>();
        }
        user.customerList = customers;

        savedShoppingCart = (ArrayList<cartitem>) filemanager.loadObject("shoppingCart.ser");   // Load in shopping cart
        if (savedShoppingCart == null)
        {
            savedShoppingCart = new ArrayList<cartitem>();
        }
        customer.shoppingCart = savedShoppingCart;

        store.openStore();   // Open the store

        filemanager.saveData("shopInventory.ser", "users.ser", "shoppingCart.ser", shopInventory, customers, savedShoppingCart);   // Save data at end of program run
    }
}
