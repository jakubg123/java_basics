package uni.lodz.project.travel;

import uni.lodz.project.city.City;
import uni.lodz.project.enums.TravelStatus;

import java.time.*;

public class Travel {
    private TravelStatus travelStatus;
    private LocalDateTime startTime;
    private int duration;
    private City startCity;
    private City endCity;
    private int seats;

    private int occupied_seats;


    public Travel(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupied_seats) {
        this.startCity = startCity;
        this.endCity = endCity;
        this.startTime = startTime;
        this.duration = duration;
        this.seats = seats;
        this.occupied_seats = occupied_seats;
        this.travelStatus = TravelStatus.NOT_STARTED;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public City getStartCity() {
        return startCity;
    }

    public void setStartCity(City startCity) {
        this.startCity = startCity;
    }

    public City getEndCity() {
        return endCity;
    }

    public void setEndCity(City endCity) {
        this.endCity = endCity;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getOccupied_seats() {
        return occupied_seats;
    }

    public void setOccupied_seats(int occupied_seats) {
        this.occupied_seats = occupied_seats;
    }

    public void setTravelStatus(TravelStatus status){
        this.travelStatus = status;
    }

    public TravelStatus getTravelStatus(){
        return this.travelStatus;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "startCity=" + startCity +
                ", endCity=" + endCity +
                '}';
    }


    public void printTravelData() {
        if (startCity.isTheSameTime(endCity)) {
            System.out.println("The same time zone");
            System.out.println(this.toString());
        } else {
            System.out.println("Different time zone");

            ZonedDateTime arrivalFromDepartureZone = ZonedDateTime.of(this.getStartTime().plusMinutes(duration), startCity.getTimeZone());
            ZonedDateTime arrivalInAnotherZone = ZonedDateTime.of(this.getStartTime().plusMinutes(duration), endCity.getTimeZone());

            System.out.println("Departure time zone\n" + this.toString() + ", arrival time=" + arrivalFromDepartureZone);
            System.out.println("Arrival time zone\n" + this.toString() + ", arrival time=" + arrivalInAnotherZone);
        }


    }

    public boolean isNationalTravel(){
        return !this.startCity.getCountry().equalsIgnoreCase(endCity.getCountry());
    }

    public boolean doesChangeDate(){
        LocalDateTime localDateTime = ZonedDateTime.of(this.getStartTime(), this.getStartCity().getTimeZone()).toLocalDateTime();
        LocalDateTime arrivalDate = ZonedDateTime.of(getStartTime().plusMinutes(getDuration()), getEndCity().getTimeZone()).toLocalDateTime();

        return localDateTime.getDayOfMonth() == arrivalDate.getDayOfMonth();
    }



}







