package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

	public void run() {
		try {
			int clientNumber = 1;
			ServerSocket server = new ServerSocket(1234);
			System.out.println("Le serveur attend un client");
			while(true) {
				Socket socket = server.accept();
				String ip = socket.getRemoteSocketAddress().toString();
				ClientProcess client = new ClientProcess(socket, clientNumber, ip);
				client.start();
				clientNumber++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server().start();
	}

}
