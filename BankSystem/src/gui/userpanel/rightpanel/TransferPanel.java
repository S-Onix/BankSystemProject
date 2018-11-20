package gui.userpanel.rightpanel;

import javax.swing.JPanel;

import system.BankSystem;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TransferPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public TransferPanel(BankSystem bs) {
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 17));
		btnNewButton.setBounds(246, 488, 97, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.PLAIN, 16));
		lblNewLabel.setBounds(218, 23, 370, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 16));
		lblNewLabel_1.setBounds(218, 159, 125, 15);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(218, 208, 68, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("-");
		label.setBounds(298, 211, 14, 15);
		add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(315, 208, 107, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(429, 211, 14, 15);
		add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(444, 208, 116, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(218, 374, 116, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCurrentTime = new JLabel("current time");
		lblCurrentTime.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 14));
		lblCurrentTime.setBounds(218, 426, 291, 15);
		add(lblCurrentTime);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 16));
		label_2.setBounds(218, 335, 125, 15);
		add(label_2);
		
		JButton button = new JButton("New button");
		button.setFont(new Font("ÈÞ¸Õ¸ðÀ½T", Font.BOLD, 17));
		button.setBounds(412, 488, 97, 23);
		add(button);

	}
}
