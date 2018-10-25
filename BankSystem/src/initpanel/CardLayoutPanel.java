package initpanel;

import java.awt.CardLayout;
import java.awt.Panel;

public class CardLayoutPanel extends Panel{
	CardLayout card;
	public CardLayoutPanel() {
		card = new CardLayout();
		
		this.setLayout(card);
		
	}
}
