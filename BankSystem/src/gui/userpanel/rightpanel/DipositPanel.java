package gui.userpanel.rightpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import system.BankSystem;

public class DipositPanel extends JPanel implements ActionListener {
	private JTextField textField;
	private JPanel panel;
	JLabel userInfo;
	JLabel timeInfo;

	JButton checkButton;
	JButton cancelButton;
	BankSystem bs;

	public DipositPanel(BankSystem bs) {
		this.setLayout(null);
		this.bs = bs;

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

		JLabel lblNewLabel = new JLabel("���ݾ�");
		lblNewLabel.setFont(new Font("�޸ո���T", Font.BOLD, 16));
		lblNewLabel.setBounds(245, 397, 92, 20);
		add(lblNewLabel);

		userInfo = new JLabel(bs.getLoginCustomer().getName() + "�� ȯ���մϴ�");
		userInfo.setHorizontalAlignment(SwingConstants.CENTER);
		userInfo.setFont(new Font("�޸ո���T", Font.BOLD, 16));
		userInfo.setBounds(243, 27, 248, 20);
		add(userInfo);

		timeInfo = new JLabel("�ð� ���");
		timeInfo.setFont(new Font("�޸ո���T", Font.BOLD, 16));
		timeInfo.setBounds(245, 463, 229, 26);
		add(timeInfo);

		checkButton = new JButton("Ȯ��");
		checkButton.setFont(new Font("�޸ո���T", Font.BOLD, 16));
		checkButton.setBounds(243, 506, 107, 43);
		checkButton.setEnabled(false);
		add(checkButton);

		cancelButton = new JButton("���");
		cancelButton.setFont(new Font("�޸ո���T", Font.BOLD, 16));
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
		case "Ȯ��":
			// �ش� ���� �ݾ� ����
			System.out.println("���� ���� �ܰ� : " + bs.getCustomerBalance());

			checkButton.setEnabled(true);
			String s = textField.getText();
			int money = Integer.parseInt(s);
			bs.deposit(money);
			bs.updateCustomer();

			System.out.println("���� ���� �ܰ� : " + bs.getCustomerBalance());
			// ���̾�α� �ۼ�
			break;
		case "���":
			// dialog
			textField.setText("");
			break;

		}
	}

}
