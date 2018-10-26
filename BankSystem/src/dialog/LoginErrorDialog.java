package dialog;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginErrorDialog extends Dialog{
	Label la1, la2, la3;
	Panel p1, p2;
	Button checkButton;
	
	public LoginErrorDialog(Frame parent) {
		super(parent, "Login Error");
		p1 = new Panel();
		p2 = new Panel();
		la1 = new Label("아이디 or 비밀번호를 잘못 입력하셨습니다!");
		la2 = new Label("");
		la3 = new Label("");
		checkButton = new Button("확인");
		
		//P1
		p1.add(la1);
		
		//P2
		p2.add(la2);
		p2.add(checkButton);
		p2.add(la3);
		
		checkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(checkButton)){
					dispose();
				}
			}
		});
		
		//Dialog
		this.setLayout(new GridLayout(2, 1));
		this.add(p1);
		this.add(p2);
		this.setSize(300, 100);
		this.setResizable(false);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		
	}

}
