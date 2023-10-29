package travel_agency;

import java.time.LocalDate;

public class Travel {
    private Customer customer;
    private Agent agent;
    private Destination destination;
    private LocalDate localDate;

    private Insurance travelInsurance;
   public Travel(Customer customer, Agent agent, Destination destination, LocalDate localDate,Insurance travelInsurance) throws Exception {

       if(isValid(localDate))
       {
           this.customer = customer;
           this.agent = agent;
           this.destination = destination;
           this.localDate = localDate;
           if(travelInsurance != null){
               this.travelInsurance = travelInsurance;
           }
           else
           {
               this.travelInsurance = null;
           }
       }
       else
       {
           throw new Exception("Wrong date!");
       }
   }

    @Override
    public String toString() {
        return "Customer: " + customer.toString() + "\nAgent: " + agent.toString() + " " + "\nDestination: " + destination.toString() + "\nTravel date: " + localDate;
    }

    public boolean isValid(LocalDate localDate){
        return LocalDate.now().isBefore(localDate);
    }

    public boolean bookSeatForCustomer(Customer customer) {
        if (destination.getTransport().isSeatAvailable()) {
            return destination.getTransport().bookSeat(customer);
        }
        return false;
    }

}
