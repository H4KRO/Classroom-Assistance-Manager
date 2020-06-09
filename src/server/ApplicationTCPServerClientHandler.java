package server;

import java.io.IOException;
import java.net.Socket;

import TCP.TCPHandler;
import TCP.TCPJsonMessage;
import commons.Classroom;
import commons.Session;
import commons.Ticket;

public class ApplicationTCPServerClientHandler extends TCPHandler {

	public ApplicationTCPServerClientHandler(Socket socket) throws IOException {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void trait(String message) {
		TCPJsonMessage jsonMessage = TCPJsonMessage.toTCPJsonMessage(message);
		System.out.println("Type : " + jsonMessage.getType());
		switch(jsonMessage.getType()) {
		case "classroom":
			System.out.println(Classroom.toClassroom(message).toString());
			break;
		case "session":
			System.out.println(Session.toSession(message));
			break;
		case "ticket":
			System.out.println(Ticket.toTicket(message));
			break;
		}
	}

}
