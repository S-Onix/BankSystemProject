package gui.userpanel.rightpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import system.BankSystem;

public class TransferPanel extends Panel implements ActionListener {
	BankSystem bs;
	JLabel userInfoLb, timeInfoLb;
	JLabel accountLb, moneyLb, pwLb;
	JLabel hyponLb[];

	JTextField accountTf[];
	JTextField moneyTf;
	JPasswordField pwTf;

	JButton checkButton;
	JButton cancelButton;

	public TransferPanel(BankSystem bs) {
		this.bs = bs;
		this.setLayout(null);
		this.setBackground(Color.gray);

		initComoponent();
		initComponentSite();
		addComponent();
		setListener();

	}

	public void initComoponent() {
		userInfoLb = new JLabel(bs.getLoginCustomer().getName() + "�� ȯ���մϴ�");
		accountLb = new JLabel("���¹�ȣ");
		pwLb = new JLabel("��й�ȣ");
		timeInfoLb = new JLabel("����ð� ���");
		hyponLb = new JLabel[2];
		for (int i = 0; i < hyponLb.length; i++) {
			hyponLb[i] = new JLabel("-");
		}

		accountTf = new JTextField[3];
		for (int i = 0; i < accountTf.length; i++) {
			accountTf[i] = new JTextField();
		}

		moneyLb = new JLabel("�ݾ� �Է� : ");
		moneyTf = new JTextField();

		pwTf = new JPasswordField();

		checkButton = new JButton("������ü");
		cancelButton = new JButton("���");
	}

	

	public void initComponentSite() {
		// ȸ������
		userInfoLb.setHorizontalAlignment(SwingConstants.CENTER);
		userInfoLb.setFont(new Font("�޸ո���T", Font.PLAIN, 16));
		userInfoLb.setBounds(218, 23, 370, 20);

		// ���� ����
		accountLb.setFont(new Font("�޸ո���T", Font.BOLD, 16));
		accountLb.setBounds(218, 129, 125, 20);

		accountTf[0].setBounds(218, 178, 68, 21);
		accountTf[0].setColumns(10);

		hyponLb[0].setBounds(298, 181, 14, 15);

		accountTf[1].setBounds(315, 178, 107, 21);
		accountTf[1].setColumns(10);

		hyponLb[1].setBounds(429, 181, 14, 15);

		accountTf[2].setBounds(444, 178, 116, 21);
		accountTf[2].setColumns(10);

		// �ݾ� ����
		moneyLb.setBounds(218, 225, 100, 30);
		moneyLb.setFont(new Font("�޸ո���T", Font.BOLD, 16));

		moneyTf.setBounds(325, 225, 100, 21);
		moneyTf.setColumns(10);

		// ��й�ȣ ����
		pwLb.setBounds(215, 330, 125, 15);
		pwLb.setFont(new Font("�޸ո���T", Font.BOLD, 16));

		pwTf.setBounds(218, 374, 116, 21);
		pwTf.setColumns(10);

		// �ð� ���� ����
		timeInfoLb.setFont(new Font("�޸ո���T", Font.BOLD, 14));
		timeInfoLb.setBounds(218, 426, 291, 15);

		// ��ư ����
		checkButton.setFont(new Font("�޸ո���T", Font.BOLD, 17));
		checkButton.setBounds(246, 471, 97, 40);

		cancelButton.setFont(new Font("�޸ո���T", Font.BOLD, 17));
		cancelButton.setBounds(412, 471, 97, 40);
	}
	
	public void setListener() {
		checkButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}
	
	public void setKeyEvent() {
		accountTf[0].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c= ke.getKeyChar();
				if(!Character.isDigit(c))
					ke.consume();
			}
		});
	}

	public void addComponent() {
		this.add(userInfoLb);
		this.add(timeInfoLb);
		this.add(accountLb);
		this.add(pwLb);
		this.add(hyponLb[0]);
		this.add(hyponLb[1]);
		this.add(accountTf[0]);
		this.add(accountTf[1]);
		this.add(accountTf[2]);
		this.add(moneyLb);
		this.add(moneyTf);
		this.add(pwTf);
		this.add(checkButton);
		this.add(cancelButton);
	}

	public void initTextField() {
		for (int i = 0; i < accountTf.length; i++) {
			accountTf[i].setText("");
		}
		moneyTf.setText("");
		;
		pwTf.setText("");
	}



	public boolean isEmpty() {
		if (accountTf[0].getText().equals("") && accountTf[1].getText().equals("") && accountTf[2].getText().equals("")
				&& moneyTf.getText().equals("") && pwTf.getText().equals(""))
			return true;
		else
			return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();

		String account = "";
		int money = 0;


		/*
		 * TODO : TextField ���� ���� �� ���̾�α� ���
		 */
		switch (button.getText()) {
		case "������ü":
			if (!isEmpty()) {
				account = accountTf[0].getText() + "-" + accountTf[1].getText() + "-" + accountTf[2].getText();
				money = Integer.parseInt(moneyTf.getText());
				if (bs.transMoney(account, money) && bs.getLoginCustomer().getPw().equals(pwTf.getText())) {
					System.out.println("trans money success");
				} else {
					System.out.println("trans money fail");
				}
			}
			
			break;
		case "���":
			initTextField();
			break;
		}

	}

}
