//Tyler Rinko
//5/4/2024
//SER120 Final Project

import java.awt.Color;

public class ColorEllipse extends ColorShape{
	
	//constructors for the failsafe ellipse found in the avatar and enemy classes
	public ColorEllipse() {
		this(Color.red);
		this.setSize(100, 100);
		this.setLocation(100, 100);
	}

	public ColorEllipse(Color color) {
		super(new java.awt.geom.Ellipse2D.Double());
		this.setColor(color);
		this.setSize(100, 100);
		// TODO Auto-generated constructor stub
	}
}