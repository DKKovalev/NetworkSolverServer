package com.dkkovalev.MathHandlers;

public class QuadraticEquationSolver {

    public QuadraticEquationSolver() {

    }

    public String solve(double a, double b, double c) {
        String answer = "error";
        if ((b * b - 4 * a * c) >= 0) {
            double sol1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            double sol2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            if (sol1 == sol2) {
                answer = String.valueOf(sol1);
            } else {
                answer = String.valueOf(sol1) + " " + String.valueOf(sol2);
            }
        } else {
            double sola = (-b / (2 * a));
            double solb = Math.sqrt(-(b * b - 4 * a * c)) / (2 * a);
            answer = (String.valueOf(sola) + " + " + String.valueOf(solb) + "i and" + String.valueOf(sola) + " - " + String.valueOf(solb) + "i");
        }

        return answer;
    }

}
