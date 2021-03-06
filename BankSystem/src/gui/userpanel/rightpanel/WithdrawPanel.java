package gui.userpanel.rightpanel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dialog.MessageDialog;
import gui.UserMainFrame;
import system.BankSystem;

public class WithdrawPanel extends JPanel implements ActionListener {

	private JTextField textField;
	private JPanel panel;
	JLabel userInfo;
	JLabel timeInfo;

	JButton checkButton;
	JButton cancelButton;
	BankSystem bs;
	MessageDialog msgDialog;

	public WithdrawPanel(BankSystem bs) {
		this.setLayout(null);
		this.bs = bs;
		
		msgDialog = new MessageDialog(this.getParent());

		textField = new JTextField();
		textField.setBounds(243, 425, 159, 21);
		add(textField);
		textField.setColumns(10);

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (!Character.isDigit(c))
					ke.consume();
				else
					checkButton.setEnabled(true);
			}
		});

		JLabel lblNewLabel = new JLabel("출금액");
		lblNewLabel.setFont(new Font("휴먼모음T", Font.BOLD, 16));
		lblNewLabel.setBounds(245, 397, 92, 20);
		add(lblNewLabel);

		userInfo = new JLabel(bs.getLoginCustomer().getName() + "님 환영합니다");
		userInfo.setFont(new Font("휴먼모음T", Font.BOLD, 16));
		userInfo.setHorizontalAlignment(SwingConstants.CENTER);
		userInfo.setBounds(243, 27, 248, 20);
		add(userInfo);

		timeInfo = new JLabel("시간 출력");
		timeInfo.setFont(new Font("휴먼모음T", Font.BOLD, 16));
		timeInfo.setBounds(245, 463, 229, 26);
		add(timeInfo);

		checkButton = new JButton("확인");
		checkButton.setFont(new Font("휴먼모음T", Font.BOLD, 16));
		checkButton.setBounds(243, 506, 107, 44);
		checkButton.setEnabled(false);
		add(checkButton);

		cancelButton = new JButton("취소");
		cancelButton.setFont(new Font("휴먼모음T", Font.BOLD, 16));
		cancelButton.setBounds(433, 505, 107, 44);
		add(cancelButton);

		// Image Background setting
		panel = new JPanel() {
			ImageIcon icon = new ImageIcon("D:/yms/BankSystemProject/BankSystem/img/fall.jpg");

			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), this.getY(), this.getY(), this);
				setOpaque(false);
				super.paintComponent(g);
			}

		};
		panel.setBounds(174, 52, 394, 322);

		add(panel);
		this.setBackground(Color.gray);
		checkButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch (button.getText()) {
		case "확인":
			// 해당 고객의 금액 변경
			System.out.println("이전 고객의 잔고 : " + bs.getCustomerBalance());

			checkButton.setEnabled(true);
			String s = textField.getText();
			int money = Integer.parseInt(s);
			if (bs.isUpdate(money)) {
				bs.withdraw(money);
				bs.updateCustomer();
				bs.updateTransLog(money, 1);
				msgDialog.getLabel().setText(money + "원 출금하셨습니다.");
				msgDialog.setVisible(true);
			}else {
				msgDialog.getLabel().setText("잔고에 있는 금액보다 많이 출금할 수 없습니다.");
				msgDialog.setVisible(true);
			}
			textField.setText("");
			System.out.println("이후 고객의 잔고 : " + bs.getCustomerBalance());
			break;
		case "취소":
			// dialog
			textField.setText("");
			break;

		}
	}
}
