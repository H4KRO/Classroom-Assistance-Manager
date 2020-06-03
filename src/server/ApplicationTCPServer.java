package server;

import java.io.IOException;
import java.net.Socket;

import TCP.TCPHandler;
import TCP.TCPServer;

public class ApplicationTCPServer extends TCPServer {

	public ApplicationTCPServer(int port) throws IOException {
		super(port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TCPHandler connection(Socket clientSocket) {
		try {
			return new ApplicationTCPServerClientHandler(clientSocket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
