import exceptions.ValidDataException;
import person.Person;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ValidDataException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter surname:");
        String surname = scanner.nextLine();

        if (!isValidNameAndSurname(name, surname) || !hasCapitalizedInitials(name, surname)) {
            throw new ValidDataException("Invalid name or surname");
        }

        System.out.println("Enter birth year:");
        int year = scanner.nextInt();
        System.out.println("Enter birth month:");
        int month = scanner.nextInt();
        System.out.println("Enter birth day:");
        int day = scanner.nextInt();

        if (!isValidDate(year, month, day)) {
            throw new ValidDataException("Invalid date");
        }

        Person person = new Person(name, surname, LocalDate.of(year, month, day), LocalTime.now());

        System.out.println("Gender: " + person.getGender());
        System.out.println("Age: " + person.getAge());
        System.out.println("Day of Birth: " + person.getDayOfBirth());
        System.out.println("Reversed Name: " + person.reverseString());
        System.out.println("Los Angeles Date and Time: " + person.getLosAngelesDateTime());
    }

    public static boolean isValidNameAndSurname(String name, String surname) {
        return name.matches("[a-zA-Z]+") && surname.matches("[a-zA-Z]+");
    }

    public static boolean hasCapitalizedInitials(String name, String surname) {
        return Character.isUpperCase(name.charAt(0)) && Character.isUpperCase(surname.charAt(0));
    }

    public static boolean isValidDate(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (java.time.DateTimeException e) {
            return false;
        }
    }

}



