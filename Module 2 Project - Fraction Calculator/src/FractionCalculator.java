/*************************************************************
 * Microsoft: DEV277x - Object-Oriented Programming in Java
 * Module 2 Project - Fraction Calculator (Part 2 – FractionCalculator Class)
 * ***********************
 * Author: Nur Fatin
 * 29/11/2021
 *************************************************************/

import java.util.Scanner;
public class FractionCalculator {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //welcome message
        System.out.println("""
                This program is a fraction calculator.
                It will add, subtract, multiply and divide fractions until you type Q to quit.
                Please enter your fractions in the form a/b, where a and b are integers.""");

        while (true) {
            System.out.println("----------------------------------------------------------------------------------");
            String operation = getOperation();
            Fraction input1 = getFraction();
            Fraction input2 = getFraction();

            //Calculate result
            if (operation.equals("=")) {
                boolean result = input1.equals(input2);
                System.out.println(input1.toString() + " " + operation + " " + input2.toString() + " = " + result);
            } else if (operation.equals("-")) {
                Fraction result = input1.subtract(input2);
                result.toLowestTerms();
                System.out.println(input1.toString() + " " + operation + " " + input2.toString() + " = " + result);
            } else if (operation.equals("*")) {
                Fraction result = input1.multiply(input2);
                result.toLowestTerms();
                System.out.println(input1.toString() + " " + operation + " " + input2.toString() + " = " + result);
            } else if (operation.equals("/")) {
                Fraction result = input1.divide(input2);
                result.toLowestTerms();
                System.out.println(input1.toString() + " " + operation + " " + input2.toString() + " = " + result);
            } else {
                Fraction result = input1.add(input2);
                result.toLowestTerms();
                System.out.println(input1.toString() + " " + operation + " " + input2.toString() + " = " + result);
            }
        }
    }

    public static String getOperation() {
            System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
            String operation = input.nextLine();

            while(!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*") &&
                    !operation.equals("=") && !operation.equalsIgnoreCase("q")) {
                System.out.print("Invalid input (Select +, -, /, *, = or Q to quit): ");
                operation = input.nextLine();
            }

            if (operation.equalsIgnoreCase("q")) {
                System.exit(0);
            }

            return operation;
    }

    public static Fraction getFraction() {
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String data = input.nextLine();

        while (validFraction(data) == false) {
            System.out.print("Invalid fraction. Please enter a fraction (a/b) or (a), " +
                    "where a and b are integers and b is not zero: ");
            data = input.nextLine();
        }

        // change String input into integer
        if (data.contains("/")) { // if input is as fraction
            String[] fraction = data.split("/");  // fraction[0] = numerator, fraction[1] = denominator
            int num = Integer.parseInt(fraction[0]);
            int den = Integer.parseInt(fraction[1]);
            return new Fraction(num, den);
        } else {
            return new Fraction(Integer.parseInt(data), 1);
        }
    }

    public static boolean validFraction(String input) {
        if (input.contains("/")) { // if input is as fraction
            String[] fraction = input.split("/");  // fraction[0] = numerator, fraction[1] = denominator
            // check if fraction are integers
            if ((fraction[0].matches("-?\\d+")) && (fraction[1].matches("-?\\d+"))) {
                if (Integer.parseInt(fraction[1]) != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            if (input.matches("-?\\d+")) {  // if input is an integer
                return true;
            } else {
                return false;
            }
        }
    }








}
