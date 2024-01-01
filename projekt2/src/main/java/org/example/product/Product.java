package org.example.product;


public class Product {
    private String name;
    private int quantity;
    private double price;
    private int available;

    public Product(String name, int quantity, double price, int available) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.available = available;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}