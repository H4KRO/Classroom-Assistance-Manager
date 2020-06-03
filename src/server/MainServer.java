package server;

import java.io.IOException;

import TCP.TCPServer;

public class MainServer {

	public static void main(String[] args) throws IOException {
		ApplicationTCPServer server = new ApplicationTCPServer(3001);
	}
}
