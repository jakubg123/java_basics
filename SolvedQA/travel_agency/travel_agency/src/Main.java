import travel_agency.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {

        Customer customer = new Customer(1,"jakub", "gniadek", "111233", "sdsadasd@gmailc.om");
        Customer customer2 = new Customer(1,"jakub", "test", "123321", "gmailc.om");
        Customer[] customers = {customer, customer2};

        Location hotelLocation = new Location("street","city","country");
        Reviews hotelReview = new Reviews("firstReview", "I can't review this.");
        Reviews[] hotelReviews = {hotelReview};
        Hotel hotel = new Hotel("hotel",customers,hotelLocation, hotelReviews);

        Reviews[] agencyReviews = new Reviews[2];
        agencyReviews[0] = new Reviews("new agency review", "review body");
        agencyReviews[1] = new Reviews("new new agency review", "Review body x2");

        Agent agent = new Agent(1,"testAgent");
        Agent agent2 = new Agent(2, "testAgent2");

        Agent[] agentTable = new Agent[2];
        agentTable[0] = agent;
        agentTable[1] = agent2;






        Location location = new Location("testStreet", "testCity", "testCountry");
        Location location2 = new Location("testStreet2", "testCity2", "testCountry2");



        MeanOfTransport Plane = new MeanOfTransport(1,"plane",100);
        MeanOfTransport Car = new MeanOfTransport(2,"car", 4);


        Destination destination = new Destination(1,location, Plane);
        Destination destination2 = new Destination(2, location2,Car);

        Insurance insurance = new Insurance(1,LocalDate.of(2023,11,30), LocalDate.of(2023, 12,10));




        Agency agency = new Agency("testAgency", location, null, agentTable);
        Agency agency1 = new Agency("testAgency2 ", location2, agencyReviews, agentTable);

        Travel travel = new Travel(customer, agent, destination, LocalDate.of(2023, 11,20), null);
        Travel travel2 = new Travel(customer, agent2, destination2, LocalDate.of(2023, 11,20), insurance);




        System.out.println(travel);
        System.out.println(travel2);


        if (travel.bookSeatForCustomer(customer)) {
            System.out.println("Seat booked for: " + customer.getName());

        } else {
            System.out.println("No seats for " + customer.getName());
        }







        //agent location agency MeanofTransport, destination, customer, travel, insurance, hotel, reviews




    }
}