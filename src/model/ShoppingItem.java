package model;

import java.io.Serializable;

/**
 * Represents a single item in a shopping list
 * Demonstrates Encapsulation (private fields + getters/setters)
 */
public class ShoppingItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int quantity;
    private boolean purchased;

    // Constructor
    public ShoppingItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.purchased = false;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    @Override
    public String toString() {
        if (purchased) {
            return "[Purchased] " + name + " (Qty: " + quantity + ")";
        } else {
            return name + " (Qty: " + quantity + ")";
        }
    }
}
