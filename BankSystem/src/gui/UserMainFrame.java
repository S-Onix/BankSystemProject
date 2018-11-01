package gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gui.userpanel.UserLeftPanel;
import gui.userpanel.UserRightPanel;

public class UserMainFrame extends Frame {

	// �ش� �����ӿ��� �ΰ��� �г��� �ְ� �� �г��� GridLayout�� CardLayout���� �����Ǿ� �ִ�.
	UserLeftPanel leftPanel;
	UserRightPanel rightPanel;
	Frame loginFrame;
	boolean alive = false;

	public UserMainFrame(Frame loginFrame) {
		this.loginFrame = loginFrame;
		this.setSize(600, 600);

		leftPanel = new UserLeftPanel(this);
		rightPanel = new UserRightPanel(this);

		initPanelSite();
		
		
		this.add(leftPanel);
		this.add(rightPanel);

		this.setResizable(false);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				loginFrame.setEnabled(true);

			}
		});
	}

	public void initPanelSite() {
		leftPanel.getPanel().setBounds(this.getX(), this.getY() + 24, this.getWidth() / 3 - 26, this.getHeight() - 26);
		rightPanel.getPanel().setBounds(leftPanel.getWidth(), this.getY() + 26, (this.getWidth() / 3) * 2 - 26,
				this.getHeight() - 26);
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
