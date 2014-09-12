package Gallhp;

public class DiffusionSimulatorFactory {

	public DiffusionSimulatorFactory() {
	}
	
	//Returns a specific immplementation of the interface DiffusionSimulator
	public static DiffusionSimulator createSimulator(String type){
		if("Tpdahp".equalsIgnoreCase(type)){
			return null;
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
