package org.example.client;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ClientLoading {

    public static List<Client> loadClients(String filePath) {
        List<Client> clients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] clientData = line.split(";");
                if (clientData.length == 5) {
                    Client client = new Client(clientData[0], clientData[1], clientData[2], clientData[3], clientData[4]);
                    clients.add(client);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }
}

