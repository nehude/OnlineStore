package org.example;

public class Product {
    public String SKU;
    public String productname;
    public  double price;
    public String department;



    public Product(String SKU, String productname, double price, String department) {
        this.SKU = SKU;
        this.productname = productname;
        this.price = price;
        this.department = department;

    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String toString() {
        return "SKU: " + SKU + ", Product Name: " + productname + ", Price: " + price + ", Department: " + department;
    }
}
