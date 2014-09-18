package Gallhp;

import javax.swing.SwingUtilities;

public class Demo
{

    public Demo()
    {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                DiffusionSimulatorGUI gui = new DiffusionSimulatorGUI();
                gui.displayGui();
                //gui.displayGui();
            }
        });

    }

}
