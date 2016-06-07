package com.dkkovalev.MathHandlers;


import java.util.Random;

public class RandomBetweenTwoNumbers {
    public String getRandom(int a, int b) {
        Random r = new Random();
        int result = r.nextInt(a - b) + b;
        return String.valueOf(result);
    }
}
