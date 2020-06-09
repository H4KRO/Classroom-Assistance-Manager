package tests;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import TCP.TCPJsonMessage;
import commons.Classroom;
import commons.Session;
import commons.Ticket;

public class Test {

	public static void main(String[] args) throws ParseException {
	      Session s = new Session("Eddie", "Vallier", "class", 1);
	      String m1 = s.getData();
	      
	      ArrayList<Integer> computers = new ArrayList<Integer>();
	      computers.add(1);
	      computers.add(2);
	      
	      Classroom c = new Classroom("1", computers);
	      String m2 = c.getData();
	      
	      Ticket t = new Ticket("TEST", "DESC", 0, s);
	      String m3 = t.getData();
	      
	      System.out.println(Session.toSession(m1));
	      
	      System.out.println(Classroom.toClassroom(m2));
	      
	      System.out.println(Ticket.toTicket(m3));
	      
	      }

}
