package com.alex.graphics.shapes;

import java.awt.Graphics2D;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public abstract class Shape implements Cloneable {
	protected boolean selected = false;
	protected String shapeType;
	
	abstract public void draw(Graphics2D g);
	
	public String getShapeType() {
		return shapeType;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
