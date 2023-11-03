package server;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

class ClientProcess extends Thread {
    Socket clientSocket;

    public ClientProcess(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        try {    		
    		System.out.println("Je un client "+clientSocket.getRemoteSocketAddress());
    		
    		InputStream is = clientSocket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			Operation op = (Operation)ois.readObject();
			
			int p1 = Integer.parseInt(op.getP1());
			String p2 = op.getO();
			int p3 = Integer.parseInt(op.getP2());
			
			float nb=0;
			
			switch(p2) {
				case "+": nb = p1+p3;
						break;
				case "-": nb = p1-p3;
						break;
				case "*": nb = p1*p3;
						break;
				case "/": nb = p1/p3;
						break;
			}
			op.setRes(nb);
			OutputStream os = clientSocket.getOutputStream();
			ObjectOutputStream ooos = new ObjectOutputStream(os);
			ooos.writeObject(op);
			
        	clientSocket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
    }
}
