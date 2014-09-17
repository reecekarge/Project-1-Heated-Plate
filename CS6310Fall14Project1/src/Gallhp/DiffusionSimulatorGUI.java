package Gallhp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.InputVerifier;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import Gallhp.Tpdahp;

public class DiffusionSimulatorGUI extends JFrame{
	DiffusionSimulator plate =null;
	JButton runButton = new JButton("Setup Simulation");
	JTextField gridSize = new JTextField();
	JTextField topTemp = new JTextField();
	JTextField botTemp = new JTextField();
	JTextField rightTemp = new JTextField();
	JTextField leftTemp = new JTextField();
	JPanel rightPanel= new JPanel();
	JComboBox<String> programComboBox;
	
	public DiffusionSimulatorGUI() {
		super();
	}
	
	//Create Gui
	public void displayGui(){
		setUIFont(new FontUIResource("Arial",0,40));
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
		this.setResizable(false);
	
		this.setVisible(true);
	}
	
	private void setupMenu(JPanel gridLeftPanel) {
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new FlowLayout());
		
		JPanel smallGrid = new JPanel();
		smallGrid.setFont(new Font("Arial",0,40));
		smallGrid.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		smallGrid.setLayout(new GridLayout(0,2));
		
		JLabel gridSizeLabel = new JLabel("Dimension of Grid:");
		gridSizeLabel.setFont(new Font("Arial",0,40));
		
		smallGrid.add(gridSizeLabel);
		gridSize.setFont(new Font("Arial",0,40));
		gridSize.setToolTipText("Enter an Integer greater than zero.");
		gridSize.setInputVerifier(new InputVerifier() {
			@Override
			public boolean verify(JComponent input) {
				String text = ((JTextField) input).getText();
				try{
					Integer value = Integer.valueOf(text);
					if(value<=0){
						gridSize.setText("");
						return false;
					}else{ 
						return true;
					}
				}catch(NumberFormatException e){
					gridSize.setText("");
					return false;
				}
			}
		});
		smallGrid.add(gridSize);
		

		JLabel topLabel = new JLabel("Top Temp:");
		topLabel.setFont(new Font("Arial",0,40));
		smallGrid.add(topLabel);
		topTemp.setFont(new Font("Arial",0,40));
		topTemp.setToolTipText("Enter an Integer between zero and 100.");
		topTemp.setInputVerifier(new InputVerifier() {
			@Override
			public boolean verify(JComponent input) {
				String text = ((JTextField) input).getText();
				try{
					Integer value = Integer.valueOf(text);
					if(value<0 || value>100){
						topTemp.setText("");
						return false;
					}else{ 
						return true;
					}
				}catch(NumberFormatException e){
					topTemp.setText("");
					return false;
				}
			}
		});
		smallGrid.add(topTemp);
		

		JLabel bottomLabel = new JLabel("Bottom Temp:");
		bottomLabel.setFont(new Font("Arial",0,40));
		smallGrid.add(bottomLabel);
		botTemp.setFont(new Font("Arial",0,40));
		botTemp.setToolTipText("Enter an Integer between zero and 100.");
		botTemp.setInputVerifier(new InputVerifier() {
			@Override
			public boolean verify(JComponent input) {
				String text = ((JTextField) input).getText();
				try{
					Integer value = Integer.valueOf(text);
					if(value<0 || value>100){
						botTemp.setText("");
						return false;
					}else{ 
						return true;
					}
				}catch(NumberFormatException e){
					botTemp.setText("");
					return false;
				}
			}
		});
		smallGrid.add(botTemp);
		

		JLabel leftLabel = new JLabel("Left Temp:");
		leftLabel.setFont(new Font("Arial",0,40));
		smallGrid.add(leftLabel);
		leftTemp.setFont(new Font("Arial",0,40));
		leftTemp.setToolTipText("Enter an Integer between zero and 100.");
		leftTemp.setInputVerifier(new InputVerifier() {
			@Override
			public boolean verify(JComponent input) {
				String text = ((JTextField) input).getText();
				try{
					Integer value = Integer.valueOf(text);
					if(value<0 || value>100){
						leftTemp.setText("");
						return false;
					}else{ 
						return true;
					}
				}catch(NumberFormatException e){
					leftTemp.setText("");
					return false;
				}
			}
		});
		smallGrid.add(leftTemp);

		JLabel rightLabel = new JLabel("right Temp:");
		rightLabel.setFont(new Font("Arial",0,40));
		smallGrid.add(rightLabel);
		rightTemp.setFont(new Font("Arial",0,40));
		rightTemp.setToolTipText("Enter an Integer between zero and 100.");
		rightTemp.setInputVerifier(new InputVerifier() {
			@Override
			public boolean verify(JComponent input) {
				String text = ((JTextField) input).getText();
				try{
					Integer value = Integer.valueOf(text);
					if(value<0 || value>100){
						rightTemp.setText("");
						return false;
					}else{ 
						return true;
					}
				}catch(NumberFormatException e){
					rightTemp.setText("");
					return false;
				}
			}
		});
		smallGrid.add(rightTemp);
		smallGrid.add(new JLabel("Select program:"));

		
		Vector<String> programs = new Vector<String>();
		programs.add("Tpdahp");
		programs.add("Tpdohp");
		programs.add("Tpfahp");
		programs.add("Twfahp");
		programComboBox = new JComboBox<String>(programs);
		smallGrid.add(programComboBox);

		runButton.setFont(new Font("Arial",0,40));
		innerPanel.add(smallGrid);

		
		runButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	if(plate==null){
            		if(!gridSize.getText().equals("") && !topTemp.getText().equals("") && !botTemp.getText().equals("")
            				 && !leftTemp.getText().equals("") && !rightTemp.getText().equals("")){
            		plate = DiffusionSimulatorFactory.createSimulator((String)programComboBox.getSelectedItem(),gridSize.getText(),
            				topTemp.getText(),
            				botTemp.getText(),
            				leftTemp.getText(),
            				rightTemp.getText()); 
            		rightPanel.add(plate);
            		runButton.setText("Run Simulation");
            		repaint();
    				revalidate();
            		}
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
	public static void setUIFont (FontUIResource f){
		Enumeration keys = UIManager.getDefaults().keys();
		while(keys.hasMoreElements()){
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if(value!=null && value instanceof FontUIResource){
				UIManager.put(key,f);
			}
		}
	}

}
