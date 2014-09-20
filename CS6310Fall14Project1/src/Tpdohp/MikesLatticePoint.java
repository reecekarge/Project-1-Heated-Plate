package Tpdohp;




public class MikesLatticePoint //extends Point
{
	private int x;
	private int y;

	public double temp = 0; 
	public MikesLatticePoint leftPoint = null;
	public MikesLatticePoint rightPoint = null;
	public MikesLatticePoint topPoint = null;
	public MikesLatticePoint bottomPoint = null;
	
	public MikesLatticePoint()
	{
		//Zero arg
	}
	public MikesLatticePoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public MikesLatticePoint(int x, int y, double temp)
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
	
	public void setLeftPoint(MikesLatticePoint l)
	{
		
		leftPoint = l;
	}
	public void setRightPoint(MikesLatticePoint r)
	{
		
		rightPoint = r;
	}
	public void setTopPoint(MikesLatticePoint t)
	{
		
		topPoint = t;
	}
	public void setBottomPoint(MikesLatticePoint b)
	{
		
		bottomPoint = b;
	}
	public MikesLatticePoint getLeftPoint()
	{
		return leftPoint;
		
	}
	public MikesLatticePoint getRightPoint()
	{
		return rightPoint;
		
	}
	public MikesLatticePoint getTopPoint()
	{
		return topPoint;
		
	}
	public MikesLatticePoint getBottomPoint()
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
