package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class TCPServer {
	protected ServerSocket serverSocket;
	private boolean isRunning;
	public TCPServer(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);

		
	}
	public void start() throws IOException {
		this.isRunning = true;
		while(isRunning) {
			Socket clientSocket = this.serverSocket.accept();
			Thread clientThread = new Thread(connection(clientSocket));
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
	
	public abstract TCPHandler connection(Socket cliendSocket);
}
