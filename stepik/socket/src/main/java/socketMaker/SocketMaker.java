package socketMaker;

import threadmaker.ThreadMaker;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketMaker {

    private final ServerSocket serverSocket;

    public SocketMaker(int PORT) throws IOException {
        serverSocket = new ServerSocket(PORT);
        serverSocket.setSoTimeout(30000);
    }
    
    public void start() throws IOException {
        while(true){
            Socket socket = serverSocket.accept();
            Thread thread =  new Thread(new ThreadMaker(socket));
            thread.start();
        }
    }
}
