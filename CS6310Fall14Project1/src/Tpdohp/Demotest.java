package Tpdohp;

public class Demotest {

	public static void main(String[] args) {


		/*LatticePoint point = new LatticePoint();
		System.out.println(point.y);
		LatticePoint point2 = new LatticePoint(2,3);
		System.out.println(point2.y);
		*/
		
		Grid g = new Grid(2, 30, 30, 10, 15);
		g.createGrid();
		g.setPointNeighbors();
		g.loopTemp();
		
		
		
	}

}
