//Tyler Rinko
//5/4/2024
//SER120 Final Project

//necessary imports
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationTimer extends Timer{
	
	//private and protected class variable declarations
	private DrawingPanel dp;
	protected static int score = 0;
	
	//Timer constructor
	public AnimationTimer(DrawingPanel dp) {
		super(100, null);
		this.dp = dp;
		//adding and action listener so that things happen when the timer updates
		this.addActionListener(new MoveListener());
		
	}
	
	//class to define what happens when the timer updates
	private class MoveListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//move all elements
			dp.move();
			//if there are enemies still alive, iterate over them to determine if any of them are touching
			//the avatar
			if(!DrawingPanel.enemyList.isEmpty()) {
				int size = DrawingPanel.enemyList.size();
				for(int i = 0; i < size; i++) {
					Enemy enemy = DrawingPanel.enemyList.get(i);
					//use hitboxes in avatar and enemies class to determine contact
					if(enemy.collidesWith(DrawingPanel.avatar1)) {	
						DrawingPanel.avatar1.setColor(java.awt.Color.red);
						new FinalPrompt();
						DrawingPanel.timer.stop();
					}
					//if enemies get past the avatar, clear them from the list and
					//increment score
					if(enemy.getXLocation() > 460) {
						DrawingPanel.enemyList.remove(enemy);
						size--;
						score++;
						App.scoreLabel.setText("Score: " + score);
					}
				}
				//if there are no more enemies then show score label
			}if(DrawingPanel.enemyList.isEmpty()) {
				new FinalPrompt();
				DrawingPanel.timer.stop();
			}
		}
	}

}
