// File manager class - Used to save progress of the store elements (inventory and customer list)

import java.io.*;
import java.util.ArrayList;

public class filemanager
{
    public static void saveData(String inventoryFilepath, String userFilepath, String shoppingCartFilepath, ArrayList<product> i, ArrayList<customer> customers, ArrayList<cartitem> shoppingCart)
    {
        saveObject(inventoryFilepath, i);
        saveObject(userFilepath, customers);
        saveObject(shoppingCartFilepath, shoppingCart);
    }

    public static Object loadObject(String filepath)
    {
        Object loadedObject = null;

        try
        {
            FileInputStream file = new FileInputStream(filepath);  // Read in from filepath
            ObjectInputStream in = new ObjectInputStream(file);
            loadedObject = in.readObject();
            in.close();
            file.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + filepath);
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return loadedObject;
    }

    private static void saveObject(String filepath, Object o)
    {
        try
        {
            FileOutputStream file = new FileOutputStream(filepath);   // Save object to filepath
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(o);
            out.close();
            file.close();
        }
        catch(IOException e)
        {
            System.out.println("Error saving data to " + filepath);
            e.printStackTrace();
        }
    }
}
