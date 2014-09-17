package Gallhp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Gallhp.simulator.Tpdahp;

public class DiffusionSimulatorGUI extends JFrame{
	DiffusionSimulator plate =null;
	JButton runButton = new JButton("Setup Simulation");
	JTextField gridSize = new JTextField();
	JTextField topTemp = new JTextField();
	JTextField botTemp = new JTextField();
	JTextField rightTemp = new JTextField();
	JTextField leftTemp = new JTextField();
	JPanel rightPanel= new JPanel();
	
	public DiffusionSimulatorGUI() {
		super();
	}
	
	//Create Gui
	public void displayGui(){
		
		JPanel mainPanel= new JPanel();
		mainPanel.setFont(new Font("Arial",0,40));
		mainPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mainPanel.setLayout(new GridLayout(0,2));
		
		JPanel gridLeftPanel= new JPanel();
		gridLeftPanel.setFont(new Font("Arial",0,40));
		gridLeftPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		gridLeftPanel.setLayout(new GridLayout(0,1));
		
		setupMenu(gridLeftPanel);
		
		mainPanel.add(gridLeftPanel);

		
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBackground(Color.LIGHT_GRAY);
		
		
		mainPanel.add(rightPanel);
		add(mainPanel);
		this.pack();

		this.setSize(1800, 900);
	
		this.setVisible(true);
	}
	
	private void setupMenu(JPanel gridLeftPanel) {
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new FlowLayout());
		
		JPanel smallGrid = new JPanel();
		smallGrid.setFont(new Font("Arial",0,40));
		smallGrid.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		smallGrid.setLayout(new GridLayout(0,2));
		
		JLabel gridSizeLabel = new JLabel("Enter Size of Grid");
		gridSizeLabel.setFont(new Font("Arial",0,40));
		
		smallGrid.add(gridSizeLabel);
		gridSize.setFont(new Font("Arial",0,40));
		smallGrid.add(gridSize);
		

		JLabel topLabel = new JLabel("Top:");
		topLabel.setFont(new Font("Arial",0,40));
		smallGrid.add(topLabel);
		topTemp.setFont(new Font("Arial",0,40));
		smallGrid.add(topTemp);
		

		JLabel bottomLabel = new JLabel("Bottom:");
		bottomLabel.setFont(new Font("Arial",0,40));
		smallGrid.add(bottomLabel);
		botTemp.setFont(new Font("Arial",0,40));
		smallGrid.add(botTemp);
		

		JLabel leftLabel = new JLabel("Left:");
		leftLabel.setFont(new Font("Arial",0,40));
		smallGrid.add(leftLabel);
		leftTemp.setFont(new Font("Arial",0,40));
		smallGrid.add(leftTemp);

		JLabel rightLabel = new JLabel("right:");
		rightLabel.setFont(new Font("Arial",0,40));
		smallGrid.add(rightLabel);
		rightTemp.setFont(new Font("Arial",0,40));
		smallGrid.add(rightTemp);
		

		runButton.setFont(new Font("Arial",0,40));
		innerPanel.add(smallGrid);

		
		runButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	if(plate==null){
            		plate = DiffusionSimulatorFactory.createSimulator("Tpdahp",gridSize.getText(),
            				topTemp.getText(),
            				botTemp.getText(),
            				leftTemp.getText(),
            				rightTemp.getText()); 
            		rightPanel.add(plate);
            		runButton.setText("Run Simulation");
            		repaint();
    				revalidate();
            	}else if(runButton.getText().contains("Clear")){
            		rightPanel.remove(plate);
            		plate=null;
          			runButton.setText("Setup Simulation");
              		repaint();
      				revalidate();
            	}else{
            		new Thread() {
            	    @Override public void run () {

            			plate.simulate();
              			runButton.setText("Clear Simulation");
                  		repaint();
          				revalidate();
            	     
            	    }
            	  }.start();

            	}
            }
        }); 
		innerPanel.add(runButton);
		gridLeftPanel.add(innerPanel);
	}


}
