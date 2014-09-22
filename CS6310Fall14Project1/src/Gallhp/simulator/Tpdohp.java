package Gallhp.simulator;

import java.text.DecimalFormat;

import Gallhp.DiffusionSimulator;


public class Tpdohp extends DiffusionSimulator {
	private double significantDifference = 0;
	private int iterations = 0;
	String output = "";
	int dim = 0;
	int left = -1;
	int right = -1;
	int top = -1;
	int bottom = -1;
	Grid plateOld;
	Grid plateNew;
	Grid plateSwitch;
	
	Boolean done = false;
	LatticePoint pointbring = new LatticePoint();
	
	Coords holderC = new Coords(0,0);
	DecimalFormat td = new DecimalFormat("00.00");

	public Tpdohp(int dim, int top, int bottom, int left, int right) {
		 super(dim);
		 this.dim = dim;
		 plateOld = new Grid(dim, left, right, top, bottom);
		 plateNew = new Grid(dim, left, right, top, bottom);
		 plateSwitch = new Grid(dim, left, right, top, bottom);
		 initialize();
		
		
	}
	
	public void simulate() {
		do
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
					
					
					pointbring = plateOld.getMap().get(holderC);
					LatticePoint pointbringNew = plateNew.getMap().get(holderC);	
					
					temperature1 = pointbring.getTemp();

					updateGridCell(y, x,temperature1);
					temperature2 = pointbring.getAverageTemp();

					pointbringNew.setTemp(temperature2);	
                    
					plateNew.getMap().put(holderC, pointbringNew);
					
					output += ("[ "+td.format(pointbring.getTemp())+" ]");
                    
					//pointbring.setTemp(temperature1);
                    
					if (pointbring.getX() == dim)
					{
						output += "\n";
					}
					if (temperature2 - temperature1 > .1)
					{
						significantDifference = temperature2 - temperature1;
					}

				}
			}
			
			
			if (significantDifference <= .001 || iterations > 9999)
			{
			 	done = true;
				
				
			}

			//swap
			plateSwitch = plateNew;  
			plateNew = plateOld;    
			plateOld = plateSwitch;  

			

			super.reloadGrid();
			
		}
		while(!done);

	}


	protected void initialize() {
		plateNew.createGrid();
		plateNew.setPointNeighbors();
		
		plateOld.createGrid();
		plateOld.setPointNeighbors();
		
		plateSwitch.createGrid();
		plateSwitch.setPointNeighbors();

	}


	public void printResults() {
		System.out.println(output);

	}

	public int getNumberOfIterations()
    {
        return iterations;
    }
	protected boolean done() {
		if (significantDifference <= .1 || iterations > 9999)
		{
		 	return true;
			
			
		}
		return false;
	}

        
        public StringBuffer exportResults()
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }



}
