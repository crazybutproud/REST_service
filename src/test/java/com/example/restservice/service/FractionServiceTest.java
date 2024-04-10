package com.example.restservice.service;

import com.example.restservice.entity.Fraction;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FractionServiceTest {
    private final FractionService fractionService = new FractionService();

    @Test
    public void checkTest() {
        assertTrue(fractionService.check(new Fraction(2, 3)));
        assertTrue(fractionService.check(new Fraction(-7, 9)));
        assertTrue(fractionService.check(new Fraction(2, -5)));
        assertTrue(fractionService.check(new Fraction(-1, -7)));
        assertTrue(fractionService.check(new Fraction(0, 9)));
        assertTrue(fractionService.check(new Fraction(0, -8)));
        assertTrue(fractionService.check(new Fraction(-0, 8)));
        assertTrue(fractionService.check(new Fraction(-0, -8)));

        assertFalse(fractionService.check(new Fraction(3, 2)));
        assertFalse(fractionService.check(new Fraction(-9, 7)));
        assertFalse(fractionService.check(new Fraction(5, -2)));
        assertFalse(fractionService.check(new Fraction(-7, -3)));
    }

    private static Object[] testValuesForSimplify() {
        return new Object[]{
                new Object[]{1, 2, "1/2"},
                new Object[]{2, 4, "1/2"},
                new Object[]{72, 144, "1/2"},
                new Object[]{24, 18, "4/3"},
                new Object[]{315, 15, "21/1"},
                new Object[]{1260, 1260, "1/1"},
                new Object[]{-1, 81, "-1/81"},
                new Object[]{2, -4, "-1/2"},
                new Object[]{-105, 120, "-7/8"},
                new Object[]{96, -56, "-12/7"},
                new Object[]{-274, 391, "-274/391"},
                new Object[]{0, 9, "0"}
        };
    }

    @Test
    @Parameters(method = "testValuesForSimplify")
    public void simplifyTestParams(int numerator, int denominator, String result) {
        assertEquals(result, fractionService.simplify(new Fraction(numerator, denominator)).toString());
    }

    private static Object testValuesForAddition() {
        return new Object[]{
                new Object[]{new Fraction(5, 9), new Fraction(-5, 9), "0"},
                new Object[]{new Fraction(1, 6), new Fraction(7, 9), "17/18"},
                new Object[]{new Fraction(-1, 6), new Fraction(7, 9), "11/18"},
                new Object[]{new Fraction(1, 6), new Fraction(-7, 9), "-11/18"},
                new Object[]{new Fraction(-1, 6), new Fraction(-7, 9), "-17/18"},
                new Object[]{new Fraction(0, 2), new Fraction(0, 9), "0"},
                new Object[]{new Fraction(0, 2), new Fraction(7, 9), "7/9"},
        };
    }

    @Test
    @Parameters(method = "testValuesForAddition")
    public void additionTestParams(Fraction first, Fraction second, String result) {
        assertEquals(result, fractionService.addition(first, second).toString());
    }

    private static Object testValuesForSubtraction() {
        return new Object[]{
                new Object[]{new Fraction(7, 11), new Fraction(7, 11), "0"},
                new Object[]{new Fraction(4, 5), new Fraction(9, 10), "-1/10"},
                new Object[]{new Fraction(-4, 5), new Fraction(9, 10), "-17/10"},
                new Object[]{new Fraction(4, 5), new Fraction(-9, 10), "17/10"},
                new Object[]{new Fraction(-4, 5), new Fraction(-9, 10), "1/10"},
                new Object[]{new Fraction(0, 4), new Fraction(-4, 5), "4/5"},
                new Object[]{new Fraction(0, 7), new Fraction(0, 9), "0"}
        };
    }

    @Test
    @Parameters(method = "testValuesForSubtraction")
    public void subtractionTestParams(Fraction first, Fraction second, String result) {
        assertEquals(result, fractionService.subtraction(first, second).toString());
    }

    private static Object testValuesForMultiplication() {
        return new Object[]{
                new Object[]{new Fraction(0, 7), new Fraction(-1, 8), "0"},
                new Object[]{new Fraction(4, 9), new Fraction(21, 2), "14/3"},
                new Object[]{new Fraction(-6, 7), new Fraction(14, 15), "-4/5"},
                new Object[]{new Fraction(1, 8), new Fraction(-4, 11), "-1/22"},
                new Object[]{new Fraction(-12, 13), new Fraction(-26, 21), "8/7"},
                new Object[]{new Fraction(5, 17), new Fraction(-17, 5), "-1/1"},
                new Object[]{new Fraction(-14, 9), new Fraction(-9, 14), "1/1"},
        };
    }

    @Test
    @Parameters(method = "testValuesForMultiplication")
    public void multiplicationTestParams(Fraction first, Fraction second, String result) {
        assertEquals(result, fractionService.multiplication(first, second).toString());
    }

    private static Object testValuesForDivision() {
        return new Object[]{
                new Object[]{new Fraction(0, 49), new Fraction(1, 7), "0"},
                new Object[]{new Fraction(7, 10), new Fraction(21, 5), "1/6"},
                new Object[]{new Fraction(2, 5), new Fraction(-24, 25), "-5/12"},
                new Object[]{new Fraction(-9, 13), new Fraction(3, 26), "-6/1"},
                new Object[]{new Fraction(-81, 14), new Fraction(-9, 7), "9/2"},
                new Object[]{new Fraction(-5, 11), new Fraction(5, 11), "-1/1"},
                new Object[]{new Fraction(-21, 27), new Fraction(-21, 27), "1/1"},
        };
    }

    @Test
    @Parameters(method = "testValuesForDivision")
    public void divisionTestParams(Fraction first, Fraction second, String result) {
        assertEquals(result, fractionService.division(first, second).toString());
    }
}
