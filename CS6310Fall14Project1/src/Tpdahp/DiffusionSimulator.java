package Tpdahp;

public class DiffusionSimulator
{

    private double[][] oldPlate;
    private double[][] newPlate;
    private int dimension;
    private int counter;

    public DiffusionSimulator(int dim, int top, int bot, int left, int right)
    {
        this.dimension = dim + 2;
        oldPlate = new double[dimension][dimension];
        newPlate = new double[dimension][dimension];

        // Initialize the temperatures of the edge values and the plate itself
        initialize(oldPlate, top, bot, left, right);
        initialize(newPlate, top, bot, left, right);
    }

    //Simulates the diffusion of heat throught the plate
    public void simulate()
    {

        counter = 0;
        // Loop until exit criteria are met, updating each newPlate cell from the
        //   average temperatures of the corresponding neighbors in oldPlate
        do
        {
            counter++;
            for (int i = 1; i <= dimension - 2; i++)
            {
                for (int j = 1; j <= dimension - 2; j++)
                {
                    newPlate[i][j] = (oldPlate[i + 1][j] + oldPlate[i - 1][j]
                            + oldPlate[i][j + 1] + oldPlate[i][j - 1]) / 4.0;
                }
            }
            // Swap the plates and continue
            swap(oldPlate, newPlate);
        } while (!done());
    }

    //Initializes starting temperatures on the edges of the plate
    private void initialize(double[][] plate, int top, int bot, int left, int right)
    {
        //initialize the grid
        for (int i = 0; i < plate.length; i++)
        {
            for (int j = 0; j < plate.length; j++)
            {
                plate[i][j] = (double) 0;
            }
        }
        //initialize the top temp
        for (int i = 0; i < dimension; i++)
        {
            if (i != 0 && i != dimension - 1)
            {
                plate[0][i] = top;
            }
        }
        //initialize the bottom
        for (int i = 0; i < dimension; i++)
        {
            if (i != 0 && i != dimension - 1)
            {
                plate[dimension - 1][i] = bot;
            }
        }
        //initialize the left
        for (int i = 0; i < dimension; i++)
        {
            if (i != 0 && i != dimension - 1)
            {
                plate[i][0] = left;
            }
        }
        //initialize right
        for (int i = 0; i < dimension; i++)
        {
            if (i != 0 && i != dimension - 1)
            {
                plate[i][dimension - 1] = right;
            }
        }

    }

    //Switches the old plate with the new plate
    private void swap(double[][] oldPlate, double[][] newPlate)
    {
        double[][] tempPlate = oldPlate;
        this.oldPlate = newPlate;
        this.newPlate = tempPlate;
    }

    //prints out the plate
    public void printResults()
    {
        System.out.println();
        for (int i = 1; i < dimension - 1; i++)
        {
            for (int j = 1; j < dimension - 1; j++)
            {
                System.out.printf("[%.2f]", oldPlate[i][j]);
            }
            System.out.println();
        }
    }

    //Returns the results in a string buffer
    public StringBuffer exportResults()
    {
        StringBuffer ret = new StringBuffer();

        for (int i = 1; i < dimension - 1; i++)
        {
            for (int j = 1; j < dimension - 1; j++)
            {
                ret.append(String.format("[%.2f]", oldPlate[i][j]));
            }
            ret.append("\n");
        }
        return ret;
    }

    //returns true if counter is over 3000 or the change in values was negligible last iteration
    public boolean done()
    {
        if (counter > 10000)
        {
            return true;
        }
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                if (oldPlate[i][j] < newPlate[i][j] - .01 || oldPlate[i][j] > newPlate[i][j] + .01)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int getNumberOfIterations()
    {
        return counter;
    }
}
