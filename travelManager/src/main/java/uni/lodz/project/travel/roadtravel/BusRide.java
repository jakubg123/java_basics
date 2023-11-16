package uni.lodz.project.travel.roadtravel;

import uni.lodz.project.city.City;
import uni.lodz.project.exceptions.NoFreeSeatsException;

import java.time.LocalDateTime;

public class BusRide extends RoadTravel{

    public BusRide(LocalDateTime startTime, int duration,
                   City startCity, City endCity, int seats, int occupied_seats, String registrationNumber) {
        super(startTime, duration, startCity, endCity, seats, occupied_seats, registrationNumber);
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
