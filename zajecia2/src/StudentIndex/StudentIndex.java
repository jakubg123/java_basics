package StudentIndex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class StudentIndex {
    private String surname;
    private int subjects;
    private int[] marks;
    public StudentIndex(String surname, int subjects){
        this.surname = surname;
        this.subjects = subjects;
        this.marks = new int[0];
    }
    public int[] dataScanner(Scanner scanner){
        System.out.println("How many marks do you have ?");
        int numOfMarks = scanner.nextInt();
        this.marks = new int[numOfMarks];

       for(int i =0; i < numOfMarks;i++){
           marks[i] = scanner.nextInt();
       }
       scanner.close();
       return marks;
    }

    public void printMarks(){
        for(int data : marks){
            System.out.println(data);
        }
    }

    public void describe(){
        System.out.println(surname);
        for (int mark : marks) {
            switch (mark) {
                case 2 -> {
                    System.out.println("Niedostateczny");
                }
                case 3 -> {
                    System.out.println("Dostateczny");
                }
                case 4 -> {
                    System.out.println("Dobry");
                }
                case 5 -> {
                    System.out.println("Bardzo dobry");
                }
                default -> {
                    break;
                }

            }
        }
    }
    public int maxMark(){
        int last = marks.length - 1;
        Arrays.sort(marks);
        return marks[last];
    }


    public void notAcquired(){
        HashSet<Integer> foundMarks = new HashSet<>();
        for (int i = 0; i < marks.length; i++) {
            int grade = marks[i];
            if (grade >= 2 && grade <= 5) {
                foundMarks.add(grade);
            }
        }
        for (int mark = 2; mark <= 5; mark++) {
            if (!foundMarks.contains(mark)) {
                System.out.println("Missing grade: " + mark);
            }
        }
    }
}








