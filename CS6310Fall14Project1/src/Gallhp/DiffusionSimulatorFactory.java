package Gallhp;

public class DiffusionSimulatorFactory
{

    public DiffusionSimulatorFactory()
    {
    }

    //Returns a specific immplementation of the abstract class DiffusionSimulator
    public static DiffusionSimulator createSimulator(String type, String gridSize, String topTemp, String botTemp, String leftTemp, String rightTemp)
    {
        if ("Tpdahp".equalsIgnoreCase(type))
        {
            return null;
        } else if ("Tpdohp".equalsIgnoreCase(type))
        {
            return null;
        } else if ("Tpfahp".equalsIgnoreCase(type))
        {
            return null;
        } else if ("Twfahp".equalsIgnoreCase(type))
        {
            return null;
        }
        return null;
    }
}
