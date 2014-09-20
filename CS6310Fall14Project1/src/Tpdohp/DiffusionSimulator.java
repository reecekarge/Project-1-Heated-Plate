package Tpdohp;

public class DiffusionSimulator
{

    protected Plate oldPlate;
    protected Plate newPlate;
    private int dimension;
    private int counter;

    public DiffusionSimulator(int dim, int top, int bot, int left, int right)
    {
        this.dimension = dim + 2;
        this.oldPlate = new Plate(dim);
        this.newPlate = new Plate(dim);
        
        // Initialize the temperatures of the edge values and the plate itself
        initialize(oldPlate.plate, top, bot, left, right);
        initialize(newPlate.plate, top, bot, left, right);

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
                    newPlate.plate[i][j] = (double) ((oldPlate.plate[i + 1][j] + oldPlate.plate[i - 1][j]
                            + oldPlate.plate[i][j + 1] + oldPlate.plate[i][j - 1]) / 4.0);
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
                plate[0][i] = (double) top;
            }
        }
        //initialize the bottom
        for (int i = 0; i < dimension; i++)
        {
            if (i != 0 && i != dimension - 1)
            {
                plate[dimension - 1][i] = (double) bot;
            }
        }
        //initialize the left
        for (int i = 0; i < dimension; i++)
        {
            if (i != 0 && i != dimension - 1)
            {
                plate[i][0] = (double) left;
            }
        }
        //initialize right
        for (int i = 0; i < dimension; i++)
        {
            if (i != 0 && i != dimension - 1)
            {
                plate[i][dimension - 1] = (double) right;
            }
        }

    }

    //Switches the old plate with the new plate
    private void swap(Plate oldPlate, Plate newPlate)
    {
        Plate tempPlate = oldPlate;
        this.oldPlate = newPlate;
        this.newPlate = tempPlate;
    }

    //prints out the plate
    public void printPlate()
    {
        for (int j = 1; j < dimension - 1; j++)
        {
            System.out.print("------");
        }
        System.out.println();
        for (int i = 1; i < dimension - 1; i++)
        {
            for (int j = 1; j < dimension - 1; j++)
            {
                System.out.printf("%.2f|", oldPlate.plate[i][j]);
            }
            System.out.println();
            for (int j = 1; j < dimension - 1; j++)
            {
                System.out.print("------");
            }
            System.out.println();
        }
    }

    //Returns the results in a string buffer
    public StringBuffer exportPlate()
    {
        StringBuffer ret = new StringBuffer();
        for (int j = 1; j < dimension - 1; j++)
        {
            ret.append("------");
        }
        ret.append("\n");
        for (int i = 1; i < dimension - 1; i++)
        {
            for (int j = 1; j < dimension - 1; j++)
            {
                ret.append(String.format("%.2f|", oldPlate.plate[i][j]));
            }
            ret.append("\n");
            for (int j = 1; j < dimension - 1; j++)
            {
                ret.append("------");
            }
            ret.append("\n");
        }
        return ret;
    }

    //returns true if counter is over 3000 or the change in values was negligible last iteration
    public boolean done()
    {
        if (counter > 3000)
        {
            return true;
        }
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                if (oldPlate.plate[i][j] < newPlate.plate[i][j] - .01 || oldPlate.plate[i][j] > newPlate.plate[i][j] + .01)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int getNumberOfOperations()
    {
        return counter;
    }
}
