package com.example.restservice.entity;

import com.example.restservice.exception.ErrorFractionException;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Fraction {
    private int numerator;
    private int denominator;


    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ErrorFractionException();
        }
        if (numerator < 0 && denominator < 0 || numerator >= 0 && denominator > 0) {
            this.numerator = Math.abs(numerator);
        } else {
            this.numerator = -Math.abs(numerator);
        }
        this.denominator = Math.abs(denominator);
    }

    public String toString() {
        return numerator == 0 ? "0" : numerator + "/" + denominator;
    }
}
