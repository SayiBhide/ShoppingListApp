# Shopping List Application

This is a simple desktop application for managing a shopping list, built using Java Swing. It allows users to add items, mark them as purchased, delete items, and save/load their lists to a file.

## Features

* **Add Item:** Add a new item with a name and quantity.
* **Mark as Purchased:** Mark an item on the list, which will add a `[Purchased]` tag.
* **Delete Item:** Remove a selected item from the list.
* **Clear Purchased:** Remove all items that have been marked as purchased.
* **Save List:** Save the current list to a file (`shoppinglist.dat`).
* **Load List:** Load a previously saved list from `shoppinglist.dat`.

## Project Structure

The project is organized into packages to demonstrate separation of concerns:

* `main`: Contains the main entry point of the application (`ShoppingListApp.java`).
* `gui`: Contains all the user interface (Swing) code (`MainFrame.java`).
* `model`: Contains the data classes (`ShoppingItem.java`, `ShoppingList.java`).
* `util`: Contains helper classes, like the `FileManager.java` for saving and loading.

## How to Run

This project is ready to be opened in an IDE like VS Code (with the Java Extension Pack) or Eclipse. The main entry point is `src/main/ShoppingListApp.java`.