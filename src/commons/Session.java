package commons;

import java.util.Iterator;
import java.util.Scanner;

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
		String string = " Session :\n";
		string += "  Name : " + this.name + "\n";
		string += "  Surname : " + this.surname + "\n";
		string += "  Classroom : " + this.classroomId + "\n";
		string += "  ComputerId : " + this.computerId + "\n";
		return string;
	}
	
	public static Session toSession(String message) {
		Gson gson = new Gson();
		return gson.fromJson(message, Session.class);
	}
	
	public static Session prompt(Classrooms classrooms) {
		Scanner s = new Scanner(System.in);
		System.out.println("========================================");
		System.out.println("NEW SESSION FORM");
		System.out.println("Name :");
		String name = s.nextLine();
		System.out.println("Surname :");
		String surname = s.nextLine();
		
		System.out.println("Please, select one of the list : ");
		String classroomsString = "    ";
		Iterator<Classroom> i = classrooms.getArray().iterator();
		while(i.hasNext()) {
			Classroom classroom = i.next();
			classroomsString += " " + classroom.name + " " + classroom.computers.toString();
			if(i.hasNext()) {
				classroomsString += ",";
			}
		}
		System.out.println(classroomsString);
		
		System.out.println("Classroom id : ");
		String classroomId = s.nextLine();
		System.out.println("Computer id : ");
		int computerId = s.nextInt();
		System.out.println("========================================");
		return new Session(name, surname, classroomId, computerId);
		
	}
}
