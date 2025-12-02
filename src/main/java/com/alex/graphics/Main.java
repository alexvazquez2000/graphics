package com.alex.graphics;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw Vector Lines");
		WindowPanel panel = new WindowPanel(frame);
		frame.add(panel);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
