package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	protected ServerSocket serverSocket;
	private boolean isRunning;
	public TCPServer(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
		this.isRunning = true;
		while(isRunning) {
			Socket clientSocket = this.serverSocket.accept();
			System.out.println("New client !");
			Thread clientThread = new Thread(new TCPHandler(clientSocket));
			clientThread.start();
		}
		
	}
	public void stop() {
		this.isRunning = false;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
