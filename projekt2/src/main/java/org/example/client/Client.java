package org.example.client;

import java.util.Objects;

public class Client {
    private String name;
    private String taxId;
    private String address;
    private String zipCode;
    private String city;



    public Client(String name, String taxId, String address, String zipCode, String city) {
        this.name = name;
        this.taxId = taxId;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", taxId='" + taxId + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(taxId, client.taxId) && Objects.equals(address, client.address) && Objects.equals(zipCode, client.zipCode) && Objects.equals(city, client.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, taxId, address, zipCode, city);
    }
}
