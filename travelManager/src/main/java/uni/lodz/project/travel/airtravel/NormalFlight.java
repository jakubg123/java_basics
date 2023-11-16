package uni.lodz.project.travel.airtravel;

import uni.lodz.project.city.City;
import uni.lodz.project.exceptions.NoFreeSeatsException;
import uni.lodz.project.interfaces.Reservable;

import java.time.LocalDateTime;

public class NormalFlight extends AirTravel implements Reservable {


    public NormalFlight(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupied_seats, String planeNumber) {
        super(startTime, duration, startCity, endCity, seats, occupied_seats, planeNumber);
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
