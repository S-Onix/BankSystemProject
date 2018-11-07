package gui.userpanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

import gui.userpanel.rightpanel.DipositPanel;
import gui.userpanel.rightpanel.SearchPanel;
import gui.userpanel.rightpanel.TransferPanel;
import gui.userpanel.rightpanel.WithdrawPanel;
import system.BankSystem;

public class UserRightPanel extends Panel{
	Frame parent;
	DipositPanel dp;
	WithdrawPanel wp;
	TransferPanel tp;
	SearchPanel sp;
	private CardLayout card;
	BankSystem bs;
	
	public UserRightPanel(BankSystem bs) {
		this.setBackground(Color.BLACK);
		this.bs = bs;
		
		card = new CardLayout();
		this.setLayout(card);
		
		initRightPanel();
		addPanel();
		
		this.setVisible(true);
		
	}
	
	public void initRightPanel() {
		dp = new DipositPanel(bs);
		wp = new WithdrawPanel(bs);
		tp = new TransferPanel(bs);
		sp = new SearchPanel(bs);
	}
	
	public void addPanel() {
		this.add(dp, "����");
		this.add(wp, "���");
		this.add(tp, "��ü");
		this.add(sp, "��ȸ");
	}


	public void show(String cardName) {
		card.show(this, cardName);
	}
}
