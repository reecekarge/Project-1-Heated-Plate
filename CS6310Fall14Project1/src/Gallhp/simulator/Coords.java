package Gallhp.simulator;

public class Coords
{
	
	private int x;
	private int y;

	public Coords(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	
	public int getX() 
    { 
    	return x; 
    }
	public int getY() 
    { 
    	return y; 
    }
	public String toString()
	{
		return x+" "+y;
		
	}
	@Override
	public int hashCode()
	{
	    return (x+" "+y).hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
	    return (x+" "+y).equals(o.toString());
	}
}
