package com.dkkovalev;


import com.dkkovalev.MathHandlers.LinearEquationSolver;
import com.dkkovalev.MathHandlers.QuadraticEquationSolver;

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
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    private String message;

    private PrintWriter printWriter;

    private QuadraticEquationSolver quadraticEquationSolver;
    private LinearEquationSolver linearEquationSolver;

    public ServerHandler() {
        quadraticEquationSolver = new QuadraticEquationSolver();
        linearEquationSolver = new LinearEquationSolver();
    }

    public void handleMessage(int port) throws IOException {
        serverSocket = new ServerSocket(port);

        System.out.println("Server is online. Listening to the port: " + port);

        while (true) {
            socket = serverSocket.accept();
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);

            printWriter = new PrintWriter(socket.getOutputStream(), true);

            message = bufferedReader.readLine();

            String[] splitMessage = message.split(",");

            if (splitMessage[0].equals("Quadratic")) {

                String response = quadraticEquationSolver.solve(Double.valueOf(splitMessage[1]), Double.valueOf(splitMessage[2]), Double.valueOf(splitMessage[3]));

                printWriter.write(response);
                System.out.println(quadraticEquationSolver.solve(Double.valueOf(splitMessage[1]), Double.valueOf(splitMessage[2]), Double.valueOf(splitMessage[3])));
            } else if (splitMessage[0].equals("Linear")) {
                System.out.println(Arrays.toString(linearEquationSolver.solve(Double.valueOf(splitMessage[1]), Double.valueOf(splitMessage[2]))));
            } else if (splitMessage[0].equals("Random")) {

            }

            inputStreamReader.close();
            socket.close();
        }
    }
}
