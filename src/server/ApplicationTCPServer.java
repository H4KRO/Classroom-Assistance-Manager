package server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import TCP.TCPHandler;
import TCP.TCPServer;
import commons.Classrooms;
import commons.Session;

public class ApplicationTCPServer extends TCPServer {
	
	private Classrooms classrooms;
	private ArrayList<Session> sessions;
	
	public ApplicationTCPServer(int port) throws IOException {
		super(port);
		this.classrooms = Classrooms.prompt();
		this.sessions = new ArrayList<Session>();
		System.out.println("Server listenning on port " + port + ".");
	}

	@Override
	public TCPHandler connection(Socket clientSocket) {
		System.out.println("New client.");
		try {
			return new ApplicationTCPServerClientHandler(clientSocket, this.classrooms, this.sessions);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
