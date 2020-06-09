package client;

import java.util.Date;

public class Ticket {
	public String motif;
	public String description;
	public Date date;
	public int criticity;
	public boolean state;
	
	public Ticket(String motif, String description, int criticity, boolean state){
		this.motif = motif;
		this.description = description;
		this.criticity = criticity;
		this.state = state; 
		
		
	}
	public String toString() {
		return " Le motif est : "+this.motif + "\n La description est:  " +this.description +"\n La criticité est : "+this.criticity+"\n L'état du ticket est :  "+state;
	}
}
