package Tpdohp;

import java.text.DecimalFormat;


public class Demo 
{

	public static void main(String[] args) 
	{
		int dim = 6;
		int left = 100;
		int right = 0;
		int top = 25;
		int bottom = 40;
		
		double significantDifference = 0;
		Boolean done = false;
		LatticePoint holderP = new LatticePoint();
		Coords holderC = new Coords(0,0);
		DecimalFormat td = new DecimalFormat("#.00");
		
		int i = 0, j;
		String arg;
        char flag;
        int d = 0, t = 0, b = 0, l = 0, r = 0;
		while (i < args.length)
        {

            if (args[i].startsWith("-"))
            {
                arg = args[i++];
                for (j = 1; j < arg.length(); j++)
                {
                    flag = arg.charAt(j);
                    switch (flag)
                    {
                        case 'd':
                            d = Integer.valueOf(args[i++]);
                            break;
                        case 't':
                            t = Integer.valueOf(args[i++]);
                            break;
                        case 'b':
                            b = Integer.valueOf(args[i++]);
                            break;
                        case 'l':
                            l = Integer.valueOf(args[i++]);
                            break;
                        case 'r':
                            r = Integer.valueOf(args[i++]);
                            break;
                        default:
                            System.err.println("ParseCmdLine: illegal option " + flag);
                            break;
                    }
                }
            }
        }
		

		
		
		
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
					//System.out.println(holderP.getChange());
					holderP.setTemp();
					if (holderP.getChange() > significantDifference)
					{
						significantDifference = holderP.getChange();
					}
					
					plate.put(holderC,holderP);
					output += (holderP.toString()+td.format(holderP.getTemp())+"  ");
					
					
					if (holderP.getX() == dim)						
					{
						output += "\n";
					}
				
				}
			}
			if (significantDifference < .2)				
			{
				done = true;
			}
			
			System.out.println(output);
		}

		//System.out.println(plate.toString());
		
	}

}
