package uni.lodz.project.travel.airtravel;

import uni.lodz.project.city.City;
import uni.lodz.project.travel.Travel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class AirTravel extends Travel {
    private final String planeNumber;

    public AirTravel(LocalDateTime startTime, int duration,
                     City startCity, City endCity, int seats, int occupied_seats, String planeNumber) {
        super( startTime,  duration,  startCity,  endCity,  seats, occupied_seats);
        this.planeNumber = planeNumber;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }


}
