import Exc.GradeException;
import Exc.Pupil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws GradeException {
        int choice;
        Pupil pupil = Pupil.getData();

        Scanner scanner = new Scanner(System.in);
        do
        {
            Pupil.menu();
            choice = scanner.nextInt();
            pupil.choose(choice);

        }while(choice != 4);

    }
}