import Exc.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework {

    public static void main(String[] args) throws HomeworkOutofRangeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pass a number in range [0.1 - 9999.99]");
        double number = scanner.nextDouble();
        double sqrt = Math.sqrt(number);

        try{
            if(sqrt <= 0){
                throw new UnsupportedOperationException("Number should be positive");
            }
            else if(sqrt < 0.1 || sqrt > 9999.99){
                throw new HomeworkOutofRangeException("Out of range!");
            }

            System.out.println(sqrt);
        }
        catch (UnsupportedOperationException e) {
            System.out.println( e + "It is not a number.");
        }

        catch (HomeworkOutofRangeException e) {
            System.out.println(e.getMessage());
        }


    }

}
