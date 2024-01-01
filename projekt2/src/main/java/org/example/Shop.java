package org.example;

import org.example.client.Client;
import org.example.product.Product;

import java.util.ArrayList;
import java.util.List;

class Shop {
    private static Shop instance = null;
    private List<Client> clients;
    private List<Product> products;
    private List<Transaction> transactions;

    private Shop() {
        clients = new ArrayList<>();
        products = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public static Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }
}
