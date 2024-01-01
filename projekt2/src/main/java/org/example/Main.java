package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.example.client.Client;
import org.example.client.ClientLoading;
import org.example.product.Product;
import org.example.product.ProductLoading;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Client> clients = ClientLoading.loadClients("/home/jakubg/Downloads/clients.csv");
        List<Product> products = ProductLoading.loadProducts("/home/jakubg/Downloads/products.csv");


        List<List<Client>> clientSubsets = Simulator.generateClientSubsets(clients);

        for(int i = 0; i < clientSubsets.size();i++){
            System.out.println(clientSubsets.get(i).size());
        }

    }


}
