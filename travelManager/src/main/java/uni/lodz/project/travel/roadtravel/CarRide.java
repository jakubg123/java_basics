package uni.lodz.project.travel.roadtravel;

import uni.lodz.project.city.City;
import uni.lodz.project.exceptions.NoFreeSeatsException;
import uni.lodz.project.interfaces.Rentable;

import java.time.LocalDateTime;

public class CarRide extends RoadTravel implements Rentable {
    private String hirerName;
    private boolean isRented;
    public CarRide(LocalDateTime startTime, int duration,
                   City startCity, City endCity, int seats,
                   int occupied_seats, String registrationNumber) {
        super(startTime, duration, startCity, endCity, seats,occupied_seats, registrationNumber);
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
            System.out.println(this.getRegistrationNumber() + " has just been rented");
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


    @Override
    public void reserve(int numberOfSeats) throws NoFreeSeatsException {
        if(this.getSeats() < numberOfSeats){
            throw new NoFreeSeatsException("Not enough total seats");
        }
        else
        {
            if(this.getSeats() - this.getOccupied_seats() > numberOfSeats){
                this.setOccupied_seats(this.getOccupied_seats() + numberOfSeats);
            }
            else
            {
                throw new NoFreeSeatsException("Too many seats are already occupied!");
            }
        }
    }

}
