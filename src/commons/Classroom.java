package commons;

import java.util.ArrayList;

public class Classroom {
	public String name;
	public ArrayList<Integer> computers;
	
	public Classroom(String name){
		this.name = name;
		this.computers = new ArrayList<Integer>();
	}
	
	public String toString() {
		return this.name + " " + this.computers.toString();
	}
}
