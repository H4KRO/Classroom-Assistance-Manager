package client;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import commons.Classroom;
import commons.Classrooms;
import commons.Session;
import commons.Ticket;

public class MainClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
	    ApplicationTCPClient client = new ApplicationTCPClient(new Socket("localhost", 3001));
	    
	}

}
