package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class TCPHandler implements Runnable {
	private Socket socket;
	private BufferedReader bufferedReader; 
	private PrintWriter printWriter;
	public TCPHandler(Socket socket) throws IOException {
		this.socket = socket;
		this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		this.printWriter = new PrintWriter(this.socket.getOutputStream());
	}
	@Override
	public void run() {
		while(socket.isConnected()) {
			try {
				String message = this.bufferedReader.readLine();
				if(message != null) {
					System.out.println(message);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void send(String message) {
		this.printWriter.println(message);
		this.printWriter.flush();
	}
	
	public void stop() throws IOException {
		this.socket.close();
	}
	
	public abstract void trait(String message);
}
