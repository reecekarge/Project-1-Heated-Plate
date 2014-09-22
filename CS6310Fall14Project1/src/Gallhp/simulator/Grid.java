package Gallhp.simulator;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;


public class Grid 
{
	
	int dimension = 0;
	int leftTemp = 0;
	int rightTemp = 0;
	int topTemp = 0;
	int bottomTemp = 0;
	
	Boolean done = false;
	LatticePoint holderP = new LatticePoint();
	HashMap<Coords, LatticePoint> map = new HashMap<Coords, LatticePoint>();
	Coords holderC = new Coords(0,0);
	Set<Coords> keys = map.keySet();
	DecimalFormat td = new DecimalFormat("##.00");
	//Grid self = this;
	public Grid(int dimension, int leftTemp, int rightTemp, int topTemp, int bottomTemp)
	{
		this.dimension = dimension; 
		this.leftTemp = leftTemp;
		this.rightTemp = rightTemp;
		this.topTemp = topTemp;
		this.bottomTemp = bottomTemp;
		
	}
	/*
	 * createGrid() method:
	 * Creates Grid and initializes the temperature around the border
	 */
	public void createGrid()
	{
		for (int y = 0; y < dimension + 2; y++)
		{
			for (int x = 0; x < dimension + 2; x++)
			{
				//Set Temp of Top
				if (y == 0)
				{
					LatticePoint p = new LatticePoint(x,y,topTemp);
					Coords c = new Coords(x,y);
					map.put(c, p);
					//System.out.print(" "+p.temp);
					
				}
				// Set Temp of Bottom
				else if (y == dimension + 1)
				{
					LatticePoint p = new LatticePoint(x,y,bottomTemp);
					Coords c = new Coords(x,y);
					map.put(c, p);
					//System.out.print(" "+p.temp);
					
				}
				// Set Temp of Left
				else if (x == 0)
				{
					LatticePoint p = new LatticePoint(x,y,leftTemp);
					Coords c = new Coords(x,y);
					map.put(c, p);
					//System.out.print(" "+p.temp);
				}
				// Set Temp of Right
				else if (x == dimension+1)
				{
					LatticePoint p = new LatticePoint(x,y,rightTemp);
					Coords c = new Coords(x,y);
					map.put(c, p);
					//System.out.print(" "+p.temp);
				}
				//set everything else within border
				else
				{
				LatticePoint p = new LatticePoint(x,y);
				
				Coords c = new Coords(x,y);
				
				map.put(c, p);
				//System.out.print(" "+p.temp);
				}
				
			}
			System.out.println();
		}

	}
	/*
	 * Point all the inner LatticePoints to their neighbors
	 */
	public void setPointNeighbors()
	{	
	        for(Coords p:keys)
	        {
	        	holderP = map.get(p);
	        	
	        	
	        	
	        	if (holderP.getX() == 0 || holderP.getY() == 0 || holderP.getX() == dimension+1 || holderP.getY() == dimension+1)
	        	{
	        		//do nothing, these are border Points
	        	}
	        	else
	        	{
	        		//populate neighbors
	        		Coords coordL = new Coords(p.getX()-1,p.getY());
		        	Coords coordR = new Coords(p.getX()+1,p.getY());
		        	Coords coordT = new Coords(p.getX(),p.getY()+1);
		        	Coords coordB = new Coords(p.getX(),p.getY()-1);
	        		holderP.setLeftPoint(map.get(coordL));
	        		holderP.setRightPoint(map.get(coordR));
	        		holderP.setTopPoint(map.get(coordT));
	        		holderP.setBottomPoint(map.get(coordB));

	        		map.put(p, holderP);
	        	}
	        }
	        System.out.println();
		}
	public HashMap<Coords, LatticePoint> getMap()
	{
		return map;
	}
	public void put(Coords holderC2, LatticePoint holderP2) 
	{
		map.put(holderC2, holderP2);
		
	}
	@Override
	public String toString()
	{
		String all = "";
		for (Entry<Coords, LatticePoint> e : map.entrySet()) {
		    //to get key
		    
		    //and to get value
		    all +=e.getValue().getTemp()+" ";
		}
		return all;
	}
	
	
	 
}
