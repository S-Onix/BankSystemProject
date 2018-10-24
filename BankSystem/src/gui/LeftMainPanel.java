package gui;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftMainPanel extends Panel implements ActionListener{
	Button buttons[];
	Label la1, la2;
	private String mainStr[] = {
			"ȸ������", "�����", "�Ա�", "���", "�ܰ�", "������", "����"
	};
	
	public LeftMainPanel() {
		buttons = new Button[mainStr.length];
		la1 = new Label("");
		la2 = new Label("");
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button(mainStr[i]);
		}
		
		this.setLayout(new GridLayout(9, 1, 0, 20));
		this.add(la1);
		for(int i = 0 ; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
			this.add(buttons[i]);
		}
		this.add(la2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		Button button = (Button) obj;
	
		
		
	}
}
