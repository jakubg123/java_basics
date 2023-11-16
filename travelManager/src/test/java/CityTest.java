import org.junit.Test;
import uni.lodz.project.city.City;

import java.time.ZoneId;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CityTest {

    @Test
    public void isTheSameCountry() {
        City city1 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City city2 = new City("Moskwa", "Russia", ZoneId.of("Europe/Moscow"));
        City city3 = new City("Krakow", "Poland", ZoneId.of("Europe/Warsaw"));
        City city4 = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));

        assertTrue(city1.isTheSameCountry(city1));
        assertTrue(city1.isTheSameCountry(city3));
        assertFalse(city2.isTheSameCountry(city4));
        assertFalse(city1.isTheSameCountry(city2));
    }

    @Test
    public void isTheSameTime() {
        City city1 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City city2 = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));
        City city3 = new City("Dushanbe", "Tajik", ZoneId.of("Asia/Dushanbe"));

        assertTrue(city1.isTheSameTime(city1));
        assertTrue(city1.isTheSameTime(city2));
        assertFalse(city1.isTheSameCountry(city3));
        assertFalse(city2.isTheSameCountry(city3));
    }
}