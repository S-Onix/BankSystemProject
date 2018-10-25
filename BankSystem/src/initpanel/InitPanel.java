package initpanel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.LoginErrorDialog;
import dialog.SignInDialog;

public class InitPanel extends Panel {
	TopPanel tp;
	BottomPanel bp;


	public InitPanel(Frame parent) {
		tp = new TopPanel();
		bp = new BottomPanel(parent);

		this.setLayout(new GridLayout(2, 1));

		this.add(tp);
		this.add(bp);
	}

}

class TopPanel extends Panel {
	Canvas c;
	Image img;

	public TopPanel() {
		c = new Canvas();
		Toolkit tool = Toolkit.getDefaultToolkit();
		img = tool.getImage("D:/work_yms/img/duke.jpg");
		this.setLayout(new BorderLayout());
		this.add(c, "Center");
	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(img,0,0,this);
	}
}

class BottomPanel extends Panel implements ActionListener{
	GridBagLayout gBag;
	Label idLb, pwLb;
	TextField idTf, pwTf;
	Button loginButton, signinButton, exitButton;
	Label[] emptyLb;
	SignInDialog sd;
	LoginErrorDialog led;

	public BottomPanel(Frame parent) {
		this.setBackground(Color.gray);
		
		sd = new SignInDialog(parent);
		led = new LoginErrorDialog(parent);
		
		gBag = new GridBagLayout();
		emptyLb = new Label[10];
		for (int i = 0; i < emptyLb.length; i++) {
			emptyLb[i] = new Label("");
		}

		idLb = new Label("ID : ", Label.CENTER);
		pwLb = new Label("PW : ", Label.CENTER);
		idTf = new TextField();
		pwTf = new TextField();
		loginButton = new Button("로그인");
		signinButton = new Button("회원가입");
		exitButton = new Button("종료");
		
		loginButton.addActionListener(this);
		signinButton.addActionListener(this);
		exitButton.addActionListener(this);

		this.setLayout(gBag);
		gbinsert(idLb, 1, 2, 3, 2);
		gbinsert(idTf, 5, 2, 6, 2);
		gbinsert(pwLb, 1, 5, 3, 2);
		gbinsert(pwTf, 5, 5, 6, 2);
		gbinsert(loginButton, 1, 9, 3, 2);
		gbinsert(signinButton, 5, 9, 3, 2);
		gbinsert(exitButton, 9, 9, 2, 2);
		gbinsert(emptyLb[0], 0, 0, 12, 2);
		gbinsert(emptyLb[1], 0, 2, 1, 10);
		gbinsert(emptyLb[2], 4, 2, 1, 2);
		gbinsert(emptyLb[3], 4, 5, 1, 2);
		gbinsert(emptyLb[4], 4, 9, 1, 2);
		gbinsert(emptyLb[5], 8, 9, 1, 2);
		gbinsert(emptyLb[6], 11, 2, 1, 10);
		gbinsert(emptyLb[7], 1, 4, 10, 1);
		gbinsert(emptyLb[8], 1, 7, 10, 2);
		gbinsert(emptyLb[9], 1, 11, 10, 1);

		this.setMaximumSize(getMaximumSize());
	}

	public void gbinsert(Component c, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gBag.setConstraints(c, gbc);
		this.add(c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(loginButton)) {
			led.setVisible(true);
		}
		
		if(e.getSource().equals(signinButton)) {
			sd.setVisible(true);
		}
		
		if(e.getSource().equals(exitButton)) {
			//exit dialog 호출
		}
		
	}
}
