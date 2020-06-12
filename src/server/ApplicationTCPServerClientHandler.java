package server;

import java.io.IOException;
import java.net.Socket;

import TCP.TCPHandler;
import TCP.TCPJsonMessage;
import commons.Classroom;
import commons.Classrooms;
import commons.ClientState;
import commons.Session;
import commons.Ticket;
import sun.net.ProgressSource.State;

public class ApplicationTCPServerClientHandler extends TCPHandler {
	
	protected ClientState state;

	public ApplicationTCPServerClientHandler(Socket socket) throws IOException {
		super(socket);
		this.state = ClientState.CONNECTED;
		this.send(/* Classrooms */);
	}

	@Override
	public void trait(String message) {
		TCPJsonMessage jsonMessage = TCPJsonMessage.toTCPJsonMessage(message);
		
	}

}
