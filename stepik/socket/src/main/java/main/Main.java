package main;

import socketMaker.SocketMaker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        SocketMaker socketMaker = new SocketMaker(5050);

        System.out.println("Server started");
        socketMaker.start();






    }
}
