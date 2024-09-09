//Tyler Rinko
//5/4/2024
//SER120 Final Project

//Importing necessary imports
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	
	//Declaring class specific variables
	protected static Enemy enemy;
	protected static Avatar avatar1;
	private boolean newFlag;
	protected static AnimationTimer timer;
	protected static LinkedList<Enemy> enemyList;
	protected ImageIcon backgroundImage;
	
	//Drawing panel constructor
	public DrawingPanel() {
		//super is a JPanel here
		super();
		this.setSize(500, 500);
		
		this.setPreferredSize(new Dimension(500, 450));
		this.setBackground(java.awt.Color.black);
		
		enemyList = new LinkedList<Enemy>();
		
		//iterates the number of times that is previously selected or typed into control panel
		//and creates a linked list full of randomly generated enemies
		for(int i = 0; i < ControlPanel.numEnemies; i++) {
			Random rand = new Random();
			int randomY = rand.nextInt(251);
			int randomX = rand.nextInt(150);
			int randomFlag = rand.nextInt(2);
			if(randomFlag == 1) {
				newFlag = true;
			}else {
				newFlag = false;
			}
			enemy = new Enemy(randomX, randomY, newFlag, "zombie_topdown.png");
			enemyList.add(enemy);
		}
		
		//creates the default character (skeleton)
		avatar1 = new Avatar(400, 100, "skeleton_attack_sheet.png");
		//creates a new instance of the animation timer that will be used for the game
		timer = new AnimationTimer(this);

	}
	
	public void move() {
		//moves all enemies that are in the enemyList
		for(Enemy enemy : enemyList) {
			enemy.move(1, 1);
		}
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		//similar goal as the move method, but paint the avatar as well
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D)g;
		for(Enemy enemy : enemyList) {
			enemy.paint(brush);
		}
		avatar1.paint(brush);
	}
}