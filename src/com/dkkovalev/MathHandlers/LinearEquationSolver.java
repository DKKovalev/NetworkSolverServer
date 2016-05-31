package com.dkkovalev.MathHandlers;

public class LinearEquationSolver {

    public LinearEquationSolver() {

    }

    public double[] solve(double a, double b) {
        double[] answer = new double[10];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = a * i + b;
        }
        return answer;
    }


}
