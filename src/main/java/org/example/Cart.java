package src.main.java.org.example;

import java.util.ArrayList;
import org.example.Product;

public class Cart {
    private ArrayList<Product> productList;

    public Cart(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void addItem(Product product) {
        productList.add(product);
    }

    public void removeItem(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).SKU == product.SKU) {
                productList.remove(i);
                break;
            }
        }
    }

    public void displayItems() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}
