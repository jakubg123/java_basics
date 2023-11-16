package uni.lodz.project.travel.railwaytravel;

import uni.lodz.project.city.City;
import uni.lodz.project.interfaces.Reservable;
import uni.lodz.project.travel.Travel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class RailwayTravel extends Travel implements Reservable {


    private final String trainNumber;

    public RailwayTravel(LocalDateTime startTime, int duration,
                         City startCity, City endCity, int seats, int occupied_seats, String trainNumber) {
        super(startTime, duration, startCity, endCity, seats, occupied_seats);
        this.trainNumber = trainNumber;
    }

    public String getTrainNumber() {
        return trainNumber;
    }







}
