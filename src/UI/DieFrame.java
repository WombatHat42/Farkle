package UI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class DieFrame extends JFrame{
	private DiePanel die1;
	private DiePanel die2;
	private DiePanel die3;
	private DiePanel die4;
	private DiePanel die5;
	private DiePanel die6;
	private JPanel field;
	private JPanel menu;
	
	public DiceFrame()
		//constructor
		//initialize frame properties
		this.setLayout(new FlowLayout());
		this.setSize(300,300);
		this.setTitle("Farkle Dice ");
		//Build Panels
		this.createFieldPanel();
		this.createMenuPanel();
		
		//add field & panel to frame
		this.add(field);
		this.add(menu);
	
	//class methods
		
	//private helpers
	
	//build menu panel
	private void createMenuPanel() {
		//set up menu area
		menu = new JPanel();
		menu.setBounds(0,300,250,100);
		
		//create button & add listner
		JButton rollButton = new JButton("Re-Roll");
		rollButton.setSize(300,200);
		rollButton.addActionListener(new RollListener());
		
		//add button
		menu.add(rollButton)
		}
	//build field panel
	private void createFieldPanel() {
		//set up dice field area
		field = new JPanel();
		field.setBounds(0,0,250,200);
		
		//create dice & add them
		die1 = new DiePanel();
		die2 = new DiePanel();
		die3 = new DiePanel();
		die4 = new DiePanel();
		die5 = new DiePanel();
		die6 = new DiePanel();
		
		field.add(die1);
		field.add(die2);
		field.add(die3);
		field.add(die4);
		field.add(die5);
		field.add(die6);
		
	}
	
	//inner classes
	private class RollListener implements ActionListener{
		die1.rollDie();
		die2.rollDie();
		die3.rollDie();
		die4.rollDie();
		die5.rollDie();
		die6.rollDie();
	}
	
}
