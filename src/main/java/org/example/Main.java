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
        }
    }
}