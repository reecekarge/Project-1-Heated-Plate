package Gallhp;

public abstract class  DiffusionSimulator {
	
	abstract public void simulate();
	abstract protected void initialize(double[][] plate,int top,int bot,int left,int right);
	abstract protected void swap(double[][] oldPlate, double[][] newPlate);
	abstract public void printPlate();
	abstract protected boolean done();
	
}
