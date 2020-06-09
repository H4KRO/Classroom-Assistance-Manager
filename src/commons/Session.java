package commons;

public class Session {
	public String name;
	public String surname;
	public String classroomId;
	public int computerId;
	
	
	public Session(String name, String surname, String classroomId, int computerId){
		this.name = name;
		this.surname = surname;
		this.classroomId = classroomId;
		this.computerId = computerId;
		
	}
	
	public String toString() {
		return this.name + " " +this.surname +" "+this.classroomId+" "+this.computerId;
	}
}
