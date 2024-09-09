//Tyler Rinko
//5/4/2024
//SER120 Final Project


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;

//abstract class for all color shapes
public abstract class ColorShape {

	private RectangularShape shape;
	
	private Color fillColor, borderColor;
	private double rotation;
	
	public ColorShape(RectangularShape shape) {
		this.shape = shape;
		rotation = 0;
	}
	
	public double getRotation() {
		return rotation * 180/Math.PI;
	}
	
	public void setRotation(double rotation) {
		this.rotation = rotation * Math.PI/180;
	}
	
	public void setLocation(double x, double y) {
		shape.setFrame(x, y, shape.getWidth(), shape.getHeight());
	}
	
	public void setSize(double w, double h) {
		shape.setFrame(shape.getX(), shape.getY(), w, h);
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color color) {
		this.fillColor = color;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color color) {
		this.borderColor = color;
	}
	
	public void setColor(Color color) {
		this.fillColor = color;
		this.borderColor = color;
	}
	
	public double getX() {
		return shape.getX();
	}
	
	public double getY() {
		return shape.getY();
	}
	
	public void paint(Graphics2D brush) {
		brush.setColor(borderColor);
		brush.rotate(this.rotation, shape.getCenterX(), shape.getCenterY());
		brush.draw(shape);
		brush.setColor(fillColor);
		brush.fill(shape);
		brush.rotate(-this.rotation, shape.getCenterX(), shape.getCenterY());
	}
	
}