package com.alex.graphics;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class WindowPanel extends JPanel{
	/** Serial number */
	private static final long serialVersionUID = -3701210413617715525L;
	
	private JLabel statusLabel;

	public WindowPanel(JFrame frame) {
		statusLabel = new JLabel("status", SwingConstants.CENTER);
		statusLabel.setSize(350, 100);

		setLayout(new BorderLayout());
		
		new MenuPane(frame);
		SplinePanel splinePanel = new SplinePanel();
		LineDrawingPanel linePanel = new LineDrawingPanel();
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splinePanel, linePanel);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);
		
		ToolPanel toolPanel = new ToolPanel();
		
		add(toolPanel,BorderLayout.WEST);
		add(splitPane,BorderLayout.CENTER);
		add(statusLabel,BorderLayout.SOUTH);
	}

}
