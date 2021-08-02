package com.company;

import java.util.Scanner;

public class ConsoleHelper {
    public static int InputInt(String message) {
        boolean isNumber;
        int number = 0;

        do {
            try {
                isNumber = true;
                Scanner input = new Scanner(System.in);

                System.out.print(message);
                number = input.nextInt();
            } catch (Exception e) {
                isNumber = false;
            }

        } while (isNumber == false);

        return number;
    }

    public static int InputInt(String message, int minValue, int maxValue) {
        boolean isNumber;
        int number = 0;

        do {
            try {
                isNumber = true;
                Scanner input = new Scanner(System.in);

                System.out.print(message);
                number = input.nextInt();

                if (number < minValue || number > maxValue) {
                    throw new Exception();
                }

            } catch (Exception e) {
                isNumber = false;
            }

        } while (isNumber == false);

        return number;
    }

    public static double InputDouble(String message) {
        boolean isNumber;
        double number = 0;

        do {
            try {
                isNumber = true;
                Scanner input = new Scanner(System.in);

                System.out.print(message);
                number = input.nextDouble();
            } catch (Exception e) {
                isNumber = false;
            }

        } while (isNumber == false);

        return number;
    }

    public static String InputString(String message) {
        boolean isString;
        String string = "";

        do {
            try {
                isString = true;
                Scanner input = new Scanner(System.in);

                System.out.print(message);
                string = input.nextLine();
            } catch (Exception e) {
                isString = false;
            }

        } while (isString == false);

        return string;
    }

    public static void PrintMessage(String message){
        System.out.println(message);
    }
}