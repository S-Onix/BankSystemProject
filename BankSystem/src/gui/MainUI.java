package gui;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainUI extends Frame{
	LeftMainPanel lm;
	RightMainPanel rm;
	
	public MainUI() {
		
		lm = new LeftMainPanel();
		rm = new RightMainPanel();
		
		this.setLayout(new GridLayout(1,2));
		
		this.add(lm);
		this.add(rm);
		this.setVisible(true);
		this.setSize(500,500);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
}
