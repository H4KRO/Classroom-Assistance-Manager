package client;
import commons.*;

public class MainClient {

	public static void main(String[] args) {
		Classroom classroom = new Classroom("A-1");
		classroom.computers.add(new Integer(1));
		classroom.computers.add(new Integer(2));
		System.out.println(classroom);
	}

}
