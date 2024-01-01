package org.example.product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductLoading {

    public static List<Product> loadProducts(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();
        String line;
        BufferedReader br = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8));
        while ((line = br.readLine()) != null) {
            String[] cols = line.split(",");
            String purchase = cols[0];
            String stock = cols[1];

            String[] purchaseToken = purchase.split(";");
            String[] stockToken = stock.split(";");

            String productName = purchaseToken[0];
            int quantity = Integer.parseInt(purchaseToken[1]);
            String priceRecplacement = stockToken[0].replace("z�", "");
            double price = Double.parseDouble(priceRecplacement);
            int available = Integer.parseInt(stockToken[1]);

            products.add(new Product(productName, quantity, price, available));

        }
        return products;
    }
}