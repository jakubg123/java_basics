package org.example;

import org.example.client.Client;
import org.example.client.ClientLoading;
import org.example.product.Product;
import org.example.product.ProductLoading;
import org.example.threads.ClientProcessor;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = "/home/jakubg/Downloads/products.csv";
        List<Client> clients = ClientLoading.loadClients("/home/jakubg/Downloads/clients.csv");
        List<Product> products = ProductLoading.loadProducts(path);

        List<List<Client>> clientSublists = Simulator.generateClientSubsets(clients);


        Shop shop = Shop.getInstance();

        shop.addClients(clientSublists);
        shop.addProducts(products);


        for (int i = 0; i < 60; i++) {
            System.out.println("Minuta " + (i + 1) + " symulacji startuje.");
            for (Client client : shop.getClientList(i)) {
                ClientProcessor clientThread = new ClientProcessor(client, i);
                clientThread.start();
                try {
                    clientThread.join();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Minuta " + (i + 1) + " symulacji zakończona.");

        }


        ProductLoading.updateProductFile(products, path);
        Shop.writeTransactionsToFile(Shop.getInstance().getTransactions(), "target/raports.txt");



        List<Transaction> transactions = shop.getTransactions();
        List<Transaction> transactionsTimeBased = transactions.stream()
                .filter(transaction -> Integer.parseInt(transaction.getTime()) > 30)
                .filter(transaction -> transaction.getStatus())
                .collect(Collectors.toList());

        System.out.println(transactionsTimeBased);


        int totalTransactions = transactions.size();
        long failedTransactions = transactions.stream().filter(transaction -> !transaction.getStatus()).count();
        System.out.println((double) failedTransactions / totalTransactions * 100 + "%");


        transactions.stream()
                .max(Comparator.comparing(transaction -> transaction.getProduct().getPrice() * transaction.getQuantity()))
                .ifPresent(maxTransaction -> System.out.println(maxTransaction.getClient()));
    }


}


