package travel_agency;

import java.util.Arrays;

public class Hotel {

    private String name;
    private Customer[] customers;
    private Reviews[] reviews;

    private Location location;


    public Hotel(String name, Customer[] customers, Location location, Reviews[] reviews){
        this.name = name;
        this.customers = customers;
        this.reviews = reviews;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public Reviews[] getReviews() {
        return reviews;
    }

    public void setReviews(Reviews[] reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return name + "\n" + Arrays.toString(customers) + "\n"  + Arrays.toString(reviews);
    }
}
