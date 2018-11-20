package gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gui.loginpanel.LoginPanel;
import system.BankSystem;

public class InitFrame extends Frame{
	BankSystem bs;
	Label la[] = new Label[4];
	LoginPanel ip;
	String direction[] = {"North", "East", "West", "South"};
	
	public InitFrame(BankSystem bs) {
		this.bs = bs;
		ip = new LoginPanel(this, bs);
		
		this.setTitle("은행 업무 시스템");
		this.setLayout(new BorderLayout());
		
		for(int i = 0; i < la.length; i++) {
			la[i] = new Label("");	
		}
		
		for(int i = 0 ; i < la.length; i++) {
			this.add(la[i], direction[i]);
		}
		this.add(ip, "Center");
		
		
		this.setVisible(true);
		this.setSize(350,500);
		this.setResizable(false);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new InitFrame(new BankSystem());
	}
	
}
