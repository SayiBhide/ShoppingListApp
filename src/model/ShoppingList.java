package model;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Represents a shopping list which contains multiple items
 * Demonstrates Composition and use of ArrayList
 */
public class ShoppingList implements Serializable {
    private static final long serialVersionUID = 1L;

    private String listName;
    private ArrayList<ShoppingItem> items;

    // Constructor
    public ShoppingList(String listName) {
        this.listName = listName;
        this.items = new ArrayList<>();
    }

    // Add an item
    public void addItem(ShoppingItem item) {
        items.add(item);
    }

    // Remove an item by index
    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    // Get all items
    public ArrayList<ShoppingItem> getItems() {
        return items;
    }

    // Clear purchased items
    public void clearPurchasedItems() {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isPurchased()) {
                items.remove(i);
                i--; // adjust index after removal
            }
        }
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
