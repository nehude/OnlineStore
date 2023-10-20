package org.example;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> productlist = new ArrayList<>();
        ArrayList<String> cart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to our online store");
        System.out.println("please select 1 to view product, 2 to view cart,3 exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                viewproduct(productlist);
                break;
        }
    }
    public static void viewproduct(ArrayList<Product> productlist) {
        Scanner scanner = null;
        try {
            Scanner scanner1 = new Scanner(System.in);
            FileInputStream fis = new FileInputStream("src/main/resources/Products.csv");
            scanner = new Scanner(fis);
            /* ArrayList<Product> productlist = new ArrayList<>();*/
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String Input = scanner.nextLine();
                String[] line = Input.split("\\|");
                String SKU = line[0];
                String productname = line[1];
                Double price = Double.parseDouble(line[2]);
                String department = line[3];
                Product newitem = new Product(SKU, productname, price, department);
                productlist.add(newitem);
                System.out.println(newitem);
            }

        } catch (Exception ex) {
            System.out.println("not found");
            return;
        }
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please enter product SKU to to search product or 'exit' to go back:");
        String SKU = inputScanner.nextLine();
        if (!SKU.equalsIgnoreCase("exit")) {
            boolean found = false;
            for (Product product : productlist) {
                if (product.getSKU().equals(SKU)) {
                    found = true;
                    System.out.println("Results:");
                    System.out.printf("SKU: %s Product Name: %s Price: $%.2f Department: %s%n",
                            product.getSKU(), product.getProductname(), product.getPrice(), product.getDepartment());

                    System.out.println("Select 1 to add this item to your cart, 2 to continue shopping:");
                    int choice = inputScanner.nextInt();
                    if (choice == 1) {
                        addToCart(product);
                        System.out.println("Product added to cart!");
                    }
                    else {

                        viewproduct(productlist);
                    }
                    break;

                }
            }
            if (!found) {
                System.out.println("Product not found in stock.");
            }
        }
    }
    public static void addToCart(Product product) {
        try {
            FileWriter cartWriter = new FileWriter("src/main/resources/cart.txt", true);
            cartWriter.write(product.getSKU() + " " + product.getProductname() + " " +
                    product.getPrice() + " " + product.getDepartment() + "\n");
            cartWriter.close();
        } catch (Exception ex) {
            System.out.println("Error writing to cart file.");
        }
    }
}