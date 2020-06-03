package commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class TCPHandler implements Runnable {

	private Socket socket;
	private PrintStream printer;
	private BufferedReader reader;
	
	public TCPHandler(Socket socket) throws IOException {
		
	}
}
