package uni.lodz.project.city;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class City {
    private String name;
    private String country;
    private ZoneId timeZone;

    public City(String name, String country, ZoneId timezone){
        this.name = name;
        this.country = country;
        this.timeZone = timezone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(ZoneId timeZone) {
        this.timeZone = timeZone;
    }


    public boolean isTheSameCountry(City city2){
        return this.country.equalsIgnoreCase(city2.country);
    }

    public boolean isTheSameTime(City city2){
        ZonedDateTime first = ZonedDateTime.now(this.getTimeZone());
        ZonedDateTime second = ZonedDateTime.now(city2.getTimeZone());

        int firstHour = first.withZoneSameInstant(ZoneId.of("UTC")).getHour();
        int firstMinute = first.getMinute();
        int secondHour = second.withZoneSameInstant(ZoneId.of("UTC")).getHour();
        int secondMinute = second.getMinute();
        System.out.println(firstHour + " " + firstMinute + " " + secondHour + " " + secondMinute);
        return firstHour == secondHour && firstMinute == secondMinute;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", timeZone=" + timeZone +
                '}';
    }
}
