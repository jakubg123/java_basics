package uni.lodz.project.travel.roadtravel;

import uni.lodz.project.city.City;
import uni.lodz.project.interfaces.Rentable;
import uni.lodz.project.interfaces.Reservable;
import uni.lodz.project.travel.Travel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class RoadTravel extends Travel implements Reservable{

    private final String registrationNumber;

    public RoadTravel(LocalDateTime startTime, int duration,
                      City startCity, City endCity, int seats, int occupied_seats, String registrationNumber) {
        super(startTime, duration, startCity, endCity, seats, occupied_seats);
        this.registrationNumber = registrationNumber;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }




}
