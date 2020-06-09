package client;

import java.util.Date;

public class Session {
	public String name;
	public String surname;
	public String classroomId;
	public int computerId;
	public Date date;
	
	
	public Session(String name, String surname, String classroomId, int computerId){
		this.name = name;
		this.surname = surname;
		this.classroomId = classroomId;
		this.computerId = computerId;
		
	}
	
	public Session(Date date){
	    Date date = new Date();
	    System.out.println(Date.
	    		(date));//2016/11/16 12:08:43
		
	}
	public String toString() {
		return this.name + " " +this.surname +" "+this.classroomId+" "+this.computerId;
	}
}
