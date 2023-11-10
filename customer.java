// Customer class

import java.util.Scanner;
import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;

public class customer extends user
{
    public int balance = 100;
    public static transient ArrayList<cartitem> shoppingCart = new ArrayList<>();   // shoppingCart array list contains cartitem objects
    public static int index;

    public customer(String username, String password)
    {
        super(username, password);
        this.balance = balance;

        for (int i=0; i<user.customerList.size(); i++)
        {
            if (username.equals(user.customerList.get(i).getUsername()))
            {
                this.index = i;
            }
        }
    }

    public static void passCustomer(customer customer, int choice)  // Method to evaluate customer choice and call appropriate method
    {
        if (choice ==1)
        {
            customer.shopStore();
        }
        else if (choice == 2)
        {
            customer.viewAndCheckout();
        }
        else if (choice == 3)
        {
            customer.viewBalance();
        }
        else if (choice == 4)
        {
            customer.addBalance();
        }
        else
        {
            System.out.println("Have a nice day!");
        }
    }

    public void shopStore()
    {
        System.out.println();
        System.out.println("******** Shop the Store ********");
        for (int i=0; i<inventory.shopInventory.size(); i++)   // Cycle through inventory to display each product name, price, and quantity
        {
            System.out.println("Name: " + inventory.shopInventory.get(i).getProductName());
            System.out.println("Count: " + inventory.shopInventory.get(i).getProductQuantity());
            System.out.println("Price: $" + inventory.shopInventory.get(i).getProductPrice());
            System.out.println();
        }

        System.out.print("Enter the product you want to add to your cart: ");
        Scanner inputScanner = new Scanner(System.in);
        String productToAdd = inputScanner.nextLine();       // Read in product the user wants to add to cart
        boolean productInStock = false;
        int productCost=0;
        int maxQuantity = 0;

        for (int i = 0; i < inventory.shopInventory.size(); i++)
        {
            if (inventory.shopInventory.get(i).getProductName().equals(productToAdd))       // Cycle through the inventory to find the product
            {
                maxQuantity = inventory.shopInventory.get(i).getProductQuantity();     // Determine the maximum quantity the customer can buy by getting the quantity of that product in stock
                productCost = inventory.shopInventory.get(i).getProductPrice();        // Get the price of that product
                productInStock = true;                                                 // Change productInStock to true and exit the loop
                break;
            }
        }

        if (productInStock)          // Evaluate productInStock to ensure it exists
        {
            System.out.print("Enter quantity: ");
            int quantityToAdd = inputScanner.nextInt();     // Read in quantity the user desires

            if (quantityToAdd > maxQuantity)        // Ensure desired quantity does not exceed amount in stock
            {
                System.out.println("Sorry, we do not have enough of that product in stock");
            }
            else
            {
                cartitem cartitem = new cartitem(productToAdd, quantityToAdd, productCost);   // Create a new cartitem
                shoppingcart.addItem(cartitem, quantityToAdd);                                // Call method to add item to shopping cart
                System.out.println();
                System.out.println("Success: The product has been added to your shopping cart");
            }
        }
        else
        {
            System.out.println("Sorry, we do not carry that product");
        }

        store.displayMenu(2);
    }

    public void viewAndCheckout()
    {
        System.out.println();
        System.out.println("******** View and checkout shopping cart ********");
        System.out.println("Your balance: $" + balance);
        System.out.println();

        if (shoppingcart.viewShoppingCart() == 2)
        {
            int total = shoppingcart.getTotal();       // Call method to get total of shopping cart
            System.out.println("Checkout (Y/N)?");
            Scanner inputScanner = new Scanner(System.in);
            char checkoutAnswer = inputScanner.next().charAt(0);  // Prompt the user to checkout and read in answer
            System.out.println();

            if (checkoutAnswer == 'Y')          // If they choose to check out, ensure they have the money to cover the purchase
            {
                if (balance >= total)
                {
                    shoppingcart.checkout(shoppingCart);    // Call checkout method which clears the customer's cart
                    setBalance(-total);
                    System.out.println("Your new balance: $" + balance);      // Decrease balance by purchase amount and display
                }
                else
                {
                    System.out.println("Insufficient funds");     // If their balance doesn't cover the total, print error message
                }
            }
        }

        store.displayMenu(2);
    }

    public void viewBalance()
    {
        System.out.println();
        System.out.println("Balance: $" + balance);  // Display current customer balance
        store.displayMenu(2);
    }

    public void addBalance()
    {
        int randomNumber = (int)Math.floor(Math.random()*5)+1;  // To add balance, user must guess a random number between 1 and 5

        System.out.println();
        System.out.println("I'm thinking of a number 1-5. Can you guess it?");
        System.out.print("Your guess: ");
        Scanner inputScanner = new Scanner(System.in);
        int userGuess = inputScanner.nextInt();        // Read in user guess

        if (userGuess == randomNumber)
        {
            setBalance(100);                    // If they guess correctly, add $100 to their balance
            System.out.println("Corret! $100 has been added to your balance");
        }
        else
        {
            System.out.println("Sorry, incorrect guess");
        }
        
        store.displayMenu(2);
    }

    public int getBalance()  // Method to get customer balance
    {
        return balance;
    }

    public void setBalance(int amount)   // Method to set customer balance
    {
        this.balance = balance + amount;
    }
}
