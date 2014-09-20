package Tpdohp;

import java.text.DecimalFormat;


public class Demo 
{

	public static void main(String[] args) 
	{
		
		int dim = 0;
		int left = -1;
		int right = -1;
		int top = -1;
		int bottom = -1;
		
		double significantDifference = 0;
		Boolean done = false;
		LatticePoint holderP = new LatticePoint();
		Coords holderC = new Coords(0,0);
		DecimalFormat td = new DecimalFormat("#.00");
		int iterations = 0;
		
		
		int i = 0, j;
        String arg;
        char flag;
       
        
        
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
                            dim = Integer.valueOf(args[i++]);
                            break;
                        case 'l':
                           left  = Integer.valueOf(args[i++]);
                            break;
                        case 'r':
                            right = Integer.valueOf(args[i++]);
                            break;
                        case 't':
                            top = Integer.valueOf(args[i++]);
                            break;
                        case 'b':
                            bottom = Integer.valueOf(args[i++]);
                            break;
                        default:
                            System.err.println("ParseCmdLine: illegal option " + flag);
                            break;
                    }
                }
            }
        }
        if (dim <= 0 || left < 0 || left > 100 || right < 0 || right > 100 || top < 0 || top > 100 || bottom < 0 || bottom > 100 )
        {
            System.out.println("Invalid number of arguements.");
            System.out.println("Your Parameter values: d="+dim+" l="+left+" r="+right+" t="+top+" b="+bottom);
            System.out.println("Proper usage: java Tpdahp.Demo -d # -l # -r # -t # -b #\nValue for d > 0, Values for rest 0 - 100");
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
			if (significantDifference <= .1 || iterations > 9999)				
			{
				done = true;
			}
			
			System.out.println(output);
			}
		
		 	long end = System.currentTimeMillis();
			Runtime runtime = Runtime.getRuntime();
	        long memory = runtime.totalMemory() - runtime.freeMemory();
	        System.out.println("\n\nPerformance Summary");
	        System.out.println((" - Time Taken: "+ (end - start)));
	        System.out.println((" - Memory Used: bytes"+ memory));
	        System.out.println((" - Number of iterations: "+iterations ));
		
	 
		}
	}

}
