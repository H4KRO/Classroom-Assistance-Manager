package commons;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;

import TCP.TCPJsonMessage;

public class Classrooms extends TCPJsonMessage {
	private ArrayList<Classroom> ClassroomsArray;
	
	public Classrooms() {
		super("classrooms");
		this.ClassroomsArray = new ArrayList<Classroom>();
	}
	
	public Classrooms(ArrayList<Classroom> ClassroomsArray) {
		super("classrooms");
		this.ClassroomsArray = ClassroomsArray;
	}
	
	public ArrayList<Classroom> getArray() {
		return this.ClassroomsArray;
	}
	
	public String toString() {
		String string = "";
		Iterator<Classroom> i = this.ClassroomsArray.iterator();
		while(i.hasNext()) {
			string += i.next().toString();
		}
		return string;
	}
	
	public static Classrooms toClassrooms(String message) {
		Gson g = new Gson();
		return g.fromJson(message, Classrooms.class);
	}
}
