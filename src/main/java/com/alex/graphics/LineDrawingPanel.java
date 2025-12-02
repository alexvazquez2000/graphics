package com.alex.graphics;

import javax.swing.*;

import com.alex.graphics.shapes.Shape;
import com.alex.graphics.shapes.Square;
import com.alex.graphics.shapes.Circle;
import com.alex.graphics.shapes.Line;
import com.alex.graphics.shapes.Oval;
import com.alex.graphics.shapes.Rectangle;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class LineDrawingPanel extends JPanel {

	/** Generated serial ID*/
	private static final long serialVersionUID = -182916530111931167L;
	
	private ArrayList<Line2D.Double> lines = new ArrayList<>();
	private Point startPoint;
	private Point endPoint;

	public LineDrawingPanel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startPoint = e.getPoint();
				endPoint = startPoint; // Initialize end point to start point
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				endPoint = e.getPoint();
				if (startPoint != null) {
					lines.add(new Line2D.Double(startPoint, endPoint));
				}
				startPoint = null; // Reset for next line
				endPoint = null;
				repaint();
			}
		});

		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				//System.out.println(e.getX() + ", " + e.getY());
				for(Line2D.Double line : lines) {
					if ( ((int)line.x1) ==e.getX() && ((int)line.y1) ==e.getY()) {
						System.out.println("matches line");
					}
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (startPoint != null) {
					endPoint = e.getPoint();
					repaint(); // Redraw to show the line being dragged
				}
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// Draw all previously drawn lines
		for (Line2D.Double line : lines) {
			g2d.draw(line);
		}

		// Draw the line currently being dragged
		if (startPoint != null && endPoint != null) {
			g2d.draw(new Line2D.Double(startPoint, endPoint));
		}
		
		//test
		Shape l = new Line(10,10, 150, 200);
		l.draw(g2d);
		Shape o = new Oval(20,10, 150, 20);
		o.draw(g2d);
		Shape c = new Circle(50,10, 50);
		c.draw(g2d);
		Shape r = new Rectangle(10, 120, 150, 20);
		r.draw(g2d);
		Shape s = new Square(10, 160, 150);
		s.draw(g2d);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw Lines with Mouse");
		LineDrawingPanel panel = new LineDrawingPanel();
		frame.add(panel);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
