package olympics;

import java.time.*;
import java.util.*;

public class Olympics {
    private String hostCity;
    private String country;
    private int number;
    private List<String> disciplines;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ZoneId zone;


    public Olympics(String hostCity, String countyr, int number, List<String> disciplines, LocalDateTime startTime, LocalDateTime endTime, ZoneId zone) {
        this.hostCity = hostCity;
        this.country = countyr;
        this.number = number;
        this.disciplines = disciplines;
        this.startTime = startTime;
        this.endTime = endTime;
        this.zone = zone;
    }

    public String getHostCity() {
        return hostCity;
    }

    public void setHostCity(String hostCity) {
        this.hostCity = hostCity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<String> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<String> disciplines) {
        this.disciplines = disciplines;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ZoneId getZone() {
        return zone;
    }

    public void setZone(ZoneId zone) {
        this.zone = zone;
    }


    public boolean checkIfInCountry(String countryName){
        return this.country.equalsIgnoreCase(countryName);
    }

    public int daysFrom(LocalDateTime d){
        if(d.isBefore(startTime)){
           Duration duration = Duration.between(d, startTime);
           return (int) duration.toDays();
        }
        else
        {
            return -1;
        }
    }

    public int daysTo(LocalDateTime d) {
        if (d.isAfter(endTime)) {
            Duration duration = Duration.between(d, endTime);
            return (int) duration.toDays();
        }
        return -1;
    }

    public String getDisciplineWithTheLongestName() {
        return disciplines.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }


    public String getDisciplineAlphabeticallyFirst() {
        List<String> mutableDisciplines = new ArrayList<>(disciplines);
        mutableDisciplines.sort(Comparator.naturalOrder());
        return mutableDisciplines.get(0);
    }

    public LocalDate getStartDateInLocation(ZoneId z){
        return startTime.atZone(zone).withZoneSameInstant(z).toLocalDate();
    }

    public Duration getDuration(){
        return Duration.between(startTime, endTime);
    }

    public int getNumberOfDisciplines() {
        return disciplines.size();
    }

    public String toRomanNumbers(int number) {
        if (number < 1 || number > 3999) {
            return "Number out of range";
        }

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[number / 1000] +
                hundreds[(number % 1000) / 100] +
                tens[(number % 100) / 10] +
                ones[number % 10];
    }


    public String getFullName(){
        return toRomanNumbers(this.number) + " " + this.country;
    }


}
