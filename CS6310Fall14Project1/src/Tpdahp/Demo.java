package Tpdahp;

public class Demo {

	public Demo() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		if(args.length==5){
			DiffusionSimulator simulator = new DiffusionSimulator(Integer.valueOf(args[0]),
					Integer.valueOf(args[3]),
					Integer.valueOf(args[4]),
					Integer.valueOf(args[1]),
					Integer.valueOf(args[2]));
			simulator.simulate();
			simulator.printPlate();
		}else{
			System.out.println("Invalid number of arguements.");
			System.out.println("Proper usage: java Tpdahp.Demo -d # -l # -r # -t # -b #");
		}
//		DiffusionSimulator simulator = new DiffusionSimulator(5,
//				5,
//				3,
//				2,
//				1);
//		simulator.simulate();
//		simulator.printPlate();
	
	}
}
