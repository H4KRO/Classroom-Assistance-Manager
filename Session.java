package client;

import java.util.ArrayList;

public class Session {
	public String students;
	public String name;
	public String surname;
	public ArrayList<Integer> computernb;
	public int id;
	
	
	public Session(String Identity){
		students = surname  + name;
		System.out.println("L'utilisateur est"+students);
	}
	public void ComputerId (int id){
		
		this.id = id;
		this.computernb = new ArrayList<Integer>();
	}
	
	public String toString() {
		return this.name + " " + this.students.toString();
	}
}
