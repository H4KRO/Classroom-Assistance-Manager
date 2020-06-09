package client;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import commons.Classroom;
import commons.Session;
import commons.Ticket;

public class MainClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Session s = new Session("Eddie", "Vallier", "class", 1);
	    String m1 = s.getData();
	      
	    ArrayList<Integer> computers = new ArrayList<Integer>();
	    computers.add(1);
	    computers.add(2);
	      
	    Classroom c = new Classroom("1", computers);
	    String m2 = c.getData();
	     
	    Ticket t = new Ticket("TEST", "DESC", 0, s);
	    String m3 = t.getData();
	    
		ApplicationTCPClient client = new ApplicationTCPClient(new Socket("localhost", 3001));
		client.send(m1);
		client.send(m2);
		client.send(m3);
		client.stop();
	}

}
