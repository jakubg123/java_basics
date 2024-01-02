package org.example;

import org.example.client.Client;
import org.example.product.Product;
import org.example.threads.ClientProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulator {

    public static List<List<Client>> generateClientSubsets(List<Client> allClients) {
        List<List<Client>> clientSubsets = new ArrayList<>();
        Random random = new Random();
        List<Client> availableClients = new ArrayList<>(allClients);

        for (int i = 0; i < 60; i++) {
            int subsetSize = 2 + random.nextInt(14);
            List<Client> subset = new ArrayList<>();
            List<Integer> temporaryUnavailable = new ArrayList<>();
            for (int j = 0; j < subsetSize; j++) {
                int index;
                do {
                    index = random.nextInt(availableClients.size());
                } while (temporaryUnavailable.contains(index));

                subset.add(availableClients.get(index));
                temporaryUnavailable.add(index);
            }

            clientSubsets.add(subset);
        }

        return clientSubsets;
    }




}
