package commons;

import org.json.simple.JSONObject;

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
		return " Le motif est : "+this.reason + "\n La description est:  " +this.description +"\n La criticité est : "+this.severity+"\n L'état du ticket est :  " + state;
	}
	@Override
	public void setData() {
		JSONObject data = new JSONObject();
		data.put("reason", this.reason);
		data.put("description", this.description);
		data.put("severity", new Integer(this.severity));
		data.put("session", this.session.getData());
		this.data = data;
	}
	
	public static Ticket toTicket(JSONObject message) {
		// Convertir message en Ticket et le retourne
		return null;
	}
}
