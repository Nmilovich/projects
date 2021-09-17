package threadmaker;

import socketMaker.SocketMaker;

import java.io.*;
import java.net.Socket;

public class ThreadMaker implements Runnable{

    private final  Socket socket;

    public ThreadMaker (Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true)){

            while (true){
                String massage = reader.readLine();
                if (massage.equals("Bue.") || massage.equals("Bye.")){
                    socket.close();
                    break;
                } else {
                    writer.println(massage);
                }
            }

        } catch (IOException e){}


    }
}
