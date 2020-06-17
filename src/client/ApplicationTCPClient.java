package client;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import TCP.TCPHandler;
import TCP.TCPJsonMessage;
import commons.Classrooms;
import commons.ClientState;
import commons.CloseTicket;
import commons.Session;
import commons.Ticket;

public class ApplicationTCPClient extends TCPHandler {
	
	protected ClientState state;
	protected Classrooms classrooms;
	protected Session session;
	protected ArrayList<Ticket> tickets;

	public ApplicationTCPClient(Socket socket) throws IOException {
		super(socket);
		this.state = ClientState.NOTCONNECTED;
		this.tickets = new ArrayList<Ticket>();
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
		if(this.state == ClientState.NOTCONNECTED && jsonMessage.getType().equals("classrooms")) {
			System.out.println("Classrooms received, i'm connected.");
			this.classrooms = Classrooms.toClassrooms(message);
			this.state = ClientState.CONNECTED;
			this.session = Session.prompt(this.classrooms);
			this.send(this.session.getData());
		}else if(this.state == ClientState.CONNECTED || this.state == ClientState.REGISTRED && jsonMessage.getType().equals("ok")) {
			if(this.state == ClientState.CONNECTED) {
				System.out.println("I'm logged.");
				this.state = ClientState.REGISTRED;
			}
			System.out.println("Would you like to create a ticket or close a ticket ? (create/close)");
			Scanner s = new Scanner(System.in);
			String rep = s.nextLine();
			if(rep.equals("close") && this.tickets.size() > 0) {
				CloseTicket ct = CloseTicket.prompt(this.tickets);
				this.send(ct.getData());
			}else{
				Ticket t = Ticket.prompt(this.session);
				this.tickets.add(t);
				this.send(t.getData());
			}			
		}
	}

}
