import java.util.ArrayList;
import java.util.List;

/* Maximum number of events = 100. Minimum is 0
 * Maximum number of tickers per event = 10
 * Ticket prices range from 0.1$ to 1000$
 * 
*/

/**
 * This class models an event
 * @author Sachith Kothur
 *
 */
class Event
{
	/**
	 * Location of the event
	 */
	Point loc;
	
	/**
	 * Unique ID of the event
	 */
	int eID;
	
	/**
	 * Number of tickets available for the Event.
	 * Can be zero.
	 */
	int  numTickets;
	
	/**
	 * UID generator
	 */
	static int idCount = 0;
	
	/**
	 * List of Ticket Prices. Can be null
	 */
	List<Double> tickets;
	/**
	 * Keeps track of the minimum ticket for the event. If it is Integer.MAX_VALUE, then there are no tickets 
	 */
	double minTicketVal = Integer.MAX_VALUE;
	
	/**
	 * Creates an Event Object provided the coordinates of the point.
	 * The numTickets is randomly generated and so are the ticket prices 
	 * @param xCord
	 * @param yCord
	 */
	Event(int xCord, int yCord)
	{
		this.loc = new Point(xCord, yCord);
		this.eID = idCount++;
		this.numTickets = (int) Math.floor(Math.random() * 11);
		this.tickets = new ArrayList<Double>(this.numTickets);
		for(int i = 0; i < this.numTickets; i++)
		{
			double currTicket = 0.1 + Math.random() * 999.9;
			this.tickets.add(currTicket);
			if(currTicket < this.minTicketVal)
			{
				this.minTicketVal =currTicket;
			}
		}
	}
	
	/**
	 * Overrides the toString() method. For Debug purposes 
	 */
	public String toString()
	{
		return "Event # " + this.eID + ", Location " + this.loc + ", NumTickets "+this.numTickets;
	}
}