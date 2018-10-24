package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;

import rightpanel.DepositPanel;
import rightpanel.PrintCustomerInfoPanel;
import rightpanel.PrintCustomerPanel;
import rightpanel.SignInPanel;
import rightpanel.WithdrawPanel;

public class RightMainPanel extends Panel {
	private CardLayout card;
	SignInPanel sp;
	PrintCustomerPanel pcp;
	DepositPanel dp;
	WithdrawPanel wp;
	PrintCustomerInfoPanel pcip;
	
	public RightMainPanel() {
		card = new CardLayout();
		sp = new SignInPanel();
		pcp = new PrintCustomerPanel();
		dp = new DepositPanel();
		wp = new WithdrawPanel();
		pcip = new PrintCustomerInfoPanel();
		
		
		
		
		
		
		card.show(this, "right panel");
		
		
	}
}
