//Tyler Rinko
//5/4/2024
//SER120 Final Project

//Import necessary imports
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FinalPrompt extends JFrame{
	//Declaring all class specific variables
	JLabel winningLabel = new JLabel();
	
	//Prompt constructor
	public FinalPrompt() {
		//Super is a JFrame 
		super("Game Over");
		this.setSize(300, 200);
		this.setLocation(100, 150);
		
		//Logic to determine if the player should get a you win
		//you lose or neither message when the game ends
		if(AnimationTimer.score > 0) {
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			if(AnimationTimer.score == ControlPanel.numEnemies) {
				winningLabel = new JLabel("You win!!  Your final score is: " + AnimationTimer.score);
			}else {
				winningLabel = new JLabel("Your final score is: " + AnimationTimer.score);
			}
			//add a quit button to the message allow the user to shut down
			//the program efficiently
			JButton quitButton = new JButton("Quit");
			ButtonListener quitListener = new ButtonListener("Quit");
			quitButton.addActionListener(quitListener);
			panel.add(quitButton, BorderLayout.SOUTH);
			panel.add(winningLabel, BorderLayout.CENTER);
			this.add(panel);
		}else {
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			JLabel winningLabel = new JLabel("You lose. Final score: 0");
			JButton quitButton = new JButton("Quit");
			ButtonListener quitListener = new ButtonListener("Quit");
			quitButton.addActionListener(quitListener);
			panel.add(quitButton, BorderLayout.SOUTH);
			panel.add(winningLabel, BorderLayout.CENTER);
			this.add(panel);
		}
		//make the message visible to the user
		this.setVisible(true);
	}
}
