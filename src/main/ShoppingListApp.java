package main;

import gui.MainFrame;
import javax.swing.SwingUtilities;

/**
 * Entry point of the application
 */
public class ShoppingListApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
