/*************************************************************
 * Microsoft: DEV277x - Object-Oriented Programming in Java
 * Module 2 Project - Fraction Calculator (Part 1 - Fraction Class)
 * ***********************
 * Author: Nur Fatin
 * 29/11/2021
 *************************************************************/

public class Fraction {
    private int numerator;
    private int denominator;

    // overloading constructor
    public Fraction(int num, int den) {
        numerator = num;
        if (den == 0) {
            throw new IllegalArgumentException("denominator cannot be zero");
        } else if (den < 0) {
            numerator *= -1;
            denominator = Math.abs(den);

        } else {
            denominator = den;
        }
    }

    public Fraction(int num) {
        this(num, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    // What it does
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator/denominator;
    }

    public Fraction add(Fraction otherFraction) {
        int fracnumerator = numerator + otherFraction.numerator;
        int fracdenominator = denominator + otherFraction.denominator;
        return new Fraction(fracnumerator, fracdenominator);
    }

    public Fraction subtract(Fraction otherFraction) {
        int fracnumerator = numerator - otherFraction.numerator;
        int fracdenominator = denominator - otherFraction.denominator;
        if (fracdenominator == 0) {
            fracdenominator = 1;
        }
        return new Fraction(fracnumerator, fracdenominator);
    }

    public Fraction multiply(Fraction otherFraction) {
        int fracnumerator = numerator * otherFraction.numerator;
        int fracdenominator = denominator * otherFraction.denominator;
        return new Fraction(fracnumerator, fracdenominator);
    }

    public Fraction divide(Fraction otherFraction) {
        int fracnumerator = numerator / otherFraction.numerator;
        int fracdenominator = denominator / otherFraction.denominator;
        return new Fraction(fracnumerator, fracdenominator);
    }

    public boolean equals(Fraction otherFraction) {
        if (Math.abs(toDouble()) == Math.abs(otherFraction.toDouble())) {
            return true;
        } else if ((numerator == otherFraction.numerator) && (denominator == otherFraction.denominator)) {
            return true;
        } else {
            return false;
        }
    }

    public void toLowestTerms() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    public static int gcd(int num, int den) {
        while (num != 0 && den != 0) {
            int remainder = num % den;
            num = den;
            den = remainder;
        }
        return num;
    }
}
