package com.alex.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 * @author Alex Vazquez <vazqueza2000@gmail.com>
 */
public class MenuPane {
	public MenuPane(JFrame frame) {
		// create a menu bar
		final JMenuBar menuBar = new JMenuBar();

		// create menus
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		final JMenu aboutMenu = new JMenu("About");
		final JMenu linkMenu = new JMenu("Links");

		// create menu items
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		newMenuItem.setActionCommand("New");

		JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.setActionCommand("Open");

		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.setActionCommand("Save");

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setActionCommand("Exit");

		JMenuItem cutMenuItem = new JMenuItem("Cut");
		cutMenuItem.setActionCommand("Cut");

		JMenuItem copyMenuItem = new JMenuItem("Copy");
		copyMenuItem.setActionCommand("Copy");

		JMenuItem pasteMenuItem = new JMenuItem("Paste");
		pasteMenuItem.setActionCommand("Paste");

		MenuItemListener menuItemListener = new MenuItemListener();

		newMenuItem.addActionListener(menuItemListener);
		openMenuItem.addActionListener(menuItemListener);
		saveMenuItem.addActionListener(menuItemListener);
		exitMenuItem.addActionListener(menuItemListener);
		cutMenuItem.addActionListener(menuItemListener);
		copyMenuItem.addActionListener(menuItemListener);
		pasteMenuItem.addActionListener(menuItemListener);

		final JCheckBoxMenuItem showWindowMenu = new JCheckBoxMenuItem("Show About", true);
		showWindowMenu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (showWindowMenu.getState()) {
					menuBar.add(aboutMenu);
					menuBar.repaint();
				} else {
					menuBar.remove(aboutMenu);
					menuBar.repaint();
				}
			}
		});
		final JRadioButtonMenuItem showLinksMenu = new JRadioButtonMenuItem("Show Links", true);
		showLinksMenu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (menuBar.getMenu(3) != null) {
					menuBar.remove(linkMenu);
					menuBar.repaint();
				} else {
					menuBar.add(linkMenu);
					menuBar.repaint();
				}
			}
		});
		// add menu items to menus
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(showWindowMenu);
		fileMenu.addSeparator();
		fileMenu.add(showLinksMenu);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);

		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);

		// add menu to menubar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(aboutMenu);
		menuBar.add(linkMenu);

		// add menubar to the frame
		frame.setJMenuBar(menuBar);
	}

	class MenuItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//FIXME: statusLabel.setText(e.getActionCommand() + " JMenuItem clicked.");
			System.out.println(e.getActionCommand() + " JMenuItem clicked.");
		}
	}

}
