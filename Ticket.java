//COSC1047 Assignment 5 Ticket class - Adam Byrne

public class Ticket {
	
	//Variables
	private int[] winningTicket;
	
	//Constructors
	public Ticket(){
	}
	
	public Ticket(int[] ticketNum) {
		this.winningTicket = ticketNum;
	}
	
	//get
	public int[] getTicket() {
		return winningTicket;
	}
	
	//set
	public void setTicket(int[] ticketNum) {
		this.winningTicket = ticketNum;
	}
	
}//Class
