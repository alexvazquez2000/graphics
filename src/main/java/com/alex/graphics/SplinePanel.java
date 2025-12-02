package com.alex.graphics;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class SplinePanel extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
	/** Generated serial ID */
	private static final long serialVersionUID = -5628233135178136776L;
	private BufferedImage image;
	private final List<Point> controlPoints = new ArrayList<>();
	private Point selectedPoint = null;

	private final JPopupMenu popupMenu = new JPopupMenu();

	public SplinePanel() {
		try {
			// Replace "path/to/your/image.jpg" with the actual path to your image file
			image = ImageIO.read(new File("image.jpg"));
		} catch (IOException e) {
			System.err.println("Error loading image: " + e.getMessage());
			// Create a blank image if loading fails
			image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
		}
		JMenuItem menuItem1 = new JMenuItem("Remove Spline");
		JMenuItem menuItem2 = new JMenuItem("Make Bezier");
		menuItem1.setName("menuItem1");
		menuItem2.setName("menuItem2");
		menuItem1.addActionListener(this);
		menuItem2.addActionListener(this);
		popupMenu.add(menuItem1);
		popupMenu.add(menuItem2);
		setComponentPopupMenu(popupMenu);
		//Save the default Cursor c = getCursor()
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// Draw the background image, scaling it to fit the panel
		if (image != null) {
			g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}

		// Draw the spline
		if (controlPoints.size() > 1) {
			g2d.setColor(Color.BLUE);
			// For a smooth spline, a custom drawing algorithm is needed.
			// A simple polyline is shown for demonstration, using GeneralPath for
			// flexibility.
			GeneralPath path = new GeneralPath();
			path.moveTo(controlPoints.get(0).x, controlPoints.get(0).y);
			for (int i = 1; i < controlPoints.size(); i++) {
				path.lineTo(controlPoints.get(i).x, controlPoints.get(i).y);
			}
			g2d.draw(path); // This draws a polyline

			// For a true spline, you would use a method to calculate intermediate points
			// between control points and draw those.
		}

		// Draw control points as small circles/rectangles
		g2d.setColor(Color.RED);
		for (Point p : controlPoints) {
			g2d.fillOval(p.x - 5, p.y - 5, 10, 10);
		}
	}

	// Mouse Listener implementations
	@Override
	public void mouseClicked(MouseEvent e) {
		// Add a new control point on click if not dragging an existing one
		controlPoints.add(e.getPoint());
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mouse pressed " + e.getButton());
		if (e.getButton() == 1) {
			// Left button
			// Check if a point is selected for dragging
			for (Point p : controlPoints) {
				if (p.distance(e.getPoint()) <= 5) {
					selectedPoint = p;
					break;
				}
			}
		} else if (e.getButton() == 2) {
			// middle button
		} else if (e.getButton() == 3) {
			// right button
			for (Point p : controlPoints) {
				if (p.distance(e.getPoint()) <= 5) {
					System.out.println("right mouse pressed " + e.getButton());
					showPopup(e);
					break;
				}
			}
		}
	}

	private void showPopup(MouseEvent e) {
		if (e.isPopupTrigger()) {
			System.out.println("isPopupTrigger " + e.getComponent().getName());
			// Checks if the event is the platform-specific popup trigger
			popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		selectedPoint = null; // Release the selected point
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// Move the selected point
		if (selectedPoint != null) {
			selectedPoint.setLocation(e.getPoint());
			repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem item) {
			System.out.println("item= " + item.getName());
		}
	}

}
