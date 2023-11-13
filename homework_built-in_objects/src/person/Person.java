package person;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Person {



    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalTime timeOfBirth;
    private final ZoneId polandZoneId = ZoneId.of("Europe/Warsaw");
    private final ZoneId losAngelesZoneId = ZoneId.of("America/Los_Angeles");

    public Person(String name, String surname, LocalDate birthDate, LocalTime timeOfBirth) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.timeOfBirth = timeOfBirth;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalTime getTimeOfBirth() {
        return timeOfBirth;
    }

    public void setTimeOfBirth(LocalTime timeOfBirth) {
        this.timeOfBirth = timeOfBirth;
    }



    public String getGender(){

        return (name.charAt(name.length() - 1) == 'a') ? "Woman" : "Man"; // Polish language adjusted :-)
    }

    public int getAge()
    {
        Period period = Period.between(birthDate, LocalDate.now());
        return period.getYears();
    }

    public String getDayOfBirth( ){
        Locale origin = new Locale("pl", "PL");
        System.out.println(origin);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE", origin);
        DayOfWeek dayOfWeek = birthDate.getDayOfWeek();

        return dayOfWeek.getDisplayName(TextStyle.FULL, origin);

    }

    public String reverseString(){
        String fullName = this.name + " " + this.surname;
        StringBuilder reversedString = new StringBuilder(this.surname + " " + this.name).reverse();
        String[] result = reversedString.toString().split(" ");

        return capitalizeFirstLetter(result);
    }


    public String capitalizeFirstLetter(String[] str) {
        StringBuilder result = new StringBuilder();
        for(String string : str){
            result.append(string.substring(0, 1).toUpperCase()).append(string.substring(1)).append(" ");
        }

        return result.toString().trim();
    }

    public LocalTime getLosAngelesDateTime() {
        LocalDateTime dateTime = LocalDateTime.of(birthDate, timeOfBirth);

        ZonedDateTime polandZonedDateTime = ZonedDateTime.of(dateTime, polandZoneId);
        ZonedDateTime losAngelesZonedDateTime = polandZonedDateTime.withZoneSameInstant(losAngelesZoneId);

        return losAngelesZonedDateTime.toLocalTime();
    }


}
