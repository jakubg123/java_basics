package org.example;

import org.example.client.Client;
import org.example.product.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static Shop instance = null;
    private List<List<Client>> clients;

    private List<Product> products;
    private List<Transaction> transactions;

    private Shop() {
        clients = new ArrayList<>();
        products = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public static synchronized Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }

    public synchronized void addProducts(List<Product> products){
        this.products.addAll(products);
    }

    public synchronized void addClients(List<List<Client>> clients){
        this.clients.addAll(clients);
    }

    public synchronized void addTransactions(List<Transaction> transactions){
        this.transactions.addAll(transactions);
    }

    public synchronized ArrayList<Client> getClientList(int i){
        return (ArrayList<Client>) clients.get(i);
    }

    public synchronized List<Product> getProducts() {
        return products;
    }

    public synchronized List<Transaction> getTransactions() {
        return transactions;
    }

    public synchronized boolean purchaseProduct(Client client, Product product, int quantity, String time) {
        if (product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);

            Transaction transaction = new Transaction(client, product, quantity, true, time);
            transactions.add(transaction);

            return true;
        } else {
            Transaction transaction = new Transaction(client, product, quantity, false, time);
            transactions.add(transaction);
        }
        return false;
    }

    public static void writeTransactionsToFile(List<Transaction> transactions, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Transaction transaction : transactions) {
                String status;
                double price;
                if(transaction.getStatus()){
                    status = "Transakcja powiodla sie";
                    price = transaction.getProduct().getPrice() * transaction.getQuantity();
                }
                else{
                    status = "Transakcja nie powiodla sie";
                    price = 0;
                }
                String line = transaction.getClient().getName() + ";" + transaction.getId() + ";" + "12:" + transaction.getTime() + ";" + transaction.getProduct().getName() + ";" + transaction.getProduct().getCode() + ";" + status + ";" + price + " zl";
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



}
