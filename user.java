// User class

import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;

public class user implements Serializable
{
    public String username;
    public String password;
    public static transient ArrayList<customer> customerList = new ArrayList<>();       // ArrayList containing all customer objects

    public user(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername()     // Function to get username
    {
        return username;
    }

    public String getPassword()     // Function to get password
    {
        return password;
    }
}
