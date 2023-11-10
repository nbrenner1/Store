// Product class

import java.io.*;
import java.util.Scanner;

public class product implements Serializable
{
    String productName;
    int productPrice;
    int productQuantity;

    public product(String productName, int productQuantity, int productPrice)
    {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public String getProductName()  // Method to get the name of a certain product
    {
        return productName;
    }

    public int getProductPrice()   // Method to get the price of a certain product
    {
        return productPrice;
    }

    public int getProductQuantity()  // Method to get the quantity of a certain product
    {
        return productQuantity;
    }

    public void setProductQuantity(int amount)    // Method used to restock a product
    {
        this.productQuantity = productQuantity + amount;
    }
}
