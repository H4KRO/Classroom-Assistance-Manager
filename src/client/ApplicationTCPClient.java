package client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import TCP.TCPHandler;
import TCP.TCPJsonMessage;
import commons.Classrooms;
import commons.ClientState;
import commons.Session;

public class ApplicationTCPClient extends TCPHandler {
	
	protected ClientState state;
	protected Classrooms classrooms;

	public ApplicationTCPClient(Socket socket) throws IOException {
		super(socket);
		this.state = ClientState.CONNECTED;
		
	}
	
	public ClientState getState() {
		return this.state;
	}
	
	public Classrooms getClassrooms() {
		return this.classrooms;
	}
	
	@Override
	public void trait(String message) {
		TCPJsonMessage jsonMessage = TCPJsonMessage.toTCPJsonMessage(message);
		System.out.println("Message type : " + jsonMessage.getType());
		if(this.state == ClientState.CONNECTED && jsonMessage.getType().equals("classrooms")) { // Get Session
			System.out.println("Classrooms received, i'm connected.");
			this.classrooms = Classrooms.toClassrooms(message);
			Session s = Session.prompt(this.classrooms);
			this.send(s.getData());
		}else if(this.state == ClientState.CONNECTED && jsonMessage.getType().equals("ok")) {
			System.out.println("I'm logged.");
			this.state = ClientState.REGISTRED;
		}
	}

}
