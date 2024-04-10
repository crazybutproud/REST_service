package com.example.restservice.service;

import com.example.restservice.entity.Fraction;
import org.springframework.stereotype.Service;

@Service
public class FractionService {

    public boolean check(Fraction fraction) {
        return Math.abs(fraction.getNumerator()) < fraction.getDenominator();
    }

    public Fraction simplify(Fraction fraction) {
        int numerator = fraction.getNumerator();
        int denominator = fraction.getDenominator();
        int i = 2;
        while (i <= Math.min(Math.abs(numerator), denominator)) {
            if (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
                i = 2;
                continue;
            }
            i++;
        }
        return new Fraction(numerator, denominator);
    }

    public Fraction addition(Fraction first, Fraction second) {
        int resultNumerator = first.getNumerator() * second.getDenominator() + second.getNumerator() * first.getDenominator();
        int resultDenominator = first.getDenominator() * second.getDenominator();
        return simplify(new Fraction(resultNumerator, resultDenominator));
    }

    public Fraction subtraction(Fraction first, Fraction second) {
        int resultNumerator = first.getNumerator() * second.getDenominator() - second.getNumerator() * first.getDenominator();
        int resultDenominator = first.getDenominator() * second.getDenominator();
        return simplify(new Fraction(resultNumerator, resultDenominator));
    }

    public Fraction multiplication(Fraction first, Fraction second) {
        int resultNumerator = first.getNumerator() * second.getNumerator();
        int resultDenominator = first.getDenominator() * second.getDenominator();
        return simplify(new Fraction(resultNumerator, resultDenominator));
    }

    public Fraction division(Fraction first, Fraction second) {
        int resultNumerator = first.getNumerator() * second.getDenominator();
        int resultDenominator = first.getDenominator() * second.getNumerator();
        return simplify(new Fraction(resultNumerator, resultDenominator));
    }
}
