package com.alex.graphics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class SplineEditorExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2843296429437935624L;

	public SplineEditorExample() {
		setTitle("Editable Spline on Image Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SplinePanel panel = new SplinePanel();
		add(panel);

		setSize(800, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(SplineEditorExample::new);
	}

}
