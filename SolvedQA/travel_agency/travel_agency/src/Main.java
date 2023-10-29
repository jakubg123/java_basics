import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {

        Agent agent = new Agent(1,"testAgent");

        MeanOfTransport Plane = new MeanOfTransport(1,"plane",100);

        Destination destination = new Destination(1,"destination", Plane);

        Customer customer = new Customer(1,"jakub", "gniadek", "111233", "sdsadasd@gmailc.om");
        Customer customer2 = new Customer(1,"jakub", "test", "123321", "gmailc.om");

        Travel travel = new Travel(customer, agent, destination, LocalDate.of(2023, 11,20));

        System.out.println(customer.toString());
        System.out.println(travel);

        if (travel.bookSeatForCustomer(customer)) {
            System.out.println("Seat booked for: " + customer.getName());

        } else {
            System.out.println("No seats for " + customer.getName());
        }








    }
}