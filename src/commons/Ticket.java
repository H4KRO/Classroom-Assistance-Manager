package commons;

import java.util.Scanner;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import TCP.TCPJsonMessage;

public class Ticket extends TCPJsonMessage {
	public String reason;
	public String description;
	public int severity;
	public int state;
	public Session session;
	
	public Ticket(String reason, String description, int severity, Session session){
		super("ticket");
		this.reason = reason;
		this.description = description;
		this.severity = severity;
		this.session = session;
		this.state = 1; 
	}
	public String toString() {
		String string = "\n========================================\n";
		string += "Ticket : \n";
		string += " Reason : " + this.reason + "\n";
		string += " Description : " + this.description + "\n";
		string += " Severity : " + this.severity + "\n";
		if(this.state == 1) {
			string += " State : Open \n";
		}else {
			string += " State : Close \n";
		}
		string += this.session;
		string += "========================================";
		return string;
	}
	
	public static Ticket toTicket(String message) {
		Gson gson = new Gson();
		return gson.fromJson(message, Ticket.class);
	}
	
	public static Ticket prompt(Session session) {
		Scanner s = new Scanner(System.in);
		System.out.println("========================================");
		System.out.println("TICKET FORM");
		System.out.println("Reason : ");
		String reason = s.nextLine();
		System.out.println("Description : ");
		String description = s.nextLine();
		System.out.println("Severity : ");
		int severity = s.nextInt();
		System.out.println("========================================");		
		return new Ticket(reason, description, severity, session);
	}
}
