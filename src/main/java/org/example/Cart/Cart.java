package org.example.Cart;

import java.util.ArrayList;
import src.main.java.org.example.Product.Product;

public class Cart {
    private ArrayList<Product> productList;
    private double total;

    public Cart() {
        this.productList = new ArrayList<Product>();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void addItem(Product product) {
        this.total += product.price;
        productList.add(product);
    }

    public void removeItem(String sku) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).SKU == sku) {
                productList.remove(i);
                this.total -= productList.get(i).price;
                break;
            }
        }
    }

    public void displayItems() {
        System.out.println("--- CART ---");
        for (Product product : productList) {
            System.out.println(product);
        }
        System.out.println("------------");
        System.out.printf("TOTAL: $%.2f\n", total);
        System.out.println("------------");
    }

    public boolean isEmpty() {
        return productList.isEmpty();
    }
}
