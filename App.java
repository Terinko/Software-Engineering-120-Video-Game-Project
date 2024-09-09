//Tyler Rinko
//5/4/2024
//SER120 Final Project

//import necessary imports
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App extends JFrame{
	
	//declaring all class specific variables
	protected static JLabel scoreLabel;
	protected static DrawingPanel p1;
	protected static JPanel p2;
	protected static ImageIcon backgroundImage;
	
	//class constructor
	public App() {
		//super is a JFrame in this instance
		super("Final Game");
		this.setSize(500, 500);
		
		//set all panels within the border layout
		p1 = new DrawingPanel();
	    p2 = new JPanel();
	    JPanel p3 = new ControlPanel();
	    JPanel p4 = new JPanel();
	    JPanel p5 = new JPanel();
	   
	   //checks to determine where the border bounds are visually 
//	    p1.setBackground(Color.RED);
//		p2.setBackground(Color.GREEN);	
//		p3.setBackground(Color.ORANGE);
//		p4.setBackground(Color.CYAN);
//		p5.setBackground(Color.BLUE);
				
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ControlPanel panel = new ControlPanel();
		
		panel.setLayout(new BorderLayout());
		panel.add(p1, BorderLayout.CENTER);
		panel.add(p2, BorderLayout.NORTH);
		panel.add(p3, BorderLayout.SOUTH);
		panel.add(p4, BorderLayout.EAST);
		panel.add(p5, BorderLayout.WEST);
		scoreLabel = new JLabel("Score: 0");
		p2.add(scoreLabel);	
		//p1.add(picLabel);
		
		this.add(panel);
		//this.pack();
		
		this.setVisible(true);
	}

	//main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new App();
	}

}
