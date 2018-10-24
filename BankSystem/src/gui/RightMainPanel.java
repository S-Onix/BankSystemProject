package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;

public class RightMainPanel extends Panel{
	private String[] direction = { "West", "East", "North", "South" };
	private Label[] lbs;
	private Label centerLabel;

	public RightMainPanel() {

		lbs = new Label[4];
		centerLabel = new Label("Áß¾Ó");
		for (int i = 0; i < lbs.length; i++) {
			lbs[i] = new Label("");
		}

		centerLabel.setBackground(Color.blue);
		
		this.setLayout(new BorderLayout());
		
		
		
		for (int i = 0; i < direction.length; i++) {
			this.add(lbs[i], direction[i]);
		}
		this.add(centerLabel, "Center");

	}
}
