// Shopping cart class

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class shoppingcart implements Serializable
{
    public static int numProducts;
    public static int totalCost;
    public static int tempCost;

    public shoppingcart()
    {
        this.numProducts = numProducts;
        this.totalCost = totalCost;
    }

    public static void addItem(cartitem itemToAdd, int quantity)   // Method to add to shopping cart
    {
        customer.shoppingCart.add(itemToAdd);                                          // Add to array list
        int cost = customer.shoppingCart.get(customer.shoppingCart.size() - 1).getProductPrice();  // Get the cost of that new product by getting the price of the last item in the cart
        cost *= quantity;                                                        // Calculate cost by multiplying price by quantity
        totalCost += cost;                                      // Increment the total cart cost by cost
        numProducts++;                                                           // Increment the number of items in the cart
    }

    public static void checkout(ArrayList<cartitem> shoppingCart)
    {
        for (int i=0; i<shoppingCart.size(); i++)     // Double FOR loops to find each cart item in the inventory 
        {                                             // and decrement the inventory amount by the amount purchased
            for (int k=0; k<inventory.shopInventory.size(); k++)
            {
                if (shoppingCart.get(i).getProductName().equals(inventory.shopInventory.get(k).getProductName()))
                {
                    inventory.shopInventory.get(k).setProductQuantity(-(shoppingCart.get(i).getProductQuantity()));
                    break;
                }
            }
        }

        shoppingCart.clear();   // Clear the customer.shoppingCart array list of cart items
        totalCost = 0;       // Reset the total cost of the cart to 0
        System.out.println("Thank you for shopping at Nick's Sporting Goods");
    }

    public static int getTotal()   // Method to get the total cost of the cart
    {
        return totalCost;
    }

    public static int viewShoppingCart()
    {
        int tempCost = 0;
        if (customer.shoppingCart.size()<1)    // Check if shopping cart is empty
        {
            System.out.println("Shopping cart is empty. Please select \"Shop the store\" to add items");
            return 1;
        }
        else
        {
            for (int i=0; i<customer.shoppingCart.size(); i++)           // FOR loop to print name, quantity, and price of
            {                                                            // each product in the customer's shopping cart
                System.out.println("Name: " + customer.shoppingCart.get(i).getProductName());
                System.out.println("Count: " + customer.shoppingCart.get(i).getProductQuantity());
                System.out.println("Price: $" + customer.shoppingCart.get(i).getProductPrice());
                tempCost += (customer.shoppingCart.get(i).getProductQuantity()*customer.shoppingCart.get(i).getProductPrice());
                System.out.println();
            }
            totalCost = tempCost;
            System.out.println("Total: $" + totalCost);    // Display cart total
            System.out.println();
            return 2;
        }
    }
}
