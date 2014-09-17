package Gallhp;

import Gallhp.simulator.Tpdahp;

public class DiffusionSimulatorFactory {

	public DiffusionSimulatorFactory() {
	}
	
	//Returns a specific immplementation of the abstract class DiffusionSimulator
	public static DiffusionSimulator createSimulator(String type, String gridSize, String topTemp, String botTemp, String leftTemp, String rightTemp){
		if("Tpdahp".equalsIgnoreCase(type)){
			return  new Tpdahp(Integer.valueOf(gridSize),
    				Integer.valueOf(topTemp),
    				Integer.valueOf(botTemp),
    				Integer.valueOf(leftTemp),
    				Integer.valueOf(rightTemp)); 
		}else if("Tpdohp".equalsIgnoreCase(type)){
			return null;
		}else if("Tpfahp".equalsIgnoreCase(type)){
			return null;
		}else if("Twfahp".equalsIgnoreCase(type)){
			return null;
		}
		return null;
	}
}
