package client;

import java.io.IOException;
import java.net.Socket;

import TCP.TCPHandler;

public class ApplicationTCPClient extends TCPHandler {

	public ApplicationTCPClient(Socket socket) throws IOException {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void trait(String message) {
		System.out.println(message);
	}

}
