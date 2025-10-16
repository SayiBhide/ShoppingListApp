package gui;

import model.ShoppingItem;
import model.ShoppingList;
import util.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainFrame extends JFrame {
    private ShoppingList currentList;
    private DefaultListModel<String> listModel;
    private JList<String> itemList;
    private JTextField itemField;
    private JTextField qtyField;

    // Constructor
    public MainFrame() {
        currentList = new ShoppingList("My Shopping List");
        setupUI();
    }

    private void setupUI() {
        setTitle("Shopping List App");
        setSize(520, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //  Background color
        getContentPane().setBackground(new Color(240, 248, 255)); // light blue

        // Header label
        JLabel titleLabel = new JLabel("My Shopping List", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(25, 25, 112)); // navy blue
        add(titleLabel, BorderLayout.NORTH);

        // List display
        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        itemList.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(itemList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Items"));

        // Input fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.setBackground(new Color(240, 248, 255));

        inputPanel.add(new JLabel("Item Name:"));
        itemField = new JTextField();
        inputPanel.add(itemField);

        inputPanel.add(new JLabel("Quantity:"));
        qtyField = new JTextField();
        inputPanel.add(qtyField);

        // Buttons with colors
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 8, 8));
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton addButton = new JButton("Add Item");
        JButton markButton = new JButton("Mark Purchased");
        JButton deleteButton = new JButton("Delete Item");
        JButton clearButton = new JButton("Clear Purchased");
        JButton saveButton = new JButton("Save List");
        JButton loadButton = new JButton("Load List");

        // Button colors
        addButton.setBackground(new Color(173, 216, 230));
        markButton.setBackground(new Color(144, 238, 144));
        deleteButton.setBackground(new Color(255, 160, 122));
        clearButton.setBackground(new Color(255, 228, 181));
        saveButton.setBackground(new Color(221, 160, 221));
        loadButton.setBackground(new Color(176, 224, 230));

        JButton[] buttons = {addButton, markButton, deleteButton, clearButton, saveButton, loadButton};
        for (JButton b : buttons) {
            b.setFocusPainted(false);
            b.setFont(new Font("SansSerif", Font.BOLD, 13));
        }

        // Add buttons
        buttonPanel.add(addButton);
        buttonPanel.add(markButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        // Add panels to frame
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(_ -> addItem());
        markButton.addActionListener(_ -> markItem());
        deleteButton.addActionListener(_ -> deleteItem());
        clearButton.addActionListener(_ -> {
            currentList.clearPurchasedItems();
            refreshList();
        });
        saveButton.addActionListener(_ -> {
            String name = JOptionPane.showInputDialog("Enter filename:");
            if (name != null) FileManager.saveList(currentList, name);
        });
        loadButton.addActionListener(_ -> {
            String name = JOptionPane.showInputDialog("Enter filename:");
            if (name != null) {
                ShoppingList loaded = FileManager.loadList(name);
                if (loaded != null) {
                    currentList = loaded;
                    refreshList();
                }
            }
        });

        setVisible(true);
    }

    private void addItem() {
        try {
            String name = itemField.getText().trim();
            int qty = Integer.parseInt(qtyField.getText().trim());
            if (!name.isEmpty() && qty > 0) {
                currentList.addItem(new ShoppingItem(name, qty));
                refreshList();
                itemField.setText("");
                qtyField.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }

    private void markItem() {
        int index = itemList.getSelectedIndex();
        if (index >= 0) {
            ShoppingItem item = currentList.getItems().get(index);
            item.setPurchased(!item.isPurchased());
            refreshList();
        }
    }

    private void deleteItem() {
        int index = itemList.getSelectedIndex();
        if (index >= 0) {
            currentList.removeItem(index);
            refreshList();
        }
    }

    private void refreshList() {
        listModel.clear();
        for (ShoppingItem item : currentList.getItems()) {
            listModel.addElement(item.toString());
        }
    }
}