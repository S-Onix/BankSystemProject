package gui.userpanel.rightpanel;

import java.awt.Color;
import java.awt.Panel;

public class TransferPanel extends Panel{
	Panel parent;
	
	public TransferPanel(Panel parent) {
		// TODO Auto-generated constructor stub
		this.parent = parent;
		this.setBackground(Color.YELLOW);
		this.setVisible(true);
	}

}
