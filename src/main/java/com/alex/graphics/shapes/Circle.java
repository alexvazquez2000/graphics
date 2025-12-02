package com.alex.graphics.shapes;

import java.awt.Graphics2D;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class Circle extends Shape {

	private double x;
	private double y;
	private double radius;
	
	public Circle(double x, double y, double radius) {
		shapeType = "Circle";
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawOval((int)x, (int)y, (int) (radius*2), (int) (radius*2));
	}

}
