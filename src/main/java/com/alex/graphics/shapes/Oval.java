package com.alex.graphics.shapes;

import java.awt.Graphics2D;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class Oval extends Shape {

	private double x;
	private double y;
	private double width;
	private double height;
	private double rotate;
	
	/**
	 * @param x 
	 * @param y
	 * @param width
	 * @param height
	 */
	public Oval(double x, double y, double width, double height) {
		this(x, y, width, height, 0);
	}

	public Oval(double x, double y, double width, double height, double rotate) {
		shapeType = "Oval";
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.rotate = rotate;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawOval((int)x, (int)y, (int)width, (int)height);
		//TODO: Rotate
		if (rotate != 0d) {
			
		}

	}

}
