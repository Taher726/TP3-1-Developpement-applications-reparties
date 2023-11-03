package Client;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import server.Operation;

public class Client {

	public static void main(String[] args) throws IOException, IOException, ClassNotFoundException {
		Socket clientSocket = new Socket("localhost", 1234);
		
		System.out.println("Je suis connecté");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner le premier nombre ");
		String x = sc.next();
	
		System.out.println("Donner l'operateur ");
		String x2 = sc.next();
		
		System.out.println("Donner le deuxieme nombre ");
		String x3 = sc.next();
		
		Operation op = new Operation(x,x3,x2);
		
		ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
		oos.writeObject(op);
		
		
		InputStream is = clientSocket.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		Operation op2 = (Operation)ois.readObject();
		System.out.println("The result is : "+op2.getRes());
		
		clientSocket.close();

	}
	
}
