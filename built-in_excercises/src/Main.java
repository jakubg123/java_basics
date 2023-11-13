import olympics.Olympics;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        ZoneId[] zones= {ZoneId.of("PRC"),ZoneId.of("Europe/Paris"),
                ZoneId.of("Europe/Warsaw"),ZoneId.of("Asia/Tokyo"),
                ZoneId.of("America/New_York")};

        Olympics[] olympics=new Olympics[2];

        String[] dBeijing = {"skiing","biathlon","bobsleigh","curling",
                "skating","ice hokey","luge","skeleton","snowboarding"};
        LocalDateTime beijingS = LocalDateTime.of(2022,2,4,20, 0);
        LocalDateTime beijingE = LocalDateTime.of(2022,2,20,21,40);
        olympics[0] = new Olympics("Beijing","China",24, List.of(dBeijing),
                beijingS,beijingE,zones[0]);

        String[] dParis = {"aquatics","archery","atchletics","badminton",
                "basketball","boxing","breaking","canoeing","cycyling",
                "equestrian","fencing","field hockey","football","golf",
                "gymnastics", "handball", "judo", "modern pentathlon",
                "rowing","rugby sevens", "sailing", "shooting",
                "skateboarding","sport climbing", "surfing", "table tennis",
                "taekwondo","tennis", "triathlon", "volleyball",
                "weightlifting", "wrestiling"};
        LocalDateTime parisS = LocalDateTime.of(2024,7,26,20,00);
        LocalDateTime parisE = LocalDateTime.of(2024,8,11,22,50);
        olympics[1] = new Olympics("Paris","France",33, List.of(dParis),
                parisS,parisE,zones[1]);

        for (Olympics olympic : olympics) {
            System.out.println(olympic.getFullName());
            System.out.println("In France? " + olympic.checkIfInCountry("France"));
            System.out.println("In China? " + olympic.checkIfInCountry("China"));
            System.out.println("Days from: " + olympic.daysFrom(LocalDateTime.now()));
            System.out.println("Days to: " + olympic.daysTo(LocalDateTime.now()));
            System.out.println("First discipline: " + olympic.getDisciplineAlphabeticallyFirst());
            System.out.println("Longest discipline: " + olympic.getDisciplineWithTheLongestName());
            System.out.println("Duration: " + olympic.getDuration());
            System.out.println("Number of disciplines :" + olympic.getNumberOfDisciplines());
            for (ZoneId zone : zones) {
                System.out.println(zone.toString() + " " + olympic.getStartDateInLocation(zone));
            }
            System.out.println();
        }
    }

}