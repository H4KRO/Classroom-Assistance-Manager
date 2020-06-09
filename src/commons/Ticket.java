package commons;

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
		this.state = 0; 
		
		
	}
	public String toString() {
		String string = "\n========================================\n";
		string += "Ticket : \n";
		string += " Reason : " + this.reason + "\n";
		string += " Description : " + this.description + "\n";
		string += " Severity : " + this.severity + "\n";
		string += " Session : " + this.session + "\n";
		string += " State : " + this.state + "\n";
		string += "========================================\n";
		return string;
	}
	
	public static Ticket toTicket(String message) {
		Gson gson = new Gson();
		return gson.fromJson(message, Ticket.class);
	}
}
