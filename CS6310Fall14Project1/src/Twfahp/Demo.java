package Twfahp;

public class Demo
{

    public Demo()
    {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args)
    {
        int i = 0, j;
        String arg;
        char flag;
        boolean vflag = false;
        String outputfile = "";
        int d = 0, t = 0, b = 0, l = 0, r = 0;

        while (i < args.length)
        {

            if (args[i].startsWith("-"))
            {
                arg = args[i++];
                for (j = 1; j < arg.length(); j++)
                {
                    flag = arg.charAt(j);
                    switch (flag)
                    {
                        case 'd':
                            d = Integer.valueOf(args[i++]);
                            break;
                        case 't':
                            t = Integer.valueOf(args[i++]);
                            break;
                        case 'b':
                            b = Integer.valueOf(args[i++]);
                            break;
                        case 'l':
                            l = Integer.valueOf(args[i++]);
                            break;
                        case 'r':
                            r = Integer.valueOf(args[i++]);
                            break;
                        default:
                            System.err.println("ParseCmdLine: illegal option " + flag);
                            break;
                    }
                }
            }
        }
        if (d == 0 || t == 0 || l == 0 || r == 0)
        {
            System.out.println("Invalid number of arguements.");
            System.out.println("Proper usage: java Tpdahp.Demo -d # -l # -r # -t # -b #");
        } else
        {

            long start = System.currentTimeMillis();

            //Instanciate and calls the Simulator
            DiffusionSimulator simulator = new DiffusionSimulator(d, t, b, l, r);
            simulator.simulate();
            simulator.printResults();

            long end = System.currentTimeMillis();
            Runtime runtime = Runtime.getRuntime();
            long memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("\n\nPerformance Summary");
            System.out.println(String.format(" - Time Taken: %dms", end - start));
            System.out.println(String.format(" - Memory Used: %d bytes", memory));
        }

    }

}
