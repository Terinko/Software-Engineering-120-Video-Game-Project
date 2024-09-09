//Tyler Rinko
//5/4/2024
//SER120 Final Project

//import necessary imports
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class RadioListener implements MouseListener {
	//Declare class specific variables
    private Color _color;
    private Graphics2D g;
    
    //Radionlistener parameterized constructor
    public RadioListener(JLabel label, Color color) {
        _color = color;
    }

    //Next 5 methods are necessary when implementing the MouseListener interface
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//Sets the image of the avatar when button is pressed
		if(_color.equals(Color.green)) {
			DrawingPanel.avatar1.setImage("rogue spritesheet calciumtrice.png");
		}else {
			DrawingPanel.avatar1.setImage("skeleton_attack_sheet.png");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
