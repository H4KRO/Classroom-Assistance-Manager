package commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.Gson;

import TCP.TCPJsonMessage;

public class CloseTicket extends TCPJsonMessage {
	public Ticket ticket;
	public CloseTicket(Ticket ticket) {
		super("closeticket");
		this.ticket = ticket;
	}
	
	public static CloseTicket prompt(ArrayList<Ticket> tickets) {
		int i = 0;
		Iterator<Ticket> it = tickets.iterator();
		while(it.hasNext()) {
			System.out.println(i + " : " + it.next().reason);
			i++;
		}
		System.out.println("========================================");
		System.out.println("CLOSE TICKET FORM");
		System.out.println("ID : ");
		Scanner s = new Scanner(System.in);
		int selected = s.nextInt();
		System.out.println("========================================");
		CloseTicket ct = new CloseTicket(tickets.get(selected));
		return ct;
	}
	
	public static CloseTicket toCloseTicket(String message) {
		Gson gson = new Gson();
		return gson.fromJson(message, CloseTicket.class);
	}
}
