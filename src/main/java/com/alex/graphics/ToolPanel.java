package com.alex.graphics;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.alex.graphics.utils.Utils;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class ToolPanel extends JPanel {

	/** Generated serial ID */
	private static final long serialVersionUID = 5198424878189812263L;

	public ToolPanel() {
		String[] imageNames = { "select", "line", "square", "rectangle", "circle", "oval" };
		setLayout(new GridLayout(imageNames.length, 1));

		ImageIcon icon = null;
		for (String imageName : imageNames) {
			java.net.URL imgURL = ToolPanel.class.getResource("/buttons/" + imageName + ".png");
			if (imgURL != null) {
				icon = new ImageIcon(imgURL);
			} else {
				JOptionPane.showMessageDialog(this.getParent(), "Icon " + imageName + ".png image not found.");
			}
			JButton button = new JButton(icon);
			button.setToolTipText(Utils.firstCharToUpper(imageName));
			add(button);
		}
	}
}
