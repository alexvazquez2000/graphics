package com.alex.graphics;

import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.*;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class BezierCurvePanel extends JPanel {

	/** Generated serial ID*/
	private static final long serialVersionUID = -7514710043099534060L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// Define control points and endpoints for a cubic Bezier curve
		double startX = 50.5;
		double startY = 200.01;
		double control1X = 150;
		double control1Y = 50;
		double control2X = 250;
		double control2Y = 350;
		double endX = 350;
		double endY = 200;

		Path2D.Double bezierPath = new Path2D.Double();
		bezierPath.moveTo(startX, startY);
		bezierPath.curveTo(control1X, control1Y, control2X, control2Y, endX, endY);
		bezierPath.curveTo(450, 5, 150, 250, 10, 10);
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(2)); // Set stroke thickness
		g2d.draw(bezierPath);

		// Optionally, draw control points and lines
		g2d.setColor(Color.RED);
		g2d.fillOval((int) startX - 3, (int) startY - 3, 6, 6);
		g2d.fillOval((int) control1X - 3, (int) control1Y - 3, 6, 6);
		g2d.fillOval((int) control2X - 3, (int) control2Y - 3, 6, 6);
		g2d.fillOval((int) endX - 3, (int) endY - 3, 6, 6);

		g2d.setColor(Color.GRAY);
		g2d.drawLine((int) startX, (int) startY, (int) control1X, (int) control1Y);
		//g2d.drawLine((int) control1X, (int) control1Y, (int) control2X, (int) control2Y)
		g2d.drawLine((int) control2X, (int) control2Y, (int) endX, (int) endY);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bezier Curve Demo");
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.add(new BezierCurvePanel());
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
