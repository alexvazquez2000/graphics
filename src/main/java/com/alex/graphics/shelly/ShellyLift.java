package com.alex.graphics.shelly;

import javax.swing.*;
import java.awt.*;

// 1. Create a custom panel extending JPanel
class LineDrawingPanel extends JPanel {
	private int scale = 4;
	private int xOffset = 160;
	private int yOffset = 10;

	@Override
	protected void paintComponent(Graphics g) {
		// Always call super.paintComponent(g) to clear the background properly
		super.paintComponent(g);

		//Set the color of the line
		g.setColor(Color.BLUE);

		//from wheel axel up at an angle to center
		double cb = 24.0d;
		double cb_degrees = 120.0d;
		//pickup end to center
		double ca = 24.0d;
		double ca_degrees = 180.0d;
		//center to handle
		double cd = 36.0d;
		double cd_degrees = 30.0d;
		int wheelCenterX = 5;
		int wheelRadius = 5;
		//---------------------------------------
		LiftFrame lift = new LiftFrame(wheelCenterX, wheelRadius, cb, cb_degrees, ca, ca_degrees, cd, cd_degrees);
		//draw the wheel only on first
		drawOval(g, wheelCenterX -wheelRadius , 0, wheelRadius * 2, wheelRadius *2);
		System.out.println("Picking Shelly");
		lift.drawModelA(this, g);
		drawGripper(g, lift.getAX(), lift.getAY());
		System.out.println("\nLifting Shelly (must clear pool which is 16\")");
		
		int turnAngle = 40;
		LiftFrame liftLoaded = new LiftFrame(lift, turnAngle);
		g.setColor(Color.RED);
		liftLoaded.drawModelA(this, g);
		
		System.out.println("Model A Lift to clear pool = " + (liftLoaded.getAY() - lift.getAY()) + " <<-- must be >18\" \n");
		//---------------------------------------
		{
		System.out.println("\n-------------\nModel B");
		g.setColor(Color.BLUE);
		//from wheel axel up at an angle to center
		cb = 20.0d;
		cb_degrees = 40.0d;
		//pickup end to center
		ca = 42.0d;
		ca_degrees = 160.0d;
		//center to handle
		cd = 49.0d;
		cd_degrees = 40.0d;
		wheelCenterX = 80;
		LiftFrame liftB = new LiftFrame(wheelCenterX, wheelRadius, cb, cb_degrees, ca, ca_degrees, cd, cd_degrees);
		drawOval(g, wheelCenterX -wheelRadius , 0, wheelRadius * 2, wheelRadius *2);
		liftB.drawModelA(this, g);
		
		//turnAngle = 25;
		LiftFrame liftBLoaded = new LiftFrame(liftB, turnAngle);
		g.setColor(Color.RED);
		liftBLoaded.drawModelA(this, g);
		System.out.println("Model B Lift to clear pool = " + (liftBLoaded.getAY() - liftB.getAY()) + " <<-- must be >18\" \n");
		}
		//---------------------------------------
		System.out.println("\n-------------\nModel C");
		cb = 32.0d;
		cb_degrees = 120;
		//pickup end to center
		ca = 32.0d;
		ca_degrees = 170.0d;
		//center to handle
		cd = 36.0d;
		cd_degrees = 30.0d;
		wheelCenterX = 160;
		
		g.setColor(Color.BLUE);
		LiftFrame liftC = new LiftFrame(wheelCenterX, wheelRadius, cb, cb_degrees, ca, ca_degrees, cd, cd_degrees);
		drawOval(g, wheelCenterX -wheelRadius , 0, wheelRadius * 2, wheelRadius *2);
		liftC.drawModelC(this, g);
		
		//turnAngle = 35;
		LiftFrame liftCLoaded = new LiftFrame(liftC, turnAngle);
		g.setColor(Color.RED);
		liftCLoaded.drawModelC(this, g);
		System.out.println("Model C Lift to clear pool = " + (liftCLoaded.getAY() - liftC.getAY()) + " <<-- must be >18\" \n");
		//---------------------------------------
		
	}

	private void drawGripper(Graphics g, int aX, int aY) {
		System.out.println("\nGripper");
		double lineLen = 17.125d;
		double angle = 30.0d;
		int verticalToGripper = 12;
		
		int dX = (int)(Math.cos(Math.toRadians(angle)) * (lineLen / 2.0d));
		int dY = (int)(Math.sin(Math.toRadians(angle)) * (lineLen / 2.0d));
		Point p1 = new Point(aX - dX, aY - dY);
		Point p2 = new Point(aX + dX, aY - dY);
		drawLine(g, aX, aY, aX - dX, aY - dY, "To First pivot Left");
		drawLine(g, aX, aY, aX + dX, aY - dY, "To First pivot Right");
		
		int d2X = (int)(Math.cos(Math.toRadians(angle)) * lineLen);
		int d2Y = (int)(Math.sin(Math.toRadians(angle)) * lineLen);
		Point p3 = new Point(p1.x + d2X, p1.y - d2Y);
		Point p4 = new Point(p2.x - d2X, p2.y - d2Y);
		drawLine(g, p1.x, p1.y, p3.x, p3.y, "To corner Right");
		drawLine(g, p2.x, p2.y, p4.x, p4.y, "To corner Left");
		
		Point p5 = new Point( p3.x, p3.y - verticalToGripper);
		Point p6 = new Point(p4.x, p4.y - verticalToGripper);
		drawLine(g, p3.x, p3.y, p5.x, p5.y, "To Gripper Right");
		drawLine(g, p4.x, p4.y, p6.x, p6.y, "To Gripper Left");
		
		int gripper = 3;
		Point p7 = new Point(p3.x - gripper, p3.y - verticalToGripper);
		Point p8 = new Point(p4.x + gripper, p4.y - verticalToGripper);
		drawLine(g, p5.x, p5.y, p7.x, p7.y, "Gripper Right");
		drawLine(g, p6.x, p6.y, p8.x, p8.y, "Gripper Left");
		
		System.out.println("Gripper holding width = " + (p5.x - p6.x) + " (distance between the vertical sides) ");
		
	}

	public void drawOval(Graphics g,int x, int y, int width, int height ) {
		//System.out.println(" Circle (" + x + "," + y + ") with W=" + width + ", h=" + height );
		int w2 = width * scale;
		int h2 = height * scale;
		int x2 = x * scale + xOffset;
		int y2 = getHeight() - (y * scale) - yOffset - h2;
		g.drawOval(x2, y2, w2, h2);
	}

	public void drawLine(Graphics g, int i, int j, int centerX, int centerY, String comment) {
		//System.out.println("(" + i + "," + j + ") to (" + centerX + "," + centerY + ") " + comment );
		g.drawLine(i * scale + xOffset, getHeight() - j * scale - yOffset,
				centerX * scale  + xOffset, getHeight() - centerY * scale - yOffset);
		
	}
}

public class ShellyLift {
	public static void main(String[] args) {
		// 2. Set up the window frame
		JFrame frame = new JFrame("Java Swing Draw Line Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 400);

		// 3. Add your custom panel to the frame
		LineDrawingPanel panel = new LineDrawingPanel();
		frame.add(panel);

		// 4. Make the window visible
		frame.setVisible(true);
	}
}
