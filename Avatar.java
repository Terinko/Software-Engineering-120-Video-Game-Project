//Tyler Rinko
//5/4/2024
//SER120 Final Project

//necessary imports
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Avatar{
	
	//declaring all class specific variables
	protected static ColorEllipse character;
	protected ImageIcon characterImage;
	protected static JLabel imageLabel;
	static final int SIZE = 30;
	private int x,y;
	
	//avatar constructor to be used from drawing panel
	public Avatar(int x, int y, String ImagePath) {
		
		// set color
		
		//fail safe if image is not found
		character = new ColorEllipse(Color.blue);
		//the character image based on the character file
		this.characterImage = new ImageIcon(getClass().getResource(ImagePath));
		
		character.setSize(10,10);
		
		// set location
		
		this.setLocation(x, y);
		
	}
	
	public void move(int dx, int dy) {
		
		// set location
		this.setLocation(x+dx, y+dy);	
		
	}
	
	public void setLocation(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		character.setLocation(x, y);
		
	}
	
	public void paint(Graphics2D brush) {
		if(characterImage != null) {
			brush.drawImage(characterImage.getImage(), x, y, SIZE, SIZE, null);
		}else {
			character.paint(brush);
		}
	}

	public int getYLocation() {
		return y;
	}

	public int getXLocation() {
		// TODO Auto-generated method stub
		return x;
	}
	
	public void setColor(java.awt.Color color) {
		character.setColor(color);
	}
	
	//creates a hitbox with roughly the proportions of the image
	public Rectangle getHitbox() {
        return new Rectangle(this.x, this.y, 20, 20);
    }

    // Method to check if this element has collided with another
    public boolean collidesWith(Enemy other) {
        return this.getHitbox().intersects(other.getHitbox());
    }
    
    public void setImage(String newImage) {
    	this.characterImage = new ImageIcon(getClass().getResource(newImage)); 
    }
}
