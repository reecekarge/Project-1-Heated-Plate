package Tpdohp;





public class LatticePoint //extends Point
{
	private int x;
	private int y;
	private double temp = 0; 
	public LatticePoint leftPoint = null;
	public LatticePoint rightPoint = null;
	public LatticePoint topPoint = null;
	public LatticePoint bottomPoint = null;
	
	public LatticePoint()
	{
		//Zero arg
	}
	public LatticePoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public LatticePoint(int x, int y, double temp)
	{
		this.x = x;
		this.y = y;
		this.temp = temp;
		
	}
	
	
	public void setTemp()
	{
		
		temp=(leftPoint.temp+rightPoint.temp+topPoint.temp+bottomPoint.temp)/4;
		
							 
	}
	public double getTemp()
	{
		
		return temp;
		
	}
	public void setTemp(double t)
	{
		temp = t;
	}
	
	public void setLeftPoint(LatticePoint l)
	{
		
		leftPoint = l;
	}
	public void setRightPoint(LatticePoint r)
	{
		
		rightPoint = r;
	}
	public void setTopPoint(LatticePoint t)
	{
		
		topPoint = t;
	}
	public void setBottomPoint(LatticePoint b)
	{
		
		bottomPoint = b;
	}
	public LatticePoint getLeftPoint()
	{
		return leftPoint;
		
	}
	public LatticePoint getRightPoint()
	{
		return rightPoint;
		
	}
	public LatticePoint getTopPoint()
	{
		return topPoint;
		
	}
	public LatticePoint getBottomPoint()
	{
		return bottomPoint;
		
	}
	@Override
	public String toString()
	{
		return "("+this.getX()+","+this.getY()+")";
		
	}
	public int getX() 
    { 
    	return x; 
    }
	public int getY() 
    { 
    	return y; 
    }
	

	
}
