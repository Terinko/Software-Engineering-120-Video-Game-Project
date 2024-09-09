//Tyler Rinko
//5/4/2024
//SER120 Final Project

//Imports necessary imports
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy {

	//Declaring all class specific variables
	private ColorEllipse face;
	private int x,y;
	private boolean goingDown;
	protected ImageIcon enemyImage;
	static final int SIZE = 30;
	
	//Enemy parameterized constructor with two ints describing x and y coordinates,
	//a boolean which describes the current direction of travel, and the image that it uses to display itself
	public Enemy(int x, int y, boolean goingDown, String imagePath) {
		
		// set color
		//similar to avatar, has a face and a fail safe to the image if image is null
		face = new ColorEllipse(Color.green);
		this.enemyImage = new ImageIcon(getClass().getResource(imagePath));
		
		face.setSize(30,30);
		
		this.goingDown = goingDown;
		
		// set location
		
		this.setLocation(x, y);
		
	}
	
	public void move(int dx, int dy) {
		//move implements logic based on direction of travel and the bounds of the drawing panel
		//this allows the enemies to "bounce" off the walls if they touch them
		if(goingDown){
			// moves down
			if(this.getYLocation() >= 340){
				this.setLocation(x+5, y-5);
				goingDown = false;
			}else{
				this.setLocation(x+5, y+5);
			}
		}else{
			// moves up
			if(this.getYLocation() <= 2){
				this.setLocation(x+5, y+5);
				goingDown = true;
			}else{
				this.setLocation(x+5, y-5);
			}
		}
	}
	
	public void setLocation(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		face.setLocation(x, y);
		
	}
	
	public void paint(Graphics2D brush) {
		if(enemyImage != null) {
			brush.drawImage(enemyImage.getImage(), x, y, SIZE, SIZE, null);
		}else {
			face.paint(brush);
		}
	}

	public int getYLocation() {
		return y;
	}

	public int getXLocation() {
		// TODO Auto-generated method stub
		return x;
	}
	
	//Creates a hitbox for each enemy that is created that is close to the image size
	public Rectangle getHitbox() {
        return new Rectangle(this.x, this.y, 10, 10);
    }

    // Method to check if this element has collided with another
    public boolean collidesWith(Avatar other) {
        return this.getHitbox().intersects(other.getHitbox());
    }
	
}

