package com.alex.graphics.shelly;

import java.awt.Graphics;

public class LiftFrame {
	
	private int wheelCenterX;
	private int wheelCenterY;
	//from wheel axel up at an angle to center
	private double cb;
	private double cbDegrees;
			
	//pickup end to center
	private double ca;
	private double caDegrees;
			
	//center to handle
	private double cd;
	private double cdDegrees;

	//generated
	//gripper hangs from here
	int aX;
	int aY;
	
	public LiftFrame(int wheelCenterX, int wheelCenterY, double cb, double cbDegrees, double ca, double caDegrees, double cd, double cdDegrees) {
		this.wheelCenterX = wheelCenterX;
		//wheelCenterY is always same as the radius
		this.wheelCenterY = wheelCenterY;
		
		this.cb = cb;
		this.cbDegrees = cbDegrees;
		this.ca = ca;
		this.caDegrees = caDegrees;
		this.cd = cd;
		this.cdDegrees = cdDegrees;
	}

	public LiftFrame(LiftFrame lift, int turnAngle) {
		this.wheelCenterX = lift.wheelCenterX;
		this.wheelCenterY = lift.wheelCenterY;
		
		this.cb = lift.cb;
		this.cbDegrees = lift.cbDegrees - turnAngle;
		this.ca = lift.ca;
		this.caDegrees = lift.caDegrees - turnAngle;
		this.cd = lift.cd;
		this.cdDegrees = lift.cdDegrees - turnAngle;
	}

	public void drawModelA(LineDrawingPanel lineDrawingPanel, Graphics g) {
		int centerX = (int)(Math.cos(Math.toRadians(cbDegrees)) * cb) + wheelCenterX;
		int centerY = (int)(Math.sin(Math.toRadians(cbDegrees)) * cb) + wheelCenterY;
		//from axel to center
		lineDrawingPanel.drawLine(g, wheelCenterX, wheelCenterY, centerX, centerY, "Axel to center");
		
		this.aX = (int)(Math.cos(Math.toRadians(caDegrees)) * ca) + centerX;
		this.aY = (int)(Math.sin(Math.toRadians(caDegrees)) * ca) + centerY;
		//from center to pickup point
		lineDrawingPanel.drawLine(g, centerX, centerY, aX, aY, "Center to pick end");
		
		int dX = (int)(Math.cos(Math.toRadians(cdDegrees)) * cd) + centerX;
		int dY = (int)(Math.sin(Math.toRadians(cdDegrees)) * cd) + centerY;
		//from center to handle
		lineDrawingPanel.drawLine(g, centerX, centerY, dX, dY, "Center to handle");
	}

	public void drawModelC(LineDrawingPanel lineDrawingPanel, Graphics g) {
		int centerX = (int)(Math.cos(Math.toRadians(cbDegrees)) * cb) + wheelCenterX;
		int centerY = (int)(Math.sin(Math.toRadians(cbDegrees)) * cb) + wheelCenterY;
		//from axel to center
		lineDrawingPanel.drawLine(g, wheelCenterX, wheelCenterY, centerX, centerY, "Axel to center");
		
		//draw another line towards the back where the handle will attach
		int rearX = (int)(Math.cos(Math.toRadians(cbDegrees - 45.0d)) * cb) + wheelCenterX;
		int rearY = (int)(Math.sin(Math.toRadians(cbDegrees - 45.0d)) * cb) + wheelCenterY;
		//from axel to center
		lineDrawingPanel.drawLine(g, wheelCenterX, wheelCenterY, rearX, rearY, "Axel to rear center");
		lineDrawingPanel.drawLine(g, centerX, centerY, rearX, rearY, "center to rear center");
		
		
		this.aX = (int)(Math.cos(Math.toRadians(caDegrees)) * ca) + centerX;
		this.aY = (int)(Math.sin(Math.toRadians(caDegrees)) * ca) + centerY;
		//from center to pickup point
		lineDrawingPanel.drawLine(g, centerX, centerY, aX, aY, "Center to pick end");
		
		int dX = (int)(Math.cos(Math.toRadians(cdDegrees)) * cd) + rearX;
		int dY = (int)(Math.sin(Math.toRadians(cdDegrees)) * cd) + rearY;
		//from center to handle
		lineDrawingPanel.drawLine(g, rearX, rearY, dX, dY, "Center to handle");
	}

	public int getAX() {
		return aX;
	}

	public int getAY() {
		return aY;
	}

}
