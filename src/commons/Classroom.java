package commons;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import TCP.TCPJsonMessage;

public class Classroom extends TCPJsonMessage {
	public String name;
	public ArrayList<Integer> computers;
	
	public Classroom(String name, ArrayList<Integer> computers){
		super("classroom");
		this.name = name;
		this.computers = computers;
	}
	
	public String toString() {
		return this.name + " " + this.computers.toString();
	}

	@Override
	public void setData() {
		JSONObject data = new JSONObject();
		data.put("name", this.name);
		JSONArray computers = new JSONArray();
		Iterator<Integer> computer = this.computers.iterator();
		while(computer.hasNext()) {
			computers.add(computer.next());
		}
		data.put("computers", computers);
		this.data = data;
	}
	
	public static Classroom toClassroom(JSONObject message) {
		// Converti message en Classroom et le retourne
		return null;
	}
}
