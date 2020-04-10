package UI;

import java.awt.*;
import javax.swing.*;
import Game.Die;

public class DiePanel {

	//---------------------
	//Instance Variables
	//---------------------
	
	private static final int PIP_DIAMETER = 15;
	private Die myDie;

	//---------------------
	//Constructors
	//---------------------
	
	/**
	 * Default Constructor crease a white die
	 */
	
	public DiePanel() {
		myDie = new Die();
		
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(100,100));
	}
	

	//---------------------
	//Class Methods
	//---------------------
	
	/*
	 * rolls die & repaints the display to the new result
	 */
	
	public void rollDie() {
		myDie.roll();
		repaint();
	}
	
	/*
	 * Defines how obj is drawn on screen
	 * 
	 * @param g The Graphics obj to draw to
	 */
	
	public void paintComponent(Graphics g) {
		//Required to draw panel
		super.paintComponent(g);
		
		//Initialize local variables
		int panelWidth = this.getWidth();
		int panelHeight = this.getHeight();
		
		//Draw outside border of die
		g.drawRoundRect(0, 0, panelWidth-1, panelHeight-1, 10, 10);
		
		//add on the PIPs
		this.drawPips(g, myDie.getCurrentValue());
	}
	

	//---------------------
	//Private Helper Methods
	//---------------------
	
	/*
	 * Defines how this object is drawn on screen
	 * 
	 * @param g the graphics obj to draw to
	 * @param g numberOfPips the number to draw on die
	 */
	private void drawPips(Graphics g, int numberOfPips) {
		//initialize local variables
		int panelWidth = this.getWidth();
		int panelHeight = this.getHeight();
		
		//Conditional to determine how many and locations of pips 
		switch (numberOfPips) {
		
		case 1: drawPip(g, panelWidth/2, panelHeight/2);
				break;
		
		case 2: drawPip(g, panelWidth/4, panelHeight/4);
				drawPip(g, 3*panelWidth/4, 3*panelHeight/4);
				break;
				
		case 3:	drawPip(g, panelWidth/2, panelHeight/2);
				drawPip(g, panelWidth/4, panelHeight/4);
				drawPip(g, 3*panelWidth/4, 3*panelHeight/4);
				break;
				
		case 4: drawPip(g, panelWidth/4, panelHeight/4);
				drawPip(g, 3*panelWidth/4, 3*panelHeight/4);
				drawPip(g, 3*panelWidth/4, panelHeight/4);
				drawPip(g, panelWidth/4, 3*panelHeight/4);
				break;
				
		case 5:	drawPip(g, panelWidth/2, panelHeight/2);
				drawPip(g, panelWidth/4, panelHeight/4);
				drawPip(g, 3*panelWidth/4, 3*panelHeight/4);
				drawPip(g, 3*panelWidth/4, panelHeight/4);
				drawPip(g, panelWidth/4, 3*panelHeight/4);		
				break;
				
		case 6:	drawPip(g, panelWidth/4, panelHeight/4);
				drawPip(g, 3*panelWidth/4, 3*panelHeight/4);
				drawPip(g, 3*panelWidth/4, panelHeight/4);
				drawPip(g, panelWidth/4, 3*panelHeight/4);
				drawPip(g, panelWidth/4, panelHeight/2);
				drawPip(g, 3*panelWidth/4, panelHeight/2);
				break;
		}
	}
	
	/*
	 * Defines how this obj is drawn on the screen
	 * @param g The graphics obj to draw to
	 * @param x the x coordinate where to draw the pip
	 * @param y the y coordinate where to draw the pip
	 */
	private void drawPip(Graphics g, int x, int y) {
		g.fillOval(x-PIP_DIAMETER/2, y-PIP_DIAMETER, PIP_DIAMETER, PIP_DIAMETER);
	}
}
