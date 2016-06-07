package com.dkkovalev.MathHandlers;


import java.util.Random;

public class RandomBetweenTwoNumbers {
    public String getRandom(double a, double b) {
        Random r = new Random();
        double randomValue = b + (a - b) * r.nextDouble();
        return String.valueOf(randomValue);
    }
}
