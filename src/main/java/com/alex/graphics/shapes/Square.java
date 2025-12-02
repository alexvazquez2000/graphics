package com.alex.graphics.shapes;

import java.awt.Graphics2D;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class Square extends Shape {

	private double x;
	private double y;
	private double side;
	private double rotate;
	
	public Square(double x, double y, double side) {
		this(x, y, side, 0);
	}

	public Square(double x, double y, double side, double rotate) {
		shapeType = "Square";
		this.x = x;
		this.y = y;
		this.side = side;
		this.rotate = rotate;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawRect((int)x, (int)y, (int)side, (int)side);
		//TODO: Rotate
	}

}
