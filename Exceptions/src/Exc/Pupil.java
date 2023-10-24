package Exc;

import java.util.Scanner;

public class Pupil {

    private String name;
    private String surname;
    private int marksNumber;

    private int[] marks;


    public Pupil(String name, String surname, int marksNumber, int[] marks) {
        this.name = name;
        this.surname = surname;
        this.marksNumber = marksNumber;
        this.marks = marks;
    }

    public double avg() {
        double average = 0;
        for (int mark : marks) {
            average += mark;
        }

        return average / marksNumber;
    }

    public void printOut() {
        System.out.println(name + " " + surname + " " + marksNumber + " [ ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.print(" ]");
    }

    public int getMark(int number) {

        if (number >= marksNumber) {
            throw new ArrayIndexOutOfBoundsException("you dont have that many marks!");
        } else {
            return marks[number];
        }
    }


    public static Pupil getData() throws GradeException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Surname: ");
        String surname = scanner.nextLine();

        System.out.println("Marks number: ");
        int marksNumber = scanner.nextInt();

        if(marksNumber == 0){
            throw new IllegalArgumentException("You can't have 0 marks");
        }



        int[] marks = new int[marksNumber];

        for (int i = 0; i < marksNumber; i++) {
            try{
                int nextInt = scanner.nextInt();
                if(nextInt > 6 || nextInt < 1){
                    throw new GradeException();
                }
                else
                    marks[i] = nextInt;
            }
            catch(GradeException e){
                System.out.println(e.getMessage());
            }
        }
        return new Pupil(name, surname, marksNumber, marks);

    }

    public static void menu(){
        System.out.println("1.Average\n2.Print\n3.Print grade\n4.Exit");

    }

    public void choose(int input){
        try {
            switch (input) {
                case 1:
                    System.out.println(avg());
                    break;
                case 2:
                    printOut();
                    break;
                case 3:
                    Scanner sc = new Scanner(System.in);
                    int index = sc.nextInt() - 1;
                    try {
                        System.out.println("Mark: " + getMark(index));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Wrong index!");
                    }
                    break;

                case 4:
                    break;
                default:
                    System.out.println("Unknown input");
            }
        }
        finally{
            System.out.println("****************END ");
            }
        }
    }

