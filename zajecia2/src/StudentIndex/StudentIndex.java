package StudentIndex;

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
       return marks;
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
}
