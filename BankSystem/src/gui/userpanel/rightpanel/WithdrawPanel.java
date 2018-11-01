package gui.userpanel.rightpanel;

import java.awt.Color;
import java.awt.Panel;

public class WithdrawPanel extends Panel{
	Panel parent;
	
	public WithdrawPanel(Panel parent) {
		// TODO Auto-generated constructor stub
		this.parent = parent;
		this.setBackground(Color.RED);
		this.setVisible(true);
		
	}
}
