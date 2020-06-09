package commons;

import java.util.ArrayList;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

import TCP.TCPJsonMessage;

public class Classroom extends TCPJsonMessage {
	public String name;
	public ArrayList<Integer> computers;
	public Classroom() {
		super("classroom");
		this.name = "";
		this.computers = new ArrayList<Integer>();
	}
	public Classroom(String name, ArrayList<Integer> computers){
		super("classroom");
		this.name = name;
		this.computers = computers;
	}
	
	public String toString() {
		String string = "\n========================================\n";
		string += "Classroom :\n";
		string += " Name : " + this.name + "\n";
		string += " Computers : " + this.computers + "\n";
		string += "========================================\n";
		return string;
	}
	
	public static Classroom toClassroom(String message) {
		Gson g = new Gson();
		return g.fromJson(message, Classroom.class);
	}
}
