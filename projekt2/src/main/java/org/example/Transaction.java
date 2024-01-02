package org.example;

import org.example.client.Client;
import org.example.product.Product;

import java.util.Random;

public class Transaction {

    private final int id;
    private Client client;
    private Product product;

    private boolean status;

    private int quantity;

    private String time;



    public Transaction(Client client, Product product, int quantity, boolean status, String time) {
        Random random = new Random();
        this.id = random.nextInt(1000000000);
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.status = status;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean getStatus(){
        return status;
    }

    public String getTime(){
        return time;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", client=" + client +
                ", product=" + product +
                ", status=" + status +
                ", quantity=" + quantity +
                ", time='" + time + '\'' +
                '}';
    }


}
