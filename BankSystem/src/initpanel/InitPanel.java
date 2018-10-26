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

import dialog.ExitDialog;
import dialog.LoginErrorDialog;
import dialog.SignInDialog;

public class InitPanel extends Panel {
	TopPanel tp;
	BottomPanel bp;

	public InitPanel(Frame parent) {
		tp = new TopPanel();
		bp = new BottomPanel(parent);

		this.setLayout(new GridLayout(2, 1));

		this.add(tp.getPanel());
		this.add(bp);
	}

}

//class TopPanel extends Panel {
//	Canvas c;
//	Image img;
//
//	public TopPanel() {
//		c = new Canvas();
//		Toolkit tool = Toolkit.getDefaultToolkit();
//		img = tool.getImage("D:/work_yms/img/duke.jpg");
//		this.setLayout(new BorderLayout());
//		this.add(c, "Center");
//	}
//
//	@Override
//	public void paint(Graphics g) {
//
//		g.drawImage(img, 0, 0, this);
//	}
//}

class TopPanel extends Canvas {
	Panel p;
	Image img;

	public TopPanel() {
		p = new Panel();

		Toolkit tool = Toolkit.getDefaultToolkit();
		img = tool.getImage("D:/work_yms/img/duke.jpg");

		p.setLayout(new BorderLayout());
		p.add(this, "Center");
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}

	public Panel getPanel() {
		return this.p;
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
	ExitDialog ed;

	public BottomPanel(Frame parent) {
		this.setBackground(Color.gray);
		
		sd = new SignInDialog(parent);
		led = new LoginErrorDialog(parent);
		ed = new ExitDialog(parent);
		
		gBag = new GridBagLayout();
		emptyLb = new Label[11];
		for (int i = 0; i < emptyLb.length; i++) {
			emptyLb[i] = new Label();
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
		gbinsert(idLb, 1, 1, 2, 1);
		gbinsert(idTf, 4, 1, 5, 1);
		gbinsert(pwLb, 1, 3, 2, 1);
		gbinsert(pwTf, 4, 3, 5, 1);
		gbinsert(loginButton, 1, 5, 2, 1);
		gbinsert(signinButton, 4, 5, 2, 1);
		gbinsert(exitButton, 7, 5, 2, 1);
		gbinsert(emptyLb[0], 0, 0, 10, 1);
		gbinsert(emptyLb[1], 0, 1, 1, 6);
		gbinsert(emptyLb[2], 3, 1, 1, 6);
		gbinsert(emptyLb[3], 9, 1, 1, 8);
		gbinsert(emptyLb[4], 1, 2, 2, 1);
		gbinsert(emptyLb[5], 1, 4, 2, 1);
		gbinsert(emptyLb[6], 1, 6, 2, 1);
		gbinsert(emptyLb[7], 4, 2, 5, 1);
		gbinsert(emptyLb[8], 4, 4, 5, 1);
		gbinsert(emptyLb[9], 4, 6, 5, 1);
		gbinsert(emptyLb[10], 6, 5, 1, 1);

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
			ed.setVisible(true);
		}
		
	}
}
