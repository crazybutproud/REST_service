package com.example.restservice.controller;

import com.example.restservice.entity.Fraction;
import com.example.restservice.service.FractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fraction")
public class FractionController {
    private final FractionService fractionService;

    @GetMapping("/check")
    public boolean check(@RequestParam int numerator, @RequestParam int denominator) {
        return fractionService.check(new Fraction(numerator, denominator));
    }

    @GetMapping("/simplify")
    public String simplify(@RequestParam int numerator, @RequestParam int denominator) {
        return fractionService.simplify(new Fraction(numerator, denominator)).toString();
    }

    @GetMapping("/addition")
    public String addition(@RequestParam int numeratorFirst,
                           @RequestParam int denominatorFirst,
                           @RequestParam int numeratorSecond,
                           @RequestParam int denominatorSecond) {
        Fraction first = new Fraction(numeratorFirst, denominatorFirst);
        Fraction second = new Fraction(numeratorSecond, denominatorSecond);
        return fractionService.addition(first, second).toString();
    }

    @GetMapping("/subtraction")
    public String subtraction(@RequestParam int numeratorFirst,
                              @RequestParam int denominatorFirst,
                              @RequestParam int numeratorSecond,
                              @RequestParam int denominatorSecond) {
        Fraction first = new Fraction(numeratorFirst, denominatorFirst);
        Fraction second = new Fraction(numeratorSecond, denominatorSecond);
        return fractionService.subtraction(first, second).toString();
    }

    @GetMapping("/multiplication")
    public String multiplication(@RequestParam int numeratorFirst,
                                 @RequestParam int denominatorFirst,
                                 @RequestParam int numeratorSecond,
                                 @RequestParam int denominatorSecond) {
        Fraction first = new Fraction(numeratorFirst, denominatorFirst);
        Fraction second = new Fraction(numeratorSecond, denominatorSecond);
        return fractionService.multiplication(first, second).toString();
    }

    @GetMapping("/division")
    public String division(@RequestParam int numeratorFirst,
                           @RequestParam int denominatorFirst,
                           @RequestParam int numeratorSecond,
                           @RequestParam int denominatorSecond) {
        Fraction first = new Fraction(numeratorFirst, denominatorFirst);
        Fraction second = new Fraction(numeratorSecond, denominatorSecond);
        return fractionService.division(first, second).toString();
    }
}

