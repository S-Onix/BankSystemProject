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
		this.add(dp, "예금");
		this.add(wp, "출금");
		this.add(tp, "이체");
		this.add(sp, "조회");
	}


	public void show(String cardName) {
		card.show(this, cardName);
	}
}
