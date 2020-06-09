package commons;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import TCP.TCPJsonMessage;

public class Session extends TCPJsonMessage {
	public String name;
	public String surname;
	public String classroomId;
	public int computerId;
	
	
	public Session(String name, String surname, String classroomId, int computerId){
		super("session");
		this.name = name;
		this.surname = surname;
		this.classroomId = classroomId;
		this.computerId = computerId;
		
	}
	
	public String toString() {
		return this.name + " " +this.surname +" "+this.classroomId+" "+this.computerId;
	}

	@Override
	public void setData() {
		this.data = new JSONObject();
		data.put("name", this.name);
		data.put("surname", this.surname);
		data.put("classroomId", this.classroomId);
		data.put("computerId", new Integer(this.computerId));
		this.data = data;
	}
	
	public static Session toSession(Object message) {
		return null;
	}
}
