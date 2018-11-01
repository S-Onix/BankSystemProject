package gui.userpanel.rightpanel;

import java.awt.Color;
import java.awt.Panel;

public class DipositPanel extends Panel{
	Panel parent;
	
	public DipositPanel(Panel parent) {
		this.parent = parent;
		this.setBackground(Color.GREEN);
		this.setVisible(true);
	}

}
