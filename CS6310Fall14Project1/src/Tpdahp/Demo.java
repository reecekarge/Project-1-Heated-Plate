package Tpdahp;

public class Demo
{

    public Demo()
    {
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
            DiffusionSimulator simulator = new DiffusionSimulator(d, t, b, l, r);
            simulator.simulate();
            simulator.printPlate();
        }

//		if(args.length==5){
//			DiffusionSimulator simulator = new DiffusionSimulator(
//                                        Integer.valueOf(args[0]),
//					Integer.valueOf(args[3]),
//					Integer.valueOf(args[4]),
//					Integer.valueOf(args[1]),
//					Integer.valueOf(args[2])
//                        );
//			simulator.simulate();
//			simulator.printPlate();
//		}else{
//			//Print out help
//			System.out.println("Invalid number of arguements.");
//			System.out.println("Proper usage: java Tpdahp.Demo -d # -l # -r # -t # -b #");
//		}
    }
}
