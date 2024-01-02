package org.example.threads;

import org.example.Shop;
import org.example.client.Client;
import org.example.product.Product;

import java.util.List;
import java.util.Random;

public class ClientProcessor extends Thread {
    private final Client client;
    private int minute;

    public ClientProcessor(Client client, int i) {
        this.client = client;
        this.minute = i;
    }

    @Override
    public void run() {
        Shop shop = Shop.getInstance();
        Random random = new Random();
        List<Product> availableProducts = shop.getProducts();

        if (!availableProducts.isEmpty()) {
            Product selectedProduct = availableProducts.get(random.nextInt(availableProducts.size()));
            int quantity = random.nextInt(10) + 1; // od 1 do 10

            if(shop.purchaseProduct(client, selectedProduct, quantity, String.valueOf(this.minute)))
                System.out.println("Klient " + client.getName() + " kupił produkt " + selectedProduct.getName() + " w ilości " + quantity + " zostalo:" + selectedProduct.getQuantity());
            else{
                System.out.println("Transakcja nie powiodla sie z powodu braku materialu" + " dostepny:" + selectedProduct.getQuantity() + " wymagany przez klienta:" + quantity);
            }
        }
    }

}