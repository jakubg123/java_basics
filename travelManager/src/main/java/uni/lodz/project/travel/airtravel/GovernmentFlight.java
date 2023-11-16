package uni.lodz.project.travel.airtravel;

import uni.lodz.project.city.City;
import uni.lodz.project.interfaces.Rentable;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class GovernmentFlight extends AirTravel implements Rentable {
    private String hirerName;
    private boolean isRented;


    public GovernmentFlight(LocalDateTime startTime, int duration,
                            City startCity, City endCity, int seats, int occupied_seats, String planeNumber) {
        super(startTime, duration, startCity, endCity, seats, occupied_seats, planeNumber);
    }



    public String getHirerName() {
        return hirerName;
    }
    public void setHirerName(String hirerName) {
        this.hirerName = hirerName;
    }



    public boolean isRented() {
        return isRented;
    }
    public void setRented(boolean state){
        this.isRented = state;
    }


    @Override
    public void rent(String name) {
        if(!isRented){
            this.setRented(true);
            this.setHirerName(name);
            System.out.println(this.getPlaneNumber() + " has just been rented");
        }
        else
        {
            System.out.println("That vehicle has already been rented");
        }
    }

    @Override
    public void stopRent() {
        if(this.isRented){
            this.setRented(false);
            this.setHirerName(null);
        }
        else
        {
            System.out.println("That vehicle is not being rented");
        }
    }
}
