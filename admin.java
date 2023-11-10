// Admin class

import java.util.Scanner;
import java.io.Serializable;

public class admin implements Serializable
{
    public admin()
    {
        
    }

    public static void createCustomerAccount()  // Function to create a customer account
    {                                           // Similar to register user function in store - Verify password has length 5
        System.out.println(); 
        System.out.println("******** Create a customer account ********");
        System.out.print("Enter username: ");
        Scanner inputScanner = new Scanner(System.in);
        String inputUsername = inputScanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = inputScanner.nextLine();
        System.out.println();

        while (inputPassword.length() != 5)
        {
            System.out.println("Error: Password should be exactly 5 characters");
            System.out.println();
            System.out.print("Enter password: ");
            inputPassword = inputScanner.nextLine();
            System.out.println();
        }

        user.customerList.add(new customer(inputUsername, inputPassword));   // Add created customer to customerList

        System.out.println("Success: Customer account created");

        store.displayMenu(1);   // Return to admin menu
    }

    public static void removeCustomerAccount()
    {
        System.out.println();
        System.out.println("******** Remove a customer account ********");
        System.out.print("Enter username: ");
        Scanner inputScanner = new Scanner(System.in);
        String inputUsername = inputScanner.nextLine();
        boolean customerExists = false;
        
        for (int i=0; i < user.customerList.size(); i++)       // FOR loop to cycle through customerList to find the index
        {                                                      // of the customer to remove and verify they exist
            if (inputUsername.equals(user.customerList.get(i).getUsername()))
            {
                user.customerList.remove(i);                   // If found, remove and change customerExists to true
                customerExists = true;
            }
        }

        System.out.println();
        if (customerExists)        // Evaluate state of customerExists and display appropriate message
        {
            System.out.println("Success: Customer account removed");
        }
        else
        {
            System.out.println("Error: Customer account not found");
        }

        store.displayMenu(1);
    }

    public static void viewInventory()
    {
        System.out.println();
        System.out.println("******** View Inventory ********");
        for (int i=0; i<inventory.shopInventory.size(); i++)       // FOR loop to cycle through inventory ArrayList and display
        {                                                          // each product name, quantity, and price
            System.out.println("Name: " + inventory.shopInventory.get(i).getProductName());
            System.out.println("Count: " + inventory.shopInventory.get(i).getProductQuantity());
            System.out.println("Price: $" + inventory.shopInventory.get(i).getProductPrice());
            System.out.println();
        }

        store.displayMenu(1);
    }

    public static void addProduct()
    {
        System.out.println();
        System.out.println("******** Add a Product ********");
        System.out.print("Enter new product name: ");
        Scanner inputScanner = new Scanner(System.in);
        String newProductName = inputScanner.nextLine();        // Read in name of product to add
        
        int max = inventory.getNumProducts();

        for (int i=0; i<max; i++)
        {
            while (newProductName.equals(inventory.shopInventory.get(i).getProductName()))     // Check inventory to see if the product already exists
            {
                System.out.println();
                System.out.println("Error: product already exists in inventory");
                System.out.println();
                System.out.print("Enter new product name: ");
                newProductName = inputScanner.nextLine();
            }
        }

        System.out.print("Enter count: ");        // Read in count and price
        int newProductQuantity = inputScanner.nextInt();
        System.out.print("Enter price: $");
        int newProductPrice = inputScanner.nextInt();

        inventory.addProduct(newProductName, newProductQuantity, newProductPrice);      // Add product to ArrayList of products
        System.out.println();
        System.out.println("Success: Product has been added to inventory");

        store.displayMenu(1);
    }

    public static void removeProduct()
    {
        System.out.println();
        System.out.println("******** Remove a Product ********");
        System.out.print("Enter product to remove: ");
        Scanner inputScanner = new Scanner(System.in);
        String removedProductName = inputScanner.nextLine();      // Read in product to remove
        
        boolean existsInInventory = false;

        for (int i=0; i<inventory.shopInventory.size(); i++)      // FOR loop to cycle through inventory
        {
            if (removedProductName.equals(inventory.shopInventory.get(i).getProductName()))    
            {
                inventory.removeProduct(i);       // If it is found, remove it and make existsInInventory = true
                existsInInventory = true;
            }
        }
        
        if (existsInInventory)                    // Evaluate existsInInventory and print appropriate message
        {
            System.out.println();
            System.out.println("Success: Product has been removed from inventory");
        }
        else
        {
            System.out.println();
            System.out.println("Error: Product does not exist in inventory");
        }

        store.displayMenu(1);
    }

    public static void restockProduct()
    {
        System.out.println();
        System.out.print("Which product would you like to restock: ");
        Scanner inputScanner = new Scanner(System.in);
        String restockProductName = inputScanner.nextLine();   // Read in product to restock

        boolean exists = false;

        for (int i=0; i<inventory.shopInventory.size(); i++)   // Cycle through inventory looking for that product
        {
            if (restockProductName.equals(inventory.shopInventory.get(i).getProductName()))  // If the product exists, read in amount to add
            {                                                                                // and display new count
                System.out.print("How many units should be added to inventory: ");
                int restockAmount = inputScanner.nextInt();
                inventory.shopInventory.get(i).setProductQuantity(restockAmount);
                System.out.println();
                System.out.println("Success: product quantity updated");
                System.out.println(inventory.shopInventory.get(i).getProductName() + " now has a count of " + inventory.shopInventory.get(i).getProductQuantity() + " units");
                exists = true;
                break;
            }
        }

        if (!exists)      // If the product does not exist, print an error message
        {
            System.out.println();
            System.out.println("Error: Product \"" + restockProductName + "\" does not exist.");
        }

        store.displayMenu(1);
    }
}
