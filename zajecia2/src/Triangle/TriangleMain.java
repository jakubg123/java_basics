package Triangle;

import java.util.Scanner;

public class TriangleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jaka jest dlugosc bokow ?");

        int[] tab = new int[3];

        for(int i=0;i < 3;i++){
            tab[i] = scanner.nextInt();

        }

        int a = tab[0];
        int b = tab[1];
        int c = tab[2];

        Triangle test = new Triangle(a,b,c);


        while(true){


            System.out.println("1: Show area");
            System.out.println("2: Show perimiter");
            System.out.println("3: Show type");
            System.out.println("4: Quit!");

            int answer = scanner.nextInt();

            switch (answer){
                case 1 -> System.out.println(test.calculateArea());
                case 2 -> System.out.println(test.calculatePerimiter());
                case 3 -> System.out.println(test.getType());
                default -> {
                    break;
                }
            }

            if(answer == 4){break;}

        }






    }
}
