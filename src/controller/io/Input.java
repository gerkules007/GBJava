package controller.io;

import java.util.Scanner;

public class Input {

    public static int takeIntegerNumber(String header) {
        Scanner line = new Scanner(System.in);
        System.out.printf("%s: ", header);
        while(line.hasNext()) {
            if(line.hasNextInt()) {
                return line.nextInt();
            } else {
                line.next();
                System.out.printf("%s: ", header);
            }
        }
        line.close();
        return 0;
    }

    public static String takeString(String header) {
        Scanner line = new Scanner(System.in);
        System.out.println(header);
        line.close();
        return line.nextLine();
    }

    public static void readFile() {

    }


}