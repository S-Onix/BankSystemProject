package gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import initpanel.InitPanel;

public class MainUI extends Frame{
	Label la[] = new Label[4];
	InitPanel ip;
	String direction[] = {"North", "East", "West", "South"};
	
	public MainUI() {
		ip = new InitPanel(this);
		
		this.setTitle("은행 업무 시스템");
		this.setLayout(new BorderLayout());
		
		for(int i = 0; i < la.length; i++) {
			la[i] = new Label("");	
		}
		
		//새로운 패널 저장 (CardLayout)
		for(int i = 0 ; i < la.length; i++) {
			this.add(la[i], direction[i]);
		}
		this.add(ip, "Center");
		
		
		
		
		
		
		this.setVisible(true);
		this.setSize(500,500);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new MainUI();
	}
	
}
