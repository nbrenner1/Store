// Cart item class

import java.io.*;
import java.util.Scanner;

public class cartitem implements Serializable
{
    String productName;
    int productQuantity;
    int productPrice;

    public cartitem(String productName, int productQuantity, int productPrice)
    {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public String getProductName()   // Method to get the name of a cart item
    {
        return productName;
    }

    public int getProductQuantity()  // Method to get the quantity of a cart item
    {
        return productQuantity;
    }

    public int getProductPrice()     // Method to get the price of a cart item
    {
        return productPrice;
    }
}
