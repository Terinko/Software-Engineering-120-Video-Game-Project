//Tyler Rinko
//5/4/2024
//SER120 Final Project

//importing necessary imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener {
	
	//declaring class specific variables
	private String buttonType;
	private JButton currentButton;
	protected static boolean startButtonClicked = false;
	private static boolean drawingPanelAdded = false;
	
	//class constructor
	public ButtonListener(String button) {
		buttonType = button;
	}
	
	//second constructor for button that necessitate more variables in the constructor's method call
	public ButtonListener(String button, JButton thisButton) {
		buttonType = button;
		currentButton = thisButton;
	}
	
	//method that determines which button is being pressed and the logical operations that determine 
	//what the button should do depending on the situation
	public void actionPerformed(ActionEvent e) {
		if(buttonType.equals("up")) {
			if(DrawingPanel.avatar1.getYLocation() >= 10) {
		          DrawingPanel.avatar1.move(0, -10);     
			}
		}else if(buttonType.equals("down")) {
			if(DrawingPanel.avatar1.getYLocation() <= 300) {
		          DrawingPanel.avatar1.move(0, 10);
			}
		}else if(buttonType.equals("start")){
			if(!startButtonClicked){
				if(!drawingPanelAdded){
					App.p1.add(new DrawingPanel());
					drawingPanelAdded = true;
				}
				DrawingPanel.timer.start();
				currentButton.setText("Pause");
				startButtonClicked = true;
			}else{
				DrawingPanel.timer.stop();
				currentButton.setText("Start");
				startButtonClicked = false;
			}
		}else if(buttonType.equals("quit")){
			System.exit(0);
		}else if(buttonType.equals("Quit")) {
			System.exit(0);
		}
	}
	
}