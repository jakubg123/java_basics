package StudentIndex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentIndex index = new StudentIndex("test", 5);
        Scanner scanner = new Scanner(System.in);
        index.dataScanner(scanner);

    }
}