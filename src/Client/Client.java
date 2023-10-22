package Client;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			InetAddress id = InetAddress.getByName("192.168.1.8");
			InetSocketAddress isd = new InetSocketAddress(id, 1234);
			Socket socket = new Socket();
			socket.connect(isd);
			System.out.println("Je suis connecté");
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
