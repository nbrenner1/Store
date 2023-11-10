// Inventory class

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;

public class inventory implements Serializable
{
    private static int numProducts;
    public static transient ArrayList<product> shopInventory = new ArrayList<>();   // shopInventory array list contains product objects

    public inventory()
    {
        this.numProducts = shopInventory.size();
    }

    public static int getNumProducts()   // Method to get the total number of products
    {
        return numProducts;
    }

    public static void addProduct(String newProductName, int newProductQuantity, int newProductPrice)  // Method to add a new product
    {
        shopInventory.add(new product(newProductName, newProductQuantity, newProductPrice));
        numProducts++;    // Increment total number of products
    }

    public static void removeProduct(int index)   // Method to remove a product
    {
        shopInventory.remove(index);
        numProducts--;    // Decrement total number of products
    }
}
