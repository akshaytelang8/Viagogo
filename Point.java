/**
 * This class implements a simple 2-D Cartesian Point
 * @author Sachith Kothur
 *
 */
class Point
{
	private int x,y;
	
	/**
	 * Creates a Point object given the (x,y) coordinates
	 * @param x x co-ordinate
	 * @param y y co-ordinate
	 */
	Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Computes the Manhattan distance between 2 points : |x1 - x2| + |y1 - y2|
	 * @param p1 Point p1 (x1,y1)
	 * @param p2 Point p2 (x2,y2)
	 * @return Manhattan distance as Integer
	 */
	static int manDist(Point p1, Point p2)
	{
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
	/**
	 * Overrides toString()  method to print (x,y)
	 */
	@Override
	public String toString()
	{
		return "("+this.x+" , "+this.y+")";
	}
	
	/**
	 * Implements equality when x1 == x2 and y1 == y2
	 */
	 @Override
	 public boolean equals(Object other) 
    {
        if (this == other)
          return true;

        if (!(other instanceof Point))
          return false;

        Point otherPoint = (Point) other;
        return otherPoint.x == x && otherPoint.y == y;
    }
	
	/**
	 * Implements Hashcode as we would use this class as a key in Map
	 */
	@Override
	public int hashCode() {
	    int hash = 7;
	    hash = 71 * hash + this.x;
	    hash = 71 * hash + this.y;
	    return hash;
	}
}