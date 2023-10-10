package Triangle;

import java.sql.Array;
import java.util.Scanner;

public class MainTemperature {
    public static void main(String[] args){
//        double daysCount = 4;
//        double[] tab = {15,4,2,3};
//        TemperatureController controller = new TemperatureController(daysCount, tab);
//        controller.describe();
//        controller.avgTemperature();
//        controller.minTemperature();
//        controller.maxTemperature();
//        controller.median();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile dni?");
        int daysCount = scanner.nextInt();
        double [] days = new double[daysCount];
        for(int i =0; i < daysCount;i++){
            days[i] = scanner.nextInt();
        }






    }
}
