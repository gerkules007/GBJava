package controller;

import java.util.Scanner;

public class Input {
    private static final Scanner line = new Scanner(System.in);

    public static int inputNumber(String header) {
        System.out.println(header);
        while (line.hasNext()) {
            if (line.hasNextInt()) {
                return line.nextInt();
            } else {
                System.out.println(header);
                line.next();
            }
        }
        return 0;
    }

    public String inputString(String header) {
        System.out.println(header);
        return line.nextLine();
    }
}