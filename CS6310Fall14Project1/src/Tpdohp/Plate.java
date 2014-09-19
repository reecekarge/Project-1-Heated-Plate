package Tpdohp;

public class Plate {
	
	private int dimension;
	//private int top;
	//private int bot;
	//private int left;
	//private int right;
	
	public double [][] plate;

	public Plate(){
		
	}
	
	public Plate(int dim){
		this.dimension = dim + 2;
		//this.top = aTop;
		//this.bot = aBot;
		//this.left = aLeft;
		//this.right = aRight;
		this.plate = new double[dimension][dimension];

	}
	

}
