package gui.userpanel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.ExitDialog;

public class UserLeftPanel extends Panel implements ActionListener {
	Button button[] = new Button[5];
	Label emptyLb;
	String bStr[] = { "����", "���", "��ü", "��ȸ", "����" };
	Frame parent;
	ExitDialog ed;

	public UserLeftPanel(Frame parent) {
		this.parent = parent;
		this.setLayout(new GridLayout(0, 1, 0, 10));
		initComponent();
		addComponent();
		addButtonAction();
		this.setBackground(Color.blue);
		this.setVisible(true);
	}

	public Panel getPanel() {
		return this;
	}

	public void initComponent() {
		ed = new ExitDialog(parent);
		for (int i = 0; i < button.length; i++) {
			button[i] = new Button(bStr[i]);
			button[i].setName(bStr[i]);
		}
		emptyLb = new Label("");
	}

	public void addComponent() {
		for (int i = 0; i < button.length; i++) {
			if (i == 3) {
				this.add(emptyLb);
			}
			this.add(button[i]);
		}
	}

	public void addButtonAction() {
		for (int i = 0; i < button.length; i++) {
			button[i].addActionListener(this);
		}
	}

	// �̺�Ʈ ó�����ֱ�
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Button temp = (Button) e.getSource();
		String buttonName = temp.getName();

		switch (buttonName) {
		case "����":
			// ���� �гη� �ٲ��ֱ� (cardlayout����)
			break;
		case "���":
			break;
		case "��ü":
			break;
		case "��ȸ":
			break;
		case "����":
			// ���̾�α� ��� �� parent frame ����
			ed.setVisible(true);
			break;

		}

	}
}
