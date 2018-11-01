package gui.userpanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

import gui.userpanel.rightpanel.DipositPanel;
import gui.userpanel.rightpanel.SearchPanel;
import gui.userpanel.rightpanel.TransferPanel;
import gui.userpanel.rightpanel.WithdrawPanel;

public class UserRightPanel extends Panel{
	Frame parent;
	DipositPanel dp;
	WithdrawPanel wp;
	TransferPanel tp;
	SearchPanel sp;
	
	
	public UserRightPanel(Frame parent) {
		this.parent = parent;
		this.setBackground(Color.BLACK);
		this.setLayout(new CardLayout());
		this.setVisible(true);
	}
	
	public void initRightPanel() {
		dp = new DipositPanel(this);
		wp = new WithdrawPanel(this);
		tp = new TransferPanel(this);
		sp = new SearchPanel(this);
	}
	
	public void addPanel() {
		this.add(dp, "����");
		this.add(wp, "���");
		this.add(tp, "��ü");
		this.add(sp, "��ȸ");
	}
	
	
	public Panel getPanel() {
		return this;
	}
	
	
}
