package Triangle;

import java.util.Arrays;

public class TemperatureController {

    private double daysCount;
    private double[] tab;
    public TemperatureController(double daysCount, double [] tab){
        this.daysCount = daysCount;
        this.tab = tab;
    }

    public void describe(){
        System.out.println(daysCount + " " + Arrays.toString(tab));
    }
    public void avgTemperature(){
        int i;
        double sum = 0;
        for(i=0; i < tab.length;i++){
            i++;
            sum+=tab[i];
        }
        double out = sum/i;
        System.out.println(out);
    }

    public void minTemperature(){
        double minTemp = Integer.MAX_VALUE;
        for(double temperature : tab){
            if(temperature < minTemp){
                minTemp = temperature;
            }
        }
        System.out.println(minTemp);
    }

    public void maxTemperature(){
        double maxTemp = Integer.MIN_VALUE;
        for(double temperature : tab){
            if(temperature > maxTemp){
                maxTemp = temperature;
            }
        }
        System.out.println(maxTemp);
    }

    public void median(){
        Arrays.sort(tab);
        double med = tab[tab.length/2];

        System.out.println(med);

    }
}
