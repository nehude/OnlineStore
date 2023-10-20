package org.example;

import org.example.Cart.Cart;
import src.main.java.org.example.Product.Product;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart();

        ArrayList<Product> productlist = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the online store");
            System.out.println("Select which option you would like to choose:");
            System.out.println("[1] View products");
            System.out.println("[2] View cart");
            System.out.println("[3] Exit");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        displayProduct(productlist, cart);
                        break;
                    case 2:
                        displayCartMenu(cart);
                    case 3:
                        System.out.println("We hope you come back soon! Thank you.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Sorry, please enter 1, 2, or 3.");
                }
            } catch (Exception ex) {
                System.out.println("Sorry, please enter 1, 2, or 3.");
                scanner.nextLine();
            }
        }
    }

    public static void displayCartMenu(Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("You don't have anything in your cart!");
            System.out.println("Add some items to your cart first");
            return;
        }
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            cart.displayItems();
            System.out.println("[1] - Check out");
            System.out.println("[2] - Remove Item");
            System.out.println("[3] - Go Back");
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1 -> {
                    System.out.println("Thanks for shopping with us!");
                }
                case 2 -> {
                    System.out.println("Please enter the SKU of what you want to remove:");
                    String sku = scan.nextLine();
                    cart.removeItem(sku);
                }
                default -> {}
            }
        } while (option != 3);
    }

    public static void displayProduct(ArrayList<Product> productlist, Cart cart) {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/Products.csv");
            Scanner scanner = new Scanner(fis);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] line = input.split("\\|");
                String SKU = line[0];
                String productName = line[1];
                Double price = Double.parseDouble(line[2]);
                String department = line[3];
                Product newItem = new Product(SKU, productName, price, department);
                productlist.add(newItem);
                System.out.println(newItem);
            }

            Scanner inputScanner = new Scanner(System.in);
            while (true) {
                System.out.println("To search for a product, enter product SKU or [0] to go back to the home screen:");
                String input = inputScanner.nextLine().toLowerCase();

                if (input.equals("0")) {
                    break;
                }

                boolean found = false;
                for (Product product : productlist) {
                    if (product.getSKU().equalsIgnoreCase(input)) {
                        found = true;
                        System.out.println("Results:");
                        System.out.printf("SKU: %s Product Name: %s Price: $%.2f Department: %s%n",
                                product.getSKU(), product.getProductName(), product.getPrice(), product.getDepartment());

                        System.out.println("Select [1] to add this item to your cart, [2] to continue shopping:");
                        int choice = inputScanner.nextInt();
                        inputScanner.nextLine();

                        if (choice == 1) {
                            cart.addItem(product);

                            addToCart(product);
                            // ^ deprecated
                            System.out.println("Product added to cart!");
                        }
                        else {
                        }
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Product not found in stock.");
                }
            }
        } catch (Exception exception) {
            System.out.println("Error reading products file");
        }
    }


    public static void addToCart(Product product) {
        try {
            FileWriter cartWriter = new FileWriter("src/main/resources/cart.txt", true);
            cartWriter.write(product.getSKU() + " " + product.getProductName() + " " +
                    product.getPrice() + " " + product.getDepartment() + "\n");
            cartWriter.close();
        } catch (Exception ex) {
            System.out.println("Error writing to cart file: " + ex.getMessage());
        }
    }
}
