package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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
                        System.out.println("display products method will go here");
                        break;
                    case 2:
                        System.out.println("display cart method will go here");
                        break;
                    case 3:
                        System.out.println("We hope you come back soon! Thank you.");
                        System.exit(0);
                    default:
                        System.out.println("Sorry, please enter 1, 2, or 3.");
                }
            } catch (Exception ex) {
                System.out.println("Sorry, please enter 1, 2, or 3.");
                scanner.nextLine();
            }


        Product[] products = new Product[12];

        products[0] = new Product("AV1051", "JBL Bluetooth Speaker", 89.95, "Audio Video");
        products[1] = new Product("AV1312", "Mini 1000 Lumens Projector", 149.95, "Audio Video");
        products[2] = new Product("AV1412", "XLR Podcast Cardiod Mic", 44.99, "Audio Video");
        products[3] = new Product("CP2012", "Desktop PC Computer Intel Core i5", 139.00, "Computers");
        products[4] = new Product("CP2123", "Wired Backlit Keyboard", 21.99, "Computers");
        products[5] = new Product("CP2154", "RGB Wireless Gaming Mouse", 67.45, "Computers");
        products[6] = new Product("GM1032", "Telestrations Board Game", 17.99, "Games");
        products[7] = new Product("GM1075", "Battleship Board Game", 12.99, "Games");
        products[8] = new Product("GM1148", "Retro Handheld Arcade", 24.45, "Games");
        products[9] = new Product("PW1255", "USB C to A Cable", 13.95, "Electronics");
        products[10] = new Product("PW1341", "Solar Powered Battery Charger", 19.99, "Electronics");
        products[11] = new Product("PW1431", "Wireless Charger iPhone", 12.99, "Electronics");

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Welcome to The Online Store home screen!");
            System.out.println("Please select an option:");
            System.out.println("1- View products");
            System.out.println("2- View my cart");
            System.out.println("3- Exit");

            try {
                int customerChoice = scanner.nextInt();
                scanner.nextLine();

                switch (customerChoice) {
                    case 1:
                        System.out.println("Products Available:");
                        displayProduct(products);
                        break;
                    case 2:
                        System.out.println("Your cart:");
                        displayCart(products);
                        break;
                    case 3:
                        System.out.println("Thank you, hope to see you soon!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Sorry, please enter 1, 2 or 3.");
                }
            }       catch (Exception ex) {

            }



        }
    }
}