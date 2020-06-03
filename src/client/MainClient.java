package client;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import TCP.TCPHandler;

public class MainClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		ApplicationTCPClient client = new ApplicationTCPClient(new Socket("127.0.0.1", 3001));
		client.send("Je suis connecté !");
		client.stop();
	}

}
