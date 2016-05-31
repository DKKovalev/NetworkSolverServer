package com.dkkovalev;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerHandler serverHandler = new ServerHandler();
        serverHandler.handleMessage(8080);
    }
}
