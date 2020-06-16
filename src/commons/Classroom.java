package commons;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	public static Classroom prompt() {
		System.out.println("========================================");
		System.out.println("CLASSROOM FORM");
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter class name : ");
		String name = s.nextLine();
		System.out.println("Please enter number of computer : ");
		int numberOfComputers = s.nextInt();
		ArrayList<Integer> cList = new ArrayList<Integer>();
		for(int i = 0; i < numberOfComputers; i++) {
			cList.add(new Integer(i));
		}
		//s.close();
		System.out.println("========================================");
		return new Classroom(name, cList);
	}
}
