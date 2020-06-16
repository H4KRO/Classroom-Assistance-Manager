package server;

import java.io.IOException;

public class MainServer {

	public static void main(String[] args) throws IOException {
		ApplicationTCPServer s = new ApplicationTCPServer(3001);
		s.start();
	}
}
