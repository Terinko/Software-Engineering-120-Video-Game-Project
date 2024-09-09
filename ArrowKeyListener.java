//Tyler Rinko
//5/4/2024
//SER120 Final Project

//necessary imports
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ArrowKeyListener implements KeyListener {

	//implementing mandatory methods 
	@Override
    public void keyPressed(KeyEvent e) {
		//handles when keys are pressed and what to do when they are pressed
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                // Handle up arrow key press
            	if(DrawingPanel.avatar1.getYLocation() >= 10) {
            		DrawingPanel.avatar1.move(0, -10);     
            	}
            	//DrawingPanel.avatar1.move(0, -10); // CHANGE
                break;
            case KeyEvent.VK_DOWN:
                // Handle down arrow key press
            	if(DrawingPanel.avatar1.getYLocation() <= 310) {
            		DrawingPanel.avatar1.move(0, 10);
            	}
            	//DrawingPanel.avatar1.move(0, 10); // CHANGE
                break;
            case KeyEvent.VK_LEFT:
                // Handle left arrow key press
                break;
            case KeyEvent.VK_RIGHT:
                // Handle right arrow key press
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key release if necessary
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key type if necessary
    }
}