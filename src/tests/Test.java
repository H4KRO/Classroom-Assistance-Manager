package tests;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import commons.Classroom;
import commons.Session;
import commons.Ticket;

public class Test {

	public static void main(String[] args) throws ParseException {
	      Session s = new Session("Eddie", "Vallier", "1", 1);
	      System.out.println(s.getData().toString());
	      
	      ArrayList<Integer> computers = new ArrayList<Integer>();
	      computers.add(1);
	      computers.add(2);
	      
	      Classroom c = new Classroom("1", computers);
	      System.out.println(c.getData().toString());
	      
	      Ticket t = new Ticket("TEST", "DESC", 0, s);
	      System.out.println(t.getData().toString());
	      
	      JSONParser parser = new JSONParser();
	      
	      //JSONObject sessionJson = (JSONObject) parser.parse(s.getData().toString());
	      //System.out.println(Session.toSession(sessionJson).toString());
	      
	      //JSONObject classroomJson = (JSONObject) parser.parse(c.getData().toString());
	      //System.out.println(Classroom.toClassroom(sessionJson).toString());
	      
	      //JSONObject ticketJson = (JSONObject) parser.parse(t.getData().toString());
	      //System.out.println(Ticket.toTicket(ticketJson).toString());
	}

}
