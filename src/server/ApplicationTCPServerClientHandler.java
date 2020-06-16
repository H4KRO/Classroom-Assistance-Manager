package server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import TCP.TCPHandler;
import TCP.TCPJsonMessage;
import commons.Classroom;
import commons.Classrooms;
import commons.ClientState;
import commons.Session;

public class ApplicationTCPServerClientHandler extends TCPHandler {
	
	protected ClientState state;
	protected Classrooms classrooms;
	protected ArrayList<Session> sessions;

	public ApplicationTCPServerClientHandler(Socket socket, Classrooms classrooms, ArrayList<Session> sessions) throws IOException {
		super(socket);
		this.state = ClientState.CONNECTED;
		
		this.sessions = sessions;
		this.classrooms = classrooms;
		
		this.send(classrooms.getData());
	}

	@Override
	public void trait(String message) {
		TCPJsonMessage jsonMessage = TCPJsonMessage.toTCPJsonMessage(message);
		System.out.println("Message type : " + jsonMessage.getType());
		if(this.state == ClientState.CONNECTED && jsonMessage.getType().equals("session")) {
			System.out.println("Session received.");
			this.sessions.add(Session.toSession(message));
			this.state = ClientState.REGISTRED;
			this.send(new TCPJsonMessage("ok").getData());
		}
	}

}
