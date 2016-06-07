package com.dkkovalev;


import com.dkkovalev.MathHandlers.LinearEquationSolver;
import com.dkkovalev.MathHandlers.QuadraticEquationSolver;
import com.dkkovalev.MathHandlers.RandomBetweenTwoNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ServerHandler {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader;
    private String message;

    private PrintWriter printWriter;

    private QuadraticEquationSolver quadraticEquationSolver;
    private LinearEquationSolver linearEquationSolver;
    private RandomBetweenTwoNumbers randomBetweenTwoNumbers;

    public ServerHandler() {
        quadraticEquationSolver = new QuadraticEquationSolver();
        linearEquationSolver = new LinearEquationSolver();
        randomBetweenTwoNumbers = new RandomBetweenTwoNumbers();
    }

    public void handleMessage(int port) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;

        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        serverSocket = new ServerSocket(port);
        System.out.println("Server is online. Listening to the port: " + port);
        while (true) {
            clientSocket = serverSocket.accept();

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            String input;
            input = in.readLine();

            String[]splitMessage = input.split(",");

            if (splitMessage[0].equals("Quadratic")) {

                String response = quadraticEquationSolver.solve(Double.valueOf(splitMessage[1]), Double.valueOf(splitMessage[2]), Double.valueOf(splitMessage[3]));
                System.out.println(response);
                out.println(response);
            } else if (splitMessage[0].equals("Linear")) {
                String response = Arrays.toString(linearEquationSolver.solve(Double.valueOf(splitMessage[1]), Double.valueOf(splitMessage[2])));
                System.out.println(response);
                out.println(response);
            } else if (splitMessage[0].equals("Random")) {
                String response = randomBetweenTwoNumbers.getRandom(Integer.valueOf(splitMessage[1]), Integer.valueOf(splitMessage[2]));
                System.out.println(response);
                out.println(response);
            }

            out.println(splitMessage[0]);
            System.out.println(input);
        }
    }
}
