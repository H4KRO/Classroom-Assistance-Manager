package server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import TCP.TCPHandler;
import TCP.TCPJsonMessage;
import commons.Classroom;
import commons.Classrooms;
import commons.ClientState;
import commons.CloseTicket;
import commons.Session;
import commons.Ticket;

public class ApplicationTCPServerClientHandler extends TCPHandler {
	
	protected ClientState state;
	protected Classrooms classrooms;
	protected ArrayList<Session> sessions;
	protected Session session;
	protected ArrayList<Ticket> tickets;

	public ApplicationTCPServerClientHandler(Socket socket, Classrooms classrooms, ArrayList<Session> sessions, ArrayList<Ticket> tickets) throws IOException {
		super(socket);
		this.state = ClientState.CONNECTED;
		
		this.sessions = sessions;
		this.classrooms = classrooms;
		this.tickets = tickets;
		
		this.send(classrooms.getData());
	}

	@Override
	public void trait(String message) {
		TCPJsonMessage jsonMessage = TCPJsonMessage.toTCPJsonMessage(message);
		System.out.println("Message type : " + jsonMessage.getType());
		if(this.state == ClientState.CONNECTED && jsonMessage.getType().equals("session")) {
			System.out.println("Session received.");
			Session s = Session.toSession(message);
			this.sessions.add(s);
			this.session = s;
			this.state = ClientState.REGISTRED;
			this.send(new TCPJsonMessage("ok").getData());
		}else if(this.state == ClientState.REGISTRED && jsonMessage.getType().equals("ticket")) {
			System.out.println("Ticket received.");
			Ticket t = Ticket.toTicket(message);
			this.tickets.add(t);
			Iterator<Ticket> i = this.tickets.iterator();
			while(i.hasNext()) {
				System.out.println(i.next().toString());
			}
			this.send(new TCPJsonMessage("ok").getData());
		}else if(this.state == ClientState.REGISTRED && jsonMessage.getType().equals("closeticket")) {
			System.out.println("Close Ticket received");
			CloseTicket ct = CloseTicket.toCloseTicket(message);
			Iterator<Ticket> i = this.tickets.iterator();
			while(i.hasNext()) {
				Ticket t = i.next();
				if(t.reason.equals(ct.ticket.reason)) {
					t.state = 0;
				}
			}
			i = this.tickets.iterator();
			while(i.hasNext()) {
				System.out.println(i.next().toString());
			}
			this.send(new TCPJsonMessage("ok").getData());
		}
	}

}
