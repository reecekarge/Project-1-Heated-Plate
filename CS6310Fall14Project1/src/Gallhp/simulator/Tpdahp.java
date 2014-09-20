package Gallhp.simulator;

import Gallhp.DiffusionSimulator;

public class Tpdahp extends DiffusionSimulator {

	public Tpdahp(int dim, int top, int bot, int left, int right) {
		super(dim);
		this.dimension = dim + 2;
		oldPlate = new double[dimension][dimension];
		newPlate = new double[dimension][dimension];

		// Initialize the temperatures of the edge values and the plate itself
		initialize(oldPlate, top, bot, left, right);
		initialize(newPlate, top, bot, left, right);

		counter = 0;
	}

	private double[][] oldPlate;
	private double[][] newPlate;
	private int dimension;
	private int counter;

	// Simulates the diffusion of heat throught the plate
	public void simulate() {

		// Loop until exit criteria are met, updating each newPlate cell from
		// the
		// average temperatures of the corresponding neighbors in oldPlate
		do {
			counter++;
			for (int i = 1; i <= dimension - 2; i++) {
				for (int j = 1; j <= dimension - 2; j++) {
					updateGridCell(i, j, newPlate[i][j]);
					newPlate[i][j] = (oldPlate[i + 1][j] + oldPlate[i - 1][j]
							+ oldPlate[i][j + 1] + oldPlate[i][j - 1]) / 4.0;

				}
			}
			// Swap the plates and continue
			swap(oldPlate, newPlate);
			super.reloadGrid();
		} while (!done());
	}
	// Initializes starting temperatures on the edges of the plate
	protected void initialize(double[][] plate, int top, int bot, int left,
			int right) {
		// initialize the top temp
		for (int i = 0; i < dimension; i++) {
			if (i == 0) {
				plate[0][i] = (top+left)/2;
			}else if(i == dimension - 1){
				plate[0][i] = (top+right)/2;
			}else{
				plate[0][i] = top;
			}
		}
		// initialize the bottom
		for (int i = 0; i < dimension; i++) {
			if (i == 0) {
				plate[dimension - 1][i] =  (bot+left)/2;
			}else if(i == dimension - 1){
				plate[dimension - 1][i] =  (bot+right)/2;
			}else{
				plate[dimension - 1][i] = bot;
			}
		}
		// initialize the left
		for (int i = 0; i < dimension; i++) {
			if (i == 0) {
				plate[i][0] =  (left+top)/2;
			}else if(i == dimension - 1){
				plate[i][0] =  (left+bot)/2;
			}else{
				plate[i][0] = left;
			}
		}
		// initialize right
		for (int i = 0; i < dimension; i++) {
			if (i == 0) {
				plate[i][dimension - 1] =  (right+top)/2;
			}else if(i == dimension - 1){
				plate[i][dimension - 1] =  (right+bot)/2;
			}else{
				plate[i][dimension - 1] = right;
			}
		}

	}

	// Switches the old plate with the new plate
	protected void swap(double[][] oldPlate, double[][] newPlate) {
		double[][] tempPlate = oldPlate;
		this.oldPlate = newPlate;
		this.newPlate = tempPlate;
	}

	// prints out the plate
	public void printResults() {
		for (int j = 0; j < dimension; j++) {
			System.out.print("----");
		}
		System.out.println();
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				System.out.printf("%.1f|", oldPlate[i][j]);
			}
			System.out.println();
			for (int j = 0; j < dimension; j++) {
				System.out.print("----");
			}
			System.out.println();
		}
	}

	// returns true if counter is over 3000 or the change in values was
	// negligible last iteration
	public boolean done() {
		if (counter > 30000) {
			return true;
		}
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (oldPlate[i][j] < newPlate[i][j] - .001
						|| oldPlate[i][j] > newPlate[i][j] + .001) {
					return false;
				}
			}
		}
		return true;
	}

        @Override
        public StringBuffer exportResults()
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
}