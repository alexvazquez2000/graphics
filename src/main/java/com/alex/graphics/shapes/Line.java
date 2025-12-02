package com.alex.graphics.shapes;

import java.awt.Graphics2D;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class Line extends Shape {

	private double x;
	private double y;
	private double endX;
	private double endY;
	
	public Line(double x, double y, double endX, double endY) {
		shapeType = "Line";
		this.x = x;
		this.y = y;
		this.endX = endX;
		this.endY = endY;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawLine((int)x, (int)y, (int)endX, (int)endY);
	}

}
