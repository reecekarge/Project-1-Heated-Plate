package Tpdohp;

import java.text.DecimalFormat;


public class Demo {

	public static void main(String[] args) {

		int dim = 2;
		int left = 30;
		int right = 50;
		int top = 25;
		int bottom = 67;

		
		double significantDifference = 0;
		Boolean done = false;
		LatticePoint holderP = new LatticePoint();
		Coords holderC = new Coords(0,0);
		DecimalFormat td = new DecimalFormat("#.00");
		
		Grid plate = new Grid(dim, left, right, top, bottom);
		plate.createGrid();
		plate.setPointNeighbors();
		

		while(!done)
		{
			String output = "";
			for(int y = 1; y <= dim; y++)
			{
				significantDifference = 0;
				for(int x = 1; x <= dim; x++)
				{					
					holderC = new Coords(x,y);
					holderP = plate.getMap().get(holderC);
				
					holderP.setTemp();
					plate.put(holderC,holderP);
					output += (holderP.toString()+td.format(holderP.getTemp())+"  ");
					
					
					if (holderP.getX() == dim)						
					{
						output += "\n";
					}
				
				}
			}
			if (significantDifference < -1)				
			{
				done = true;
			}
			System.out.println(output);
		}

		//System.out.println(plate.toString());
		
	}

}
