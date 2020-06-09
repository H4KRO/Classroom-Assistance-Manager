package commons;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

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
		String string = "\n========================================\n";
		string += "Session :\n";
		string += " Name : " + this.name + "\n";
		string += " Surname : " + this.surname + "\n";
		string += " Classroom : " + this.classroomId + "\n";
		string += " ComputerId : " + this.computerId + "\n";
		string += "========================================\n";
		return string;
	}
	
	public static Session toSession(String message) {
		Gson gson = new Gson();
		return gson.fromJson(message, Session.class);
	}
}
