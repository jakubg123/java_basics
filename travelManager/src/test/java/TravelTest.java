import org.junit.Test;
import uni.lodz.project.city.City;
import uni.lodz.project.exceptions.NoFreeSeatsException;
import uni.lodz.project.travel.Travel;
import uni.lodz.project.travel.roadtravel.BusRide;
import uni.lodz.project.travel.roadtravel.CarRide;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.Assert.*;

public class TravelTest {

    @Test
    public void reserveWithEnoughSeatsTest() throws NoFreeSeatsException {
        // Arrange
        City startCity = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City endCity = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));
        Travel travel = new CarRide(
                LocalDateTime.now(),
                120,
                startCity,
                endCity,
                100,0,"LLL111"
        );

        ((CarRide) travel).reserve(10);

        assertEquals(10, travel.getOccupied_seats());
    }

    @Test
    public void reserveWithNotEnoughSeatsTest() {
        City startCity = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City endCity = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));
        Travel travel = new CarRide(
                LocalDateTime.now(),
                120,
                startCity,
                endCity,
                100,0,"KKK222"
        );

        assertThrows(NoFreeSeatsException.class, () -> ((CarRide)travel).reserve(150));
    }

    @Test
    public void isNationalTravelTest(){
        City city1 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City city2 = new City("Moskwa", "Russia", ZoneId.of("Europe/Moscow"));
        City city3 = new City("Krakow", "Poland", ZoneId.of("Europe/Warsaw"));
        City city4 = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));

        Travel travel = new CarRide(LocalDateTime.now(), 100, city1,
                city2,20, 0, "ASD1111");

        Travel travel2 = new CarRide(LocalDateTime.now(), 100, city1,
                city3,20, 0, "ASD222");

        Travel travel3 =  new CarRide(LocalDateTime.now(), 100, city1,
                city4,20, 0, "ASD222");

        assertTrue(travel.isNationalTravel());
        assertTrue(travel3.isNationalTravel());
        assertFalse(travel2.isNationalTravel());
    }

    @Test
    public void doesChangeDateTest(){

        City city1 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City city2 = new City("Moskwa", "Russia", ZoneId.of("Europe/Moscow"));
        City city3 = new City("Krakow", "Poland", ZoneId.of("Europe/Warsaw"));
        City city4 = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));

        Travel travel = new CarRide((LocalDateTime.of(2023, 11, 16, 12, 30)), 100, city1,
                city2,20, 0, "ASD1111");

        Travel travel2 = new CarRide(LocalDateTime.of(2023, 11, 16, 10, 30), 100, city1,
                city3,20, 0, "ASD222");

        Travel travel3 =  new CarRide(LocalDateTime.of(2023, 11, 16, 23, 30), 100, city1,
                city4,20, 0, "ASD222");

        assertTrue(travel.doesChangeDate());
        assertTrue(travel2.doesChangeDate());
        assertFalse(travel3.doesChangeDate());
    }

}