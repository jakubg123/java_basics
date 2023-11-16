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

class TravelTest {

    @Test
    public void reserveWithEnoughSeats() throws NoFreeSeatsException {
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

        // Assert
        assertEquals(10, travel.getOccupied_seats());
    }

    @Test
    void reserve_withNotEnoughSeats_shouldThrowException() {
        // Arrange
        City startCity = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City endCity = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));
        Travel travel = new Travel(
                LocalDateTime.now(),
                Duration.ofHours(2),
                startCity,
                endCity,
                100
        );

        // Act & Assert
        assertThrows(NoFreeSeatsException.class, () -> travel.reserve(150));
    }

    @Test
    void reserve_withTooManyOccupiedSeats_shouldThrowException() {
        // Arrange
        City startCity = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City endCity = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));
        Travel travel = new Travel(
                LocalDateTime.now(),
                Duration.ofHours(2),
                startCity,
                endCity,
                100
        );

        // Occupy some seats
        travel.setOccupied_seats(90);

        // Act & Assert
        assertThrows(NoFreeSeatsException.class, () -> travel.reserve(20));
    }
}