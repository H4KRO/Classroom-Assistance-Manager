package client;

import java.io.IOException;
import java.net.Socket;

import TCP.TCPHandler;
import TCP.TCPJsonMessage;
import commons.Classrooms;
import commons.ClientState;

public class ApplicationTCPClient extends TCPHandler {
	
	protected ClientState state;
	protected Classrooms classrooms;

	public ApplicationTCPClient(Socket socket) throws IOException {
		super(socket);
		this.state = ClientState.NOTCONNECTED;
	}
	
	public ClientState getState() {
		return this.state;
	}
	
	public Classrooms getClassrooms() {
		return this.classrooms;
	}

	@Override
	public void trait(String message) {
		TCPJsonMessage jsonMessage = TCPJsonMessage.toTCPJsonMessage(message);
		if(this.state == ClientState.NOTCONNECTED && jsonMessage.getType() == "classrooms") {
			this.state = ClientState.CONNECTED;
			this.classrooms = Classrooms.toClassrooms(message);
			System.out.println(this.classrooms);
			try {
				this.stop();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
