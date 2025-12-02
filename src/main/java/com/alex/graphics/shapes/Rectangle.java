package com.alex.graphics.shapes;

import java.awt.Graphics2D;

public class Rectangle extends Shape {

	private double x;
	private double y;
	private double width;
	private double height;
	private double rotate;
	
	public Rectangle(double x, double y, double width, double height) {
		this(x, y, width, height, 0);
	}

	public Rectangle(double x, double y, double width, double height, double rotate) {
		shapeType = "Rectangle";
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.rotate = rotate;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawRect((int)x, (int)y, (int)width, (int)height);
		//TODO: Rotate
	}

}
