package server;

import java.io.IOException;

public class MainServer {

	public static void main(String[] args) throws IOException {
		ApplicationTCPServer server = new ApplicationTCPServer(3001);
	}
}
