package org.example;
import java.util.ArrayList;
import java.util.List;



    public class Cart {
        private List<Product> cartItems;

        public Cart() {
            cartItems = new ArrayList<>();
        }

        public void addProduct(Product product) {
            cartItems.add(product);
        }

        public void removeProduct(Product product) {
            cartItems.remove(product);
        }

        public void displayProductsInCart() {
            if (cartItems.isEmpty()) {
                System.out.println("Your cart is empty.");
            } else {
                System.out.println("Products in your cart:");
                for (Product product : cartItems) {
                    System.out.println(product.getProductName() + " - $" + product.getPrice());
                }
            }
        }

        public double calculateCartTotal() {
            double total = 0;
            for (Product product : cartItems) {
                total += product.getPrice();
            }
            return total;
        }
    }


