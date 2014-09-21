package Tpdohp;

import java.text.DecimalFormat;


public class Demo
{

	public static void main(String[] args)
	{
		String output = "";
		int dim = 0;
		int left = -1;
		int right = -1;
		int top = -1;
		int bottom = -1;

		double significantDifference = 0;
		Boolean done = false;
		LatticePoint pointBring = new LatticePoint();
		LatticePoint pointPut = new LatticePoint();
		LatticePoint pointSwitch = new LatticePoint();
		Coords holderC = new Coords(0,0);
		DecimalFormat td = new DecimalFormat("00.00");
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

		Grid plateOld = new Grid(dim, left, right, top, bottom);
		Grid plateNew = new Grid(dim, left, right, top, bottom);
		
		plateNew.createGrid();
		plateNew.setPointNeighbors();
		
		plateOld.createGrid();
		plateOld.setPointNeighbors();
		
		System.out.println("3eeeee44ee3");
		while(!done)
		{
			significantDifference = 0;
			iterations++;
			output = "";
			for(int y = 1; y <= dim; y++)
			{
				
				for(int x = 1; x <= dim; x++)
				{
					double temperature1 = 0; 
					double temperature2 = 0; 
					
					holderC = new Coords(x,y);
					
					//delete switcher
					pointBring = plateOld.getMap().get(holderC);
					//pointPut = plateSwitcher2.getMap().get(holderC);
					//pointSwitch = plateSwitcher.getMap().get(holderC);
					

					
					temperature1 = pointBring.getTemp();
					pointBring.setTemp();

					temperature2 = pointBring.getTemp();
					
					
					plateNew.getMap().put(holderC, pointBring);
					output += ("[ "+td.format(pointBring.getTemp())+" ]");
                    
					pointBring.setTemp(temperature1);
                    
					if (pointBring.getX() == dim)
					{
						output += "\n";
					}
					if (temperature2 - temperature1 > .1)
					{
						significantDifference = temperature2 - temperature1;
					}

				}
			}
			System.out.println(output);
			
			if (significantDifference <= .1 || iterations > 9999)
			{
				done = true;
				
				
			}

			 System.out.println(plateOld);
			 plateOld.swap(plateNew);
			 System.out.println(plateOld);
			// plateSwitcher2 = plateNew;
			System.out.println("swap");
		}
		
			
			
		 	long end = System.currentTimeMillis();
			Runtime runtime = Runtime.getRuntime();
	        long memory = runtime.totalMemory() - runtime.freeMemory();
	        System.out.println("\n\nPerformance Summary");
	        System.out.println(String.format(" - Time Taken: %dms", end - start));
	        System.out.println(String.format(" - Memory Used: %d bytes", memory));
	        System.out.println(String.format(" - Number of iterations: %d", iterations));


		}
        
	}
	

}
