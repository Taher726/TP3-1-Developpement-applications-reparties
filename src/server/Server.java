package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{


	public static void main(String[] args) {
		new Server().start();
	}
	@Override	
	public void run() {
		
		try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Le serveur est en écoute sur le port 1234");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(new ClientProcess(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        	}
    	}
	}