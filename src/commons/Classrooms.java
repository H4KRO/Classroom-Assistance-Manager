package commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.Gson;

import TCP.TCPJsonMessage;

public class Classrooms extends TCPJsonMessage {
	private ArrayList<Classroom> classroomsArray;
	
	public Classrooms() {
		super("classrooms");
		this.classroomsArray = new ArrayList<Classroom>();
	}
	
	public Classrooms(ArrayList<Classroom> slassroomsArray) {
		super("classrooms");
		this.classroomsArray = slassroomsArray;
	}
	
	public ArrayList<Classroom> getArray() {
		return this.classroomsArray;
	}
	
	public String toString() {
		String string = "";
		Iterator<Classroom> i = this.classroomsArray.iterator();
		while(i.hasNext()) {
			string += i.next().toString();
		}
		return string;
	}
	
	public static Classrooms toClassrooms(String message) {
		Gson g = new Gson();
		return g.fromJson(message, Classrooms.class);
	}
	
	public static Classrooms prompt() {
		System.out.println("========================================");
		System.out.println("CLASSROOMS FORM");
		Scanner s = new Scanner(System.in);
		ArrayList<Classroom> classroomsArray = new ArrayList<Classroom>();
		boolean another = true;
		while(another) {
			classroomsArray.add(Classroom.prompt());
			System.out.println("Would you like to add another classroom ? (y/n) ");
			String e = s.nextLine();
			another = !e.equals("n");
		}
		//s.close();
		return new Classrooms(classroomsArray);
	}
}
