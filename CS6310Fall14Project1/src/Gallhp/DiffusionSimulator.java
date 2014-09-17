package Gallhp;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public abstract class  DiffusionSimulator extends JPanel{
	int dimension=0;
	int pixelSize = 900;
	int squareSize =0;
	ArrayList<ArrayList<JTextArea>> grid = new ArrayList<ArrayList<JTextArea>>();
	
	public DiffusionSimulator(int dim) {
		super();
		setSize(pixelSize, pixelSize);
		dimension = dim;
		squareSize = pixelSize/dimension;
		setLayout(new GridLayout(dimension,dimension));
		initGrid();
		for(int i=0; i<dimension; i++){
			for(int j=0; j<dimension; j++){
			JTextArea area = new JTextArea();
			area.setSize(squareSize, squareSize);
			area.setBorder(BorderFactory.createLineBorder(Color.black));
			
			area.setBackground(Color.getHSBColor(.666f, 1f, 1f));
			area.setVisible(true);
	
			grid.get(i).set(j,area);
			add(area);
			}
		}
		setMinimumSize(getSize());
		setVisible(true);
	}
	public void updateGridCell(int i,int j,double heat){
		Double g = (heat-100)/100*(-1);
		grid.get(i-1).get(j-1).setBackground(Color.getHSBColor(.666f*g.floatValue(), 1f, 1f));
	}
	public void reloadGrid(){
				repaint();
				revalidate();
	}
	private void initGrid(){
		for(int i=0; i<dimension; i++){
			ArrayList<JTextArea> temp = new ArrayList<JTextArea>();
			for(int j=0; j<dimension; j++){
				temp.add(new JTextArea());
			}
			grid.add(temp);
		}
	}
	abstract public void simulate();
	abstract protected void initialize(double[][] plate,int top,int bot,int left,int right);
	abstract protected void swap(double[][] oldPlate, double[][] newPlate);
	abstract public void printPlate();
	abstract protected boolean done();
	abstract public double[][] next();
	
	
}
