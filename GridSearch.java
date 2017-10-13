import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Comparator;

/**
 * Driver Class
 * @author Sachith Kothur
 *
 */
public class GridSearch {
	
	/**
	 * This function randomly generates a number of events in the grid.
	 * The event coordinates are also generated randomly
	 * The number of events can be zero. 
	 * @return A HashMap<Point, Event>. Can be empty
	 */
	public static Map<Point, Event> generateEvents()
	{
		Map<Point, Event> grid = new HashMap<Point, Event>();
		int numEvents = (int)Math.floor(Math.random()*101);
		
		for(int i = 0; i < numEvents;i++)
		{
			Point p = null;
			int xCords = 0, yCords =0;
			
			do{
			xCords = (int) ((Math.random() * 20) - 10);
			yCords = (int) ((Math.random() * 20) - 10);
			p = new Point(xCords, yCords);
			}
			while(grid.containsKey(p));
			grid.put(p, new Event(xCords, yCords));
		}
		
		return grid;
	}
	
	/**
	 * Reads user input and sanitizes it.
	 * Expects  a comma seperated  x,y coordinates. 
	 * Must lie between -10 and 10. 
	 * Any kind of bad input calls this method again. 
	 * @return the x and y coordinate
	 */
	public static int[] readInp()
	{
		int[] inp_cords = {-100,-100};
		String ERROR_MSG = "\nInvalid Co-ordinates given. Please give them as \"x_cord, y_cord\".\nLimits between -10 and 10\n";
		System.out.println("Please input co-ordinates (Ex : 4,2)\nLimits between -10 and 10");
		Scanner in = new Scanner(System.in);
		in.useDelimiter("\n");
		String inp = in.next().trim();
		if (inp != null && inp.contains(","))
		{
			String[] s = inp.split(",");
			if (s.length != 2)
			{
				System.err.println(ERROR_MSG); return inp_cords;
			}
			int x,y;
			try
			{
			x = Integer.parseInt(s[0]);
			y = Integer.parseInt(s[1]);
			}
			catch (NumberFormatException e)
			{
				System.err.println(ERROR_MSG);
				return inp_cords;
			}
			
			if(x > 10 || x < -10 || y >10 || y < -10)
			{
				System.err.println(ERROR_MSG);
				return inp_cords;
			}
			inp_cords[0] = x; inp_cords[1] = y;
			return inp_cords;
		}
		else
			System.err.println(ERROR_MSG); return inp_cords;
	}
	
	/**
	 * Sorts an HashMap in ascending order based on its values
	 * @param map Unsorted Map
	 * @return Sorted Map
	 */
	public static Map<Point, Integer> sortHashMapByVal(Map<Point, Integer> map)
	{
		
		
		List<Map.Entry<Point, Integer>> ls = new LinkedList<Map.Entry<Point, Integer>>(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(ls, new Comparator<Map.Entry<Point, Integer>>() {
	            public int compare(Map.Entry<Point, Integer> o1, Map.Entry<Point, Integer> o2) {
	               return (o1.getValue()).compareTo(o2.getValue());
	            }
	       });

	       Map<Point, Integer> sortedHashMap = new LinkedHashMap<Point, Integer>();
	       for (Map.Entry<Point, Integer> entry : ls) {
	            sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	}
	
	/**
	 * Main function
	 * @param args
	 */
	public static void main(String args[])
	{
		int[] inpCords = readInp();
		while(inpCords[0] == -100)
			inpCords = readInp();
		
		Point pInp = new Point(inpCords[0], inpCords[1]);
		System.out.println("\nClosest events to "+pInp+":\n");
		
		Map<Point, Event> grid = generateEvents();
		Map<Point, Integer> dist = new HashMap<Point, Integer>();
		
		for(Point p : grid.keySet())
			dist.put(p, Point.manDist(pInp, p));
		
		
		if (dist.size() == 0)
		{
			System.out.println("No Events Found");
		}
		else
		{
			dist = sortHashMapByVal(dist);
		}
		int eventCount = 5;
		for (Point tmpKey : dist.keySet())
		{
			if(eventCount-- > 0)
			{
			Event e = grid.get(tmpKey);
			String minVal = "No Tickets";
			if (e.minTicketVal != Integer.MAX_VALUE)
				minVal = Double.toString((int)(e.minTicketVal*100)/100.0);
			
			System.out.println("Event "+e.eID+" - $" + minVal + ", Distance " + dist.get(tmpKey) );
			}
		}
		System.out.println();
	}
}
