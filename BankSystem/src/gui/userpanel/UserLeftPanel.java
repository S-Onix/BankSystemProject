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
	String bStr[] = { "예금", "출금", "이체", "조회", "종료" };
	Frame parent;
	ExitDialog ed;
	UserRightPanel rightPanel;

	public UserLeftPanel(Frame parent, UserRightPanel rightPanel) {
		this.parent = parent;
		this.rightPanel = rightPanel;
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

	// 이벤트 처리해주기
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Button temp = (Button) e.getSource();
		String buttonName = temp.getName();

		switch (buttonName) {
		case "예금":
			// 예금 패널로 바꿔주기 (cardlayout에서)
			rightPanel.show(buttonName);
			break;
		case "출금":
			rightPanel.show(buttonName);
			break;
		case "이체":
			rightPanel.show(buttonName);
			break;
		case "조회":
			rightPanel.show(buttonName);
			break;
		case "종료":
			// 다이얼로그 출력 후 parent frame 종료
			ed.setVisible(true);
			break;

		}

	}
}
