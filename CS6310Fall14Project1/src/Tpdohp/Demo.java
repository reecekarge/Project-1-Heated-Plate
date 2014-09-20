package Tpdohp;

import java.text.DecimalFormat;


public class Demo 
{

	public static void main(String[] args) 
	{
		int dim = 0;
		int left = 0;
		int right = 0;
		int top = 0;
		int bottom = 0;
		
		double significantDifference = 0;
		Boolean done = false;
		LatticePoint holderP = new LatticePoint();
		Coords holderC = new Coords(0,0);
		DecimalFormat td = new DecimalFormat("#.00");
		int iterations = 0;
		
		
		int i = 0, j;
        String arg;
        char flag;
        int d = 0, t = -1, b = -1, l = -1, r = -1;

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
        if (d == 0 || t == -1 || l == -1 || r == -1 || b == -1)
        {
            System.out.println("Invalid number of arguements.");
            System.out.println("Proper usage: java Tpdahp.Demo -d # -l # -r # -t # -b #");
        } else
        {
        	long start = System.currentTimeMillis();

		
		
		
		Grid plate = new Grid(dim, left, right, top, bottom);
		plate.createGrid();
		plate.setPointNeighbors();
		

		while(!done)
		{
			iterations++;
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
			if (significantDifference < .1 || iterations > 9999)				
			{
				done = true;
			}
			
			System.out.println(output);
		}
		long end = System.currentTimeMillis();
		Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("\n\nPerformance Summary");
        System.out.println(String.format(" - Time Taken: %dms", end - start));
        System.out.println(String.format(" - Memory Used: %d bytes", memory));
        System.out.println(String.format(" - Number of iterations: %d "+iterations ));
		//System.out.println(plate.toString());
	}
	}

}
