package main;

import javax.swing.JFrame;

import gui.userpanel.rightpanel.SearchPanel;

public class SerchTestFrme extends JFrame{
	SearchPanel sp;
	
	public SerchTestFrme() {
		sp = new SearchPanel();
		this.add(sp);
		this.setSize(500, 500);
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new SerchTestFrme();
	}
}
