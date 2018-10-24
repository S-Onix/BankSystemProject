package gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainUI extends Frame{
	LeftMainPanel lm;
	RightMainPanel rm;
	
	public MainUI() {
		this.setTitle("은행 업무 시스템");
		
		lm = new LeftMainPanel();
		rm = new RightMainPanel();
		
		this.setLayout(new BorderLayout());
		
		this.add(lm, BorderLayout.WEST);
		this.add(rm, BorderLayout.CENTER);
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
