package Tpdohp;

import java.awt.Point;

@SuppressWarnings("serial")
public class MikesLatticePoint extends Point
{
	private int x;
	private int y;
	private Grid grid = null;
	public double temp = 1; 
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
		super(x,y);
	}
	public MikesLatticePoint(int x, int y, double temp)
	{
		super(x,y);
		this.temp = temp;
		
	}
	public MikesLatticePoint(int x, int y, Grid grid)
	{
		super(x,y);
		this.grid = grid;
		
		MikesLatticePoint p = new MikesLatticePoint(x,y);
		leftPoint = p;

				
	}
	
	
	public double getTemp()
	{
		return (leftPoint.getTemp()+rightPoint.getTemp()+topPoint.getTemp()+bottomPoint.getTemp())/4;
							 
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
	
	/*
	public double getTopTemp()
	{
		return grid.getPointTemp(this.x,this.y+1).getTemp();
	}
	public double getLeftTemp()
	{
		return grid.getPointTemp(this.x-1,this.y).getTemp();
	}
	public double getRightTemp()
	{
		return grid.getPointTemp(this.x+1,this.y).getTemp();
	}
	public double getBottomTemp()
	{
		return grid.getPointTemp(this.x,this.y-1).getTemp();
	}
	*/
	
}
