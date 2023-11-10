// Store class

import java.io.*;
import java.util.Scanner;
import java.io.Serializable;

public class store implements Serializable
{
    public static admin admin = new admin();
    public static int currentCustomerIndex;

    public store()
    {
        this.currentCustomerIndex = currentCustomerIndex;
    }

    public static void openStore()
    {
        System.out.println("******** Welcome to Nick's Sporting Goods ********");
        System.out.println("1- Login");
        System.out.println("2- Register");
        Scanner inputScanner = new Scanner(System.in);
        int userChoice = inputScanner.nextInt();
        System.out.println();

        if (userChoice == 1)            // Evaluate if user is returning (login) or new (regiserUser)
        {
            int result = login();
            if (result==1)              // If login() return 1, they are an admin
            {
                displayMenu(1);
            }
            else if (result==2)         // If login() returns 2, they are a customer
            {
                displayMenu(2);
            }
            else
            {
                System.out.println();   // If login() returns a number besides 1 and 2, login failed and an error message was displayed in login function
            }

        }
        else
        {
            registerUser();
            displayMenu(2);
        }
    }
    

    private static int login()
    {
        System.out.print("Username: ");
        Scanner inputScanner = new Scanner(System.in);
        String inputUsername = inputScanner.nextLine();
        System.out.print("Password: ");
        String inputPassword = inputScanner.nextLine();

        if ((inputUsername.equals("admin")) && (inputPassword.equals("12345")))  // If user passes this check, they are an admin
        {
            return 1;
        }
        else
        {
            for (int i=0; i < user.customerList.size(); i++)         // FOR loop to cycle through customerList checking if this username and password exist and are correct
            {
                if ((inputUsername.equals(user.customerList.get(i).getUsername())) && (inputPassword.equals(user.customerList.get(i).getPassword())))
                {
                    currentCustomerIndex = i;
                    return 2;
                }
            }
        }
        
        System.out.println("Login failed - Incorrect username or password");
        return 0;
    }

    public static void registerUser()
    {
        System.out.print("Create username: ");
        Scanner inputScanner = new Scanner(System.in);
        String newUsername = inputScanner.nextLine();
        System.out.print("Create password: ");
        String newPassword = inputScanner.nextLine();

        while (newPassword.length() != 5)       // User must enter a password of length 5
        {
            System.out.println("Error: Password should be exactly 5 characters");
            System.out.println();
            System.out.print("Enter password: ");
            newPassword = inputScanner.nextLine();
        }
        
        user.customerList.add(new customer(newUsername, newPassword));   // Once username and password are entered, add user to the customerList
        currentCustomerIndex = user.customerList.size() - 1;
    }

    public static void displayMenu(int x)
    {
        if (x == 1)
        {
            System.out.println();
            System.out.println("******** Admin dashboard ********");
            System.out.println("1- Create a customer account");
            System.out.println("2- Remove a customer account");
            System.out.println("3- View inventory");
            System.out.println("4- Add a product");
            System.out.println("5- Remove a product");
            System.out.println("6- Restock a product");
            System.out.println("7- Logout");

            Scanner inputScanner = new Scanner(System.in);   // Read in choice and call appropriate admin function
            int adminChoice = inputScanner.nextInt();

            if (adminChoice == 1)
            {
                admin.createCustomerAccount();
            }
            else if (adminChoice == 2)
            {
                admin.removeCustomerAccount();
            }
            else if (adminChoice == 3)
            {
                admin.viewInventory();
            }
            else if (adminChoice == 4)
            {
                admin.addProduct();
            }
            else if (adminChoice == 5)
            {
                admin.removeProduct();
            }
            else if (adminChoice == 6)
            {
                admin.restockProduct();
            }
            else
            {
                System.out.println("Have a nice day!");
            }
        }
        else
        {
            System.out.println();
            System.out.println("******** Select an option below ********");
            System.out.println("1- Shop the store");
            System.out.println("2- View and checkout shopping cart");
            System.out.println("3- View balance");
            System.out.println("4- Add balance");
            System.out.println("5- Logout");

            Scanner inputScanner = new Scanner(System.in);    // Read in choice and send to customer class to call appropriate function
            int customerChoice = inputScanner.nextInt();

            customer.passCustomer(user.customerList.get(currentCustomerIndex), customerChoice);
        }
    }
}
