package util;

import model.ShoppingList;
import java.io.*;

/**
 * Handles saving and loading of ShoppingList objects
 * Demonstrates File Handling and Exception Handling
 */
public class FileManager {
    private static final String EXT = ".dat";

    // Save shopping list to file
    public static void saveList(ShoppingList list, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename + EXT);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
            System.out.println("List saved to " + filename + EXT);
        } catch (Exception e) {
            System.out.println("Error saving list: " + e.getMessage());
        }
    }

    // Load shopping list from file
    public static ShoppingList loadList(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename + EXT);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ShoppingList list = (ShoppingList) in.readObject();
            in.close();
            fileIn.close();
            return list;
        } catch (Exception e) {
            System.out.println("Error loading list: " + e.getMessage());
            return null;
        }
    }
}
