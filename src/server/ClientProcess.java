package server;
import java.io.IOException;
import java.net.Socket;

public class ClientProcess extends Thread {
	Socket socket;
	int clientNumber;
	String ip;
	public ClientProcess(Socket socket, int clientNumber, String ip) {
		this.socket = socket;
		this.clientNumber = clientNumber;
		this.ip= ip;
	}
	
	@Override
	public void run() {
		System.out.println("Un client de numéro "+this.clientNumber+" et ip("+this.ip+") est connecté");
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
