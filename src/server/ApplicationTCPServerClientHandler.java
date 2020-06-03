package server;

import java.io.IOException;
import java.net.Socket;

import TCP.TCPHandler;

public class ApplicationTCPServerClientHandler extends TCPHandler {

	public ApplicationTCPServerClientHandler(Socket socket) throws IOException {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void trait(String message) {
		System.out.println("message");
	}

}
